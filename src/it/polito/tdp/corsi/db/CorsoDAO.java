package it.polito.tdp.corsi.db;

import java.sql.*;
import java.util.*;

import it.polito.tdp.corsi.model.Corso;

public class CorsoDAO {

	public List<Corso> listAll(int periodo) {
		String sql = "SELECT * FROM corso WHERE pd = ?";
		List<Corso> result = new LinkedList<Corso>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, periodo);
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				result.add(c);
			}
			
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}

}
