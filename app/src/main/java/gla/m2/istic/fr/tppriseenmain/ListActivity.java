package gla.m2.istic.fr.tppriseenmain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity extends AppCompatActivity {

    private ArrayList<HashMap<String, String>> listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        if (listItem==null){
            listItem = new ArrayList<HashMap<String, String>>();
            HashMap<String,String> map = new HashMap<>();
            map.put("Nom","Nom");
            map.put("Prénom","Prénom");
            map.put("Ville","Ville");
            map.put("Date","Date");
            listItem.add(map);
        }
        Intent i = getIntent();

        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),listItem,R.layout.item,new String[]{"Prénom","Nom","Ville","Date"},new int[]{R.id.itemPrenom,R.id.itemNom,R.id.itemVille,R.id.itemDate});
        ((ListView) findViewById(R.id.listview)).setAdapter(adapter);
        Button boutonNewClient = (Button) findViewById(R.id.newclient);
        boutonNewClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SaisieActivity.class);
                startActivity(i);
            }
        });
    }
}
