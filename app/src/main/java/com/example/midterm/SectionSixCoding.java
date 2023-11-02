package com.example.midterm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SectionSixCoding extends AppCompatActivity {

    EditText name_et, number_et, type_et, fandom_et, on_et, ultimate_et, price_et;
    ListView list_lv;
    Button save_bt;
    Cursor cursor;
    SimpleCursorAdapter simpleCursorAdapter;
    String[] col_names = new String[] {
            "_id",
            SectionSixContentProvider.COL1_NAME,
            SectionSixContentProvider.COL2_NAME,
            SectionSixContentProvider.COL3_NAME,
            SectionSixContentProvider.COL4_NAME,
            SectionSixContentProvider.COL5_NAME,
            SectionSixContentProvider.COL6_NAME,
            SectionSixContentProvider.COL7_NAME,
    };
    int[] view_ids = new int[]{
            R.id._id,
            R.id.name_row_TV,
            R.id.number_row_TV,
            R.id.type_row_TV,
            R.id.fandom_row_TV,
            R.id.on_row_TV,
            R.id.ultimate_row_TV,
            R.id.price_row_TV,
    };

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
        save_bt = findViewById(R.id.save_BT);

        save_bt.setOnClickListener(save_listener);

        registerForContextMenu(list_lv);

        updateListUI();

    }

    public void updateListUI() {
        cursor = getContentResolver().query(SectionSixContentProvider.CONTENT_URI, col_names,
                null, null, null);
        simpleCursorAdapter = new SimpleCursorAdapter(
                getApplicationContext(),
                R.layout.row,
                cursor,
                col_names,
                view_ids,
                0
        );

        list_lv.setAdapter(simpleCursorAdapter);
    }

    View.OnClickListener save_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            ContentValues new_vals = new ContentValues();
            new_vals.put(SectionSixContentProvider.COL1_NAME, name_et.getText().toString().trim());
            new_vals.put(SectionSixContentProvider.COL2_NAME, Integer.parseInt(number_et.getText().toString().trim()));
            new_vals.put(SectionSixContentProvider.COL3_NAME, type_et.getText().toString().trim());
            new_vals.put(SectionSixContentProvider.COL4_NAME, fandom_et.getText().toString().trim());
            new_vals.put(SectionSixContentProvider.COL5_NAME, Integer.parseInt(on_et.getText().toString().trim()));
            new_vals.put(SectionSixContentProvider.COL6_NAME, ultimate_et.getText().toString().trim());
            new_vals.put(SectionSixContentProvider.COL7_NAME, Double.parseDouble(price_et.getText().toString().trim()));
            getContentResolver().insert(SectionSixContentProvider.CONTENT_URI, new_vals);

            Toast.makeText(getApplicationContext(), "FunkoPOP Saved!", Toast.LENGTH_LONG).show();

            updateListUI();

        }
    };

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        TextView name_row_tv = findViewById(view_ids[1]);
        TextView number_row_tv = findViewById(view_ids[2]);

        String selected_clauses = SectionSixContentProvider.COL1_NAME + " = ? " + " AND " +
                SectionSixContentProvider.COL2_NAME + " = ? ";

        String[] selected_args = new String[]{
                name_row_tv.getText().toString().trim(),
                number_row_tv.getText().toString().trim(),
        };

        getContentResolver().delete(SectionSixContentProvider.CONTENT_URI, selected_clauses, selected_args);

        Toast.makeText(getApplicationContext(), "Entry has been deleted", Toast.LENGTH_SHORT).show();

        updateListUI();

        return super.onContextItemSelected(item);

    }
}