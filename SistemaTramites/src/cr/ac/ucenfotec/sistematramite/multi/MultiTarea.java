package cr.ac.ucenfotec.sistematramite.multi;

import accesobd.Conector;
import cr.ac.ucenfotec.sistematramite.entitiespojo.BaseEntity;
import cr.ac.ucenfotec.sistematramite.entitiespojo.Tarea;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MultiTarea implements ISQLStatement {
	
	public MultiTarea() 
	{
		
	}
	
	public void GetCreateStatement(BaseEntity entity) throws Exception {
		Tarea tarea = (Tarea)entity;
		String query;
		
		query = "INSERT INTO TAREAS(NUMERO,IDTRAMITE,NOMBRE) "
				+ "VALUES('"+tarea.getNumero()+"','"+tarea.getIdTramite()+"','"+tarea.getNombre()+"');";
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
	}
	
	
    public ArrayList<BaseEntity> GetRetriveAllStatement() throws Exception{
    	ArrayList<BaseEntity> List = new ArrayList<>();
    	Tarea tarea = null;
    	ResultSet rs;
    	String query;
    	
    	query = "SELECT * "
    			+ "FROM TAREAS;";
    	
    	try {
    		
    		rs = Conector.getConector().ejecutarSQL(query, true);
    		
    		while (rs.next()) {
    			tarea = new Tarea(
    					rs.getInt("ID"),
    					rs.getInt("IDTRAMITE"),
    					rs.getString("NOMBRE"),
    					rs.getInt("NUMERO"));
    			
    			List.add(tarea);  			
    		}
    		
    		rs.close();
//    		Conector.getConector().cerrarConexion();
    		
    	} catch (Exception e) {
    		throw e;   		
    	}
    	
    	return List;
    	   	
    }
    
    public BaseEntity GetRetriveStatement(BaseEntity entity) throws Exception{
    	Tarea tarea = (Tarea)entity;
    	Tarea t = null;
    	ResultSet rs;
    	String query;
    	
    	try {
    		
    		query = "SELECT * "
    				+ "FROM TAREAS "
    				+ "WHERE ID = '"+tarea.getId()+"';";
    		
    		rs = Conector.getConector().ejecutarSQL(query, true);
    		
    		if(rs.next()) {
    			t = new Tarea(
    					rs.getInt("ID"),
    					rs.getInt("IDTRAMITE"),
    					rs.getString("NOMBRE"),
    					rs.getInt("NUMERO"));
    		}
    		
    		rs.close();
//    		Conector.getConector().cerrarConexion();
    		
    	}catch(Exception e) {
    		throw e;
    	}
    	
    	return t;
    }
    
    public void GetUpdateStatement(BaseEntity entity) throws Exception{
    	Tarea tarea = (Tarea)entity;
		String query;
		
		query = "UPDATE TRAMITES "
				+ "SET IDTRAMITE='"+tarea.getIdTramite()+"', NOMBRE='"+tarea.getNombre()+"','"+tarea.getNumero()+"' "
						+ "WHERE ID= '"+tarea.getId()+"';";
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
    	
    }
    
    public void GetDeleteStatement(BaseEntity entity) throws Exception{
    	Tarea tarea = (Tarea)entity;
		String query;
		
		query = "DELETE FROM TAREAS "
				+ "WHERE ID = '"+tarea.getId()+"';"; 
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
    	
    }
    
}
