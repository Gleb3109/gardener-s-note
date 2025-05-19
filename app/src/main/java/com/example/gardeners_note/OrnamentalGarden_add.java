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

public class OrnamentalGarden_add extends AppCompatActivity {
    Ornamental_factory mFactory;
    TextView mEditText;
    TextView mEditText2;
    TextView mType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ornamental_garden_add);
        mFactory=new Ornamental_factory(this);
        mEditText = (TextView) findViewById(R.id.editTextTextMultiLine4);
        mEditText2 = (TextView) findViewById(R.id.editTextTextMultiLine5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Spinner spinner = findViewById(R.id.spinner);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item,list);
        String[] grdTypes = {String.valueOf(GardenEnum.TREES.getTitle()),
                String.valueOf(GardenEnum.SHRUBS.getTitle()),
                String.valueOf(GardenEnum.CONIFERS.getTitle()),
                String.valueOf(GardenEnum.VINES.getTitle()),
                String.valueOf(GardenEnum.PERENNIALS.getTitle()),
                String.valueOf(GardenEnum.ANNUALS.getTitle()),};
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, grdTypes);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);
        ImageButton button2 = findViewById(R.id.imageButton8);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrnamentalGarden_add.this, OrnamentalGarden.class);
                startActivity(intent);
            }
        });
        Button button = findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=spinner.getSelectedItemPosition();
                GardenEnum e=GardenEnum.values()[i];
                OrnamentalGarden_record ornament = new OrnamentalGarden_record(mEditText.getText().toString(),
                        mEditText2.getText().toString(),
                        e);
                mFactory.add(ornament);
                Intent intent = new Intent(OrnamentalGarden_add.this, OrnamentalGarden.class);
                startActivity(intent);
            }
        });
    }
}