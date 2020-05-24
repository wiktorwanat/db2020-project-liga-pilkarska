package pl.League.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.League.DataBase.BaseConnection;
import pl.League.models.Club;

public class ClubDao {
	
	private static Connection connectionWithDateBase=BaseConnection.getConnection();

	public static List<Club> findAll(){
		List<Club> clubs=new ArrayList<Club>();
		try {
		String query="select * from football_leagues.club;";
		PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
		ResultSet result=statement.executeQuery();
		while(result.next()) {
			clubs.add(new Club(result.getInt(1),result.getString(2),result.getString(3),result.getDate(4),result.getInt(5)));
		}
		}catch(SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
		return clubs;
	}
	
	public static Club findByClubName(String club_name) {
		Club club=new Club();
		try {
			String query="select * from football_leagues.club where club_name=?";
			PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
			statement.setString(1, club_name);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				club=new Club(result.getInt(1),result.getString(2),result.getString(3),result.getDate(4),result.getInt(5));
			}
		}catch(SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
		return club;
	}
}
