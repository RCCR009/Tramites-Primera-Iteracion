package cr.ac.ucenfotec.sistematramite.gestor;

import java.sql.SQLException;
import java.util.ArrayList;

import cr.ac.ucenfotec.sistematramite.entitiespojo.Tramite;
import cr.ac.ucenfotec.sistematramite.entitiespojo.BaseEntity;
import cr.ac.ucenfotec.sistematramite.multi.MultiTramite;

public class GestorTramite {
	
	public GestorTramite() {
		
	}
	
	public void Create(BaseEntity entity) throws java.sql.SQLException, Exception {
		Tramite tramite = (Tramite)entity;
		
		try {
			new MultiTramite().GetCreateStatement(tramite);
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
	public BaseEntity Retrive(BaseEntity entity) throws java.sql.SQLException, Exception {
		Tramite tramite = (Tramite)entity;		
		Tramite t = null;
			
		try {
			 t  = (Tramite) new MultiTramite().GetRetriveStatement(tramite);
		
		} catch (java.lang.ClassNotFoundException | SQLException ex) {
            throw ex;
        }
		
		return t;		
	}
	
	public ArrayList<BaseEntity> RetriveAll() throws java.sql.SQLException, Exception{
		ArrayList<BaseEntity> list = new ArrayList<>();
		
		try {
			list = new MultiTramite().GetRetriveAllStatement();
			
		} catch (java.lang.ClassNotFoundException | SQLException ex) {
            throw ex;
        }
		
		return list;		
	}
	
	public void Update(BaseEntity entity) throws java.sql.SQLException, Exception {
		try {
			new MultiTramite().GetUpdateStatement(entity);;
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
	public void Delete(BaseEntity entity) throws java.sql.SQLException, Exception {
		try {
			new MultiTramite().GetDeleteStatement(entity);
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
}
