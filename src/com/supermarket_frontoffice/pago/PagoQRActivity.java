package com.supermarket_frontoffice.pago;

import com.supermarket_frontoffice.MainActivity;
import com.supermarket_frontoffice.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class PagoQRActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pago_qr);
		findViewById(R.id.btnConfirmQR).setOnClickListener(new handleBtnConfirmQR());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_pago_qr, menu);
		return true;
	}
	
	class handleBtnConfirmQR implements OnClickListener {		
		public void onClick(View v) {	
			
				Intent intent = new Intent(PagoQRActivity.this, FinalizarPagoActivity.class);
				startActivity(intent);			
		
		}
	}

}
