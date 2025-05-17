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

import java.util.Date;

public class Wishes_add extends AppCompatActivity {
    TextView mEditText;
    TextView mEditText2;
    Wish_factory mFactory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wishes_add);
        mFactory=new Wish_factory(this);
        mEditText = (TextView) findViewById(R.id.editTextTextMultiLine2);
        mEditText2 = (TextView) findViewById(R.id.editTextTextMultiLine3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton button2 = findViewById(R.id.imageButton6);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wishes_add.this, Wishes.class);
                startActivity(intent);

            }
        });
        Button button = findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wish_record wish = new Wish_record(mEditText.getText().toString(), mEditText2.getText().toString());
                mFactory.add(wish);
                Intent intent = new Intent(Wishes_add.this, Wishes.class);
                startActivity(intent);
            }
        });
    }
}