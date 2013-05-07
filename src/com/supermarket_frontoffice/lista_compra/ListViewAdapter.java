package com.supermarket_frontoffice.lista_compra;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public abstract class ListViewAdapter extends BaseAdapter 
{


	private Context 		m_Context;
	private int				m_LayoutIdView;
	private ArrayList< ? >  m_ListItems;
	

	/** Constructor
	 * 
	 * @param a_Context
	 * @param a_LayoutIdView
	 * @param a_ListItems
	 */
	public ListViewAdapter( 	Context 		a_Context, 
								int				a_LayoutIdView,
								ArrayList< ? >  a_ListItems ) 
	{
		
        m_Context= 		a_Context;
        m_LayoutIdView= a_LayoutIdView;
        m_ListItems= 	a_ListItems;
    }
	
	
    @Override
    public View getView( int 		a_Posicion, 
    					 View 		a_View, 
    					 ViewGroup  a_Parent ) 
    {
   	
    	
        if ( a_View == null ) {
        	
            LayoutInflater infalInflater = (LayoutInflater) m_Context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            a_View = infalInflater.inflate( m_LayoutIdView, null );   
        }
        
        this.onItemView( m_ListItems.get( a_Posicion ), a_View );

        return a_View;
        
    }

    
    @Override
    public int getCount(  ) 
    {
    	return m_ListItems.size();
    }
    
    @Override
    public Object getItem( int a_Posicion ) 
    {
    	return m_ListItems.get( a_Posicion );
    }
    
    @Override
    public long getItemId( int a_Posicion ) 
    {
    	return a_Posicion;
    }
        
    
    /** Devuelve cada una de las entradas con cada una de las vistas a las que
     *  puede ser asociada
     * 
     * @param a_ItemIn	Entrada que será asociada a la view. (Tipo paquete/handler)
     * @param a_View 	View particular que contendrá los datos del paquete/handler
     */
    public abstract void onItemView( Object a_ItemIn, View a_View );

} // end class ExpandableListCategoryAdapter 

