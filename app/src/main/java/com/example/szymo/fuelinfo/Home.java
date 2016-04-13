package com.example.szymo.fuelinfo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Home extends ActionBarActivity {

    Context context;
    TextView dbres;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        getSupportActionBar().setTitle("Witaj");
        setContentView(R.layout.activity_home);
        db = new DBHelper(context);

        dbres = (TextView) findViewById(R.id.textView_dbres);

        for(Road r:db.getAll())
            dbres.append("\n" + r.getKm() + " km, " + r.getIll() + " l, " + r.getAvgUsage() + " l/100km," + r.getUnitPrice() + " PLN, " + r.getTotalPrice()+" PLN,"+ r.getDate());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(context,AddRoad.class);
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }
}
