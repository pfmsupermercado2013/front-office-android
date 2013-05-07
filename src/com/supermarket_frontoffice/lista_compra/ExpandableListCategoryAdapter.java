package com.supermarket_frontoffice.lista_compra;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.supermarket_frontoffice.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class ExpandableListCategoryAdapter extends BaseExpandableListAdapter 
{


	private Context m_Context;
	private ArrayList< String >  				m_ListCategorias;
	private ArrayList< ArrayList< String > >  	m_ListProductosCategorias;
	

	public ExpandableListCategoryAdapter( 	Context 							a_Context, 
											ArrayList< String >  				a_ListCategorias,
											ArrayList< ArrayList< String > >  	a_ListProductosCategorias ) 
	{
		
        this.m_Context= a_Context;
        this.m_ListCategorias= a_ListCategorias;
        this.m_ListProductosCategorias= a_ListProductosCategorias;
    }


	@Override
    public boolean areAllItemsEnabled()
    {
        return true;
    }

    @Override
    public String getChild(int a_CategoriaPosicion, int a_ProductoPosicion ) 
    {
        
    	return m_ListProductosCategorias.get( a_CategoriaPosicion ).get( a_ProductoPosicion ); 
    	//return children.get(groupPosition).get(childPosition);        
    }
	

    @Override
    public long getChildId( int a_CategoriaPosicion, int a_ProductoPosicion ) 
    {
        return a_ProductoPosicion;
    }


    @Override
    public View getChildView( 	int a_CategoriaPosicion, 
    							int a_ProductoPosicion, 
    							boolean isLastChild,
    							View convertView, 
    							ViewGroup parent) {

    	
    	String hijo=  getChild(a_CategoriaPosicion, a_ProductoPosicion );
    	
    	//String hijo = (String) ((ArrayList<String>)getChild(groupPosition, childPosition)).get(0);

        if ( convertView == null ) {
        	
            LayoutInflater infalInflater = (LayoutInflater) m_Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate( R.layout.expandablelistview_productos, null );
        }

        TextView hijotxt = (TextView) convertView.findViewById(R.id.TextViewHijo01 );
        hijotxt.setText( hijo );
        
        ImageView imageView1= (ImageView) convertView.findViewById(R.id.imageViewGeolocalizarProducto);     
        ImageView imageView2= (ImageView) convertView.findViewById(R.id.imageDetallarProducto);  
        ImageView imageView3= (ImageView) convertView.findViewById(R.id.imageAnyadirCarrito);

        return convertView;
        
    }

    @Override
    public int getChildrenCount( int a_CategoriaPosicion ) 
    {
    	return m_ListProductosCategorias.get( a_CategoriaPosicion ).size();
        //return children.get(groupPosition).size();
    }

    @Override
    public String getGroup( int a_CategoriaPosicion ) 
    {
    	
    	return m_ListCategorias.get( a_CategoriaPosicion );

    }

    @Override
    public int getGroupCount() 
    {
        return m_ListCategorias.size();
    }

    @Override
    public long getGroupId(int a_CategoriaPosicion ) 
    {
        return a_CategoriaPosicion;
    }

    @Override
    public View getGroupView( 	int 		a_CategoriaPosicion, 
    							boolean 	isExpanded, 
    							View 		convertView, 
    							ViewGroup 	parent) {

    	String group=  getGroup(a_CategoriaPosicion);

    	if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) m_Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //convertView = infalInflater.inflate(R.layout.expandablelistview_categorias, null);
            convertView = infalInflater.inflate(R.layout.expandablelistview_categorias, null);
        }

        TextView grouptxt = (TextView) convertView.findViewById(R.id.textViewGrupo);
        grouptxt.setText(group);


        //imageView.setText( "+" );
        //button.setText( "+" );
        
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int arg0, int arg1) {
        return true;
    }

} // end class ExpandableListCategoryAdapter 

