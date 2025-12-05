package bank1;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class accountDAO {
			public List<account> getAllaccount() {
				List<account> accountlist = new ArrayList<>();
				String sql = "SELECT * FROM account";
				try (Connection conn = Database.getConnection();
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(sql))
				{
					while (rs.next()) {
						account account = new account(
								rs.getInt("КлиентАйди"),
								rs.getDate("ДатаОткрытия"),
								rs.getString("Валюта"),
								rs.getString("ТипСчёта"),
								rs.getDouble("Баланс"),
								rs.getInt("СчётАйди"),
								rs.getString("Статус")
								);
						accountlist.add(account);
							}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return accountlist;
			}
		}
