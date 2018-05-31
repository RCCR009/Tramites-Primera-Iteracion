package cr.ac.ucenfotec.sistematramite.multi;

import accesobd.Conector;
import cr.ac.ucenfotec.sistematramite.entitiespojo.BaseEntity;
import cr.ac.ucenfotec.sistematramite.entitiespojo.Tramite;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MultiTramite implements ISQLStatement {
	
	public MultiTramite() 
	{
		
	}
	
	public void GetCreateStatement(BaseEntity entity) throws Exception {
		Tramite tramite = (Tramite)entity;
		String query;
		
		query = "INSERT INTO TRAMITES(NOMBRE,ESTADO) "
				+ "VALUES('"+tramite.getNombre()+"','"+tramite.getEstado()+"');";
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
	}
	
	
    public ArrayList<BaseEntity> GetRetriveAllStatement() throws Exception{
    	ArrayList<BaseEntity> TramiteList = new ArrayList<>();
    	Tramite tramite = null;
    	ResultSet rs;
    	String query;
    	
    	query = "SELECT * "
    			+ "FROM TRAMITES;";
    	
    	try {
    		
    		rs = Conector.getConector().ejecutarSQL(query, true);
    		
    		while (rs.next()) {
    			tramite = new Tramite(
    					rs.getInt("ID"),
    					rs.getString("NOMBRE"),
    					rs.getInt("ESTADO"));
    			
    			TramiteList.add(tramite);  			
    		}
    		
    		rs.close();
//    		Conector.getConector().cerrarConexion();
    		
    	} catch (Exception e) {
    		throw e;   		
    	}
    	
    	return TramiteList;
    	   	
    }
    
    public BaseEntity GetRetriveStatement(BaseEntity entity) throws Exception{
    	Tramite tramite = (Tramite)entity;
    	Tramite t = null;
    	ResultSet rs;
    	String query;
    	
    	try {
    		
    		query = "SELECT * "
    				+ "FROM TRAMITES "
    				+ "WHERE ID = '"+tramite.getId()+"';";
    		
    		rs = Conector.getConector().ejecutarSQL(query, true);
    		
    		if(rs.next()) {
    			t = new Tramite(
    					rs.getInt("ID"),
    					rs.getString("NOMBRE"),
    					rs.getInt("ESTADO"));
    		}
    		
    		rs.close();
//    		Conector.getConector().cerrarConexion();
    		
    	}catch(Exception e) {
    		throw e;
    	}
    	
    	return t;
    }
    
    public void GetUpdateStatement(BaseEntity entity) throws Exception{
    	Tramite tramite = (Tramite)entity;
		String query;
		
		query = "UPDATE TRAMITES "
				+ "SET NOMBRE='"+tramite.getNombre()+"', ESTADO='"+tramite.getEstado()+"' "
						+ "WHERE ID= '"+tramite.getId()+"';";
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
    	
    }
    
    public void GetDeleteStatement(BaseEntity entity) throws Exception{
    	Tramite tramite = (Tramite)entity;
		String query;
		
		query = "DELETE FROM TRAMITES "
				+ "WHERE ID = '"+tramite.getId()+"';"; 
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
    	
    }
	

}
