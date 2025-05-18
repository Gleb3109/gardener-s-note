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

public class OrnamentalGarden extends AppCompatActivity {
    Ornamental_factory mFactory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ornamental_garden);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton button = findViewById(R.id.imageButton4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrnamentalGarden.this, MainActivity.class);
                startActivity(intent);

            }
        });
        ImageButton button2 = findViewById(R.id.imageButton7);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrnamentalGarden.this, OrnamentalGarden_add.class);
                startActivity(intent);
            }
        });
        TableLayout ornament = (TableLayout)findViewById(R.id.tableOrnamentalGarden);
        ornament.setStretchAllColumns(true);
        ornament.bringToFront();
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
            ornament.addView(tr);
        }
        mFactory=new Ornamental_factory(this);
        ArrayList<OrnamentalGarden_record> mOrnamental= new ArrayList<>();
        mOrnamental=mFactory.getAll();
        int i=0;
        for(OrnamentalGarden_record g : mOrnamental) {
            Log.d("myTag", "OrnamentalGarden " + g.getId());
            i++;
            TableRow tr = new TableRow(this);
            if (i==1) {
                tr.setBackgroundResource(R.color.white);
            } else {
                i=0;
                tr.setBackgroundResource(R.color.lightblue);
            }
            TextView c0 = new TextView(this);
            c0.setText(" " + g.getId());
            TextView c1 = new TextView(this);
            c1.setText(g.getOrnamental_type().getTitle());
            TextView c2 = new TextView(this);
            c2.setText(g.getOrnamental_name());
            TextView c3 = new TextView(this);
            c3.setText(g.getOrnamental_note());
            c2.setMaxWidth(140);
            c1.setMaxWidth(130);
            c3.setMaxWidth(150);
            tr.setGravity(Gravity.CENTER_VERTICAL);
            tr.addView(c0);
            tr.addView(c1);
            tr.addView(c2);
            tr.addView(c3);
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
                    ornament.removeView(tr);
                }
            });
            tr.addView(btDel);
            ornament.addView(tr);
        }
    }
}