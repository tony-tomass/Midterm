package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class SectionSixCoding extends AppCompatActivity {

    EditText name_et, number_et, type_et, fandom_et, on_et, ultimate_et, price_et;
    ListView list_lv;
    Button save_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_six_coding);

        name_et = findViewById(R.id.name_ET);
        number_et = findViewById(R.id.number_ET);
        type_et = findViewById(R.id.type_ET);
        fandom_et = findViewById(R.id.fandom_ET);
        on_et = findViewById(R.id.on_ET);
        ultimate_et = findViewById(R.id.ultimate_ET);
        price_et = findViewById(R.id.price_ET);
        list_lv = findViewById(R.id.list_LV);

        save_bt.setOnClickListener(save_listener);

    }

    View.OnClickListener save_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "FunkoPop Saved!", Toast.LENGTH_LONG).show();
        }
    };
}