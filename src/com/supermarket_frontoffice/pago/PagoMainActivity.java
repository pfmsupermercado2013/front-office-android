package com.supermarket_frontoffice.pago;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.R.layout;
import com.supermarket_frontoffice.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PagoMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pago_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pago__main, menu);
		return true;
	}

}
