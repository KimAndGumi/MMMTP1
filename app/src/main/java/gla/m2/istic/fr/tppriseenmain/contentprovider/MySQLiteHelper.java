package gla.m2.istic.fr.tppriseenmain.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nirina on 08/02/17.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_CREATE = "create table infos (" +
            "_id integer primary key autoincrement," +
            "lastname string," +
            "firstname string," +
            "birthdate string," +
            "birthtown string);";

    public MySQLiteHelper(Context context) {
        super(context, "infos.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
