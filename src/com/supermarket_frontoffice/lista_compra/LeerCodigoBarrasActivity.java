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
import android.widget.Toast;

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
			  SupermercadoDataSource bd = new SupermercadoDataSource(this);
			  bd.open();
			  Producto productoencontrado = bd.getProductoByEAN(scanResult.getContents());
			  if(productoencontrado !=null)
			  {
				  Log.d("Supermercado-Codigo_Barras", "Producto encontrado");
				  Toast toast = Toast.makeText(getApplicationContext(), "EAN encontrado", Toast.LENGTH_SHORT);
				  toast.show();
				  Intent intent2= new Intent(this, InformacionProductoActivity.class);
				  intent2.putExtra("idproducto", productoencontrado.getId());
				  startActivity(intent2);
			  }
			  else
			  {
				  Log.d("Supermercado-Codigo_Barras", "Producto no encontrado");
				  Toast toast2 = Toast.makeText(getApplicationContext(), "EAN no encontrado", Toast.LENGTH_SHORT);
				  toast2.show();
				  Intent intent3= new Intent(this, ListaCompraActivity.class);
				  startActivity(intent3);
			  }
		  }
		  else
		  {
			  Toast toast3 = Toast.makeText(getApplicationContext(), "Lectura EAN incorrecta", Toast.LENGTH_SHORT);
			  toast3.show();
			  Log.d("Supermercado-Codigo_Barras", "Lectura incorrecta");
			  Intent intent4= new Intent(this, ListaCompraActivity.class);
			  startActivity(intent4);
		  }
		  
		}

}
