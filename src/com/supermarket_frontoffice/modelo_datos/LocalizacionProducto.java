package com.supermarket_frontoffice.modelo_datos;

import android.os.Parcel;
import android.os.Parcelable;


/** @class LocalizacionProducto
 * 
 * @author fjvegaf
 *
 */
public class LocalizacionProducto  implements Parcelable
{
	
	private short 	m_EstanteriaId;  	///< Id de estantería
	private short 	m_SeccionId;		///< Id de sección
	private short 	m_EstanteId;		///< Id de estante
	
	
	/** Constructor
	 * 
	 */
	public LocalizacionProducto( ) 
	{
		
		this( (short)0, (short)0, (short)0 );
		
	} // LocalizacionProducto
	
	
	/** Constructor
	 * 
	 * @param a_EstanteriaId
	 * @param a_SeccionId
	 * @param a_EstanteId
	 */
	public LocalizacionProducto( 	short a_EstanteriaId,
									short a_SeccionId,
									short a_EstanteId )
	{
		
		m_EstanteriaId= a_EstanteriaId;
		m_SeccionId= a_SeccionId;
		m_EstanteId= a_EstanteId;
		
	} // LocalizacionProducto


	/**
	 * @return the m_EstanteriaId
	 */
	public short getEstanteriaId( ) 
	{
		return m_EstanteriaId;
	}


	/**
	 * @param m_EstanteriaId the m_EstanteriaId to set
	 */
	public void setEstanteriaId(short m_EstanteriaId ) 
	{
		this.m_EstanteriaId = m_EstanteriaId;
	}


	/**
	 * @return the m_SeccionId
	 */
	public short getSeccionId() 
	{
		return m_SeccionId;
	}


	/**
	 * @param m_SeccionId the m_SeccionId to set
	 */
	public void setSeccionId( short m_SeccionId ) 
	{
		this.m_SeccionId = m_SeccionId;
	}


	/**
	 * @return the m_EstanteId
	 */
	public short getEstanteId( ) 
	{
		return m_EstanteId;
	} // getEstanteId


	/**
	 * @param m_EstanteId the m_EstanteId to set
	 */
	public void setEstanteId( short m_EstanteId ) 
	{
		this.m_EstanteId = m_EstanteId;
	}


	@Override
	public int describeContents() 
	{

		return 0;
	}


	@Override
	public void writeToParcel( Parcel a_ParcelOut, int flags) 
	{

		a_ParcelOut.writeInt( (int)m_EstanteriaId );  	
		a_ParcelOut.writeInt( (int)m_SeccionId );  	
		a_ParcelOut.writeInt( (int)m_EstanteId );  	
		
	}
	
	

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator< LocalizacionProducto > CREATOR = new Parcelable.Creator< LocalizacionProducto >() 
    {
        public LocalizacionProducto createFromParcel(Parcel in) 
        {
            return new LocalizacionProducto( in );
        }

        public LocalizacionProducto[] newArray(int size) 
        {
            return new LocalizacionProducto[ size ];
        }
    };

	
    // example constructor that takes a Parcel and gives you an object populated with it's values
    private LocalizacionProducto( Parcel a_ParcelIn ) 
    {
    	
    	m_EstanteriaId= (short) a_ParcelIn.readInt();
    	m_SeccionId= (short) a_ParcelIn.readInt();
    	m_EstanteId= (short) a_ParcelIn.readInt();
    } // CarritoCompra

	
	
	/** Devuelve un String con toda la información de la clase
	 * 
	 */
	public String toString( )
	{
	
		return new String( "[Localizacion:( Estanteria=" + this.m_EstanteriaId + ", Seccion= " +  this.m_SeccionId + ", Estante= " + this.m_EstanteId + ") ]" );
		
	} // toString

} // end LocalizacionProducto
