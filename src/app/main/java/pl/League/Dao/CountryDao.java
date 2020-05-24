package pl.League.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.League.DataBase.BaseConnection;
import pl.League.models.Club;
import pl.League.models.Country;

public class CountryDao {
	
	private static Connection connectionWithDateBase=BaseConnection.getConnection();

	public static List<Country> findAll(){
		List<Country> countries=new ArrayList<Country>();
		try {
		String query="select * from football_leagues.country;";
		PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
		ResultSet result=statement.executeQuery();
		while(result.next()) {
			countries.add(new Country(result.getInt(1),result.getString(2)));
		}
		}catch(SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
		return countries;
	}
	
	public static Country findByCountryName(String country_name) {
		Country country=new Country();
		try {
			String query="select * from football_leagues.country where club_name=?;";
			PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
			statement.setString(1,country_name);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				country=new Country(result.getInt(1),result.getString(2));
			}
		}catch(SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
		return country;
	}
}
