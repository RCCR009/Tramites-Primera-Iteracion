package cr.ac.ucenfotec.sistematramite.gestor;

import java.sql.SQLException;
import java.util.ArrayList;

import cr.ac.ucenfotec.sistematramite.entitiespojo.Usuario;
import cr.ac.ucenfotec.sistematramite.entitiespojo.BaseEntity;
import cr.ac.ucenfotec.sistematramite.multi.MultiUsuario;

public class GestorUsuario {
	
	public GestorUsuario() {
		
	}
	
	public void Create(BaseEntity entity) throws java.sql.SQLException, Exception {
		Usuario Usuario = (Usuario)entity;
		
		try {
			new MultiUsuario().GetCreateStatement(Usuario);
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
	public BaseEntity Retrive(BaseEntity entity) throws java.sql.SQLException, Exception {
		Usuario usuario = (Usuario)entity;		
		Usuario u = null;
			
		try {
			 u  = (Usuario) new MultiUsuario().GetRetriveStatement(usuario);
		
		} catch (java.lang.ClassNotFoundException | SQLException ex) {
            throw ex;
        }
		
		return u;		
	}
	
	public ArrayList<BaseEntity> RetriveAll() throws java.sql.SQLException, Exception{
		ArrayList<BaseEntity> list = new ArrayList<>();
		
		try {
			list = new MultiUsuario().GetRetriveAllStatement();
			
		} catch (java.lang.ClassNotFoundException | SQLException ex) {
            throw ex;
        }
		
		return list;		
	}
	
	public void Update(BaseEntity entity) throws java.sql.SQLException, Exception {
		try {
			new MultiUsuario().GetUpdateStatement(entity);;
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
	public void Delete(BaseEntity entity) throws java.sql.SQLException, Exception {
		try {
			new MultiUsuario().GetDeleteStatement(entity);
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
	public BaseEntity login(BaseEntity entity) throws java.sql.SQLException, Exception {
		Usuario usuario = (Usuario)entity;		
		Usuario u = null;

		try {
			 u  = (Usuario) new MultiUsuario().loginVerification(usuario);
		
		} catch (java.lang.ClassNotFoundException | SQLException ex) {
            throw ex;
        }
		
		return u;		
	}
	
	
	
}
