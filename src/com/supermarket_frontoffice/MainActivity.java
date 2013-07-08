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

	
	public boolean myCustomAlert(String sCadena){

		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle("Titulo");
		alertDialog.setMessage(sCadena);
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() 
		{
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel(); //Cierra la ventana
			}
		});
//		alertDialog.setIcon(R.drawable.icon);
		alertDialog.show();
		
		return true;
		
	}
	
	
	/**
	 * 
	 * @param v
	 */
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
		///
		/// Lectura de la Base de Datos del Carrito de la Compra
		/// TODO: Pendiente de hacer el método que devuelve la clase Carrito de la Compra
		///
		
		///
		/// Ejemplo de Carrito de la Compra
		///

		Log.d("Supermercado-Main", "Se pulso recorrido optimo");

//		//Ejemplo a fuego
//		Producto p1 = new Producto((short)1, "Coca-Cola 2L", "Coca-Cola", (short)1, "1222332234","Refresco", 0.44f,new LocalizacionProducto( (short)1,  (short)2,  (short)3 ) );
//		Producto p2 = new Producto((short)2, "Coca-Cola 33cl", "Pepsi-Cola", (short)1, "567623812","Refresco", .40f, new LocalizacionProducto( (short)3,  (short)9,  (short)2 ));
//		Producto p3 = new Producto((short)3, "Ron Arehucas", "Arehucas", (short)4, "987746311","Alcohol", 11.4f, new LocalizacionProducto( (short)4,  (short)5,  (short)1 ));
//		//Producto p3 = new Producto((short)3, "Ron Arehucas", "Arehucas", (short)4, "987746311","Alcohol", 11.4f, new LocalizacionProducto( (short)4,  (short)5,  (short)1 ));
//
//		
//		CarritoCompra carrito= new CarritoCompra( (short)187 );
//
//		carrito.addProducto( new ProductoCarrito(p1, (short)1,0 )  );
//		carrito.addProducto( new ProductoCarrito(p2, (short)2,0 ) );
//		carrito.addProducto( new ProductoCarrito(p3, (short)1,0 ) );

		SupermercadoDataSource bd = new SupermercadoDataSource(this);
		bd.open();
		CarritoCompra carrito = bd.getCarrito(); 
		bd.close();
		
		Log.d("Supermercado-Main", "Se mando el siguiente Carrito: "+carrito.toString());

		///
		/// Se pasa el objeto CarritoCompra al activity que se abre.
		///
		Intent intent = new Intent( MainActivity.this, RecorridoOptimoMainActivity.class );

		intent.putExtra("carrito_compra", carrito );
		
	    startActivity( intent );
    }
    


}
