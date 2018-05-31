package cr.ac.ucenfotec.sistematramite.multi;

import accesobd.Conector;
import cr.ac.ucenfotec.sistematramite.entitiespojo.BaseEntity;
import cr.ac.ucenfotec.sistematramite.entitiespojo.AreaFuncional;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MultiAreaFuncional implements ISQLStatement {
	
	public MultiAreaFuncional() 
	{
		
	}
	
	public void GetCreateStatement(BaseEntity entity) throws Exception {
		AreaFuncional area = (AreaFuncional)entity;
		String query;
		
		query = "INSERT INTO AREAFUNCIONAL(IDTAREA,NOMBRE) "
				+ "VALUES('"+area.getIdTarea()+"','"+area.getNombre()+"');";
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
	}
	
	
    public ArrayList<BaseEntity> GetRetriveAllStatement() throws Exception{
    	ArrayList<BaseEntity> List = new ArrayList<>();
    	AreaFuncional area = null;
    	ResultSet rs;
    	String query;
    	
    	query = "SELECT * "
    			+ "FROM AREAFUNCIONAL;";
    	
    	try {
    		
    		rs = Conector.getConector().ejecutarSQL(query, true);
    		
    		while (rs.next()) {
    			area = new AreaFuncional(
    					rs.getInt("ID"),
    					rs.getInt("IDTAREA"),
    					rs.getString("NOMBRE"));
    			
    			List.add(area);  			
    		}
    		
    		rs.close();
//    		Conector.getConector().cerrarConexion();
    		
    	} catch (Exception e) {
    		throw e;   		
    	}
    	
    	return List;
    	   	
    }
    
    public BaseEntity GetRetriveStatement(BaseEntity entity) throws Exception{
    	AreaFuncional area = (AreaFuncional)entity;
    	AreaFuncional a = null;
    	ResultSet rs;
    	String query;
    	
    	try {
    		
    		query = "SELECT * "
    				+ "FROM AREAFUNCIONAL "
    				+ "WHERE ID = '"+area.getId()+"';";
    		
    		rs = Conector.getConector().ejecutarSQL(query, true);
    		
    		if(rs.next()) {
    			a = new AreaFuncional(
    					rs.getInt("ID"),
    					rs.getInt("IDTAREA"),
    					rs.getString("NOMBRE"));
    		}
    		
    		rs.close();
//    		Conector.getConector().cerrarConexion();
    		
    	}catch(Exception e) {
    		throw e;
    	}
    	
    	return a;
    }
    
    public void GetUpdateStatement(BaseEntity entity) throws Exception{
    	AreaFuncional area = (AreaFuncional)entity;
		String query;
		
		query = "UPDATE AREAFUNCIONAL "
				+ "SET IDTAREA='"+area.getIdTarea()+"',NOMBRE='"+area.getNombre()+"'"
						+ "WHERE ID= '"+area.getId()+"';";
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
    	
    }
    
    public void GetDeleteStatement(BaseEntity entity) throws Exception{
    	AreaFuncional area = (AreaFuncional)entity;
		String query;
		
		query = "DELETE FROM AREAFUNCIONAL "
				+ "WHERE ID = '"+area.getId()+"';"; 
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
    	
    }
    
}