package cr.ac.ucenfotec.sistematramite.gestor;

import java.sql.SQLException;
import java.util.ArrayList;

import cr.ac.ucenfotec.sistematramite.entitiespojo.Tarea;
import cr.ac.ucenfotec.sistematramite.entitiespojo.BaseEntity;
import cr.ac.ucenfotec.sistematramite.multi.MultiTarea;

public class GestorTarea {
	
	public GestorTarea() {
		
	}
	
	public void Create(BaseEntity entity) throws java.sql.SQLException, Exception {
		Tarea t = (Tarea)entity;
		
		try {
			new MultiTarea().GetCreateStatement(t);
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
	public BaseEntity Retrive(BaseEntity entity) throws java.sql.SQLException, Exception {
		Tarea tarea = (Tarea)entity;		
		Tarea t = null;
			
		try {
			 t  = (Tarea) new MultiTarea().GetRetriveStatement(tarea);
		
		} catch (java.lang.ClassNotFoundException | SQLException ex) {
            throw ex;
        }
		
		return t;		
	}
	
	public ArrayList<BaseEntity> RetriveAll() throws java.sql.SQLException, Exception{
		ArrayList<BaseEntity> list = new ArrayList<>();
		
		try {
			list = new MultiTarea().GetRetriveAllStatement();
			
		} catch (java.lang.ClassNotFoundException | SQLException ex) {
            throw ex;
        }
		
		return list;		
	}
	
	public void Update(BaseEntity entity) throws java.sql.SQLException, Exception {
		try {
			new MultiTarea().GetUpdateStatement(entity);;
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
	public void Delete(BaseEntity entity) throws java.sql.SQLException, Exception {
		try {
			new MultiTarea().GetDeleteStatement(entity);
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
}
