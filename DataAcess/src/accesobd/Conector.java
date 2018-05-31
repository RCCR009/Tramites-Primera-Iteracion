package accesobd;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Clase que inicializa la conexión con los valores correctos y
 * permite manejar una única conexión para todo el proyecto.
 *
 * @version 1.0
 * @author ROLANDO 
 */
public class Conector {

    //atributo de la clase	
    private static AccesoBD conectorBD = null;

    /**
     * Método estático que devuelve el objeto AccesoBD para que sea utilizado
     * por las clases
     *
     * @return objeto del tipo AccesoBD del paquete CapaAccesoDatos
     */
    public static AccesoBD getConector() throws SQLException, Exception {
        String script;
        FileInputStream fis = null;
        File persisFile = null;

        try {
            persisFile = new File("C:\\Users\\rolan\\Documents\\workspace-sts-3.9.4.RELEASE\\DataAcess\\conexion.txt");
            fis = new FileInputStream(persisFile);
            Properties propConfig = new Properties();
            propConfig.load(fis);

            //Get the properties
            script = propConfig.getProperty("script");

        } catch (Exception e) {
            e.printStackTrace();
            script="";
        }

        if (conectorBD == null) {
            conectorBD = new AccesoBD(script);
        }
        return conectorBD;
    }

}
