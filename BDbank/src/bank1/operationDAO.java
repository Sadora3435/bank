package bank1;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class operationDAO {
	public List<operation> getAlloperation() {
		List<operation> operationlist = new ArrayList<>();
		String sql = "SELECT * FROM operation"; 
		try (Connection conn = Database.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql))
		{
			while (rs.next()) {
				operation operation = new operation(
						rs.getInt("ОперацияАйди"),
						rs.getInt("СчётАйди"),
						rs.getString("ТипОперации"),
						rs.getDate("Дата"),
						rs.getDouble("Сумма")
						);
				operationlist.add(operation);
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return operationlist;
	}
}
