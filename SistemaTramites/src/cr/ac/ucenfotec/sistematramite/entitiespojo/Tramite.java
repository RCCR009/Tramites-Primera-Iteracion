package cr.ac.ucenfotec.sistematramite.entitiespojo;

public class Tramite extends BaseEntity {
	private int id;
	private String nombre;
	private int estado;
	
	public Tramite() {
		super();
	}

	public Tramite(int id, String nombre, int estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Tramite [id=" + id + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
	
}
