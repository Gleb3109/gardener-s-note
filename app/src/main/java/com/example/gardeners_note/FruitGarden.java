package com.example.gardeners_note;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
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

public class FruitGarden extends AppCompatActivity {
    Fruit_factory mFactory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fruit_garden);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton button = findViewById(R.id.imageButton4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FruitGarden.this, MainActivity.class);
                startActivity(intent);

            }
        });
        ImageButton button2 = findViewById(R.id.imageButton7);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FruitGarden.this, FruitGarden_add.class);
                startActivity(intent);
            }
        });
        TableLayout fruit = (TableLayout)findViewById(R.id.tableFruitGarden);
        fruit.setStretchAllColumns(true);
        fruit.bringToFront();
        for(int i = 0; i < 3; i++){
            TableRow tr =  new TableRow(this);
        //    TextView c1 = new TextView(this);
        //    c1.setText("");
            TextView c2 = new TextView(this);
            c2.setText("");
            TextView c3 = new TextView(this);
            c3.setText("");
            TextView c4 = new TextView(this);
            c4.setText("");
        //    tr.addView(c1);
            tr.addView(c2);
            tr.addView(c3);
            tr.addView(c4);
            fruit.addView(tr);
        }
        mFactory=new Fruit_factory(this);
        ArrayList<FruitGarden_record> mFruit= new ArrayList<>();
        mFruit = mFactory.getAll();
        int i=0;
        for(FruitGarden_record g : mFruit) {
            Log.d("myTag", "FruitGarden " + g.getId());
            i++;
            TableRow tr = new TableRow(this);
            if (i==1) {
                tr.setBackgroundResource(R.color.white);
            } else {
                i=0;
                tr.setBackgroundResource(R.color.lightblue);
            }
         //   TextView c0 = new TextView(this);
          //  c0.setText(" " + g.getId());
            TextView c1 = new TextView(this);
            c1.setText(g.getFruit_type().getTitle());
            TextView c2 = new TextView(this);
            c2.setText(g.getFruit_name());
            TextView c3 = new TextView(this);
            c3.setText(g.getVariety());
            TextView c4 = new TextView(this);
            c4.setText(g.getFruit_note());
            c4.setMaxWidth(170);
            c3.setMaxWidth(140);
            c2.setMaxWidth(140);
            c1.setMaxWidth(130);
            tr.setGravity(Gravity.CENTER_VERTICAL);
            //   tr.addView(c0);
            tr.addView(c1);
            tr.addView(c2);
            tr.addView(c3);
            tr.addView(c4);
            String btnid = "btn"+g.getId();
            ImageButton btDel = new ImageButton(this);
            btDel.setId(g.getId());
            btDel.setImageResource(R.drawable.btn_dell);
            btDel.setBackgroundResource(android.R.color.transparent);
            btDel.setPadding(2, 2, 2, 2);
            btDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mFactory.delete(g.getId());
                    fruit.removeView(tr);
                }
            });
            tr.addView(btDel);
            fruit.addView(tr);
        }
    }
}