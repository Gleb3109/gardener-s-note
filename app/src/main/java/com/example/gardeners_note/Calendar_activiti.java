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

import com.ak.ColoredDate;
import com.example.gardeners_note.Record_factory;
import com.ak.KalendarView;


public class Calendar_activiti extends AppCompatActivity {
    KalendarView mKalendarView;
    Record_factory mFactory;
    Calendar_record mRecord;
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calendar_activiti);
        mKalendarView = findViewById(R.id.kalendar);
        mTextView= (TextView)findViewById(R.id.textView3);
        mFactory=new Record_factory();

        List<ColoredDate> datesColors = new ArrayList<>();
        List<Calendar_record> mDates =mFactory.getMonth(5,2005);
        datesColors.add(new ColoredDate(new Date(), getResources().getColor(R.color.blue)));
        //Заполним календарь тестовымиданными
        for(Calendar_record dt : mDates) {
            datesColors.add(new ColoredDate(new Date((dt.getYear()-1900), (dt.getMonth()-1), dt.getDay()), getResources().getColor(R.color.blue)));
        }
        mKalendarView.setColoredDates(datesColors);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mKalendarView.setDateSelector(new KalendarView.DateSelector() {
            @Override
            public void onDateClicked(Date selectedDate) {
                    mRecord=mFactory.get(1,5,2025);
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

    }

    }