package appewtc.masterung.myishihararmutsb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 4/10/15 AD.
 */
public class IshiharaTABLE {

    //Explicit
    private MyOpenHelperSQLite objMyOpenHelperSQLite;
    private SQLiteDatabase writeSQLite, readSQLite;

    public static final String TABLE_NAME = "ishiharaTABLE";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TIMEDATE = "timeDate";
    public static final String COLUMN_SCORE = "Score";

    public IshiharaTABLE(Context context) {

        objMyOpenHelperSQLite = new MyOpenHelperSQLite(context);
        writeSQLite = objMyOpenHelperSQLite.getWritableDatabase();
        readSQLite = objMyOpenHelperSQLite.getReadableDatabase();

    }   // Constructor

    //Read All Data
    public Cursor readAllData() {

        Cursor objCursor = readSQLite.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_TIMEDATE, COLUMN_SCORE}, null, null, null, null, null);
        if (objCursor != null) {
            objCursor.moveToFirst();
        }

        return objCursor;
    }

    //Update New Value to SQLite
    public long addNewData(String strTimeDate, String strScore) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_TIMEDATE, strTimeDate);
        objContentValues.put(COLUMN_SCORE, strScore);
        return writeSQLite.insert(TABLE_NAME, null, objContentValues);
    }

}   // Main Class
