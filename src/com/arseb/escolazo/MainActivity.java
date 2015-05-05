package com.arseb.escolazo;

import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
    // Adaptador para mostrar los datos en el listview.
    //SimpleCursorAdapter mAdapter;

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
    	Spinner mySpinner = (Spinner) findViewById(R.id.spinnerListaJuegos);
    	// TODO: cambiar el modo de obtener los valores del Spinner por una solución
    	// más elegante; el método provisto ahora es provisorio.
        switch (mySpinner.getSelectedItem().toString()) {
	        case "Loto 5" :
	        	myNumbers = myRandomGenerator.testRandomNumber(0, 36, 5);
	        	break;
	        case "Loto tradicional" :
	        	myNumbers = myRandomGenerator.testRandomNumber(0, 41, 6);
	        	break;
	        case "Quini 6" :
	        	myNumbers = myRandomGenerator.testRandomNumber(0, 45, 6);
	        	break;
	        case "Quiniela 2 cifras" :
	        	myNumbers = myRandomGenerator.testRandomNumber(0, 99, 1);
	        	break;
	        case "Quiniela 3 cifras" :
	        	myNumbers = myRandomGenerator.testRandomNumber(0, 999, 1);
	        	break;
	        case "Quiniela 4 cifras" :
	        	myNumbers = myRandomGenerator.testRandomNumber(0, 9999, 1);
	        	break;
	        case "Quiniela poceada" :
	        	myNumbers = myRandomGenerator.testRandomNumber(0, 99, 6);
	        	break;
	        default:
	    		myNumbers = "Juego todavía no implementado";
	    		break;
        }
    	textElement.setText(myNumbers);

    }
}
