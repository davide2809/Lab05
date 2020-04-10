package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AnagrammaDAO {
	
	public boolean isCorrect(String anagramma) {
		final String sql="SELECT nome FROM parola WHERE nome= ? ";
		boolean flag=false;
		try {
			Connection conn= ConnectDB.getConnection();
			PreparedStatement st= conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				flag=true;
			}
			conn.close();
		}catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		return flag;
	}

}
