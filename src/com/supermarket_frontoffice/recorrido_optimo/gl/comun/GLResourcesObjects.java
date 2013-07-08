package com.supermarket_frontoffice.recorrido_optimo.gl.comun;

import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;


/** @class GLResourcesObjects
 * 
 * 	Clase que dibuja en OpenGL un objeto compuesto por varios objetos.
 * 	La base del objeto es dibujada por esta clase. 
 * 
 * @author fjvegaf
 *
 */
public class GLResourcesObjects extends GLResourceObject
{
	
	private static final String TAG= "GLResourcesObjects";
	
	private ArrayList< GLResourceObject > m_ListResourcesObjects;	///< Lista de recursos de objetos OpenGL
	
	
	/** Constructor
	 * 
	 * @param a_Context
	 * @param a_IdResourceVertices
	 * @param a_IdResourceNormales
	 * @param a_IdResourceCaras
	 * @param a_IdResourceCoorTextura
	 * @param a_IdResourceColores
	 */
	public GLResourcesObjects( 	  Context a_Context,
								  int a_IdResourceVertices,
								  int a_IdResourceNormales,
								  int a_IdResourceCaras,
								  int a_IdResourceCoorTextura,
								  int a_IdResourceColores )
	{
			
		super(  a_Context,
				a_IdResourceVertices,
				a_IdResourceNormales,
				a_IdResourceCaras,
				a_IdResourceCoorTextura,
				a_IdResourceColores );
		
		m_ListResourcesObjects= new ArrayList< GLResourceObject >();
		
		//Log.d( "GLResourcesObject", "Constructor End" );
		
	} // GLResourcesObjects

	
	/** Constructor
	 * 
	 * @param a_Context
	 * @param a_IdResourceVertices
	 * @param a_IdResourceNormales
	 * @param a_IdResourceCaras
	 */
	public GLResourcesObjects( Context a_Context,
							  int a_IdResourceVertices,
							  int a_IdResourceNormales,
							  int a_IdResourceCaras )
	{
		
		this( a_Context,
				   a_IdResourceVertices,
				   a_IdResourceNormales,
				   a_IdResourceCaras,
				   0, 0 );
		
	} // GLResourcesObjects

	
	
	/** Método abstracto que debe redefinir las clases que lo hereran
	 * 
	 * @param a_Gl
	 */
	public void draw( GL10 a_Gl )
	{
		
		super.draw( a_Gl );
		
		
		for ( GLResourceObject glResourcesObject: m_ListResourcesObjects ) {
			
			glResourcesObject.draw( a_Gl );
		}
		
		
	
	} // draw 
	
	
	/**
	 * @return the m_ListObject
	 */
	public ArrayList< GLResourceObject > getListResourcesObjects( ) 
	{
		return m_ListResourcesObjects;
	} // getListObject


	/**
	 * @param m_ListObject the m_ListObject to set
	 */
	public void setListResourcesObjects( ArrayList< GLResourceObject > a_ListResourcesObjects ) 
	{
		this.m_ListResourcesObjects= a_ListResourcesObjects;
	} // setListObject
	
	/**
	 * @param m_ListObject the m_ListObject to set
	 */
	public void addObject( GLResourceObject a_ResourcesObject ) 
	{
		this.m_ListResourcesObjects.add( a_ResourcesObject );
	} // setListObject

} // GLResourcesObjects
