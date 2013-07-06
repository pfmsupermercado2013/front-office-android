package com.supermarket_frontoffice.lista_compra;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.barscanner.IntentIntegrator;
import com.supermarket_frontoffice.barscanner.IntentResult;
import com.supermarket_frontoffice.bd.SupermercadoDataSource;
import com.supermarket_frontoffice.modelo_datos.Producto;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;

public class LeerCodigoBarrasActivity extends Activity {

	private IntentIntegrator integrator;
	private IntentResult scanResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leer_codigo_barras);
		
		integrator = new IntentIntegrator(this);
		integrator.initiateScan();
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		  scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		  if (scanResult != null) {
			  Log.d("Supermercado-Codigo_Barras", "Lectura correcta: "+ scanResult.getContents());
			  Intent intent2= new Intent(this, InformacionProductoActivity.class);
			  intent2.putExtra("CodigoEAN", scanResult.getContents());

			  startActivity(intent2);
		  }
		  else
		  {
			  Log.d("Supermercado-Codigo_Barras", "Lectura incorrecta");
			  Intent intent3= new Intent(this, ListaCompraActivity.class);
			  startActivity(intent3);
		  }
		  
		}

}
