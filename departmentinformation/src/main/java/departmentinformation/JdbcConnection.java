package departmentinformation;
import java.sql.*;


import GUI.Frame;
public class JdbcConnection {
	
	private static Connection connection;
	public static void main(String[] args) {
		
		System.out.println("-------- PostgreSQL "
				+ "JDBC 'ye Ba�lan�l�yor ------------");
		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("JDBC Driver bulunamad�! "
					+ "K�t�phane yoluna ekleyin !");
			e.printStackTrace();
			return;

		}


		System.out.println("PostgreSQL JDBC Driver Bulundu !");

		connection = null;
		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/employee", "nurullahsamed",
					"yonkou54");

		} catch (SQLException e) {

			System.out.println("Ba�lant� hatas�!");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("Ba�lant� ba�ar�yla kuruldu.");
		} else {
			System.out.println("Ba�lant� kurulumu ba�ar�s�z!");
		}
		
		//Connection tipindeki nesne Frame nesnesine parametre olarak g�nderildi.
		Frame frame = new Frame(connection);
	}
	
    protected void finalize() throws Throwable {
        connection.close();
        System.out.println("Ba�lant� kopar�ld�.");
    }
	

}
