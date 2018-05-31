package cr.ac.ucenfotec.sistematramite.multi;

import accesobd.Conector;
import cr.ac.ucenfotec.sistematramite.entitiespojo.BaseEntity;
import cr.ac.ucenfotec.sistematramite.entitiespojo.TramiteUsuario;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.util.ArrayList;


public class MultiTramiteUsuario implements ISQLStatement {
	
	public MultiTramiteUsuario() 
	{
		
	}
	
	public void GetCreateStatement(BaseEntity entity) throws Exception {
		TramiteUsuario tu = (TramiteUsuario)entity;
		String query;
		
		query = "INSERT INTO TRAMITES_USUARIOS(IDTRAMITE,FECHAINICIO,FECHAFIN,IDUSUARIO,TAREASCOMPLETADAS,ESTADO) "
				+ "VALUES('"+tu.getIdProceso()+"','"+tu.getFechaInicio()+"','"+tu.getFechaFin()+"','"+tu.getIdUsuario()+"','"+tu.getTareasCompletadas()+"','"+tu.getEstado()+"');";
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
	}
	
	
    public ArrayList<BaseEntity> GetRetriveAllStatement() throws Exception{
    	ArrayList<BaseEntity> List = new ArrayList<>();
    	TramiteUsuario tu = null;
    	ResultSet rs;
    	String query;
    	
    	query = "SELECT * "
    			+ "FROM TRAMITES_USUARIOS;";
    	
    	try {
    		
    		rs = Conector.getConector().ejecutarSQL(query, true);
    		
    		while (rs.next()) {
    			
    			tu = new TramiteUsuario(
    					rs.getInt("ID"),
    					rs.getInt("IDTRAMITE"),
    					rs.getDate("FECHAINICIO").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
    					rs.getDate("FECHAFIN").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
    					rs.getString("IDUSUARIO"),
    					rs.getInt("TAREASCOMPLETADAS"),
    					rs.getInt("ESTADO")
    					);
    			
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
    	TramiteUsuario tu = (TramiteUsuario)entity;
    	TramiteUsuario tramiteUsuario = null;
    	ResultSet rs;
    	String query;
    	
    	try {
    		
    		query = "SELECT * "
    				+ "FROM TRAMITES_USUARIOS "
    				+ "WHERE ID = '"+tu.getId()+"';";
    		
    		rs = Conector.getConector().ejecutarSQL(query, true);
    		
    		if(rs.next()) {
    			tramiteUsuario = new TramiteUsuario(
    					rs.getInt("ID"),
    					rs.getInt("IDTRAMITE"),
    					rs.getDate("FECHAINICIO").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
    					rs.getDate("FECHAFIN").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
    					rs.getString("IDUSUARIO"),
    					rs.getInt("TAREASCOMPLETADAS"),
    					rs.getInt("ESTADO")
    					);
    		}
    		
    		rs.close();
//    		Conector.getConector().cerrarConexion();
    		
    	}catch(Exception e) {
    		throw e;
    	}
    	
    	return tramiteUsuario;
    }
    
    public void GetUpdateStatement(BaseEntity entity) throws Exception{
    	TramiteUsuario tu = (TramiteUsuario)entity;
		String query;
		
		query = "UPDATE TRAMITES_USUARIOS "
				+ "SET IDTRAMITE='"+tu.getIdProceso()+"',FECHAINICIO='"+tu.getFechaInicio()+"',FECHAFIN='"+tu.getFechaFin()+"',IDUSUARIO='"+tu.getIdUsuario()+"',TAREASCOMPLEATADAS='"+tu.getTareasCompletadas()+"',ESTADO='"+tu.getEstado()+"' "
						+ "WHERE ID= '"+tu.getId()+"';";
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
    	
    }
    
    public void GetDeleteStatement(BaseEntity entity) throws Exception{
    	TramiteUsuario tu = (TramiteUsuario)entity;
		String query;
		
		query = "DELETE FROM TRAMITES_USUARIOS "
				+ "WHERE ID = '"+tu.getId()+"';"; 
		
		try {
			Conector.getConector().ejecutarSQL(query);
//			Conector.getConector().cerrarConexion();
			
		}catch(Exception e) {
			throw e;		
		}
    	
    }
    
}