package com.example.gardeners_note;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class Lunar_calendar extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lunar_calendar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton button = findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lunar_calendar.this, MainActivity.class);
                startActivity(intent);

            }
        });
        int day;
        int month;
        int year;
        int a;
        Date current = new Date();
        day= current.getDate();
        month=current.getMonth()+1;
        year=current.getYear()+1970;
        if (month==1 || month==2){
            month=month+12;
        }
        a=(year%19)/19*209;
        double w = Math.round(a);
        a= (int) Math.round((w-3+day+month)%30);
        TextView mtV= findViewById(R.id.textView4);
        TextView mtV2= findViewById(R.id.textView2);
        TextView mtV3= findViewById(R.id.textView5);
        TextView mtV4= findViewById(R.id.textView6);
        ImageView imageView = (ImageView) findViewById(R.id.imageView4);

        if (a==0){
            mtV.setText("Сейчас новолуние");
            imageView.setImageResource(R.drawable.photo_5276016729706851909_m);
        }else if (a>0 && a<15){
            mtV.setText("Сейчас растущая луна, еще " +  (15-a) + " дней");
            mtV3.setText("Новолуние через "+(30-a) + " дней");
            mtV4.setText("Полнолуние через "+(15-a) + " дней");
            imageView.setImageResource(R.drawable.photo_5276016729706851914_m);
        }else if (a==15){
            mtV.setText("Сейчас полнолуние");
            imageView.setImageResource(R.drawable.photo_5276016729706851912_m);
        }else {
            mtV.setText("Сейчас убывающая луна, еще " +  (30-a) + " дней");
            mtV4.setText("Полнолуние через "+(45-a) + " дней");
            imageView.setImageResource(R.drawable.photo_5276016729706851916_m);
        }
        mtV2.setText("Сегодня "+day+"."+month+"."+year);
        mtV3.setText("Новолуние через "+(30-a) + " дней");

      //  mtV.setText(a);


    }
}