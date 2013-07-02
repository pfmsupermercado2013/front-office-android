package com.supermarket_frontoffice.recorrido_optimo.gl.comun;


import java.util.ArrayList;
import java.util.Arrays;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.util.Log;



/** @class GLFileObject
 * 
 * @author fjvegaf
 *
 */
public class GLResourceObject extends GLObject
{
	
	
	private static final String TAG= "GLResourceObject";
	
	
	/** Constructor
	 * 
	 * @param a_Context
	 * @param a_IdResourceVertices
	 * @param a_IdResourceNormales
	 * @param a_IdResourceCaras
	 * @param a_IdResourceCoorTextura
	 * @param a_IdResourceColores
	 */
	public GLResourceObject( Context a_Context,
							  int a_IdResourceVertices,
							  int a_IdResourceNormales,
							  int a_IdResourceCaras,
							  int a_IdResourceCoorTextura,
							  int a_IdResourceColores )
	{
			
		super(  getListaVertices( a_Context, a_IdResourceVertices ), 
				getListaNormales(a_Context,  a_IdResourceNormales ), 
				getListaCaras( a_Context, a_IdResourceCaras ), 
				getListaCoordTextura( a_Context, a_IdResourceCoorTextura ), 
				getListaColores(a_Context, a_IdResourceColores )  );
		
	} // GLResourceObject

	
	/** Constructor
	 * 
	 * @param a_Context
	 * @param a_IdResourceVertices
	 * @param a_IdResourceNormales
	 * @param a_IdResourceCaras
	 */
	public GLResourceObject( Context a_Context,
							  int a_IdResourceVertices,
							  int a_IdResourceNormales,
							  int a_IdResourceCaras )
	{
		super(  getListaVertices( a_Context, a_IdResourceVertices ), 
				getListaNormales(a_Context,  a_IdResourceNormales ), 
				getListaCaras( a_Context, a_IdResourceCaras ) );
		
	} // GLResourceObject
	
	
	public static float[] getListaVertices( Context a_Context, int a_IdResource )
	{
		
		
		if ( a_IdResource == 0 ) {
			
			return null;
		}
		
		
		//Log.d("GLResourcesObject", "Lectura del vertices del recurso " + a_StrListaVertices );
		//ArrayList< String >  listVertices= new ArrayList< String >( Arrays.asList( a_Context.getResources().getStringArray( R.array.gl_carrito_compra_vertices ) ) );
		ArrayList< String >  listVertices= new ArrayList< String >( Arrays.asList( a_Context.getResources().getStringArray( a_IdResource ) ) );
		Log.d( "GLResourcesObject", "Encontrado " + listVertices.size() + " vertices." ); 
		
		ArrayList< Float > listfloatVertices= new ArrayList< Float >();
		for ( String strVertice: listVertices ) {
			
			String[] strListVertices= strVertice.split( "," );
			
			listfloatVertices.add( Float.parseFloat( strListVertices[0] ));
			listfloatVertices.add( Float.parseFloat( strListVertices[1] ));
			listfloatVertices.add( Float.parseFloat( strListVertices[2] ));
			
//			Log.d( "GLResourcesObject", "StrVertice ( " + strVertice + " )" );
//			Log.d( "GLResourcesObject", "Float Vertice ( " + Float.parseFloat( strListVertices[0]) + ", " + 
//									Float.parseFloat( strListVertices[1]) + ", " + Float.parseFloat( strListVertices[2]) + " )" );
			
		}
				
		float[] listVerticesOut= new float[ listfloatVertices.size() ]; //(float[]) listfloatVertices.toArray();
		
		for ( int i= 0; i < listfloatVertices.size(); ++i ) {
		
			listVerticesOut[i]= listfloatVertices.get( i );
		}
		
		return listVerticesOut;
		
	} // getListaVertices
	
	
	public static float[] getListaNormales( Context a_Context, int a_IdResource )
	{
		

		if ( a_IdResource == 0 ) {
			
			return null;
		}
		
		ArrayList< String >  listNormales= new ArrayList< String >( Arrays.asList( a_Context.getResources().getStringArray( a_IdResource ) ) );
		
		Log.d( "GLResourcesObject", "Encontrado " + listNormales.size() + " normales." );
		
		ArrayList< Float > listFloatNormales= new ArrayList< Float >();
		for ( String strNormales: listNormales ) {
			
			String[] strListNormales= strNormales.split( "," );
			
			listFloatNormales.add( Float.parseFloat( strListNormales[0] ));
			listFloatNormales.add( Float.parseFloat( strListNormales[1] ));
			listFloatNormales.add( Float.parseFloat( strListNormales[2] ));
			
//			Log.d( "GLResourcesObject", "StrNormales ( " + strNormales + " )" );
//			Log.d( "GLResourcesObject", "Float Normales ( " + Float.parseFloat( strListNormales[0]) + ", " + 
//									Float.parseFloat( strListNormales[1]) + ", " + Float.parseFloat( strListNormales[2]) + " )" );
			
		}
				
		float[] listNormalesOut= new float[ listFloatNormales.size() ]; //(float[]) listfloatVertices.toArray();
		
		for ( int i= 0; i < listFloatNormales.size(); ++i ) {
		
			listNormalesOut[i]= listFloatNormales.get( i );
		}
		
		return listNormalesOut;
		
	} // getListaNormales
	
	
	public static short[] getListaCaras( Context a_Context, int a_IdResource )
	{
		

		if ( a_IdResource == 0 ) {
			
			return null;
		}		
		
		ArrayList< String >  listCaras= new ArrayList< String >( Arrays.asList( a_Context.getResources().getStringArray( a_IdResource ) ) );
    	
		Log.d( "GLResourcesObject", "Encontrado " + listCaras.size() + " caras." );
		
		ArrayList< Short > listShortCaras= new ArrayList< Short >();
		for ( String strCaras: listCaras ) {
			
			String[] strListCaras= strCaras.split( "," );		

			listShortCaras.add(  Short.valueOf( strListCaras[0].trim() ));
			listShortCaras.add(  Short.valueOf( strListCaras[1].trim() ));
			listShortCaras.add(  Short.valueOf( strListCaras[2].trim() ));
		
		}
				
		short[] listCarasOut= new short[ listShortCaras.size() ]; 
		
		for ( int i= 0; i < listShortCaras.size(); ++i ) {
		
			listCarasOut[i]= listShortCaras.get( i );
		}
		
		return listCarasOut;
		
	} // getListaNormales
	
	
	public static float[] getListaCoordTextura( Context a_Context, int a_IdResource )
	{
		
		
		if ( a_IdResource == 0 ) {
			
			return null;
		}
		
		return new float[1];
//		
//		//Log.d("GLResourcesObject", "Lectura del vertices del recurso " + a_StrListaCoordTextura );
//		
//		//ArrayList< String >  listCoordTextura= new ArrayList< String >( Arrays.asList( a_Context.getResources().getStringArray( R.array.gl_carrito_compra_coord_texturas ) ) );
//		ArrayList< String >  listCoordTextura= new ArrayList< String >( Arrays.asList( a_Context.getResources().getStringArray( a_IdResource ) ) );
//    	
//		
//		Log.d( "GLResourcesObject", "Encontrado " + listCoordTextura.size() + " coordenadas texturas." );
//		
//		ArrayList< Float > listFloatCaras= new ArrayList< Float >();
//		for ( String strCoordTextura: listCoordTextura ) {
//			
//			//Log.d( "GLResourcesObject", "StrCaras ( " + strCaras + " )" );
//			String[] listStrCoordTextura= strCoordTextura.split( "," );		
//
//			listFloatCaras.add( Float.valueOf( listStrCoordTextura[0].trim() ));
//			listFloatCaras.add( Float.valueOf( listStrCoordTextura[1].trim() ));
//			listFloatCaras.add( Float.valueOf( listStrCoordTextura[2].trim() ));
//			
//			
////			Log.d( "GLResourcesObject", "Float Caras ( " + Short.valueOf( listStrCoordTextura[0].trim()) + ", " + 
////							Short.valueOf( listStrCoordTextura[1].trim()) + ", " + Short.valueOf( listStrCoordTextura[2].trim()) + " )" );
////			
//		}
//				
//		float[] listCarasOut= new float[ listFloatCaras.size() ]; //(float[]) listfloatVertices.toArray();
//		
//		for ( int i= 0; i < listFloatCaras.size(); ++i ) {
//		
//			listCarasOut[i]= listFloatCaras.get( i );
//		}
//		
//		return listCarasOut;
		
	} // getListaCoordTextura
	
	
	public static float[] getListaColores( Context a_Context, int a_IdResource )
	{
		
		if ( a_IdResource == 0 ) {
			
			return null;
		}
		
		
		
		ArrayList< String >  listColores= new ArrayList< String >( Arrays.asList( a_Context.getResources().getStringArray( a_IdResource ) ) );
		
		Log.d( "GLResourcesObject", "Encontrado " + listColores.size() + " colores." );
		
		ArrayList< Float > listFloatColores= new ArrayList< Float >();
		for ( String strColores: listColores ) {
			
			String[] strListColores= strColores.split( "," );
			
			listFloatColores.add( Float.parseFloat( strListColores[0] ) / 255.f );
			listFloatColores.add( Float.parseFloat( strListColores[1] ) / 255.f );
			listFloatColores.add( Float.parseFloat( strListColores[2] ) / 255.f );
			
			Log.d( "GLResourcesObject", "StrNormales ( " + strColores + " )" );
			Log.d( "GLResourcesObject", "Float Normales ( " + Float.parseFloat( strListColores[0]) + ", " + 
									Float.parseFloat( strListColores[1]) + ", " + Float.parseFloat( strListColores[2]) + " )" );
			
		}
				
		float[] listColoresOut= new float[ listFloatColores.size() ]; //(float[]) listfloatVertices.toArray();
		
		for ( int i= 0; i < listFloatColores.size(); ++i ) {
		
			listColoresOut[i]= listFloatColores.get( i );
		}
		
		
		
		return listColoresOut;
		
	} // getListaColores
	

	
	

} // end class GLFileObject
