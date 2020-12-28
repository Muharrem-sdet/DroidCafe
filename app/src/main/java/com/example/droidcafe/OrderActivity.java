package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView textView;
    private RadioButton sameDay;
    private RadioButton nextDay;
    private RadioButton pickUp;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        textView = findViewById(R.id.text_view);
        sameDay = findViewById(R.id.same_day);
        nextDay = findViewById(R.id.next_day);
        pickUp = findViewById(R.id.pickup);
        spinner = findViewById(R.id.label_spinner);

        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.phone_type_labels_array,
                        android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        sameDay.setOnClickListener(v -> onClickRadioButton((RadioButton) v));
        nextDay.setOnClickListener(v -> onClickRadioButton((RadioButton) v));
        pickUp.setOnClickListener(v -> onClickRadioButton((RadioButton) v));

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView.setText(message);
    }

    public void onClickRadioButton(RadioButton rd) {
        String message = rd.getText().toString();
        if (rd.isChecked()) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinnerLabel = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, spinnerLabel, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}