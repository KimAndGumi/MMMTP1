package gla.m2.istic.fr.tppriseenmain;

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
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import static android.text.InputType.TYPE_CLASS_NUMBER;

public class SaisieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boutonValider = (Button) findViewById(R.id.button);
        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),AffichageActivity.class);
                in.putExtra("nom",((EditText) findViewById(R.id.editNom)).getText());
                in.putExtra("prenom",((EditText) findViewById(R.id.editPrenom)).getText());
                in.putExtra("ville",((EditText) findViewById(R.id.editVille)).getText());
                in.putExtra("date",((EditText) findViewById(R.id.editDate)).getText());
                startActivity(in);
                String text = "";
                TableLayout tl = (TableLayout) findViewById(R.id.tablelayout);
                int tlc = tl.getChildCount();
                for (int i=0;i<tlc;i++){
                    View tmp = ((TableRow) tl.getChildAt(i)).getChildAt(1);
                    if (tmp instanceof EditText){
                        text += ((EditText) tmp).getText()+" ";
                    }
                    if (tmp instanceof Spinner){
                        text += ((Spinner) tmp).getSelectedItem().toString()+" ";
                    }
                }
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = new MenuInflater(getApplicationContext());
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int itemId = item.getItemId();
        if (item.getItemId()==R.id.raz_formulaire){
            ((EditText) findViewById(R.id.editPrenom)).setText("");
            ((EditText) findViewById(R.id.editNom)).setText("");
            ((EditText) findViewById(R.id.editDate)).setText("");
            ((EditText) findViewById(R.id.editVille)).setText("");
            //return true;
        }
        if (item.getItemId()==R.id.ajout_nouveau_cg){
            LinearLayout layout = (LinearLayout) findViewById(R.id.activity_main);
            TextView textNumTel = new TextView(getApplicationContext());
            EditText editNumTel = new EditText(getApplicationContext());
            textNumTel.setText("Numéro de téléphone");
            textNumTel.setTextColor(Color.GRAY);
            textNumTel.setTextSize((float)18.0);
            editNumTel.setInputType(TYPE_CLASS_NUMBER);
            editNumTel.setTextColor(Color.BLACK);
            TableRow tr = new TableRow(getApplicationContext());
            tr.addView(textNumTel);
            tr.addView(editNumTel);
            ((TableLayout) layout.findViewById(R.id.tablelayout)).addView(tr);
            //return true;
        }
        if (item.getItemId()==R.id.browser_wikipedia){
            // et = (EditText) findViewById(R.id.editVille);
            String ville = ((EditText) findViewById(R.id.editVille)).getText()+"";
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://fr.wikipedia.org/wiki/"+ville));
            startActivity(i);
        }
        return true;
    }
}
