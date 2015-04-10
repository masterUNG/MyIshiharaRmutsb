package appewtc.masterung.myishihararmutsb;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class ShowDetailActivity extends ActionBarActivity {

    //Explicit
    private TextView txtShowTime, txtShowScore;
    private String strShowTime, strShowScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        bindWidget();

        showDetail();

    }   //onCreate

    public void clickBack(View view) {
        finish();
    }

    private void showDetail() {
        strShowTime = getIntent().getExtras().getString("Time");
        strShowScore = getIntent().getExtras().getString("MyScore");
        txtShowTime.setText(strShowTime);
        txtShowScore.setText("Score = " + strShowScore);
    }

    private void bindWidget() {
        txtShowTime = (TextView) findViewById(R.id.txtMyShowTime);
        txtShowScore = (TextView) findViewById(R.id.txtMyShowScore);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_detail, menu);
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
}   // Main Class
