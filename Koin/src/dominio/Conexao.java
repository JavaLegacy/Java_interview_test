package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	
	private static Connection conexao = null;

	
	
	public static Connection recuperarConexao() {	

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection(
					"jdbc:mysql://localhost/koin", "root", "123");

		} catch (SQLException e) {
			System.err.println("ERRO: falha para carregar MYSQL JDBC driver.");
			e.printStackTrace();			
		}

		return conexao;

	}
	
	public static ResultSet executarQuery(String sql){
		conexao = Conexao.recuperarConexao();
		ResultSet resultSet = null;
		
		try {
			if (conexao != null) {
				Statement statement =  conexao.createStatement();
				resultSet = statement.executeQuery(sql);			
		}	
		} catch (SQLException e) {
		 e.printStackTrace();
		}
		
		
		return resultSet;
		
		
	}
		
	
	
	

}
