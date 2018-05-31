package cr.ac.ucenfotec.sistematramite.gestor;

import java.sql.SQLException;
import java.util.ArrayList;

import cr.ac.ucenfotec.sistematramite.entitiespojo.TramiteUsuario;
import cr.ac.ucenfotec.sistematramite.entitiespojo.BaseEntity;
import cr.ac.ucenfotec.sistematramite.multi.MultiTramiteUsuario;

public class GestorTramiteUsuario {
	
	public GestorTramiteUsuario() {
		
	}
	
	public void Create(BaseEntity entity) throws java.sql.SQLException, Exception {
		TramiteUsuario tramiteU = (TramiteUsuario)entity;
		
		try {
			new MultiTramiteUsuario().GetCreateStatement(tramiteU);
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
	public BaseEntity Retrive(BaseEntity entity) throws java.sql.SQLException, Exception {
		TramiteUsuario TramiteU = (TramiteUsuario)entity;		
		TramiteUsuario tu = null;
			
		try {
			 tu  = (TramiteUsuario) new MultiTramiteUsuario().GetRetriveStatement(TramiteU);
		
		} catch (java.lang.ClassNotFoundException | SQLException ex) {
            throw ex;
        }
		
		return tu;		
	}
	
	public ArrayList<BaseEntity> RetriveAll() throws java.sql.SQLException, Exception{
		ArrayList<BaseEntity> list = new ArrayList<>();
		
		try {
			list = new MultiTramiteUsuario().GetRetriveAllStatement();
			
		} catch (java.lang.ClassNotFoundException | SQLException ex) {
            throw ex;
        }
		
		return list;		
	}
	
	public void Update(BaseEntity entity) throws java.sql.SQLException, Exception {
		try {
			new MultiTramiteUsuario().GetUpdateStatement(entity);;
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
	public void Delete(BaseEntity entity) throws java.sql.SQLException, Exception {
		try {
			new MultiTramiteUsuario().GetDeleteStatement(entity);
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
}
