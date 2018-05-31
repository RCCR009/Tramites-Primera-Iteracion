package cr.ac.ucenfotec.sistematramite.entitiespojo;

public class Actividad extends BaseEntity{
	private int id;
	private int idTarea;
	private String detalle;
	
	public Actividad(){
		super();
	}

	public Actividad(int id, int idTarea, String detalle) {
		super();
		this.id = id;
		this.idTarea = idTarea;
		this.detalle = detalle;
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

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Actividad [id=" + id + ", idTarea=" + idTarea + ", detalle=" + detalle + "]";
	}

}
