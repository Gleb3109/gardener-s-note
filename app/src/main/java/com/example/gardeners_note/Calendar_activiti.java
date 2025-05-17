package com.example.gardeners_note;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.ak.ColoredDate;
import com.example.gardeners_note.Record_factory;
import com.ak.KalendarView;


public class Calendar_activiti extends AppCompatActivity {
    KalendarView mKalendarView;
    Record_factory mFactory;
    Calendar_record mRecord;
    TextView mTextView;
    TextView mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calendar_activiti);
        mKalendarView = findViewById(R.id.kalendar);
        mTextView= (TextView)findViewById(R.id.textView3);
        mTextView.setText("");
        mEditText=(TextView)findViewById(R.id.editTextTextMultiLine);
        mFactory=new Record_factory(this);

        ArrayList<ColoredDate> datesColors = new ArrayList<>();
        ArrayList<Calendar_record> mDates =new ArrayList<>();
        mDates =mFactory.getAll();
        //Заполним календарь тестовымиданными
        for(Calendar_record dt : mDates) {
            datesColors.add(new ColoredDate(new Date((dt.getYear()-1900), (dt.getMonth()-1), dt.getDay()), getResources().getColor(R.color.red)));
        }
       mKalendarView.setColoredDates(datesColors);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mKalendarView.setDateSelector(new KalendarView.DateSelector() {
            @Override
            public void onDateClicked(Date dt) {
                 mRecord= mFactory.get(dt.getDate(),dt.getMonth()+1, dt.getYear()+1900);
                mTextView.setText(mRecord.getRecord());
            }
        });
        ImageButton button = findViewById(R.id.imageButton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calendar_activiti.this, MainActivity.class);
                startActivity(intent);

            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date dt=mKalendarView.getSelectedDate();
                Calendar_record cr= new Calendar_record(dt.getDate(),dt.getMonth()+1, dt.getYear()+1900,mEditText.getText().toString());
                mEditText.setText("");
                if (!mRecord.isEmpty){
                    mFactory.edit(cr);
                }else{
                    mFactory.add(cr);
                    datesColors.add(new ColoredDate(new Date((cr.getYear()-1900), (cr.getMonth()-1), cr.getDay()), getResources().getColor(R.color.red)));
                }
            }
        });
        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date dt=mKalendarView.getSelectedDate();
                Calendar_record cr= new Calendar_record(dt.getDate(),dt.getMonth()+1, dt.getYear()+1900,mEditText.getText().toString());
                mTextView.setText("");
                if (!mRecord.isEmpty){
                    mFactory.delate(mRecord);
                    datesColors.removeIf(element -> (Objects.equals(element.date, new Date((cr.getYear()-1900), (cr.getMonth()-1), cr.getDay()))));
                }
            }
        });


    }

    }