package com.supermarket_frontoffice.modelo_datos;

import java.util.ArrayList;


/** @class CarritoCompra
 * 
 * @author fjvegaf
 *
 */
public class CarritoCompra 
{
	
	
	private short 			m_Id;  			///< Identificador del carrito de la compra
	ArrayList< Producto > 	m_ListaCompra;
	
	
	public CarritoCompra( short a_Id )
	{
		this( a_Id, new ArrayList< Producto >() );
	
	} // CarritoCompra
	
	public CarritoCompra(   short a_Id,
							ArrayList< Producto > 	a_ListaCompra )
	{
		
		m_Id= a_Id;
		m_ListaCompra= a_ListaCompra;
		
	} // CarritoCompra
	
	
	/**
	 * @return the m_Id
	 */
	public short getId() {
		return m_Id;
	}
	
	/**
	 * @param m_Id the m_Id to set
	 */
	public void setId( short a_Id ) 
	{
		this.m_Id= a_Id;
	}

	/**
	 * @return the m_ListaCompra
	 */
	public ArrayList<Producto> getListaCompra( ) 
	{
		return m_ListaCompra;
	}

	/**
	 * @param m_ListaCompra the m_ListaCompra to set
	 */
	public void setListaCompra( ArrayList<Producto> a_ListaCompra ) 
	{
		this.m_ListaCompra= a_ListaCompra;
	} // setListaCompra
	
	

} // end class CarritoCompra
