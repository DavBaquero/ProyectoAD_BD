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

    // Método para conectar a la base de datos
    public Connection connetUsuario() {
        try {
            Connection connection = DriverManager.getConnection(URLU, USER, PASSWORD);
            System.out.println("Conexión exitosa en la base de datos Usuarios!");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    // Método para seleccionar usuarios
    public ArrayList<User> selectUsuario() {
        ArrayList<User> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuario";

        try (Connection connection = connetUsuario();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(query)) {

            System.out.println("Consulta realizada");
            usuarios = procesarUsuarios(resultSet);
            System.out.println("Resultados Procesados");

        } catch (SQLException e) {
            System.err.println("Error de establecimiento de conexión: " + e.getMessage());
        }

        return usuarios;
    }

    // Procesar datos de usuarios
    private ArrayList<User> procesarUsuarios(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String nombre_usuario = resultSet.getString("nombre");
            String contraseña = resultSet.getString("contraseña");
            boolean administrador = resultSet.getBoolean("administrador");
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
