package com.epicode.jdbctest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {
	
	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "gestionale_azienda_esercizio";
	String user = "postgres";
	String pass = "root";
	Connection conn;
	Statement st;
	
	public DbConnection() throws SQLException {
		conn = DriverManager.getConnection(url+dbName, user, pass);
		st = conn.createStatement();
		System.out.println("DB Connesso!!");
	}
	
	public void inserisciCliente(Cliente c) throws SQLException {
		String sql = "INSERT INTO clienti(nome, cognome, data_nascita, regione_residenza ) "
				+ "VALUES ('"+c.getNome()+"', "
						+ "'"+c.getCognome()+"', "
						+ "'"+c.getData_nascita()+"', "
						+ "'"+c.getRegione_residenza()+"')";
		st.executeUpdate(sql);
		System.out.println( c.getNome() + " " + c.getCognome() + " salvato nel DB!!");
	}
	
	public Cliente leggiCliente(Integer id) throws SQLException {
		String sql = "SELECT * FROM clienti WHERE numero_cliente = " + id;
		ResultSet rs = st.executeQuery(sql);
		
		Cliente c = null;
		//System.out.println(rs);
		if(rs.next()) {
			int numero_cliente = rs.getInt("numero_cliente");
			String nome = rs.getString("nome");
			String cognome = rs.getString("cognome");
			String data_nascita = rs.getString("data_nascita");
			String regione_residenza = rs.getString("regione_residenza");
			c = new Cliente(numero_cliente, nome, cognome, LocalDate.parse(data_nascita), regione_residenza);
		}
		return c;
	}
	
	public List<Cliente> leggiTuttiClienti() throws SQLException {
		List<Cliente> lista = new ArrayList<Cliente>();
		String sql = "SELECT * FROM clienti";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
//			int numero_cliente = rs.getInt("numero_cliente");
//			String nome = rs.getString("nome");
//			String cognome = rs.getString("cognome");
//			String data_nascita = rs.getString("data_nascita");
//			String regione_residenza = rs.getString("regione_residenza");
//			Cliente c = new Cliente(numero_cliente, nome, cognome, LocalDate.parse(data_nascita), regione_residenza);
//			lista.add(c);
			lista.add(
					new Cliente(
							rs.getInt("numero_cliente"), 
							rs.getString("nome"), 
							rs.getString("cognome"), 
							LocalDate.parse(rs.getString("data_nascita")), 
							rs.getString("regione_residenza")));
		}
		System.out.println( lista.size() + " clienti letti dal DB!!");
		return lista;
	}
	
	public void modificaCliente(Cliente c) throws SQLException {
		String sql = "UPDATE clienti SET "
				+ "nome = '"+c.getNome()+"', "
				+ "cognome = '"+c.getCognome()+"', "
				+ "data_nascita = '"+c.getData_nascita()+"', "
				+ "regione_residenza = '"+c.getRegione_residenza()+"' "
				+ "WHERE numero_cliente = " + c.getNumero_cliente();
		st.executeUpdate(sql);
		System.out.println( c.getNome() + " " + c.getCognome() + " modificato nel DB!!");
	}
	
	public void cancellaCliente(Cliente c) throws SQLException {
		String sql = "DELETE FROM clienti WHERE numero_cliente = " + c.getNumero_cliente();
		st.executeUpdate(sql);
		System.out.println( c.getNome() + " " + c.getCognome() + " eliminato nel DB!!");
	}

}
