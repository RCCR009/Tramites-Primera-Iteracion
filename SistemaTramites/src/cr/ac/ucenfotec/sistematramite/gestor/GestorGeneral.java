package cr.ac.ucenfotec.sistematramite.gestor;

import java.util.ArrayList;

import cr.ac.ucenfotec.sistematramite.entitiespojo.BaseEntity;

public abstract class GestorGeneral {
	
	public abstract void Create(BaseEntity entity);
	
	public abstract BaseEntity Retrive(BaseEntity entity);
	
	public abstract ArrayList<BaseEntity> RetriveAll();
	
	public abstract void Update(BaseEntity entity);
	
	public abstract void Delete(BaseEntity entity);
	
}
