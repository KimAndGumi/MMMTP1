package gla.m2.istic.fr.tppriseenmain;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import static android.text.InputType.TYPE_CLASS_NUMBER;

/**
 * Created by nirina on 17/01/17.
 */

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Intent i = getIntent();
        String nom = i.getStringExtra("nom");
        String prenom = i.getStringExtra("prenom");
        String ville = i.getStringExtra("ville");
        String date = i.getStringExtra("date");

        /*((TextView) findViewById(R.id.textNom2)).setText(nom);
        ((TextView) findViewById(R.id.textPrenom2)).setText(prenom);
        ((TextView) findViewById(R.id.textVille2)).setText(ville);
        ((TextView) findViewById(R.id.textDate2)).setText(date);*/
        TextView textNom = new TextView(getApplicationContext());
        textNom.setText(nom);
        textNom.setTextColor(Color.BLACK);
        textNom.setTextSize((float)18.0);
        TextView textPrenom = new TextView(getApplicationContext());
        textPrenom.setText(prenom);
        textPrenom.setTextColor(Color.BLACK);
        textPrenom.setTextSize((float)18.0);
        TextView textVille = new TextView(getApplicationContext());
        textVille.setText(ville);
        textVille.setTextColor(Color.BLACK);
        textVille.setTextSize((float)18.0);
        TextView textDate = new TextView(getApplicationContext());
        textDate.setText(date);
        textDate.setTextColor(Color.BLACK);
        textDate.setTextSize((float)18.0);
        LinearLayout ll = ((LinearLayout) findViewById(R.id.secondLayout));
        ll.addView(textNom);
        ll.addView(textPrenom);
        ll.addView(textVille);
        ll.addView(textDate);
    }
}
