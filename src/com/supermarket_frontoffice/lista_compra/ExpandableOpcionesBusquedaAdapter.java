package com.supermarket_frontoffice.lista_compra;

import java.util.ArrayList;

import com.supermarket_frontoffice.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;




public class ExpandableOpcionesBusquedaAdapter extends BaseExpandableListAdapter 
{


	private Context 							m_Context;
	private String								m_TituloOpcionesBusqueda;
	//private ArrayList< String >  				m_ListCategorias;
	private ArrayList< String >  				m_ListOpcionesBusqueda;
	

	public ExpandableOpcionesBusquedaAdapter( 	Context 							a_Context ) 
	{
		
        this.m_Context= a_Context;
        this.m_TituloOpcionesBusqueda= new String( "Opciones de busqueda" );
        
        this.m_ListOpcionesBusqueda= new ArrayList< String >();
        
        this.m_ListOpcionesBusqueda.add( "Nombre Producto" );
        this.m_ListOpcionesBusqueda.add( "Categoría" );
        this.m_ListOpcionesBusqueda.add( "Marca" );
        this.m_ListOpcionesBusqueda.add( "Fabricante" );
    }


	@Override
    public boolean areAllItemsEnabled()
    {
        return true;
    }

    @Override
    public String getChild( int a_ParentPosicion, int a_ChildPosicion ) 
    {
        
    	return m_ListOpcionesBusqueda.get( a_ChildPosicion ); 
    	//return children.get(groupPosition).get(childPosition);        
    }
	

    @Override
    public long getChildId( int a_ParentPosicion, int a_ChildPosicion ) 
    {
        return a_ChildPosicion;
    }


    @Override
    public View getChildView( 	int 	a_ParentPosicion, 
    							int 	a_ChildPosicion, 
    							boolean isLastChild,
    							View 	convertView, 
    							ViewGroup parent) {

    	
    	String strOpcionBusqueda=  getChild( a_ParentPosicion, a_ChildPosicion );
    	
    	//String hijo = (String) ((ArrayList<String>)getChild(groupPosition, childPosition)).get(0);

        if ( convertView == null ) {
        	
            LayoutInflater infalInflater = (LayoutInflater) m_Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate( R.layout.expandableview_item_opciones_busqueda, null );
        }

        
        RadioButton radioButton = (RadioButton) convertView.findViewById(R.id.radioBtnOpcionBusqueda );
        radioButton.setText( strOpcionBusqueda );
        

        return convertView;
        
    }

    @Override
    public int getChildrenCount( int a_ParentPosicion ) 
    {
    	return m_ListOpcionesBusqueda.size();
        //return children.get(groupPosition).size();
    }

    @Override
    public String getGroup( int a_ParentPosicion ) 
    {
    	
    	return m_TituloOpcionesBusqueda; //m_ListCategorias.get( a_ParentPosicion );

    }

    @Override
    public int getGroupCount() 
    {
        return 1;
    }

    @Override
    public long getGroupId(int a_ParentPosicion ) 
    {
        return a_ParentPosicion;
    }

    @Override
    public View getGroupView( 	int 		a_ParentPosicion, 
    							boolean 	isExpanded, 
    							View 		convertView, 
    							ViewGroup 	parent) {

    	String group= getGroup( a_ParentPosicion );

    	if (convertView == null) {
    		
            LayoutInflater infalInflater = (LayoutInflater) m_Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //convertView = infalInflater.inflate(R.layout.expandablelistview_categorias, null);
            convertView = infalInflater.inflate(R.layout.expandableview_opciones_busqueda, null);
        }

        TextView grouptxt = (TextView) convertView.findViewById(R.id.textViewOpcionesBusqueda);
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

} // end class ExpandableOpcionesBusquedaAdapter 

