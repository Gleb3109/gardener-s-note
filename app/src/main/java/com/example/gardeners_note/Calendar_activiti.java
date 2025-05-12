package com.example.gardeners_note;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calendar_activiti extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calendar_activiti);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    class calendar_record {
        private int day;
        private int month;
        private int year;
        private String record;

        public calendar_record(int day, int month, int year, String record) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.record = record;
        }

        public int getDay() {
            return day;
        }

        public int getMonth() {
            return month;
        }

        public int getYear() {
            return year;
        }

        public String getRecord() {
            return record;
        }
    }
    public static class record_factory {
        public static void add() {

        }
        public static void edit() {

        }
        public static void delate() {

        }
        public static void get() {

        }
    }
}