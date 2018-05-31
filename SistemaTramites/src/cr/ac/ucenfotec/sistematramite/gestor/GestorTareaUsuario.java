package cr.ac.ucenfotec.sistematramite.gestor;

import java.sql.SQLException;
import java.util.ArrayList;

import cr.ac.ucenfotec.sistematramite.entitiespojo.TareaUsuario;
import cr.ac.ucenfotec.sistematramite.entitiespojo.BaseEntity;
import cr.ac.ucenfotec.sistematramite.multi.MultiTareaUsuario;

public class GestorTareaUsuario {
	
	public GestorTareaUsuario() {
		
	}
	
	public void Create(BaseEntity entity) throws java.sql.SQLException, Exception {
		TareaUsuario TareaU = (TareaUsuario)entity;
		
		try {
			new MultiTareaUsuario().GetCreateStatement(TareaU);
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
	public BaseEntity Retrive(BaseEntity entity) throws java.sql.SQLException, Exception {
		TareaUsuario tareaUsuario = (TareaUsuario)entity;		
		TareaUsuario tu = null;
			
		try {
			 tu  = (TareaUsuario) new MultiTareaUsuario().GetRetriveStatement(tareaUsuario);
		
		} catch (java.lang.ClassNotFoundException | SQLException ex) {
            throw ex;
        }
		
		return tu;		
	}
	
	public ArrayList<BaseEntity> RetriveAll() throws java.sql.SQLException, Exception{
		ArrayList<BaseEntity> list = new ArrayList<>();
		
		try {
			list = new MultiTareaUsuario().GetRetriveAllStatement();
			
		} catch (java.lang.ClassNotFoundException | SQLException ex) {
            throw ex;
        }
		
		return list;		
	}
	
	public void Update(BaseEntity entity) throws java.sql.SQLException, Exception {
		try {
			new MultiTareaUsuario().GetUpdateStatement(entity);;
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
	public void Delete(BaseEntity entity) throws java.sql.SQLException, Exception {
		try {
			new MultiTareaUsuario().GetDeleteStatement(entity);
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
}
