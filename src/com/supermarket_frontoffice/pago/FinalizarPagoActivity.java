package com.supermarket_frontoffice.pago;

import com.supermarket_frontoffice.MainActivity;
import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.R.layout;
import com.supermarket_frontoffice.R.menu;
import com.supermarket_frontoffice.lista_compra.ListaCompraActivity;
import com.supermarket_frontoffice.pago.PagoMainActivity.handleButtonConfirmarCompra;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class FinalizarPagoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pago_finalizar);
		findViewById(R.id.btnConfirmPaybox).setOnClickListener(new handleBtnReturn());	//Para el boton de confirmar compra

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.finalizar_pago, menu);
		return true;
	}
	
	class handleBtnReturn implements OnClickListener {		
		public void onClick(View v) {			
			
			Intent intent = new Intent(FinalizarPagoActivity.this, MainActivity.class);
			startActivity(intent);
					    
		}
    }

}
