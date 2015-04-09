package appewtc.masterung.myishihararmutsb;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    //Explicit
    private TextView txtQuestion;
    private ImageView imvIshihara;
    private RadioGroup ragChoice;
    private RadioButton radChoice1, radChoice2, radChoice3, radChoice4;
    private Button btnAnswer;
    private int intRadio, intIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind Widget
        bindWidget();

        // Button Controller
        buttonController();

        // Radio Controller
        radioController();

    }   //onCreate

    private void radioController() {
        ragChoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.radioButton:
                        intRadio = 1;
                        break;
                    case R.id.radioButton2:
                        intRadio = 2;
                        break;
                    case R.id.radioButton3:
                        intRadio = 3;
                        break;
                    case R.id.radioButton4:
                        intRadio = 4;
                        break;
                    default:
                        intRadio = 0;
                        break;
                }   //switch

            }   // event
        });
    }

    private void buttonController() {
        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check Zero
                checkZero();

            }   //event
        });
    }

    private void checkZero() {
        if (intRadio == 0) {

            //Show Dialog
            MyAlertDialog objMyAlertDialog = new MyAlertDialog();
            objMyAlertDialog.myDialog(MainActivity.this);

        } else {

            //Check Times
            checkTimes();

        }
    }

    private void checkTimes() {
        if (intIndex == 9) {

            // Intent to ShowScore
            Intent objIntent = new Intent(MainActivity.this, ShowScoreActivity.class);
            startActivity(objIntent);
            finish();

        } else {

            intIndex += 1;

        }
    }

    private void bindWidget() {
        txtQuestion = (TextView) findViewById(R.id.textView2);
        imvIshihara = (ImageView) findViewById(R.id.imageView);
        ragChoice = (RadioGroup) findViewById(R.id.ragChoice);
        radChoice1 = (RadioButton) findViewById(R.id.radioButton);
        radChoice2 = (RadioButton) findViewById(R.id.radioButton2);
        radChoice3 = (RadioButton) findViewById(R.id.radioButton3);
        radChoice4 = (RadioButton) findViewById(R.id.radioButton4);
        btnAnswer = (Button) findViewById(R.id.button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}   // Main Class นี่คือคลาสหลัก
