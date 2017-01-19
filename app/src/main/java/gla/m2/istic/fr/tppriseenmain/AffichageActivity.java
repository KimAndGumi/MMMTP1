package gla.m2.istic.fr.tppriseenmain;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by nirina on 17/01/17.
 */

public class AffichageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);

        Intent i = getIntent();
        InfoParcelable ip = i.getParcelableExtra("info");
        String nom = ip.nom;
        String prenom = ip.prenom;
        String ville = ip.ville;
        String date = ip.date;

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
