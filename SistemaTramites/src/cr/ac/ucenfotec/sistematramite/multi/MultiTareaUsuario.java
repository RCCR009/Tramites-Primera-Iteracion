package cr.ac.ucenfotec.sistematramite.multi;

import accesobd.Conector;
import cr.ac.ucenfotec.sistematramite.entitiespojo.BaseEntity;
import cr.ac.ucenfotec.sistematramite.entitiespojo.TareaUsuario;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.util.ArrayList;


public class MultiTareaUsuario implements ISQLStatement {
	
	public MultiTareaUsuario() 
	{
		
	}
	
	public void GetCreateStatement(BaseEntity entity) throws Exception {
		TareaUsuario tareau = (TareaUsuario)entity;
		String query;
		
		query = "INSERT INTO TAREAS_USUARIOS(FECHAFIN,IDTRAMITES_USUARIOS,IDUSUARIO) "
				+ "VALUES('"+tareau.getFechaFin()+"','"+tareau.getIdProcesoUsuario()+"','"+tareau.getIdUsuario()+"');";
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
	}
	
	
    public ArrayList<BaseEntity> GetRetriveAllStatement() throws Exception{
    	ArrayList<BaseEntity> List = new ArrayList<>();
    	TareaUsuario tu = null;
    	ResultSet rs;
    	String query;
    	
    	query = "SELECT * "
    			+ "FROM TAREAS_USUARIOS;";
    	
    	try {
    		
    		rs = Conector.getConector().ejecutarSQL(query, true);
    		
    		while (rs.next()) {
    			
    			tu = new TareaUsuario(
    					rs.getInt("ID"),
    					rs.getDate("FECHAFIN").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
    					rs.getInt("IDTRAMITES_USUARIOS"),
    					rs.getString("IDUSUARIO"));
    			
    			List.add(tu);  			
    		}
    		
    		rs.close();
//    		Conector.getConector().cerrarConexion();
    		
    	} catch (Exception e) {
    		throw e;   		
    	}
    	
    	return List;
    	   	
    }
    
    public BaseEntity GetRetriveStatement(BaseEntity entity) throws Exception{
    	TareaUsuario tu = (TareaUsuario)entity;
    	TareaUsuario tareaUsuario = null;
    	ResultSet rs;
    	String query;
    	
    	try {
    		
    		query = "SELECT * "
    				+ "FROM TAREAS_USUARIOS "
    				+ "WHERE ID = '"+tu.getId()+"';";
    		
    		rs = Conector.getConector().ejecutarSQL(query, true);
    		
    		if(rs.next()) {
    			tareaUsuario = new TareaUsuario(
    					rs.getInt("ID"),
    					rs.getDate("FECHAFIN").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
    					rs.getInt("IDTRAMITES_USUARIOS"),
    					rs.getString("IDUSUARIO"));
    		}
    		
    		rs.close();
//    		Conector.getConector().cerrarConexion();
    		
    	}catch(Exception e) {
    		throw e;
    	}
    	
    	return tareaUsuario;
    }
    
    public void GetUpdateStatement(BaseEntity entity) throws Exception{
    	TareaUsuario tu = (TareaUsuario)entity;
		String query;
		
		query = "UPDATE TAREAS_USUARIOS "
				+ "SET FECHAFIN='"+tu.getFechaFin()+"', IDTRAMITES_USUARIOS='"+tu.getIdProcesoUsuario()+"',IDUSUARIO='"+tu.getIdUsuario()+"' "
						+ "WHERE ID= '"+tu.getId()+"';";
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
    	
    }
    
    public void GetDeleteStatement(BaseEntity entity) throws Exception{
    	TareaUsuario tu = (TareaUsuario)entity;
		String query;
		
		query = "DELETE FROM TAREAS_USUARIOS "
				+ "WHERE ID = '"+tu.getId()+"';"; 
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
    	
    }
    
}