package appewtc.masterung.myishihararmutsb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 4/10/15 AD.
 */
public class IshiharaTABLE {

    //Explicit
    private MyOpenHelperSQLite objMyOpenHelperSQLite;
    private SQLiteDatabase writeSQLite, readSQLite;

    public IshiharaTABLE(Context context) {

        objMyOpenHelperSQLite = new MyOpenHelperSQLite(context);
        writeSQLite = objMyOpenHelperSQLite.getWritableDatabase();
        readSQLite = objMyOpenHelperSQLite.getReadableDatabase();

    }   // Constructor

}   // Main Class
