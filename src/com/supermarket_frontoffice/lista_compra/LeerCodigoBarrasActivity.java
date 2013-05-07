package com.supermarket_frontoffice.lista_compra;

import com.supermarket_frontoffice.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LeerCodigoBarrasActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leer_codigo_barras);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.leer_codigo_barras, menu);
		return true;
	}

}
