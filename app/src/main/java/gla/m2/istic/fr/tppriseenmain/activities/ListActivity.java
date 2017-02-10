package gla.m2.istic.fr.tppriseenmain.activities;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import gla.m2.istic.fr.tppriseenmain.contentprovider.InfoProvider;
import gla.m2.istic.fr.tppriseenmain.parcelable.InfoParcelable;
import gla.m2.istic.fr.tppriseenmain.R;

public class ListActivity extends AppCompatActivity {

    //private ArrayList<HashMap<String, String>> listItem;
    //private SimpleAdapter adapter;
    private SimpleCursorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        /*listItem = new ArrayList<HashMap<String, String>>();
        HashMap<String,String> map = new HashMap<>();
        map.put("Nom","Nom");
        map.put("Prenom","Prénom");
        map.put("Ville","Ville");
        map.put("Date","Date");
        listItem.add(map);*/
        //ContentValues cv = new ContentValues();
        //getContentResolver().insert(InfoProvider.CONTENT_URI,cv);

        //adapter = new SimpleAdapter(getApplicationContext(),listItem,R.layout.item,new String[]{"Prenom","Nom","Ville","Date"},new int[]{R.id.itemPrenom,R.id.itemNom,R.id.itemVille,R.id.itemDate});
        Cursor cursor = getContentResolver().query(InfoProvider.CONTENT_URI,null,null,null,null);
        adapter = new SimpleCursorAdapter(this,R.layout.item,cursor,new String[]{"firstname","lastname","birthtown","birthdate"},new int[]{R.id.itemPrenom,R.id.itemNom,R.id.itemVille,R.id.itemDate});
        ((ListView) findViewById(R.id.listview)).setAdapter(adapter);

        Button boutonNewClient = (Button) findViewById(R.id.newclient);
        boutonNewClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SaisieActivity.class);
                startActivityForResult(i,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        InfoParcelable ip = data.getParcelableExtra("info");
        /*HashMap<String, String> map = new HashMap<>();
        map.put("Nom", ip.getNom());
        map.put("Prenom", ip.getPrenom());
        map.put("Ville", ip.getVille());
        map.put("Date", ip.getDate());
        listItem.add(map);*/
        ContentValues cv = new ContentValues();
        cv.put("lastname",ip.getNom());
        cv.put("firstname",ip.getPrenom());
        cv.put("birthtown",ip.getVille());
        cv.put("birthdate",ip.getDate());
        getContentResolver().insert(InfoProvider.CONTENT_URI, cv);
        Cursor cursor = getContentResolver().query(InfoProvider.CONTENT_URI,null,null,null,null);
        //adapter.notifyDataSetChanged();
        adapter.changeCursor(cursor);
    }
}
