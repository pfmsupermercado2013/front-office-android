package com.supermarket_frontoffice.recorrido_optimo;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.R.id;
import com.supermarket_frontoffice.R.layout;
import com.supermarket_frontoffice.R.menu;
//import com.supermarket_frontoffice.MainActivity.handleButton;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class RecorridoOptimoMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recorrido_optimo_main);
		findViewById(R.id.btnNFC).setOnClickListener(new handleButton1());
		findViewById(R.id.btnPaybox).setOnClickListener(new handleButton2());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recorrido_optimo_main, menu);
		return true;
	}

	
	class handleButton1 implements OnClickListener {
	        public void onClick(View v) {
	        	myCustomAlert("Carrito de la compra vacio. Imposible iniciar la compra guiada");
		}
	}
	
	class handleButton2 implements OnClickListener {
	        public void onClick(View v) {
	        	myCustomAlert("Fin del recorrido de compra. Pague su compra en caja");
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
	
	
}
