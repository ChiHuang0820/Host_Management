package com.example.admin.hostmanagement;

import android.app.DatePickerDialog;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView mTV;
    TextView mTV1;
    Button mBtn;
    Button mBtn1;

    Calendar c;
    Calendar c1;
    DatePickerDialog dpd;
    DatePickerDialog dpd1;

    SeekBar seekBar;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTV = (EditText) findViewById(R.id.editDate);
        mBtn = (Button) findViewById(R.id.btnDate);

        mBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                            mTV.setText(mYear + "-" + (mMonth+1) + "-" + mDay );
                    }
                }, year, month, day);
                dpd.show();
            }
        });


        mTV1 = (EditText) findViewById(R.id.editendDate);
        mBtn1 = (Button) findViewById(R.id.endDate);

        mBtn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                c1 = Calendar.getInstance();
                int day = c1.get(Calendar.DAY_OF_MONTH);
                int month = c1.get(Calendar.MONTH);
                int year = c1.get(Calendar.YEAR);

                dpd1 = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        mTV1.setText(mYear + "-" + (mMonth+1) + "-" + mDay );
                    }
                }, year, month, day);
                dpd1.show();
            }
        });



        Spinner business_period = (Spinner)findViewById(R.id.period_spinner);
        ArrayAdapter<CharSequence> businessAdapter = ArrayAdapter.createFromResource(
                this, R.array.period_array, android.R.layout.simple_spinner_item );
        business_period.setAdapter(businessAdapter);
        businessAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        business_period.setAdapter(businessAdapter);


        Spinner realtime = (Spinner)findViewById(R.id.realtime_spinner);
        ArrayAdapter<CharSequence> realtimeAdapter = ArrayAdapter.createFromResource(
                this, R.array.realtime_array, android.R.layout.simple_spinner_item );
        realtime.setAdapter(realtimeAdapter);
        realtimeAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        realtime.setAdapter(realtimeAdapter);


        Spinner type = (Spinner)findViewById(R.id.type_spinner);
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(
                this, R.array.type_array, android.R.layout.simple_spinner_item );
        type.setAdapter(typeAdapter);
        typeAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(typeAdapter);



        seekBar = (SeekBar) findViewById(R.id.cost_seekBar);
        txt = (TextView) findViewById(R.id.cost);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txt.setText("Cost Price $" + Integer.toString(progress));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    Log.e("------------", "Start");
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    Log.e("------------", "Pause");
                }
            });




    }
}
