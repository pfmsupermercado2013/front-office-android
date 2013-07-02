package com.supermarket_frontoffice.recorrido_optimo.gl.comun;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;




/** @class GLObjects
 * 
 *  Clase que dibuja una lista de objetos especificada.
 * 
 * @author fjvegaf
 *
 */
public class GLObjects extends GLObject
{

	private static final String TAG= "GLObjects";
	
	private ArrayList< GLObject > m_ListObjects;
	
	
	/** Constructor
	 * 
	 */
	public GLObjects( )
	{
		
		this( new  ArrayList< GLObject >() );
		
	} // GLObjects
	
	
	/** Constructor
	 * 
	 * @param a_ListObject
	 */
	public GLObjects( ArrayList< GLObject > a_ListObjects )
	{
		super();
		m_ListObjects= a_ListObjects;
		
	} // GLObjects
	
	

	/** Método abstracto que debe redefinir las clases que lo hereran
	 * 
	 * @param a_Gl
	 */
	public void draw( GL10 a_Gl )
	{
		
		super.draw( a_Gl );
		
		for ( GLObject glObject: m_ListObjects ) {
			
			glObject.draw( a_Gl );
		}
		
	
	} // draw 
	
	
	/**
	 * @return the m_ListObject
	 */
	public ArrayList<GLObject> getListObjects( ) 
	{
		return m_ListObjects;
	} // getListObject


	/**
	 * @param m_ListObject the m_ListObject to set
	 */
	public void setListObjects( ArrayList<GLObject> a_ListObjects ) 
	{
		this.m_ListObjects= a_ListObjects;
	} // setListObject
	
	/**
	 * @param m_ListObject the m_ListObject to set
	 */
	public void addObject( GLObject a_Object ) 
	{
		this.m_ListObjects.add( a_Object );
	} // setListObject
	
	
	
} // GLObjects
