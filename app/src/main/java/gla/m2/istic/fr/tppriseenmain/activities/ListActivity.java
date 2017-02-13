package gla.m2.istic.fr.tppriseenmain.activities;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import gla.m2.istic.fr.tppriseenmain.adapter.RecyclerViewAdapter;
import gla.m2.istic.fr.tppriseenmain.contentprovider.InfoProvider;
import gla.m2.istic.fr.tppriseenmain.parcelable.InfoParcelable;
import gla.m2.istic.fr.tppriseenmain.R;

public class ListActivity extends AppCompatActivity {

    //private ArrayList<HashMap<String, String>> listItem;
    //private SimpleAdapter adapter;

    //private SimpleCursorAdapter adapter;

    //private final String TAG = "ListActivity";
    DatabaseReference mDB;
    DatabaseReference mListInfoRef;
    private RecyclerView mListInfosRecyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<InfoParcelable> myListInfos;

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
        listItem.add(map);
        adapter = new SimpleAdapter(getApplicationContext(),listItem,R.layout.item,new String[]{"Prenom","Nom","Ville","Date"},new int[]{R.id.itemPrenom,R.id.itemNom,R.id.itemVille,R.id.itemDate});*/

        /*Cursor cursor = getContentResolver().query(InfoProvider.CONTENT_URI,null,null,null,null);
        adapter = new SimpleCursorAdapter(this,R.layout.item,cursor,new String[]{"firstname","lastname","birthtown","birthdate"},new int[]{R.id.itemPrenom,R.id.itemNom,R.id.itemVille,R.id.itemDate});
        ((ListView) findViewById(R.id.listview)).setAdapter(adapter);*/

        mDB = FirebaseDatabase.getInstance().getReference();
        mListInfoRef = mDB.child("listInfos");
        myListInfos = new ArrayList<>();
        mListInfosRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        adapter = new RecyclerViewAdapter(myListInfos, R.layout.item);
        mListInfosRecyclerView.setAdapter(adapter);
        mListInfosRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button boutonNewClient = (Button) findViewById(R.id.newclient);
        boutonNewClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SaisieActivity.class);
                startActivityForResult(i,1);
            }
        });

        mListInfoRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                InfoParcelable ip = dataSnapshot.getValue(InfoParcelable.class);
                myListInfos.add(ip);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                InfoParcelable ip = dataSnapshot.getValue(InfoParcelable.class);
                myListInfos.add(ip);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        /*EditText filtertext = (EditText) findViewById(R.id.filtertext);
        filtertext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if s.
                Cursor cursor = getContentResolver().query(InfoProvider.CONTENT_URI,new String[]{"firstname","lastname","birthtown","birthdate"},
                        "lastname",new String[]{s.toString()},null,null);
                adapter.changeCursor(cursor);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        InfoParcelable ip = data.getParcelableExtra("info");
        Map<String,Object> datamap = ip.toMap();
        Map<String,Object> childUpdates = new HashMap<>();
        String key = mListInfoRef.push().getKey();
        childUpdates.put(key,datamap);
        mListInfoRef.updateChildren(childUpdates);
        /*HashMap<String, String> map = new HashMap<>();
        map.put("Nom", ip.getNom());
        map.put("Prenom", ip.getPrenom());
        map.put("Ville", ip.getVille());
        map.put("Date", ip.getDate());
        listItem.add(map);
        adapter.notifyDataSetChanged();*/
        /*ContentValues cv = new ContentValues();
        cv.put("lastname",ip.getNom());
        cv.put("firstname",ip.getPrenom());
        cv.put("birthtown",ip.getVille());
        cv.put("birthdate",ip.getDate());
        getContentResolver().insert(InfoProvider.CONTENT_URI, cv);
        Cursor cursor = getContentResolver().query(InfoProvider.CONTENT_URI,null,null,null,null);
        adapter.changeCursor(cursor);*/
    }
}
