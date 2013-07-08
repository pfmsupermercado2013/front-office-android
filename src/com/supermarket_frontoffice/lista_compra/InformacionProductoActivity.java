package com.supermarket_frontoffice.lista_compra;

import com.supermarket_frontoffice.MainActivity;
import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.bd.SupermercadoDataSource;
import com.supermarket_frontoffice.modelo_datos.CarritoCompra;
import com.supermarket_frontoffice.modelo_datos.Categoria;
import com.supermarket_frontoffice.modelo_datos.LocalizacionProducto;
import com.supermarket_frontoffice.modelo_datos.Producto;
import com.supermarket_frontoffice.modelo_datos.ProductoCarrito;
import com.supermarket_frontoffice.recorrido_optimo.RecorridoOptimoMainActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class InformacionProductoActivity extends Activity {
	
	private Producto producto;
	private Categoria categoria;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_informacion_producto);
		
		Bundle bundle = getIntent().getExtras();
		short idproducto = bundle.getShort("idproducto");
		Log.d("Supermercado-Informacion Producto", "Codigo producto recibido: "+ idproducto);
		SupermercadoDataSource bd = new SupermercadoDataSource(this);
		bd.open();
		producto = bd.getProductoByID(idproducto);
		categoria = bd.getCategoriaByID(producto.getCategoriaId());
		bd.close();
		
		TextView txtcategoria = (TextView) findViewById(R.id.textViewCategoriaProductoCarrito); 
		txtcategoria.setText(categoria.getNombreCategoria());
		
		TextView txtnombreproducto = (TextView) findViewById(R.id.textViewNombreProductoCarrito); 
		txtnombreproducto.setText(producto.getNombreProducto());
		
		TextView txtnombreproductoT = (TextView) findViewById(R.id.textViewNombreProductoTitulo); 
		txtnombreproductoT.setText(producto.getNombreProducto());
		
		TextView txtdescripcion = (TextView) findViewById(R.id.textViewDescripcionProducto); 
		txtdescripcion.setText(producto.getDescripcion());
		
		TextView txtEAN = (TextView) findViewById(R.id.textViewCodigoEANProducto); 
		txtEAN.setText(producto.getCodigoEAN());
		
		TextView txtprecioproducto = (TextView) findViewById(R.id.textViewPrecioProducto); 
		txtprecioproducto.setText(producto.getPrecio() + "€");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.informacion_producto, menu);
		return true;
	}
	
	public void onClickGeolocalizarProducto(View v)
	{
		Log.d("Supermercado-Información_Producto", "Se pulso geolocalizar");
		Intent intent = new Intent( this, RecorridoOptimoMainActivity.class );
		intent.putExtra("producto", producto );
	    startActivity( intent );	
	}
	
	public void onClickAgregarProducto(View v)
	{
		Log.d("Supermercado-Información_Producto", "Se pulso añadir al Carrito");
		Intent intent= new Intent(this, AnyadirCarritoActivity.class);
		intent.putExtra("idproducto", producto.getId());
		startActivity(intent);
	}
	
	public void onClickCarritoCompra(View v)
	{
		Intent intent= new Intent(this, CarritoCompraActivity.class);
	    startActivity(intent);	
	}
	
	
}
