package com.supermarket_frontoffice.lista_compra;


/*! Todos los datos de cada Item del carrito de la compra
 * 
 * 
 */
public class CarritoCompraItem 
{
	
	private String 	m_NombreProducto;
	private String 	m_NombreCategoria;
	private int 	m_Cantidad;
	private float 	m_PrecioUnidadProducto;
	private float 	m_PrecioTotalProducto;

	
	/** Constructor
	 * 
	 * @param a_NombreProducto
	 * @param a_NombreCategoria
	 * @param a_Cantidad
	 * @param a_PrecioUnidadProducto
	 */
	public CarritoCompraItem( String 	a_NombreProducto,
							  String	a_NombreCategoria,
							  int 		a_Cantidad,
							  float 	a_PrecioUnidadProducto ) 
	{
		
		m_NombreProducto= a_NombreProducto;
		m_NombreCategoria= a_NombreCategoria;
		m_Cantidad= a_Cantidad;
		m_PrecioUnidadProducto= a_PrecioUnidadProducto;
		m_PrecioTotalProducto= a_Cantidad * a_PrecioUnidadProducto;
		
	} // CarritoCompraItem
	
	
	public String getNombreProducto() {
		
		return m_NombreProducto;
	}


	public void setNombreProducto( String a_NombreProducto ) {
		this.m_NombreProducto = a_NombreProducto;
	}


	public String getNombreCategoria() {
		return m_NombreCategoria;
	}


	public void setNombreCategoria( String a_NombreCategoria ) {
		this.m_NombreCategoria = a_NombreCategoria;
	}


	public int getCantidad() {
		return m_Cantidad;
	}


	public void setCantidad(int a_Cantidad) {
		
		m_Cantidad = a_Cantidad;
		m_PrecioTotalProducto= m_Cantidad * m_PrecioUnidadProducto;
	}


	public float getPrecioUnidadProducto() {
		return m_PrecioUnidadProducto;
	}


	public void setPrecioUnidadProducto( float a_PrecioUnidadProducto ) {
		
		m_PrecioUnidadProducto = a_PrecioUnidadProducto;
		m_PrecioTotalProducto= m_Cantidad * m_PrecioUnidadProducto;
	}


	public float getPrecioTotalProducto() {
		return m_PrecioTotalProducto;
	}


	public void setPrecioTotalProducto( float a_PrecioTotalProducto ) {
		this.m_PrecioTotalProducto = a_PrecioTotalProducto;
	}

	
}
