package cr.ac.ucenfotec.sistematramite.entitiespojo;

public class AreaFuncional extends BaseEntity {
	private int id;
	private int idTarea;
	private String nombre;
	
	public AreaFuncional() {
		super();
	}

	public AreaFuncional(int id, int idTarea, String nombre) {
		super();
		this.id = id;
		this.idTarea = idTarea;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "AreaFuncional [id=" + id + ", idTarea=" + idTarea + ", nombre=" + nombre + "]";
	}

}
