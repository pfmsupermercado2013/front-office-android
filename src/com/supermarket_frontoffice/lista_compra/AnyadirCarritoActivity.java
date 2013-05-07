package com.supermarket_frontoffice.lista_compra;

import com.supermarket_frontoffice.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AnyadirCarritoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_anyadir_carrito);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.anyadir_carrito, menu);
		return true;
	}

}
