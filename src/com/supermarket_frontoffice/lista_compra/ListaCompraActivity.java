package com.supermarket_frontoffice.lista_compra;

import com.supermarket_frontoffice.lista_compra.CatalogoProductosActivity;
import com.supermarket_frontoffice.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
//import android.view.View.OnClickListener;

public class ListaCompraActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_compra);
		
		//findViewById(R.id.btnCatalogoProductos).setOnClickListener(new handleButtonCatalogoProductos());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_compra, menu);
			
		return true;
	}
	
	
//	class handleButtonCatalogoProductos implements OnClickListener {
//		
//        public void onClick(View v) {
//        	
//		    Intent intent = new Intent( ListaCompraActivity.this, CatalogoProductosActivity.class);
//		    startActivity(intent);	
//        }
//	}
	
    public void onClickCatalogoProductos( View v ) {
    	
		    Intent intent = new Intent( ListaCompraActivity.this, CatalogoProductosActivity.class);
		    startActivity(intent);	
     }

	
    public void onClickBuscarProductos(View v) {
    	
	    Intent intent= new Intent(ListaCompraActivity.this, BuscarProductoActivity.class);
	    startActivity(intent);	
    }
    
    public void onClickCarritoCompra(View v) {
    	
	    Intent intent= new Intent(ListaCompraActivity.this, CarritoCompraActivity.class);
	    startActivity(intent);	
    }
    
    public void onClickLeerCodigoBarras(View v) {
    	
	    Intent intent= new Intent(ListaCompraActivity.this, LeerCodigoBarrasActivity.class);
	    startActivity(intent);	
    }
}
