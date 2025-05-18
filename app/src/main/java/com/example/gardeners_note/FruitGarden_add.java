package com.example.gardeners_note;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FruitGarden_add extends AppCompatActivity {

    Fruit_factory mFactory;
    TextView mEditText;
    TextView mEditText2;
    TextView mEditText3;
    TextView mType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fruit_garden_add);
        mFactory=new Fruit_factory(this);
        mEditText = (TextView) findViewById(R.id.editTextTextMultiLine4);
        mEditText2 = (TextView) findViewById(R.id.editTextTextMultiLine5);
        mEditText3 = (TextView) findViewById(R.id.editTextTextMultiLine6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Spinner spinner = findViewById(R.id.spinner);
        String[] grdTypes = {String.valueOf(FruitEnum.TREES.getTitle()),
                String.valueOf(FruitEnum.SHRUBS.getTitle()),
                String.valueOf(FruitEnum.VEGETABLES.getTitle()),
                String.valueOf(FruitEnum.BERRIES.getTitle()),
                String.valueOf(FruitEnum.GREENS.getTitle()),};
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, grdTypes);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);
        ImageButton button2 = findViewById(R.id.imageButton8);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FruitGarden_add.this, FruitGarden.class);
                startActivity(intent);
            }
        });
        Button button = findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=spinner.getSelectedItemPosition();
                FruitEnum e=FruitEnum.values()[i];
                FruitGarden_record fruit = new FruitGarden_record(mEditText.getText().toString(),
                        mEditText2.getText().toString(),
                        e,
                        mEditText3.getText().toString());
                mFactory.add(fruit);
                Intent intent = new Intent(FruitGarden_add.this, FruitGarden.class);
                startActivity(intent);
            }
        });
    }

}