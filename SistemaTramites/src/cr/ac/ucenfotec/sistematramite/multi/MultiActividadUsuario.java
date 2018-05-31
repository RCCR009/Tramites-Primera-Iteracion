package cr.ac.ucenfotec.sistematramite.multi;

import accesobd.Conector;
import cr.ac.ucenfotec.sistematramite.entitiespojo.BaseEntity;
import cr.ac.ucenfotec.sistematramite.entitiespojo.ActividadUsuario;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MultiActividadUsuario implements ISQLStatement {
	
	public MultiActividadUsuario() 
	{
		
	}
	
	public void GetCreateStatement(BaseEntity entity) throws Exception {
		ActividadUsuario au = (ActividadUsuario)entity;
		String query;
		
		query = "INSERT INTO ACTIVIDADES_USUARIOS(IDTAREA_USUARIOS,DETALLE,RESPUESTA) "
				+ "VALUES("+au.getIdTareaUsuario()+",'"+au.getDetalle()+"','"+au.getRespuesta()+"');";
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
	}
	
	
    public ArrayList<BaseEntity> GetRetriveAllStatement() throws Exception{
    	ArrayList<BaseEntity> List = new ArrayList<>();
    	ActividadUsuario au = null;
    	ResultSet rs;
    	String query;
    	
    	query = "SELECT * "
    			+ "FROM ACTIVIDADES_USUARIOS;";
    	
    	try {
    		
    		rs = Conector.getConector().ejecutarSQL(query, true);
    		
    		while (rs.next()) {
    			
    			au = new ActividadUsuario(
    					rs.getInt("ID"),
    					rs.getInt("IDTAREA_USUARIOS"),
    					rs.getString("DETALLE"),
    					rs.getString("RESPUESTA"));
    					
    			List.add(au);  			
    		}
    		
    		rs.close();
//    		Conector.getConector().cerrarConexion();
    		
    	} catch (Exception e) {
    		throw e;   		
    	}
    	
    	return List;
    	   	
    }
    
    public BaseEntity GetRetriveStatement(BaseEntity entity) throws Exception{
    	ActividadUsuario actividadUsuario = (ActividadUsuario)entity;
    	ActividadUsuario au = null;
    	ResultSet rs;
    	String query;
    	
    	try {
    		
    		query = "SELECT * "
    				+ "FROM ACTIVIDADES_USUARIOS "
    				+ "WHERE ID = '"+actividadUsuario.getId()+"';";
    		
    		rs = Conector.getConector().ejecutarSQL(query, true);
    		
    		if(rs.next()) {
    			au = new ActividadUsuario(
    					rs.getInt("ID"),
    					rs.getInt("IDTAREA_USUARIOS"),
    					rs.getString("DETALLE"),
    					rs.getString("RESPUESTA"));
    		}
    		
    		rs.close();
//    		Conector.getConector().cerrarConexion();
    		
    	}catch(Exception e) {
    		throw e;
    	}
    	
    	return au;
    }
    
    public void GetUpdateStatement(BaseEntity entity) throws Exception{
    	ActividadUsuario au = (ActividadUsuario)entity;
		String query;
		
		query = "UPDATE ACTIVIDADES_USUARIOS "
				+ "SET IDTAREA_USUARIOS='"+au.getIdTareaUsuario()+"',DETALLE='"+au.getDetalle()+"',RESPUESTA='"+au.getRespuesta()+"' "
				+ "WHERE ID= '"+au.getId()+"';";
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
    	
    }
    
    public void GetDeleteStatement(BaseEntity entity) throws Exception{
    	ActividadUsuario au = (ActividadUsuario)entity;
		String query;
		
		query = "DELETE FROM ACTIVIDADES_USUARIOS "
				+ "WHERE ID = '"+au.getId()+"';"; 
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
    	
    }
    
}