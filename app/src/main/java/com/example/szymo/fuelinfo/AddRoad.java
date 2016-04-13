package com.example.szymo.fuelinfo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class AddRoad extends ActionBarActivity {

    EditText editText_km, editText_ill, editText_Unitprice, editText_date;
    Button button_add;
    Context context;
    double avgUsage, totalPrice;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_road);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        context = getApplicationContext();
        db = new DBHelper(context);

        editText_km = (EditText) findViewById(R.id.editText_km);
        editText_ill = (EditText) findViewById(R.id.editText_ill);
        editText_Unitprice = (EditText) findViewById(R.id.editText_price);
        editText_date = (EditText)findViewById(R.id.editText_date);
        editText_date.setText(dateFormat.format(date));



        button_add = (Button) findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Home.class);
                if(editText_km.getText().toString().equals("") || editText_ill.getText().toString().equals("") || editText_Unitprice.getText().toString().equals("")){
                    Toast.makeText(context, "Uzupelnij wysztkie dane", Toast.LENGTH_LONG).show();
                }
                else {

                    //
                    avgUsage = (100*Double.parseDouble(editText_ill.getText().toString()))/Double.parseDouble(editText_km.getText().toString());
                    totalPrice = Double.parseDouble(editText_ill.getText().toString()) * Double.parseDouble(editText_Unitprice.getText().toString());
                    Road r = new Road(editText_km.getText().toString(),editText_ill.getText().toString(),""+String.format("%1.2f", avgUsage), editText_Unitprice.getText().toString(), ""+String.format("%1.2f", totalPrice), editText_date.getText().toString());
                    db.addRoad(r);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_add_road, menu);
        return true;
    }

    @Override
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
    }
}
