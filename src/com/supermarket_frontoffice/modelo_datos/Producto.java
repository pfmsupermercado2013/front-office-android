
package com.supermarket_frontoffice.modelo_datos;

import android.os.Parcel;
import android.os.Parcelable;


/** @class Producto
 * 
 * @author fjvegaf
 *
 */
public class Producto implements Parcelable
{

	private short 				m_Id; 					///< Identificador del producto
	private String 				m_NombreProducto;		///< Nombre del producto
	private String 				m_Marca;
	private short				m_CategoriaId;	
	private String 				m_CodigoEAN;
	private float				m_Precio;
	private LocalizacionProducto m_Localizacion;
	
	
	/**
	 * 
	 */
	public Producto( )
	{
			this( (short)0, "", "", (short)0, "", 0.f, new LocalizacionProducto() );
	} // Producto
	
	
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


	@Override
	public int describeContents( ) 
	{
		
		return 0;
	}


	@Override
	public void writeToParcel( Parcel a_ParcelOut, int a_Flags ) 
	{
		
		a_ParcelOut.writeInt( (int) m_Id );
		a_ParcelOut.writeString( m_NombreProducto );
		a_ParcelOut.writeString( m_Marca );
		a_ParcelOut.writeInt( (int) m_CategoriaId );
		a_ParcelOut.writeString( m_CodigoEAN );
		a_ParcelOut.writeFloat( m_Precio );
		a_ParcelOut.writeParcelable( m_Localizacion, a_Flags );

	}
	
	
    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator< Producto > CREATOR = new Parcelable.Creator< Producto >() 
    {
        public Producto createFromParcel(Parcel in) 
        {
            return new Producto( in );
        }

        public Producto[] newArray(int size) 
        {
            return new Producto[ size ];
        }
    };

	
    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Producto( Parcel a_ParcelIn ) 
    {
    	m_Id= (short) a_ParcelIn.readInt();    	
		m_NombreProducto= a_ParcelIn.readString();
		m_Marca= a_ParcelIn.readString();
		m_CategoriaId= (short) a_ParcelIn.readInt();	
		m_CodigoEAN= a_ParcelIn.readString();
		m_Precio= a_ParcelIn.readFloat();
		m_Localizacion= a_ParcelIn.readParcelable( LocalizacionProducto.class.getClassLoader() );
    } // CarritoCompra

	
	
	/** Devuelve un String con toda la información de la clase
	 * 
	 */
	public String toString( )
	{
		
		return new String( "[Producto [ Id=" + this.m_Id + "][Nombre="+ this.m_NombreProducto + "]"+ "[Marca="+ this.m_Marca + "]" +
							"[CategoriaId=" + this.m_CategoriaId + "][CodigoEAN=" + this.m_CodigoEAN + "][Precio=" + m_Precio + "]" +
							"[" + this.m_Localizacion.toString()  + "]");
		
	} // toString

	
	
	
} // Producto
