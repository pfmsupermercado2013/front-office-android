package com.supermarket_frontoffice;
import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.bd.SupermercadoDataSource;
import com.supermarket_frontoffice.lista_compra.ListaCompraActivity;
import com.supermarket_frontoffice.modelo_datos.CarritoCompra;
import com.supermarket_frontoffice.modelo_datos.LocalizacionProducto;
import com.supermarket_frontoffice.modelo_datos.Producto;
import com.supermarket_frontoffice.modelo_datos.ProductoCarrito;
import com.supermarket_frontoffice.pago.PagoMainActivity;
import com.supermarket_frontoffice.recorrido_optimo.RecorridoOptimoMainActivity;
import com.supermarket_frontoffice.recorrido_optimo.xml.XmlResourceMobiliario;
import com.supermarket_frontoffice.utils.Utils;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity 
{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		
		Log.d("Main", "Inicializando la aplicación");
		getMenuInflater().inflate(R.menu.main, menu);
		

		return true;
	}

	public void onClickPago( View a_View ) 
    {
    	
    	Log.d("Supermercado-Main", "Se pulso pago");

	    Intent intent = new Intent( MainActivity.this, PagoMainActivity.class);
	    startActivity(intent);	
    }
    
    public void onClickListaCompra(View a_View)
    {
    	Log.d("Supermercado-Main", "Se pulso lista compra");
    	
    	Intent intent = new Intent( MainActivity.this, ListaCompraActivity.class);
	    startActivity(intent);	
    }
    
    public void onClickRecorridoOptimo( View a_View ) 
    {
		Log.d("Supermercado-Main", "Se pulso recorrido optimo");
		
		SupermercadoDataSource bd = new SupermercadoDataSource(this);
		Log.d("Supermercado-Main", "Se abre la base de datos");
		bd.open();
		
		Log.d("Supermercado-Main", "Antes de obtener el carrito de la compra");
		CarritoCompra carrito = bd.getCarrito(); 
		
		Log.d("Supermercado-Main", "Se cierra la base de datos");
		bd.close();
		
		Log.d("Supermercado-Main", "Se mando el siguiente Carrito: "+carrito.toString());

		Intent intent = new Intent( MainActivity.this, RecorridoOptimoMainActivity.class );
		intent.putExtra("carrito_compra", carrito );
		startActivity( intent );
    }
    


}
