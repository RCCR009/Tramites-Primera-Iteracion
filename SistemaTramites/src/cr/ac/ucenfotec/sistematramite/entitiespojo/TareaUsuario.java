package cr.ac.ucenfotec.sistematramite.entitiespojo;

import java.time.LocalDate;

public class TareaUsuario extends BaseEntity {
	private int id;
	private LocalDate fechaFin;
	private int idTramiteUsuario;
	private String idUsuario;
	
	public TareaUsuario() {
		super();
	}
	
	public TareaUsuario(int id, LocalDate fechaFin, int idTramiteUsuario, String idUsuario) {
		super();
		this.id = id;
		this.fechaFin = fechaFin;
		this.idTramiteUsuario = idTramiteUsuario;
		this.idUsuario = idUsuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getIdProcesoUsuario() {
		return idTramiteUsuario;
	}
	public void setIdProcesoUsuario(int idProcesoUsuario) {
		this.idTramiteUsuario = idProcesoUsuario;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	@Override
	public String toString() {
		return "TareaUsuario [id=" + id + ", idProcesoUsuario=" + idTramiteUsuario + ", idUsuario=" + idUsuario + "]";
	}
	
	

}
