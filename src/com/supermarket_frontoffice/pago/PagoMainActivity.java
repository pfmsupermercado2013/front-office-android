package com.supermarket_frontoffice.pago;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.lista_compra.ListaCompraActivity;
import com.supermarket_frontoffice.utils.Utils;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class PagoMainActivity extends Activity {

	private TextView texto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pago_main);
		findViewById(R.id.btnConfirm).setOnClickListener(new handleButtonConfirmarCompra());	//Para el boton de confirmar compra
		findViewById(R.id.btnRevisarProductos).setOnClickListener(new handleButtonRevisarProductos());	//Para el boton de revisar productos
		
		texto  = (TextView)findViewById(R.id.textCantidad);
		
		loadData();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pago__main, menu);
		return true;
	}
	
	private void loadData(){		
		
		if(texto != null ){
			
			texto.setText("11,11€"); //TODO
		}
		
	}
	
	class handleButtonConfirmarCompra implements OnClickListener {		
		public void onClick(View v) {
			
			if(false){
				Utils.myCustomAlert(getString(R.string.NotMoney),PagoMainActivity.this);
			}
			else{
			
			    Intent intent = new Intent(PagoMainActivity.this, ModoPagoActivity.class);
			    startActivity(intent);		    		    
			
			}
		}
    }
	
	class handleButtonRevisarProductos implements OnClickListener {		
		public void onClick(View v) {			
			
			Intent intent = new Intent(PagoMainActivity.this, ListaCompraActivity.class);
			startActivity(intent);
					    
		}
    }
	
	

}
