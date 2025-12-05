package bank1;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class clientDAO {
		public List<client> getAllclient() {
			List<client> clientlist = new ArrayList<>();
			String sql = "SELECT * FROM client";
			try (Connection conn = Database.getConnection();
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql))
			{
				while (rs.next()) {
					client client = new client(
							rs.getString("Фамилия"), 
							rs.getString("Имя"),
							rs.getString("Отчество"),
							rs.getInt("КлиентАйди"),
							rs.getLong("ИНН"),
							rs.getInt("НомерПаспорта"),
							rs.getInt("СерияПаспорта"),
							rs.getLong("НомерТелефона")
							);
					clientlist.add(client);
						}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return clientlist;
		}
	}
