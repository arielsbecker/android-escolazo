package com.arseb.escolazo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	// Esta variable almacenará la selección del Spinner, evitando luego el switch tan
	// poco elegante.
	// Esta variable se modificará desde OnItemSelected.
	private int mySpinnerSelection = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Spinner spinner = (Spinner) findViewById(R.id.spinnerListaJuegos);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.juegosLoteriaNacional, android.R.layout.simple_spinner_item);
		 // Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		 // Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// Devuelvo la posición dentro del Spinner, sumándole 1
				// para no afectar el valor 0 que determina
				// una "no selección".
				mySpinnerSelection = position + 1;			
			}
			
			public void onNothingSelected(AdapterView<?> parent) {
				mySpinnerSelection = 0;				
			}

		});
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
    	CharSequence myNumbers;
    	TextView textElement = (TextView) findViewById(R.id.textGeneratedNumber);
    	// TODO: mejorar la clase GeneradorAzar para que genere una cadena ya lista
    	// por cada juego.
    	switch (mySpinnerSelection){
    	case 1 :
        	// Loto 5: cinco números del 0 al 36.
    		myNumbers = GeneradorAzar.generarJuego(0, 36, 5);
    		break;
    	case 2 :
        	// Quini 6: seis números del 0 al 45.
    		myNumbers = GeneradorAzar.generarJuego(0, 45, 6);
    		break;
    	case 3 :
    		// Loto tradicional: seis números del 0 al 41.
    		myNumbers = GeneradorAzar.generarJuego(0, 41, 6);
    		break;
    	case 4 :
    		// Quiniela 2 cifras: un número del 0 al 99.
    		myNumbers = GeneradorAzar.generarJuego(0, 99, 1);
    		break;
    	case 5 :
    		// Quiniela 3 cifras: un número del 0 al 999.
    		myNumbers = GeneradorAzar.generarJuego(0, 999, 1);
    		break;
    	case 6 :
    		// Quiniela 4 cifras: un número del 0 al 9999.
    		myNumbers = GeneradorAzar.generarJuego(0, 9999, 1);
    		break;
    	case 7 :
    		// Quiniela poceada: ocho números del 0 al 99.
    		myNumbers = GeneradorAzar.generarJuego(0, 99, 8);
    		break;
    	case 8 :
    		// Brinco: seis números del 0 a 39.
    		myNumbers = GeneradorAzar.generarJuego(0, 39, 6);
    		break;
    	case 9 :
    		// Tombolina: de 3 a 7 números del 0 al 99.
    		myNumbers = GeneradorAzar.generarJuego(0, 99, 7);
    		break;
    	default :
    		// Otro juego, no implementado
    		myNumbers = getString(R.string.stringGameNotImplementedYet);
    		break;
    	}
    	textElement.setText(myNumbers);
    }

}
