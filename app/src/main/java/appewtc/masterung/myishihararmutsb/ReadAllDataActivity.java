package appewtc.masterung.myishihararmutsb;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class ReadAllDataActivity extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_read_all_data);

        //Create ListView
        createListView();

    }   // onCreate

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Cursor objCursor = (Cursor) l.getItemAtPosition(position);
        String strTimeData = objCursor.getString(objCursor.getColumnIndex(IshiharaTABLE.COLUMN_TIMEDATE));
        String strScore = objCursor.getString(objCursor.getColumnIndex(IshiharaTABLE.COLUMN_SCORE));

        //Intent to Show Detail
        Intent objIntent = new Intent(ReadAllDataActivity.this, ShowDetailActivity.class);
        objIntent.putExtra("Time", strTimeData);
        objIntent.putExtra("MyScore", strScore);
        startActivity(objIntent);

    }

    private void createListView() {
        IshiharaTABLE objIshiharaTABLE = new IshiharaTABLE(this);
        Cursor listTimeData = objIshiharaTABLE.readAllData();
        String[] strFrom = new String[]{IshiharaTABLE.COLUMN_TIMEDATE};
        int[] intTarget = new int[]{R.id.txtShowTime};
        SimpleCursorAdapter objSimpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.activity_read_all_data, listTimeData, strFrom, intTarget);
        setListAdapter(objSimpleCursorAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_read_all_data, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}   //Main Class
