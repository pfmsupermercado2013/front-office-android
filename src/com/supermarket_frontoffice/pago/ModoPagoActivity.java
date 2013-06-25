package com.supermarket_frontoffice.pago;

import com.supermarket_frontoffice.MainActivity;
import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.R.layout;
import com.supermarket_frontoffice.R.menu;
import com.supermarket_frontoffice.recorrido_optimo.RecorridoOptimoMainActivity;
import com.supermarket_frontoffice.utils.Utils;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class ModoPagoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pago_modo);
		findViewById(R.id.btnNFC).setOnClickListener(new handleBtnNFC());
		findViewById(R.id.btnPaybox).setOnClickListener(new handleBtnPaybox());	

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.modo_pago, menu);
		return true;
	}
	
	class handleBtnNFC implements OnClickListener {		
		public void onClick(View v) {
			Intent intent = new Intent(ModoPagoActivity.this, PagoNFCActivity.class);
		    startActivity(intent);	
		}
    }
	
	class handleBtnPaybox implements OnClickListener {		
		public void onClick(View v) {
			Intent intent = new Intent(ModoPagoActivity.this, PagoPayboxActivity.class);
		    startActivity(intent);	
		}
    }

}
