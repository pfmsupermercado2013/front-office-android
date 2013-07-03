package com.supermarket_frontoffice.modelo_datos;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;


/** @class CarritoCompra
 * 
 * @author fjvegaf
 *
 */
public class CarritoCompra implements Parcelable
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
	
	/**
	 * @param m_ListaCompra the m_ListaCompra to set
	 */
	public void addProducto( Producto a_Producto ) 
	{
		this.m_ListaCompra.add( a_Producto );
		
	} // setListaCompra
	

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
		a_ParcelOut.writeArray( m_ListaCompra.toArray() );
		
	} // writeToParcel

	

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator< CarritoCompra > CREATOR = new Parcelable.Creator< CarritoCompra >() 
    {
        public CarritoCompra createFromParcel(Parcel in) 
        {
            return new CarritoCompra( in );
        }

        public CarritoCompra[] newArray(int size) 
        {
            return new CarritoCompra[ size ];
        }
    };

	
    // example constructor that takes a Parcel and gives you an object populated with it's values
    @SuppressWarnings("unchecked")
	private CarritoCompra( Parcel a_ParcelIn ) 
    {
    	
    	m_Id= (short) a_ParcelIn.readInt();    	
    	m_ListaCompra= a_ParcelIn.readArrayList( Producto.class.getClassLoader() );
    	
    	
    } // CarritoCompra

	
	
	/** Devuelve un String con toda la información de la clase
	 * 
	 */
	public String toString( )
	{
		
		String strOut= new String( "[[CarritoCompra Id=" + this.m_Id + "]\n" );
	
		if ( !m_ListaCompra.isEmpty() ) {
			
			for ( Producto producto: m_ListaCompra ) {
				
				strOut += "\n\t" + producto.toString();
				
				
			}
		}
		return strOut;
	
	} // toString
	

} // end class CarritoCompra
