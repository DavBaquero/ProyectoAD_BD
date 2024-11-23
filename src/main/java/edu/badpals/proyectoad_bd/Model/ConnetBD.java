package edu.badpals.proyectoad_bd.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class ConnetBD {
    private static final String URLV = "jdbc:mysql://localhost:3306/valorant?";
    private final String URLU = "jdbc:mysql://localhost:3306/usuarios?";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private ArrayList<User> usuarios = new ArrayList();

    public Agentes ConnetValorant_Agente(String nombre) {
        try (Connection con = DriverManager.getConnection(URLV, USER, PASSWORD);
             Statement stmt = con.createStatement()) {
            // Consulta para seleccionar todas las filas de la tabla 'agentes'
            String query = String.format("SELECT * FROM agentes WHERE nombre = '%s'", nombre);
            ResultSet resultSet = stmt.executeQuery(query);

        return procesarAgentes(resultSet);
        } catch (SQLException e) {
            System.err.println("Error de establecimiento de conexión: " + e.getMessage());
        }
        return null;
    }


    private Agentes procesarAgentes(ResultSet resultSet) throws SQLException {
        int id_ag = resultSet.getInt("id_ag");
        String nombre_ag = resultSet.getString("nombre_ag");
        String descrip_ag = resultSet.getString("descrip_ag");
        int id_rol_ag = resultSet.getInt("id_rol_ag");

        // Crear un objeto Agente y agregarlo a la lista
        Agentes agente = new Agentes(id_ag, nombre_ag, descrip_ag, id_rol_ag);
        return agente;
    }

    public Habilidad ConnetValorant_Habilidades(String nombre_habilidade) {
        try (Connection con = DriverManager.getConnection(URLV, USER, PASSWORD);
             Statement stmt = con.createStatement()) {
            // Consulta para seleccionar todas las filas de la tabla 'HABILIDADES_AGENTES'
            String query = String.format("SELECT * FROM HABILIDADES_AGENTES WHERE NOMBRE_HAB = '%s'", nombre_habilidade);
            ResultSet resultSet = stmt.executeQuery(query);

            return procesarHabilidades(resultSet);
        } catch (SQLException e) {
            System.err.println("Error de establecimiento de conexión: " + e.getMessage());
        }
        return null;
    }

    private Habilidad procesarHabilidades(ResultSet resultSet) throws SQLException {
            int id_ag_per = resultSet.getInt("id_ag_per");
            String nombre_hab = resultSet.getString("nombre_hab");
            String descrip_hab = resultSet.getString("descrip_hab");
            Enum<Habilidades> tipo_hab = Habilidades.getHabilidad(nombre_hab);

            // Crear un objeto Habilidad y agregarlo a la lista
            Habilidad habilidad = new Habilidad(id_ag_per, nombre_hab, descrip_hab, tipo_hab);

        return habilidad;
    }


    public Rol ConnetValorant_Roles(int id_rol) {
        try (Connection con = DriverManager.getConnection(URLV, USER, PASSWORD);
             Statement stmt = con.createStatement()) {
            // Consulta para seleccionar todas las filas de la tabla 'ROLES'
            String query = String.format("SELECT * FROM ROLES WHERE ID_ROL = '%s'", id_rol);
            ResultSet resultSet = stmt.executeQuery(query);

            return procesarRoles(resultSet);
        } catch (SQLException e) {
            System.err.println("Error de establecimiento de conexión: " + e.getMessage());
        }
        return null;
    }
    private Rol procesarRoles(ResultSet resultSet) throws SQLException {
            int id_rol = resultSet.getInt("id_rol");
            String nombreRolString = resultSet.getString("nombre_rol");
            Roles nombreRol = Roles.getRol(nombreRolString.toUpperCase());
            String descrip_rol = resultSet.getString("descrip_rol");

            // Crear un objeto Rol y agregarlo a la lista
            Rol rol1 = new Rol(id_rol, nombreRol,  descrip_rol);

        return rol1;
    }

    //Conecxión a la BD de Usuarios
    public void ConnetUsuario() {
        try (Connection con = DriverManager.getConnection(URLU, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            System.out.println("Conexión exitosa en la base de datos!");

            // Consulta para seleccionar todas las filas de la tabla 'paises'
            String query = "SELECT * FROM ususario";
            ResultSet resultSet = stmt.executeQuery(query);

            // Procesar resultados
            procesarUsuarios(resultSet);

        } catch (SQLException e) {
            System.err.println("Error de establecimiento de conexión: " + e.getMessage());
        };
    }

    //Procesar datos de usuarios
    private ArrayList<User> procesarUsuarios(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String nombre_usuario = resultSet.getString("nombre");
            String contraseña = resultSet.getString("contraseña");
            Boolean administrador = resultSet.getBoolean("Administrador");

            // Crear un objeto Usuario y agregarlo a la lista
            User usuario = new User(nombre_usuario, contraseña, administrador);
            usuarios.add(usuario);
        }
        return usuarios;
    }
    public ArrayList<User> getUsuarios() {
        return usuarios;
    }

    public static void connect(){
        try (Connection con = DriverManager.getConnection(URLV, USER, PASSWORD);
             Statement stmt = con.createStatement()) {
            System.out.println("Conexión exitosa en la base de datos!");
        } catch (SQLException e) {
            System.err.println("Error de establecimiento de conexión: " + e.getMessage());
        }
    }

    public static void paraAgentes() {
        connect();
        if (procedimientoExiste("PARAAGENTES")) {
            System.out.println("El procedimiento almacenado ya existe.");
        } else {
            crearProcedimientoParaAgentes();
        }
        try (Connection con = DriverManager.getConnection(URLV, USER, PASSWORD);
             CallableStatement callableStatement = con.prepareCall("{CALL PARAAGENTES(?)}")) {
            callableStatement.setString(1, "Jett");
            boolean hasResults = callableStatement.execute();
            while (hasResults) {
                try (ResultSet rs = callableStatement.getResultSet()) {
                    while (rs.next()) {
                        System.out.println("Nombre: " + rs.getString("NOMBRE_AG"));
                        System.out.println("Descripción: " + rs.getString("DESCRIP_AG"));
                        System.out.println("Rol: " + rs.getString("NOMBRE_ROL"));
                    }
                }
                hasResults = callableStatement.getMoreResults();
                if (hasResults) {
                    try (ResultSet rs = callableStatement.getResultSet()) {
                        while (rs.next()) {
                            System.out.println("Habilidades: " + rs.getString("NOMBRE_HAB"));
                        }
                    }
                }
                hasResults = callableStatement.getMoreResults();
            }
        } catch (SQLException e) {
            System.err.println("Error al llamar al procedimiento almacenado: " + e.getMessage());
        }
    }

    private static boolean procedimientoExiste(String nombreProcedimiento) {
        String query = "SHOW PROCEDURE STATUS WHERE Name = '" + nombreProcedimiento + "'";
        try (Connection con = DriverManager.getConnection(URLV, USER, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Error al verificar el procedimiento: " + e.getMessage());
            return false;
        }
    }

    public static void crearProcedimientoParaAgentes() {
        String createProcedureSQL = "CREATE PROCEDURE PARAAGENTES(IN NOMBRE_AGE VARCHAR(15)) " +
                "BEGIN " +
                "SELECT a.NOMBRE_AG, a.DESCRIP_AG, r.NOMBRE_ROL " +
                "FROM agentes AS a " +
                "INNER JOIN roles AS r ON a.ID_ROL_AG = r.ID_ROL " +
                "WHERE a.NOMBRE_AG = NOMBRE_AGE; " +
                "SELECT h.NOMBRE_HAB " +
                "FROM habilidades_agentes AS h " +
                "INNER JOIN agentes AS a ON h.ID_AG_PER = a.ID_AG " +
                "WHERE a.NOMBRE_AG = NOMBRE_AGE; " +
                "END;";
        try (Connection con = DriverManager.getConnection(URLV, USER, PASSWORD);
             Statement stmt = con.createStatement()) {
            stmt.execute(createProcedureSQL);
            System.out.println("Procedimiento almacenado creado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al crear el procedimiento almacenado: " + e.getMessage());
        }
    }


    public static ObservableList<AgenteDTO> getAgentesTab() {
        ObservableList<AgenteDTO> agentesList = FXCollections.observableArrayList();
        String query = "SELECT a.ID_AG, a.NOMBRE_AG, r.NOMBRE_ROL, a.DESCRIP_AG, " +
                "MAX(CASE WHEN h.TIPO_HAB = 'C' THEN h.NOMBRE_HAB END) AS Habilidad_C, " +
                "MAX(CASE WHEN h.TIPO_HAB = 'Q' THEN h.NOMBRE_HAB END) AS Habilidad_Q, " +
                "MAX(CASE WHEN h.TIPO_HAB = 'E' THEN h.NOMBRE_HAB END) AS Habilidad_E, " +
                "MAX(CASE WHEN h.TIPO_HAB = 'X' THEN h.NOMBRE_HAB END) AS Habilidad_X " +
                "FROM agentes a " +
                "JOIN roles r ON a.ID_ROL_AG = r.ID_ROL " +
                "LEFT JOIN habilidades_agentes h ON a.ID_AG = h.ID_AG_PER " +
                "GROUP BY a.ID_AG, a.NOMBRE_AG, r.NOMBRE_ROL";
        try (Connection con = DriverManager.getConnection(URLV, USER, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet resultSet = stmt.executeQuery(query)) {
            while (resultSet.next()) {
                int idAg = resultSet.getInt("ID_AG");
                String nombreAg = resultSet.getString("NOMBRE_AG");
                String nombreRol = resultSet.getString("NOMBRE_ROL");
                String DescripAg = resultSet.getString("DESCRIP_AG");
                String habC = resultSet.getString("Habilidad_C");
                String habQ = resultSet.getString("Habilidad_Q");
                String habE = resultSet.getString("Habilidad_E");
                String habX = resultSet.getString("Habilidad_X");

                // Crear un objeto AgenteDTO
                AgenteDTO agenteDTO = new AgenteDTO(idAg, nombreAg, nombreRol, habC, habQ, habE, habX, DescripAg);

                agentesList.add(agenteDTO);
            }
        } catch (SQLException e) {
            System.err.println("Error de establecimiento de conexión: " + e.getMessage());
        }
        return agentesList;
    }

    public static ObservableList<HabilidadDTO> getHabTab(){
        ObservableList<HabilidadDTO> habilidadesList = FXCollections.observableArrayList();
        String query = "SELECT a.ID_AG, a.NOMBRE_AG, h.NOMBRE_HAB, h.DESCRIP_HAB from habilidades_agentes as h inner join\n" +
                "    agentes as a on h.id_ag_per =\n" +
                "                    a.id_ag";
        try (Connection con = DriverManager.getConnection(URLV, USER, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet resultSet = stmt.executeQuery(query)) {
            while (resultSet.next()) {
                int idAg = resultSet.getInt("ID_AG");
                String nombreAg = resultSet.getString("NOMBRE_AG");
                String nombreHab = resultSet.getString("NOMBRE_HAB");
                String descripHab = resultSet.getString("DESCRIP_HAB");

                // Crear un objeto HabilidadDTO
                HabilidadDTO habilidadDTO = new HabilidadDTO(idAg, nombreAg, nombreHab, descripHab);

                habilidadesList.add(habilidadDTO);
            }
        } catch (SQLException e) {
            System.err.println("Error de establecimiento de conexión: " + e.getMessage());
        }
        return habilidadesList;
    }


    public static ObservableList<RolDTO> getRolTab(){
        ObservableList<RolDTO> rolesList = FXCollections.observableArrayList();
        String query = "SELECT r.ID_ROL, r.NOMBRE_ROL, r.DESCRIP_ROL, a.NOMBRE_AG " +
                "from roles as r inner join agentes as a on r.ID_ROL = a.id_rol_ag;\n";
        try (Connection con = DriverManager.getConnection(URLV, USER, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet resultSet = stmt.executeQuery(query)) {
                while (resultSet.next()) {
                    int idRol = resultSet.getInt("ID_ROL");
                    String nombreRol = resultSet.getString("NOMBRE_ROL");
                    String descripRol = resultSet.getString("DESCRIP_ROL");
                    String nomAgente = resultSet.getString("NOMBRE_AG");

                    // Crear un objeto RolDTO
                    RolDTO rolDTO = new RolDTO(idRol, nombreRol, descripRol, nomAgente);

                    rolesList.add(rolDTO);
                }
        } catch (SQLException e) {
                System.err.println("Error de establecimiento de conexión: " + e.getMessage());
        }
        return rolesList;
    }
}
