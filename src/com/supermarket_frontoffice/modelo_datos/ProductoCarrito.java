
package com.supermarket_frontoffice.modelo_datos;

import android.os.Parcel;
import android.os.Parcelable;


/** @class ProductoCarrito
 * 
 * @author aarceg
 *
 */
public class ProductoCarrito implements Parcelable
{

	private Producto			m_Producto;
	private short				m_Cantidad;
	private int					m_Recogido;
	
	
	
	/**
	 * 
	 */
	public ProductoCarrito( )
	{
			this(new Producto(),(short)0,0);
	} // Producto
	
	public ProductoCarrito(  Producto a_producto,
						short				a_Cantidad,
						int				a_Recogido)
	{
		m_Producto = new Producto(a_producto.getId(),a_producto.getNombreProducto(),a_producto.getMarca(),a_producto.getCategoriaId(),a_producto.getCodigoEAN(),a_producto.getDescripcion(),a_producto.getPrecio(),a_producto.getLocalizacion());
		m_Cantidad= a_Cantidad;
		m_Recogido= a_Recogido;
		
		
	} // ProductoCarrito

	public Producto getProducto()
	{
		return m_Producto;
	}
	
	/**
	 * @return the m_Recogido
	 */
	public int getRecogido( ) 
	{
		return m_Recogido;
	}


	/**
	 * @param m_Recogido the m_Recogidod to set
	 */
	public void setRecogido( int a_Recogido ) 
	{
		this.m_Recogido= a_Recogido;
	}
	
	
	/**
	 * @return the m_Cantidad
	 */
	public short getCantidad( ) 
	{
		return m_Cantidad;
	}


	/**
	 * @param m_Cantidad the m_Cantidad to set
	 */
	public void setCantidad( short a_Cantidad ) 
	{
		this.m_Cantidad= a_Cantidad;
	}
	
	

	@Override
	public int describeContents( ) 
	{
		
		return 0;
	}


	@Override
	public void writeToParcel( Parcel a_ParcelOut, int a_Flags ) 
	{
		
		a_ParcelOut.writeParcelable( m_Producto, a_Flags );
		a_ParcelOut.writeInt( (int) m_Cantidad );
		a_ParcelOut.writeInt(m_Recogido);
		

	}
	
	
    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator< ProductoCarrito > CREATOR = new Parcelable.Creator< ProductoCarrito >() 
    {
        public ProductoCarrito createFromParcel(Parcel in) 
        {
            return new ProductoCarrito( in );
        }

        public ProductoCarrito[] newArray(int size) 
        {
            return new ProductoCarrito[ size ];
        }
    };

	
    // example constructor that takes a Parcel and gives you an object populated with it's values
    private ProductoCarrito( Parcel a_ParcelIn ) 
    {
		m_Producto= a_ParcelIn.readParcelable( Producto.class.getClassLoader() );
		m_Cantidad= (short) a_ParcelIn.readInt();
		m_Recogido= a_ParcelIn.readInt();
    } // CarritoCompra


	/** Devuelve un String con toda la información de la clase
	 * 
	 */
	public String toString( )
	{	
		return new String( "[Producto [Producto=" + this.m_Producto.toString() + "][Cantidad=" + this.m_Cantidad+ "]" +"[Recogido=" + this.m_Recogido+ "]");
		
	} // toString

} // ProductoCarrito
