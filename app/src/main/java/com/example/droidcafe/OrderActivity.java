package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    private TextView textView;
    private RadioButton sameDay;
    private RadioButton nextDay;
    private RadioButton pickUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        textView = findViewById(R.id.text_view);
        sameDay = findViewById(R.id.same_day);
        nextDay = findViewById(R.id.next_day);
        pickUp = findViewById(R.id.pickup);

        sameDay.setOnClickListener(v -> onClickRadioButton((RadioButton)v));
        nextDay.setOnClickListener(v -> onClickRadioButton((RadioButton)v));
        pickUp.setOnClickListener(v -> onClickRadioButton((RadioButton)v));

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView.setText(message);
    }

    public void onClickRadioButton(RadioButton rd){
        String message = rd.getText().toString();
        if(rd.isChecked()){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}