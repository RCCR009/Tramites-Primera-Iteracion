package cr.ac.ucenfotec.sistematramite.entitiespojo;

public class Usuario extends BaseEntity {
	private String id;
	private int idArea;
	private String clave;
	private String nombre;
	private String apellido;
	
	public Usuario() {
		super();
	}

	public Usuario(String id, int idArea, String clave, String nombre, String apellido) {
		super();
		this.id = id;
		this.idArea = idArea;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", idArea=" + idArea + ", clave=" + clave + ", nombre=" + nombre + ", apellido="
				+ apellido + "]";
	}
		
}
