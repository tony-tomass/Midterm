package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//TODO: Section 4 Question 24

public class PickActivity extends AppCompatActivity {

    Button mSubmitButton;
    EditText mFirstNameEdit;

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mFirstNameEdit.setText(mFirstNameEdit.getText().toString().toLowerCase());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick);

        mSubmitButton = findViewById(R.id.button_BT);

        mFirstNameEdit = findViewById(R.id.editText_ET);

        mFirstNameEdit.setText(R.string.secret);

        Toast.makeText(this, mFirstNameEdit.getText().toString(), Toast.LENGTH_LONG).show();

        mSubmitButton.setOnClickListener(listener);

    }
}