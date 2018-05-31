
import cr.ac.ucenfotec.sistematramite.entitiespojo.*;
import cr.ac.ucenfotec.sistematramite.gestor.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Prueba {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;

	public static void main(String[] args) throws IOException {
		
		mostrarMenu();
		
		
	}
	
	public static void mostrarMenu() throws java.io.IOException {

        byte opcion = -1;

        try {
            do {
                out.println("\nMenu\n");
                out.println("1. Administrativo");
                out.println("2. Iniciar sesion");
                out.println("3. Salir");
                opcion = Byte.parseByte(in.readLine());
                procesarOpcion(opcion);
            } while (opcion != 3);

            out.println("Usted eligio " + opcion + " salir del sistema");

        } catch (Exception e) {
            out.println(e.getMessage());
        }

    }
		
	public static void procesarOpcion(byte pOpcion) throws IOException {
		
		switch (pOpcion) {
		
		case 1:
			loginAdmin();
			break;	
		default:
			break;	
		
		}
		
	}
	
	public static void loginAdmin() throws java.io.IOException {
		GestorUsuario gestorU = new GestorUsuario();
		Usuario u = new Usuario();
		String id,clave;
		
		try {

            out.println("Digite id");
            id = in.readLine();         
            out.println("Digite su clave");
            clave = in.readLine();

            u.setId(id);
            u.setClave(clave);
            u = (Usuario) gestorU.login(u);

            if (u != null) {
                out.println("\nBienvenido al sistema\n");
                menuadmin();
   
            } else {
                out.println("\nNo hay concordancia entre el usuario y la clave introducidos\n");
            }

        } catch (java.lang.ClassNotFoundException e) {
            out.println(e.getMessage());
        } catch (SQLException e) {
            out.println(e.getMessage());
            out.println(e.getErrorCode());
        } catch (Exception e) {
            out.println(e.getMessage());
        }
		
	}
	
	public static void menuadmin() throws java.io.IOException {

        byte opcion = -1;

        do {
            out.println("\nMenu administrador\n");
            out.println("1. Crear nuevo tramite");
            out.println("2. Listar tramites");
            out.println("3. Registrar usuario nuevo");
            out.println("4. Salir");
            opcion = Byte.parseByte(in.readLine());
            procesarOpcionAdmin(opcion);
        } while (opcion != 4);

        out.println("Usted eligio " + opcion + " cerrar seccion");

    }
	
	public static void procesarOpcionAdmin(byte pOpcion) throws java.io.IOException {

        switch (pOpcion) {

            case 1:
                crearTramite();
                break;
            case 2:
            	listarTramite();
              break;
            case 3:
//                registrarUsuario();
                break;
            case 4:
                break;
            default:
                out.println("opcion invalida");
                break;

        }
    }
	
	public static void crearTramite() {
		String nombreT, nombreTarea, nombreArea, detalle;
		int numero;
		Tramite tramite = new Tramite();		
		GestorTramite GTR = new GestorTramite();
		GestorTarea GTA = new GestorTarea();
		GestorActividad GA = new GestorActividad();
		GestorAreaFuncional GAF = new GestorAreaFuncional();
		ArrayList<BaseEntity> listTramite = new ArrayList<>(); 
		ArrayList<BaseEntity> listTarea = new ArrayList<>();
		
		try {		
			
			do {
				out.println("\nDeme nombre proyecto o tramite");
				nombreT = in.readLine();			
			} while(nombreT.isEmpty());
			
			tramite.setNombre(nombreT);
			tramite.setEstado(0);
			
			GTR.Create(tramite);
			
			listTramite = GTR.RetriveAll();			
			tramite = (Tramite)listTramite.get(listTramite.size() - 1);
			
			int terminarTarea;
			do {
				Tarea tarea = new Tarea();
				AreaFuncional area = new AreaFuncional();
				
				do {
					out.println("\nDeme nombre tarea");
					nombreTarea = in.readLine();					
				} while(nombreTarea.isEmpty());				
				
				out.println("\nDeme numero de tarea");
				numero = Integer.parseInt(in.readLine());
				
				do {
					out.println("\nDeme nombre del area funcional");
					nombreArea = in.readLine();					
				} while(nombreT.isEmpty());
				
				tarea.setIdTramite(tramite.getId());
				tarea.setNumero(numero);
				tarea.setNombre(nombreTarea);
				
				GTA.Create(tarea);
				
				listTarea = GTA.RetriveAll();
				tarea = (Tarea)listTarea.get(listTarea.size() - 1);
				
				area.setNombre(nombreArea);
				area.setIdTarea(tarea.getId());
				GAF.Create(area);
			
				int terminarActividad;
				do {
					Actividad actividad = new Actividad();
					
					do {
						out.println("\nDeme detalle de la actividad");
						detalle = in.readLine();					
					}while(detalle.isEmpty());
					
					
					actividad.setDetalle(detalle);
					actividad.setIdTarea(tarea.getId());
					
					GA.Create(actividad);
					
					out.println("\n0.SEGUIR / 1.SALIR");
					terminarActividad = Integer.parseInt(in.readLine());
					
				}while(terminarActividad == 0);
				
				out.println("\n0.Mas tareas / 1.SALIR");
				terminarTarea = Integer.parseInt(in.readLine());
				
			}while(terminarTarea == 0);
			
			tramite.setEstado(1);			
			GTR.Update(tramite);
						
		} catch (java.lang.ClassNotFoundException e) {
            out.println(e.getMessage());
        } catch (SQLException e) {
            out.println(e.getMessage());
            out.println(e.getErrorCode());
        } catch (Exception e) {
            out.println(e.getMessage());
        }
	}
	
	public static void listarTramite() {
		GestorTramite GTR = new GestorTramite();
		GestorTarea GTA = new GestorTarea();
		GestorActividad GA = new GestorActividad();
		ArrayList<BaseEntity> listTramite = new ArrayList<>(); 
		ArrayList<BaseEntity> listTarea = new ArrayList<>();
		ArrayList<BaseEntity> listActividad = new ArrayList<>();
		try {
			
			listTramite = GTR.RetriveAll();
			listTarea = GTA.RetriveAll();
			listActividad = GA.RetriveAll();
			
			out.println("\nTramites");
			
			for (BaseEntity entity: listTramite) {
				Tramite tramite = (Tramite)entity;
				
				out.println("\n\n////////////////////////\n\n");
												
				out.println(tramite.toString());
				
				for (BaseEntity entity2: listTarea) {
					Tarea tarea = (Tarea)entity2;
					
					if(tarea.getIdTramite() == tramite.getId()) {
						
						out.println(tarea.toString());
						
						for(BaseEntity entity3 : listActividad) {
							Actividad actividad = (Actividad)entity3;
							
							if(actividad.getIdTarea() == tarea.getId()) {
								
								out.println(actividad.toString());
							}
						}
					}
					
				}		
				
			}
			
		} catch (java.lang.ClassNotFoundException e) {
            out.println(e.getMessage());
        } catch (SQLException e) {
            out.println(e.getMessage());
            out.println(e.getErrorCode());
        } catch (Exception e) {
            out.println(e.getMessage());
        }
			
	}
	
	
	

}
