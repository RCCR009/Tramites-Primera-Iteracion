package cr.ac.ucenfotec.sistematramite.multi;

import accesobd.Conector;
import cr.ac.ucenfotec.sistematramite.entitiespojo.BaseEntity;
import cr.ac.ucenfotec.sistematramite.entitiespojo.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MultiUsuario implements ISQLStatement {
	
	public MultiUsuario() 
	{
		
	}
	
	public void GetCreateStatement(BaseEntity entity) throws Exception {
		Usuario usuario = (Usuario)entity;
		String query;
		
		query = "INSERT INTO USUARIOS(ID,CLAVE,IDAREA,NOMBRE,APELLIDO) "
				+ "VALUES('"+usuario.getId()+"','"+usuario.getClave()+"','"+usuario.getIdArea()+"','"+usuario.getNombre()+"','"+usuario.getApellido()+"');";
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
	}
	
	
    public ArrayList<BaseEntity> GetRetriveAllStatement() throws Exception{
    	ArrayList<BaseEntity> List = new ArrayList<>();
    	Usuario usuario = null;
    	ResultSet rs;
    	String query;
    	
    	query = "SELECT * "
    			+ "FROM USUARIOS;";
    	
    	try {
    		
    		rs = Conector.getConector().ejecutarSQL(query, true);
    		
    		while (rs.next()) {
    			usuario = new Usuario(
    					rs.getString("ID"),
    					rs.getInt("IDAREA"),
    					rs.getString("CLAVE"),
    					rs.getString("NOMBRE"),
    					rs.getString("APELLIDO"));
    			
    			List.add(usuario);  			
    		}
    		
    		rs.close();
//    		Conector.getConector().cerrarConexion();
    		
    	} catch (Exception e) {
    		throw e;   		
    	}
    	
    	return List;
    	   	
    }
    
    public BaseEntity GetRetriveStatement(BaseEntity entity) throws Exception{
    	Usuario usuario = (Usuario)entity;
    	Usuario u = null;
    	ResultSet rs;
    	String query;
    	
    	try {
    		
    		query = "SELECT * "
    				+ "FROM USUARIOS "
    				+ "WHERE ID = '"+usuario.getId()+"';";
    		
    		rs = Conector.getConector().ejecutarSQL(query, true);
    		
    		if(rs.next()) {
    			u = new Usuario(
    					rs.getString("ID"),
    					rs.getInt("IDAREA"),
    					rs.getString("CLAVE"),
    					rs.getString("NOMBRE"),
    					rs.getString("APELLIDO"));
    		}
    		
    		rs.close();
//    		Conector.getConector().cerrarConexion();
    		
    	}catch(Exception e) {
    		throw e;
    	}
    	
    	return u;
    }
    
    public void GetUpdateStatement(BaseEntity entity) throws Exception{
    	Usuario usuario = (Usuario)entity;
		String query;
		
		query = "UPDATE USUARIOS "
				+ "SET CLAVE='"+usuario.getClave()+"',IDAREA='"+usuario.getIdArea()+"',NOMBRE='"+usuario.getNombre()+"', APELLIDO='"+usuario.getApellido()+"'; "
						+ "WHERE ID= '"+usuario.getId()+"';";
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
    	
    }
    
    public void GetDeleteStatement(BaseEntity entity) throws Exception{
    	Usuario usuario = (Usuario)entity;
		String query;
		
		query = "DELETE FROM USUARIOS "
				+ "WHERE ID = '"+usuario.getId()+"';"; 
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
    	
    }
    
    public BaseEntity loginVerification(BaseEntity entity) throws Exception{
    	Usuario usuario = (Usuario)entity;
    	Usuario u = null;
    	ResultSet rs;
    	String query;
    	
    	try {
    		
    		query = "SELECT * "
    				+ "FROM USUARIOS "
    				+ "WHERE ID = '"+usuario.getId()+"'AND CLAVE = '"+usuario.getClave()+"';";
    		
    		rs = Conector.getConector().ejecutarSQL(query, true);
    		
    		if(rs.next()) {
    			u = new Usuario(
    					rs.getString("ID"),
    					rs.getInt("IDAREA"),
    					rs.getString("CLAVE"),
    					rs.getString("NOMBRE"),
    					rs.getString("APELLIDO"));
    		}
    		
    		rs.close();
//    		Conector.getConector().cerrarConexion();
    		
    	}catch(Exception e) {
    		throw e;
    	}
    	
    	return u;
    }
        
}