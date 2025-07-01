package paquete_default;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Germán Ariel Tobio Antonelli
 */
public class ConexionBDMysql {

    public static void main(String[] args) {

        Connection con = null;
        String url = "jdbc:mysql://localhost/centroseducacioninfantil";
        String usuario = "root";
        String password = "1234";
        
        int opcion;
        
        boolean salir = false;

        Scanner teclado = new Scanner(System.in);

        while (!salir) {

            System.out.println("*** MENÚ DE CONSULTAS ***");

            System.out.println("1. Consulta 1: Educadores que trabajan en una guardería indicada por su nombre.");
            System.out.println("2. Consulta 2: Para cada guardería, obtener el número de educadores que trabajan en dicha guardería.");
            System.out.println("3. Consulta 3: Calcular la cantidad de presupuesto (cantidad de dinero) gastado en el salario de los educadores de una determinada guardería que se pasará como parámetro (se pasará su código).");

            System.out.println("Elija la consulta que desee");
            opcion = teclado.nextInt();
            
            teclado.nextLine(); //Limpio el buffer de Scanner

            
            switch (opcion) {
                case 1: 
                    
                    try {


                    con = DriverManager.getConnection(url, usuario, password);

                    Statement stm = con.createStatement();

                    ResultSet rs = stm.executeQuery("SELECT educador_infantil.nombre AS nombre_educador, guarderia.nombre AS nombre_guarderia "
                                                  + "FROM educador_infantil "
                                                  + "JOIN guarderia "
                                                  + "WHERE educador_infantil.codigo_guarderia = guarderia.codigo");


                    while (rs.next()) {


                        String nombreEducador = rs.getString("nombre_educador");
                        String nombreGuarderia = rs.getString("nombre_guarderia");

                        System.out.println(nombreEducador + " Trabaja en " + nombreGuarderia);
                    }
                    
                    rs.close();
                    stm.close();
                    con.close();
                    


                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;
                
                case 2:
                    try {

                    con = DriverManager.getConnection(url, usuario, password);

                    Statement stm = con.createStatement();

                    ResultSet rs = stm.executeQuery("SELECT guarderia.nombre AS nombre_guarderia, COUNT(educador_infantil.nombre) AS cantidad_educadores "
                                                  + "FROM educador_infantil "
                                                  + "JOIN guarderia "
                                                  + "WHERE educador_infantil.codigo_guarderia = guarderia.codigo "
                                                  + "GROUP BY guarderia.nombre");

                    while (rs.next()) {

                        String nombreEducador = rs.getString("nombre_guarderia");
                        String cantidadEducadores = rs.getString("cantidad_educadores");

                        System.out.println(nombreEducador + " " + cantidadEducadores);
                    }
                    
                    rs.close();
                    stm.close();
                    con.close();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;
                
                case 3:
                    try {

                    con = DriverManager.getConnection(url, usuario, password);
                    
                    System.out.println("Introduzca el código del colegio");
                    String codigoEscuela = teclado.nextLine();
                    

                    PreparedStatement ps = con.prepareStatement("SELECT SUM(educador_infantil.salario) AS presupuesto "
                                                              + "FROM educador_infantil "
                                                              + "WHERE educador_infantil.codigo_guarderia = ?");


                    ps.setString(1, codigoEscuela);
                    
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {

                        String presupuesto = rs.getString("presupuesto");

                        System.out.println("El presupuesto es de: " + presupuesto);
                    }
                    
                    rs.close();
                    ps.close();
                    con.close();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                  break;
                  
                default:
                    System.out.println("Opción inválida, elija otra.");
            }
            
            
            System.out.println("\n¿Desea hacer otra consulta? (si/no)");
            
            if(teclado.nextLine().equalsIgnoreCase("no")){
                salir = true;
                System.out.println("¡Hasta Pronto!");
            }

        }
        
    }
    
}
