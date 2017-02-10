package gla.m2.istic.fr.tppriseenmain.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import gla.m2.istic.fr.tppriseenmain.parcelable.InfoParcelable;
import gla.m2.istic.fr.tppriseenmain.R;

import static android.text.InputType.TYPE_CLASS_NUMBER;

public class SaisieActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie);

        Button boutonValider = (Button) findViewById(R.id.button);
        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), ListActivity.class);
                String nom = ((EditText) findViewById(R.id.editNom)).getText().toString();
                String prenom = ((EditText) findViewById(R.id.editPrenom)).getText().toString();
                String ville = ((EditText) findViewById(R.id.editVille)).getText().toString();
                String date = ((EditText) findViewById(R.id.editDate)).getText().toString();
                InfoParcelable ip = new InfoParcelable(nom,prenom,ville,date);
                in.putExtra("info",ip);
                setResult(Activity.RESULT_OK,in);
                finish();
                /*String text = "";
                TableLayout tl = (TableLayout) findViewById(R.id.tablelayout);
                int tlc = tl.getChildCount();
                for (int i = 0; i < tlc; i++) {
                    View tmp = ((TableRow) tl.getChildAt(i)).getChildAt(1);
                    if (tmp instanceof EditText) {
                        text += ((EditText) tmp).getText() + " ";
                    }
                    if (tmp instanceof Spinner) {
                        text += ((Spinner) tmp).getSelectedItem().toString() + " ";
                    }
                }
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();*/
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(getApplicationContext());
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (item.getItemId() == R.id.raz_formulaire) {
            ((EditText) findViewById(R.id.editPrenom)).setText("");
            ((EditText) findViewById(R.id.editNom)).setText("");
            ((EditText) findViewById(R.id.editDate)).setText("");
            ((EditText) findViewById(R.id.editVille)).setText("");
        }
        if (item.getItemId() == R.id.ajout_nouveau_cg) {
            LinearLayout layout = (LinearLayout) findViewById(R.id.activity_main);
            TextView textNumTel = new TextView(getApplicationContext());
            EditText editNumTel = new EditText(getApplicationContext());
            textNumTel.setText("Numéro de téléphone");
            textNumTel.setTextColor(Color.GRAY);
            textNumTel.setTextSize((float) 18.0);
            editNumTel.setInputType(TYPE_CLASS_NUMBER);
            editNumTel.setTextColor(Color.BLACK);
            TableRow tr = new TableRow(getApplicationContext());
            tr.addView(textNumTel);
            tr.addView(editNumTel);
            ((TableLayout) layout.findViewById(R.id.tablelayout)).addView(tr);
        }
        if (item.getItemId() == R.id.browser_wikipedia) {
            String ville = ((EditText) findViewById(R.id.editVille)).getText() + "";
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://fr.wikipedia.org/wiki/" + ville));
            startActivity(i);
        }
        return true;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Saisie Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
