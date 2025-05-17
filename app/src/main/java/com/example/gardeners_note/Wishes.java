package com.example.gardeners_note;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Wishes extends AppCompatActivity {
    Wish_factory mFactory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wishes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton button = findViewById(R.id.imageButton3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wishes.this, MainActivity.class);
                startActivity(intent);

            }
        });
        ImageButton button2 = findViewById(R.id.imageButton5);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wishes.this, Wishes_add.class);
                startActivity(intent);

            }
        });
        TableLayout wishes = (TableLayout)findViewById(R.id.tableWish);
        wishes.setStretchAllColumns(true);
        wishes.bringToFront();

        for(int i = 0; i < 3; i++){
            TableRow tr =  new TableRow(this);
            TextView c1 = new TextView(this);
            c1.setText("");
            TextView c2 = new TextView(this);
            c2.setText("");
            TextView c3 = new TextView(this);
            c3.setText("");
            TextView c4 = new TextView(this);
            c4.setText("");
            tr.addView(c1);
            tr.addView(c2);
            tr.addView(c3);
            tr.addView(c4);
            wishes.addView(tr);
        }

        mFactory=new Wish_factory(this);
        ArrayList<Wish_record> mWishs= new ArrayList<>();
        mWishs=mFactory.getAll();
        int i=0;
       for(Wish_record w : mWishs) {
           Log.d("myTag", "Wish " + w.getId());
           i++;
           TableRow tr = new TableRow(this);
           if (i==1) {
               tr.setBackgroundResource(R.color.white);
           } else {
               i=0;
               tr.setBackgroundResource(R.color.lightblue);
           }
            TextView c1 = new TextView(this);
            c1.setText(" " + w.getId());
            TextView c2 = new TextView(this);
            c2.setText(w.getWish_name());
            TextView c3 = new TextView(this);
            c3.setText(w.getWish_note());
            c3.setMaxWidth(150);
            tr.setGravity(Gravity.CENTER_VERTICAL);
            tr.addView(c1);
            tr.addView(c2);
            tr.addView(c3);
            String btnid = "btn"+w.getId();
           ImageButton btDel = new ImageButton(this);
           btDel.setId(w.getId());
           btDel.setImageResource(R.drawable.btn_dell);
           btDel.setBackgroundResource(android.R.color.transparent);
           btDel.setPadding(2, 2, 2, 2);
           btDel.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   mFactory.delete(w.getId());
                   wishes.removeView(tr);
               }
           });
           tr.addView(btDel);
            wishes.addView(tr);
        }


    }
}