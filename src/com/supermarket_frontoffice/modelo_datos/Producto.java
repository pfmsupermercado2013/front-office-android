
package com.supermarket_frontoffice.modelo_datos;


/** @class Producto
 * 
 * @author fjvegaf
 *
 */
public class Producto 
{

	private short 				m_Id; 					///< Identificador del producto
	private String 				m_NombreProducto;		///< Nombre del producto
	private String 				m_Marca;
	private short				m_CategoriaId;	
	private String 				m_CodigoEAN;
	private float				m_Precio;
	private LocalizacionProducto m_Localizacion;
	
	
	/** Constructor
	 * 
	 * @param a_Id				Identificador del producto
	 * @param a_NombreProducto
	 * @param a_Marca
	 * @param a_CategoriaId
	 * @param a_CodigoEAN
	 * @param a_Precio
	 */
	public Producto(  	short 				a_Id, 				
						String 				a_NombreProducto,
						String 				a_Marca,
						short				a_CategoriaId,	
						String 				a_CodigoEAN,
						float				a_Precio,
						LocalizacionProducto a_Localizacion )
	{
		
		m_Id= a_Id; 
		m_NombreProducto= a_NombreProducto;
		m_Marca= a_Marca;
		m_CategoriaId= a_CategoriaId;	
		m_CodigoEAN= a_CodigoEAN;
		m_Precio= a_Precio;
		m_Localizacion= a_Localizacion;
		
	} // Producto


	/**
	 * @return the m_Id
	 */
	public short getId( ) 
	{
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
	 * @return the m_NombreProducto
	 */
	public String getNombreProducto() 
	{
		return m_NombreProducto;
	}


	/**
	 * @param m_NombreProducto the m_NombreProducto to set
	 */
	public void setNombreProducto( String a_NombreProducto ) 
	{
		this.m_NombreProducto= a_NombreProducto;
	}


	/**
	 * @return the m_Marca
	 */
	public String getMarca( ) 
	{
		return m_Marca;
	}


	/**
	 * @param m_Marca the m_Marca to set
	 */
	public void setMarca( String a_Marca )
	{
		this.m_Marca= a_Marca;
	}
	
	
	/**
	 * @return the m_CategoriaId
	 */
	public short getCategoriaId() 
	{
		return m_CategoriaId;
	}
	
	
	/**
	 * @param m_CategoriaId the m_CategoriaId to set
	 */
	public void setCategoriaId(short a_CategoriaId )
	{
		this.m_CategoriaId = a_CategoriaId;
	}


	/**
	 * @return the m_CodigoEAN
	 */
	public String getCodigoEAN( ) 
	{
		return m_CodigoEAN;
	}

	
	/**
	 * @param m_CodigoEAN the m_CodigoEAN to set
	 */
	public void setCodigoEAN( String a_CodigoEAN ) 
	{
		this.m_CodigoEAN = a_CodigoEAN;
	}
	

	/**
	 * @return the m_Precio
	 */
	public float getPrecio( )
	{
		return m_Precio;
	}


	/**
	 * @param m_Precio the m_Precio to set
	 */
	public void setPrecio( float a_Precio ) 
	{
		this.m_Precio = a_Precio;
	}


	/**
	 * @return the m_Localizacion
	 */
	public LocalizacionProducto getLocalizacion() 
	{
		return m_Localizacion;
	}


	/**
	 * @param m_Localizacion the m_Localizacion to set
	 */
	public void setLocalizacion( LocalizacionProducto a_Localizacion ) 
	{
		this.m_Localizacion= a_Localizacion;
	}

	
	
	
} // Producto
