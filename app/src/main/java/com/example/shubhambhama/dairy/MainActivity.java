package com.example.shubhambhama.dairy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.DatabaseHandler;
import model.MyWish;

public class MainActivity extends Activity {

    private EditText title;
    private EditText content;
    private Button saveButton;
    private DatabaseHandler dba;
    private Vibrator vib;
    private Button listall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dba = new DatabaseHandler(MainActivity.this);

        title = (EditText) findViewById(R.id.titleEditText);
        content = (EditText) findViewById(R.id.wishEditText);
        saveButton = (Button) findViewById(R.id.saveButton);
        listall=(Button) findViewById(R.id.listall);

        final Vibrator vib=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vib.vibrate(20);

                Toast.makeText(getApplicationContext(), "Data Inserted..!!", Toast.LENGTH_SHORT).show();

                saveToDB();
            }
        });
        listall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vib.vibrate(20);
                Toast.makeText(getApplicationContext(), "Data Listed...!!", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this,DisplayWishesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
    });
    }

    private void saveToDB() {

        MyWish wish = new MyWish();
        wish.setTitle(title.getText().toString().trim());
        wish.setContent(content.getText().toString().trim());


        dba.addWishes(wish);
        dba.close();

        //clear
        title.setText("");
        content.setText("");

        Intent i = new Intent(MainActivity.this, DisplayWishesActivity.class);
        startActivity(i);
    }
}
