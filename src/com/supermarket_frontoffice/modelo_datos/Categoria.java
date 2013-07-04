package com.supermarket_frontoffice.modelo_datos;

import android.os.Parcel;
import android.os.Parcelable;


/** @class CarritoCompra
 * 
 * @author aarceg
 *
 */
public class Categoria implements Parcelable
{
	
	
	private short 			m_Id;  			
	private String 			m_NombreCategoria;
	private String 			m_Descripcion;
	
	public Categoria(   short a_Id, String a_NombreCategoria, String a_Descripcion )
	{
		
		m_Id= a_Id;
		m_NombreCategoria= a_NombreCategoria;
		m_Descripcion= a_Descripcion;
		
	}
	
		
	/**
	 * @return the m_Id
	 */
	public short getId() {
		return m_Id;
	}
	
	public void setId( short a_Id ) 
	{
		this.m_Id= a_Id;
	}

	public String getNombreCategoria( ) 
	{
		return m_NombreCategoria;
	}

	public void setNombreCategoria( String a_NombreCategoria ) 
	{
		this.m_NombreCategoria= a_NombreCategoria;
	}
	
	public String getDescripcion( ) 
	{
		return m_Descripcion;
	}

	public void setDescripcion( String a_Descripcion ) 
	{
		this.m_Descripcion= a_Descripcion;
	}
	
	
	@Override
	public int describeContents() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel( Parcel a_ParcelOut, int a_Flags ) 
	{
		
		a_ParcelOut.writeInt( (int)m_Id );  
		a_ParcelOut.writeString(m_NombreCategoria);
		a_ParcelOut.writeString(m_Descripcion);
		
	} // writeToParcel

	

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator< Categoria > CREATOR = new Parcelable.Creator< Categoria >() 
    {
        public Categoria createFromParcel(Parcel in) 
        {
            return new Categoria( in );
        }

        public Categoria[] newArray(int size) 
        {
            return new Categoria[ size ];
        }
    };

	private Categoria( Parcel a_ParcelIn ) 
    {
    	
    	m_Id= (short) a_ParcelIn.readInt();    	
    	m_NombreCategoria= a_ParcelIn.readString();
    	m_Descripcion = a_ParcelIn.readString();
    	    	
    }

	/** Devuelve un String con toda la información de la clase
	 * 
	 */
	public String toString( )
	{
		
		String strOut= new String( "[Categoria Id=" + this.m_Id + " Nombre=" + this.m_NombreCategoria + " Descripcion=" +this.m_Descripcion+"]\n" );
		return strOut;
	
	} // toString
	

} 
