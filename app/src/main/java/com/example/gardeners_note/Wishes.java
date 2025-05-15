package com.example.gardeners_note;

import android.content.Intent;
import android.os.Bundle;
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

public class Wishes extends AppCompatActivity {

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
        TableLayout prices = (TableLayout)findViewById(R.id.tableWish);
        prices.setStretchAllColumns(true);
        prices.bringToFront();
        for(int i = 0; i < 3; i++){
            TableRow tr =  new TableRow(this);
            TextView c1 = new TextView(this);
            c1.setText("№"+i);
            TextView c2 = new TextView(this);
            c2.setText("Мак"+i);
            TextView c3 = new TextView(this);
            c3.setText("красный цветок "+i);
            tr.addView(c1);
            tr.addView(c2);
            tr.addView(c3);
            prices.addView(tr);
        }
    }
}