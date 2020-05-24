package pl.League.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.League.DataBase.BaseConnection;
import pl.League.models.Club;
import pl.League.models.Employee;

public class EmployeeDao {
	
	private static Connection connectionWithDateBase=BaseConnection.getConnection();
 
	
	public static List<Employee> findAll(){
		List<Employee> employies=new ArrayList<Employee>();
		try {
		String query="select * from football_leagues.employee;";
		PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
		ResultSet result=statement.executeQuery();
		while(result.next()) {
			employies.add(new Employee(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getDate(5),result.getInt(6)));
		}
		}catch(SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
		return employies;
	}
	
	public static Employee findByEmployeeName(String employee_name) {
		Employee employee=new Employee();
		try {
			String query="select * from football_leagues.employee where surname=?;";
			PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
			statement.setString(1, employee_name);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				employee=new Employee(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getDate(5),result.getInt(6));
			}
		}catch(SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
		return employee;
	}
}
