package com.supermarket_frontoffice.lista_compra;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.bd.SupermercadoDataSource;
import com.supermarket_frontoffice.modelo_datos.Categoria;
import com.supermarket_frontoffice.modelo_datos.Producto;
import com.supermarket_frontoffice.modelo_datos.ProductoCarrito;
import com.supermarket_frontoffice.recorrido_optimo.RecorridoOptimoMainActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AnyadirCarritoActivity extends Activity {
	
	private Producto producto;
	private Categoria categoria;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_anyadir_carrito);
		
		Bundle bundle = getIntent().getExtras();
		short idproducto = bundle.getShort("idproducto");
		Log.d("Supermercado-Añadir_producto", "Codigo producto recibido: "+ idproducto);
		SupermercadoDataSource bd = new SupermercadoDataSource(this);
		bd.open();
		producto = bd.getProductoByID(idproducto);
		categoria = bd.getCategoriaByID(producto.getCategoriaId());
		bd.close();
		
		TextView txttitulo = (TextView) findViewById(R.id.txttitulo); 
		txttitulo.setText(producto.getNombreProducto());
		
		TextView txtcategoria = (TextView) findViewById(R.id.textViewCategoriaProducto); 
		txtcategoria.setText(categoria.getNombreCategoria());
		
		TextView txtnombreproductoT = (TextView) findViewById(R.id.textViewNombreProducto); 
		txtnombreproductoT.setText(producto.getNombreProducto());
	
	}
	
	public void onClickAddProducto(View v)
	{
		Log.d("Supermercado-Añadir_producto", "Se quieren añadir productos");
		
		SupermercadoDataSource bd = new SupermercadoDataSource(this);
		bd.open();
		ProductoCarrito productocarrito = bd.getProductoCarritoByID(producto.getId());
		EditText salida = (EditText) findViewById(R.id.editTextTotalPagar);
		short cantidad;
		cantidad = Short.parseShort(salida.getText().toString());
		//Si es distinto de nulo quiere decir que ya existe en la BBDD y por tanto en el Carrito
		if(productocarrito!=null)
		{
			Log.d("Supermercado-Añadir_producto", "El producto si estaba en el carrito");
			short total = (short) (productocarrito.getCantidad()+cantidad);
			bd.añadirUnidadesProductoCarrito(producto.getId(),cantidad);
			Toast.makeText(this, "Se añadio "+cantidad+" de "+producto.getNombreProducto()+", total "+total, Toast.LENGTH_SHORT).show();
			Log.d("Supermercado-Añadir_producto", "Añadidas unidades al producto "+producto.getId()+" ("+producto.getNombreProducto()+") incremento en "+cantidad+" unidades, total" +total);


		}
		else //Si no es que es nuevo y hay que agregarlo.
		{
			Log.d("Supermercado-Añadir_producto", "El producto no estaba en el carrito");
			bd.añadirProductoCarrito(producto.getId(),cantidad);
			
			Toast.makeText(this, "Se agrego "+producto.getNombreProducto()+"(nuevo) al carrito, cantidad "+cantidad, Toast.LENGTH_SHORT).show();
			Log.d("Supermercado-Añadir_producto", "Agregado al carrito producto "+producto.getId()+" ("+producto.getNombreProducto()+") con "+cantidad+" unidades");
		}
		bd.close();
	}
	
	public void onClickGeolocalizarProducto(View v)
	{
		Log.d("Supermercado-Añadir_producto", "Se pulso geolocalizar");
		Intent intent = new Intent( this, RecorridoOptimoMainActivity.class );
		intent.putExtra("producto", producto );
	    startActivity( intent );	
	}
	
    public void onClickDetallarProducto(View v) {
    	
    	Log.d("Supermercado-Añadir_producto", "Se pulso sobre detallar");
    	Intent intent= new Intent(this, InformacionProductoActivity.class);
		intent.putExtra("idproducto", producto.getId());
		startActivity(intent);
    }
    
    public void onClickCarritoCompra(View v) {
    	
	    Intent intent= new Intent(this, CarritoCompraActivity.class);
	    startActivity(intent);	
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.anyadir_carrito, menu);
		return true;
	}

}
