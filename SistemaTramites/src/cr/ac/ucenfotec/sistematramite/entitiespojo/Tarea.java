package cr.ac.ucenfotec.sistematramite.entitiespojo;

public class Tarea extends BaseEntity {
	private int id;
	private int idTramite;
	private String nombre;
	private int numero;
	
	public Tarea() {
		super();
	}

	public Tarea(int id, int idTramite, String nombre, int numero) {
		super();
		this.id = id;
		this.idTramite = idTramite;
		this.nombre = nombre;
		this.numero = numero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTramite() {
		return idTramite;
	}

	public void setIdTramite(int idTramite) {
		this.idTramite = idTramite;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", idTramite=" + idTramite + ", nombre=" + nombre + ", numero=" + numero + "]";
	}
	
}
