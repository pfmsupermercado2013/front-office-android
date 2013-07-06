package com.supermarket_frontoffice.lista_compra;

import com.supermarket_frontoffice.R;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class InformacionProductoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_informacion_producto);
		
		Bundle bundle = getIntent().getExtras();
		String CodigoEAN = bundle.getString("CodigoEAN");
		Log.d("Supermercado-Informacion Producto", "Codigo EAN recibido: "+ CodigoEAN);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.informacion_producto, menu);
		return true;
	}

}
