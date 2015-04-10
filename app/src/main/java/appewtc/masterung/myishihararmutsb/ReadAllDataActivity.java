package appewtc.masterung.myishihararmutsb;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleCursorAdapter;


public class ReadAllDataActivity extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_read_all_data);

        //Create ListView
        createListView();

    }   // onCreate

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
