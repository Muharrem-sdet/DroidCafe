package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private ImageView donut;
    private ImageView iceCream;
    private ImageView froyo;
    private FloatingActionButton fab;
    public static final String EXTRA_MESSAGE = "com.example.droidcafe.MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donut = findViewById(R.id.donut);
        iceCream = findViewById(R.id.ice_cream);
        froyo = findViewById(R.id.froyo);
        fab = findViewById(R.id.fab);

        donut.setOnClickListener(this::onClickImage);
        iceCream.setOnClickListener(this::onClickImage);
        froyo.setOnClickListener(this::onClickImage);
        fab.setOnClickListener(v -> onFABClick());
    }

    public void onClickImage(View v) {
        String message = "You ordered " + v.getContentDescription().toString() + ".";
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void onFABClick() {
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }
}