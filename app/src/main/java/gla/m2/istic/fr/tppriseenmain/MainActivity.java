package gla.m2.istic.fr.tppriseenmain;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boutonValider = (Button) findViewById(R.id.button);
        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = ((EditText) findViewById(R.id.editPrenom)).getText()+" "+
                        ((EditText) findViewById(R.id.editNom)).getText()+" "+
                        ((EditText) findViewById(R.id.editDate)).getText()+" "+
                        ((EditText) findViewById(R.id.editVille)).getText();
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
            return true;
        }
        if (item.getItemId()==R.id.ajout_nouveau_cg){
            LinearLayout layout = (LinearLayout) findViewById(R.id.activity_main);
            TextView textNumTel = new TextView(getApplicationContext());
            EditText editNumTel = new EditText(getApplicationContext());
            textNumTel.setText("Numéro de téléphone");
            TableRow tr = new TableRow(getApplicationContext());
            tr.addView(textNumTel);
            tr.addView(editNumTel);
            ((TableLayout) layout.findViewById(R.id.tablelayout)).addView(tr);
            return true;
        }
        return true;
    }
}
