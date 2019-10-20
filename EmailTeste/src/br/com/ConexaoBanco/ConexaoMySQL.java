package br.com.ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexaoMySQL {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/nomedatabela?useTimezone=true&serverTimezone=UTC";
		String usuario = "root";
		String senha = "";
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public boolean estaConectado() {
		if (this.connection != null) {
			return true;
		} else {
			return false;
		}	
	}
	
	public void listarBoletosNaoBaixados() {
		try {
			String query = "query de listagem";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				System.out.println(": " + this.resultset.getString("") + " - : " + this.resultset.getString("") + " - : " + this.resultset.getString(""));
			}
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}	
	}
	
	public void listarUsuariosParaReceberBoletos() {
		try {
			String query = "";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				System.out.println(": " + this.resultset.getString("") + " - : " + this.resultset.getString("") + " - : " + this.resultset.getString(""));
			}
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}	
	}
	
	public void inserirContato(String nome, String telefone) {
		try {
			String query = "";
			this.statement.executeUpdate(query);
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}	
	}
	
	public void editarContato(String id, String nome, String telefone) {
		try {
			String query = "";
			this.statement.executeUpdate(query);
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}	
	}
	
	public void excluirContato(String id) {
		try {
			String query = "";
			this.statement.executeUpdate(query);
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			
		}
	}
	
	public void desconectar() {
		try {
			this.connection.close();
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			
		}
	}
}
