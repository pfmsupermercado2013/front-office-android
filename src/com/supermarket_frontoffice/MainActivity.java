package com.supermarket_frontoffice;
import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.R.id;
import com.supermarket_frontoffice.R.layout;
import com.supermarket_frontoffice.R.menu;
import com.supermarket_frontoffice.lista_compra.ListaCompraActivity;
import com.supermarket_frontoffice.pago.PagoMainActivity;
import com.supermarket_frontoffice.recorrido_optimo.RecorridoOptimoMainActivity;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.btnCompraGuiada).setOnClickListener(new handleButton());	//Para el boton del la compra guiada
		findViewById(R.id.btnPagarCompra).setOnClickListener(new handleBtnPurchasePay());	//Para el boton del pago de la compra

	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class handleButton implements OnClickListener {		
		public void onClick(View v) {
			boolean bRequest = myCustomAlert("Carrito de la compra vacio. Imposible iniciar la compra guiada");
		    Intent intent = new Intent(MainActivity.this, RecorridoOptimoMainActivity.class);
		    startActivity(intent);	
		}
    }
	
	//Evento de pulsar pago de compra
	class handleBtnPurchasePay implements OnClickListener {		
		public void onClick(View v) {

		    Intent intent = new Intent(MainActivity.this, PagoMainActivity.class);
		    startActivity(intent);	
		    
		}
    }
	
	public boolean myCustomAlert(String sCadena){
		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle("Titulo");
		alertDialog.setMessage(sCadena);
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel(); //Cierra la ventana
			}
		});
//		alertDialog.setIcon(R.drawable.icon);
		alertDialog.show();
		
		return true;
		
	}
	
    public void onClickListaCompra(View v) {
    	
	    Intent intent = new Intent( MainActivity.this, ListaCompraActivity.class);
	    startActivity(intent);	
    }
    


}
