package com.example.shubhambhama.dairy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import data.DatabaseHandler;

public class WishDetailActivity extends ActionBarActivity {

    private TextView title, date, content;
    private Button deleteButton;

    private Vibrator vib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_detail);

        title = (TextView) findViewById(R.id.detailsTitle);
        date = (TextView) findViewById(R.id.detailsDateText);
        content = (TextView) findViewById(R.id.detailsTextView);

        deleteButton = (Button) findViewById(R.id.deleteButton);

        final Vibrator vib=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            title.setText(extras.getString("title"));
            String t=extras.getString("title");
            date.setText("Created: " + extras.getString("date"));
            String d=extras.getString("date");
            content.setText(" \" " + extras.getString("content") + " \" ");
            String c=extras.getString("content");

            final int id = extras.getInt("id");

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vib.vibrate(20);
                    DatabaseHandler dba = new DatabaseHandler(getApplicationContext());
                    dba.deleteWish(id);

                    Toast.makeText(getApplicationContext(), "Wish Deleted!", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(WishDetailActivity.this, DisplayWishesActivity.class));
                    WishDetailActivity.this.finish();
                }
            });


        }
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_wish_detail, menu);
        return true;
    }*/

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
