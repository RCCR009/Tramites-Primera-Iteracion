package cr.ac.ucenfotec.sistematramite.multi;

import accesobd.Conector;
import cr.ac.ucenfotec.sistematramite.entitiespojo.BaseEntity;
import cr.ac.ucenfotec.sistematramite.entitiespojo.Actividad;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MultiActividad implements ISQLStatement {
	
	public MultiActividad() 
	{
		
	}
	
	public void GetCreateStatement(BaseEntity entity) throws Exception {
		Actividad actividad = (Actividad)entity;
		String query;
		
		query = "INSERT INTO ACTIVIDADES(IDTAREA,DETALLE) "
				+ "VALUES('"+actividad.getIdTarea()+"','"+actividad.getDetalle()+"');";
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
	}
	
	
    public ArrayList<BaseEntity> GetRetriveAllStatement() throws Exception{
    	ArrayList<BaseEntity> List = new ArrayList<>();
    	Actividad actividad = null;
    	ResultSet rs;
    	String query;
    	
    	query = "SELECT * "
    			+ "FROM ACTIVIDADES;";
    	
    	try {
    		
    		rs = Conector.getConector().ejecutarSQL(query, true);
    		
    		while (rs.next()) {
    			actividad = new Actividad(
    					rs.getInt("ID"),
    					rs.getInt("IDTAREA"),
    					rs.getString("DETALLE"));
    			
    			List.add(actividad);  			
    		}
    		
    		rs.close();
//    		Conector.getConector().cerrarConexion();
    		
    	} catch (Exception e) {
    		throw e;   		
    	}
    	
    	return List;
    	   	
    }
    
    public BaseEntity GetRetriveStatement(BaseEntity entity) throws Exception{
    	Actividad actividad = (Actividad)entity;
    	Actividad a = null;
    	ResultSet rs;
    	String query;
    	
    	try {
    		
    		query = "SELECT * "
    				+ "FROM ACTIVIDADES "
    				+ "WHERE ID = '"+actividad.getId()+"';";
    		
    		rs = Conector.getConector().ejecutarSQL(query, true);
    		
    		if(rs.next()) {
    			a = new Actividad(
    					rs.getInt("ID"),
    					rs.getInt("IDTAREA"),
    					rs.getString("DETALLE"));
    		}
    		
    		rs.close();
//    		Conector.getConector().cerrarConexion();
    		
    	}catch(Exception e) {
    		throw e;
    	}
    	
    	return a;
    }
    
    public void GetUpdateStatement(BaseEntity entity) throws Exception{
    	Actividad actividad = (Actividad)entity;
		String query;
		
		query = "UPDATE ACTIVIDADES "
				+ "SET IDTAREA='"+actividad.getIdTarea()+"',DETALLE='"+actividad.getDetalle()+"'"
						+ "WHERE ID= '"+actividad.getId()+"';";
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
    	
    }
    
    public void GetDeleteStatement(BaseEntity entity) throws Exception{
    	Actividad actividad = (Actividad)entity;
		String query;
		
		query = "DELETE FROM ACTIVIDADES "
				+ "WHERE ID = '"+actividad.getId()+"';"; 
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
    	
    }
    
}