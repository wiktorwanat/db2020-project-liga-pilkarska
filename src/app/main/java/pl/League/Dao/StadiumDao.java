package pl.League.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.League.DataBase.BaseConnection;
import pl.League.models.Player;
import pl.League.models.Stadium;

public class StadiumDao {
	
	private static Connection connectionWithDateBase=BaseConnection.getConnection();

	public static List<Stadium> findAll(){
		List<Stadium> stadiums=new ArrayList<Stadium>();
		try {
		String query="select * from football_leagues.stadium;";
		PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
		ResultSet result=statement.executeQuery();
		while(result.next()) {
			stadiums.add(new Stadium(result.getInt(1),result.getString(2),result.getString(3),result.getDate(4),result.getInt(5),result.getInt(6)));
		}
		}catch(SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
		return stadiums;
	}
	
	public static Stadium findByStadiumName(String stadiumName) {
		Stadium stadium=new Stadium();
		try {
			String query="select * from football_leagues.stadium where name_stadium=?;";
			PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
			statement.setString(1, stadiumName);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				stadium=new Stadium(result.getInt(1),result.getString(2),result.getString(3),result.getDate(4),result.getInt(5),result.getInt(6));
			}
		}catch(SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
		return stadium;
	}
}
