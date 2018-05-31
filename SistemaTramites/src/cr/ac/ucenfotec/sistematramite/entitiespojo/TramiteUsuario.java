package cr.ac.ucenfotec.sistematramite.entitiespojo;

import java.time.LocalDate;

public class TramiteUsuario extends BaseEntity {
	private int id;
	private int idTramite;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String idUsuario;
	private int tareasCompletadas;
	private int estado;
	
	public TramiteUsuario() {
		super();
	}

	public TramiteUsuario(int id, int idTramite, LocalDate fechaInicio, LocalDate fechaFin, String idUsuario,
			int tareasCompletadas, int estado) {
		super();
		this.id = id;
		this.idTramite = idTramite;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.idUsuario = idUsuario;
		this.tareasCompletadas = tareasCompletadas;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProceso() {
		return idTramite;
	}

	public void setIdProceso(int idTramite) {
		this.idTramite = idTramite;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getTareasCompletadas() {
		return tareasCompletadas;
	}

	public void setTareasCompletadas(int tareasCompletadas) {
		this.tareasCompletadas = tareasCompletadas;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "TramiteUsuario [id=" + id + ", idTramite=" + idTramite + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", idUsuario=" + idUsuario + ", tareasCompletadas=" + tareasCompletadas + ", estado="
				+ estado + "]";
	}
	
}
