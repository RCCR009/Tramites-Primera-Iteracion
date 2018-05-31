package cr.ac.ucenfotec.sistematramite.gestor;

import java.sql.SQLException;
import java.util.ArrayList;

import cr.ac.ucenfotec.sistematramite.entitiespojo.ActividadUsuario;
import cr.ac.ucenfotec.sistematramite.entitiespojo.BaseEntity;
import cr.ac.ucenfotec.sistematramite.multi.MultiActividadUsuario;

public class GestorActividadUsuario {
	
	public GestorActividadUsuario() {
		
	}
	
	public void Create(BaseEntity entity) throws java.sql.SQLException, Exception {
		ActividadUsuario actividadU = (ActividadUsuario)entity;
		
		try {
			new MultiActividadUsuario().GetCreateStatement(actividadU);
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
	public BaseEntity Retrive(BaseEntity entity) throws java.sql.SQLException, Exception {
		ActividadUsuario actividadU = (ActividadUsuario)entity;		
		ActividadUsuario au = null;
			
		try {
			 au  = (ActividadUsuario) new MultiActividadUsuario().GetRetriveStatement(actividadU);
		
		} catch (java.lang.ClassNotFoundException | SQLException ex) {
            throw ex;
        }
		
		return au;		
	}
	
	public ArrayList<BaseEntity> RetriveAll() throws java.sql.SQLException, Exception{
		ArrayList<BaseEntity> list = new ArrayList<>();
		
		try {
			list = new MultiActividadUsuario().GetRetriveAllStatement();
			
		} catch (java.lang.ClassNotFoundException | SQLException ex) {
            throw ex;
        }
		
		return list;		
	}
	
	public void Update(BaseEntity entity) throws java.sql.SQLException, Exception {
		try {
			new MultiActividadUsuario().GetUpdateStatement(entity);;
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
	public void Delete(BaseEntity entity) throws java.sql.SQLException, Exception {
		try {
			new MultiActividadUsuario().GetDeleteStatement(entity);
			
		} catch (java.lang.ClassNotFoundException | SQLException e) {
            throw e;
        }
		
	}
	
}
