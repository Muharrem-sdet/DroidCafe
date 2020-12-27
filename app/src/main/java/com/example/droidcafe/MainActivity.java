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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donut = findViewById(R.id.donut);
        iceCream = findViewById(R.id.ice_cream);
        froyo = findViewById(R.id.froyo);
        fab = findViewById(R.id.fab);

        donut.setOnClickListener(this::onClickToast);
        iceCream.setOnClickListener(this::onClickToast);
        froyo.setOnClickListener(this::onClickToast);
        fab.setOnClickListener(v -> onFABClick());
    }

    public void onClickToast(View v) {
        String message = "You ordered " + v.getContentDescription().toString() + ".";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onFABClick() {
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }
}