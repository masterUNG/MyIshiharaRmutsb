package appewtc.masterung.myishihararmutsb;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ShowScoreActivity extends ActionBarActivity {

    //Explicit
    private TextView txtShowScore;
    private String strMyScore;
    private IshiharaTABLE objIshiharaTABLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        //Initial Widget
        txtShowScore = (TextView) findViewById(R.id.txtShowScore);
        int intMyScore = getIntent().getExtras().getInt("Score");
        txtShowScore.setText(Integer.toString(intMyScore) + "/10");
        strMyScore = Integer.toString(intMyScore);

        //Create and Connected
        objIshiharaTABLE = new IshiharaTABLE(this);

    }   // onCreate

    public void clickPlay(View view) {
        Intent objIntent = new Intent(ShowScoreActivity.this, MainActivity.class);
        startActivity(objIntent);
        finish();
    }

    public void clickExit(View view) {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_score, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itemSaveData:
                confirmDialog();
                break;
            case R.id.itemReadAll:
                Intent objIntent = new Intent(ShowScoreActivity.this, ReadAllDataActivity.class);
                startActivity(objIntent);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void confirmDialog() {

        //Get Time
        DateFormat objDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date objDate = new Date();
        final String strMyDateTime = objDateFormat.format(objDate);

        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this);
        objBuilder.setIcon(R.drawable.icon_question);
        objBuilder.setTitle("ยืนยันการบันทึก");
        objBuilder.setMessage("เวลา = " + strMyDateTime + "\n" + "คะแนน = " + strMyScore + " แต้ม");
        objBuilder.setCancelable(false);
        objBuilder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        objBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                objIshiharaTABLE.addNewData(strMyDateTime, strMyScore);

                dialogInterface.dismiss();

                Toast.makeText(ShowScoreActivity.this, "Update New Value Finish", Toast.LENGTH_SHORT).show();
            }
        });
        objBuilder.show();


    }
}   // Main Class
