package com.example.routefinder;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    EditText whereFrom, whereTo, Day, Month, Year;
    SeekBar seekBar;
    Button buttonSubmit;
    Button buttonReturn;
    TextView result;
    TextView cheap;
    TextView fast;
    TextView Price;
    TextView Time;
    TextView Steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        whereFrom  = (EditText) findViewById(R.id.whereFrom);
        whereTo = (EditText) findViewById(R.id.whereTo);
        Day = (EditText) findViewById(R.id.Day);
        Month = (EditText) findViewById(R.id.Month);
        Year = (EditText) findViewById(R.id.Year);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonReturn = (Button) findViewById(R.id.buttonReturn);
        fast = (TextView) findViewById(R.id.fast);
        cheap = (TextView) findViewById(R.id.cheap);
        Price = (TextView) findViewById(R.id.Price);
        Time = (TextView) findViewById(R.id.Time);
        Steps = (TextView) findViewById(R.id.Steps);
        result = (TextView) findViewById(R.id.result);
    }
        public void submit(View v) {
            String origin = whereFrom.getText().toString();
            whereFrom.setVisibility(View.GONE);
            String destination = whereTo.getText().toString();
            whereTo.setVisibility(View.GONE);
            int day = Integer.parseInt(Day.getText().toString());
            Day.setVisibility(View.GONE);
            int month;
            switch(Month.getText().toString()){
                case "January": month = 1;
                break;
                case "january": month = 1;
                break;
                case "February": month = 2;
                    break;
                case "february": month = 2;
                    break;
                case "March": month = 3;
                    break;
                case "march": month = 3;
                    break;
                case "April": month = 4;
                    break;
                case "april": month = 4;
                    break;
                case "May": month = 5;
                    break;
                case "may": month = 5;
                    break;
                case "June": month = 6;
                    break;
                case "june": month = 6;
                    break;
                case "July": month = 7;
                    break;
                case "july": month = 7;
                    break;
                case "August": month = 8;
                    break;
                case "august": month = 8;
                    break;
                case "September": month = 9;
                    break;
                case "september": month = 9;
                    break;
                case "October": month = 10;
                    break;
                case "october": month = 10;
                    break;
                case "Novermber": month = 11;
                    break;
                case "november": month = 11;
                    break;
                case "December": month = 12;
                    break;
                case "december": month = 12;
                    break;
            }
            Month.setVisibility(View.GONE);
            int year = Integer.parseInt(Year.getText().toString());
            Year.setVisibility(View.GONE);
            int cheapness = seekBar.getProgress();
            seekBar.setVisibility(View.GONE);
            buttonSubmit.setVisibility(View.GONE);
            buttonReturn.setVisibility(View.VISIBLE);
            fast.setVisibility(View.GONE);
            cheap.setVisibility(View.GONE);
//            Price.setText(setPrice());
            Price.setVisibility(View.VISIBLE);
            Time.setVisibility(View.VISIBLE);
            Steps.setVisibility(View.VISIBLE);
            result.setText("Where From:"+origin+"Where To:"+destination+"How cheap?"+cheapness);
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

}
