package cr.ac.ucenfotec.sistematramite.entitiespojo;

public class ActividadUsuario extends BaseEntity {
	private int id;
	private int idTareaUsuario;
	private String detalle;
	private String respuesta;
	
	public ActividadUsuario() {
		super();
	}
	
	public ActividadUsuario(int id, int idTareaUsuario, String detalle, String respuesta) {
		super();
		this.id = id;
		this.idTareaUsuario = idTareaUsuario;
		this.detalle = detalle;
		this.respuesta = respuesta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTareaUsuario() {
		return idTareaUsuario;
	}

	public void setIdTareaUsuario(int idTareaUsuario) {
		this.idTareaUsuario = idTareaUsuario;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
		return "ActividadUsuario [id=" + id + ", idTareaUsuario=" + idTareaUsuario + ", detalle=" + detalle
				+ ", respuesta=" + respuesta + "]";
	}
	
}
