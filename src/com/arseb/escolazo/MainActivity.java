package com.arseb.escolazo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
    public void generarAleatorio(View view){
    	// Al presionar el botón "Generar".
    	GeneradorAzar myRandomGenerator = new GeneradorAzar();
    	CharSequence myNumbers;
    	TextView textElement = (TextView) findViewById(R.id.textGeneratedNumber);
        textElement.setText(getString(R.string.defaultStartingValue));
        //Valor hardcodeado por el momento para probar si devuelve los números necesarios para el Loto 5.
    	myNumbers = myRandomGenerator.testRandomNumber(0, 36, 5);
    	textElement.setText(myNumbers);

    }
}
