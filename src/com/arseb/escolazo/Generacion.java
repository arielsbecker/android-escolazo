package com.arseb.escolazo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class Generacion extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generacion);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.generacion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void generateRandomNumber(View view) {
    	Random myNumberGenerator;
    	int myLuckyNumber;
    	myLuckyNumber=0;
    	myNumberGenerator = new Random();
    	myLuckyNumber=myNumberGenerator.nextInt(10000);
        TextView textElement = (TextView) findViewById(R.id.textGeneratedNumber);
        textElement.setText(Integer.toString(myLuckyNumber));
    }

}
