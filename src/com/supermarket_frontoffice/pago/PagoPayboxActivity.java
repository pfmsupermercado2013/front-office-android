package com.supermarket_frontoffice.pago;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.R.layout;
import com.supermarket_frontoffice.R.menu;
import com.supermarket_frontoffice.pago.FinalizarPagoActivity.handleBtnReturn;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class PagoPayboxActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pago_paybox);
		findViewById(R.id.btnConfirmPaybox).setOnClickListener(new handleBtnConfirmPaybox());	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pago_paybox, menu);
		return true;
	}
	
	class handleBtnConfirmPaybox implements OnClickListener {		
		public void onClick(View v) {	
			
			if(confirmPaybox()){
				Intent intent = new Intent(PagoPayboxActivity.this, FinalizarPagoActivity.class);
				startActivity(intent);
			}
			
		}
	}
	
	private boolean confirmPaybox(){
		
		if(sendPaybox()){		
			
			return true;
			
		}
		else{
			
			return false;
		}
	}
	
	private boolean sendPaybox(){
		
		return true;
	}

}
