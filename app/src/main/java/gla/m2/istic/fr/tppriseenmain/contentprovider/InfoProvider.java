package gla.m2.istic.fr.tppriseenmain.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by nirina on 08/02/17.
 */

public class InfoProvider extends ContentProvider {

    static final String AUTHORITY = "infoprovider";

    public static final String PROVIDER_NAME = "infoprovider";

    public static final Uri CONTENT_URI = Uri.parse("content://"+ PROVIDER_NAME);

    //private SQLiteDatabase db;
    private MySQLiteHelper helper;
    /*private static final String DATABASE_CREATE = "create table infos (" +
            "_id integer primary key autoincrement," +
            "lastname string," +
            "firstname string," +
            "birthdate string," +
            "birthtown string);";*/

    @Override
    public boolean onCreate() {
        helper = new MySQLiteHelper(getContext());
        //db = SQLiteDatabase.openOrCreateDatabase("infos.db", null);
        //db.execSQL(DATABASE_CREATE);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query("infos",projection,selection,selectionArgs,null,null,sortOrder,null);
        return cursor;
    }

    public Cursor filterByName(String name){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query("infos",new String[]{"firstname","lastname","birthtown","birthdate"},
                "lastname",new String[]{name},null,null,null);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.insert("infos",null,values);
        db.close();
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = helper.getWritableDatabase();
        int res = db.delete("infos",selection,selectionArgs);
        return res;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = helper.getWritableDatabase();
        int res = db.update("infos",values,selection,selectionArgs);
        db.close();
        return res;
    }
}
