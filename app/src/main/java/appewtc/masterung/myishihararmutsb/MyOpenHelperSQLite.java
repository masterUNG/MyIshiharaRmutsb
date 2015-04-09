package appewtc.masterung.myishihararmutsb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by masterUNG on 4/9/15 AD.
 */
public class MyOpenHelperSQLite extends SQLiteOpenHelper{

    //Explicit
    private static final String DATABASE_NAME = "ishihara.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE_TABLE = "create table ishiharaTABLE (_id integer primary key, timeDate text, Score text);";

    public MyOpenHelperSQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }   // Constructor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}   // Main Class
