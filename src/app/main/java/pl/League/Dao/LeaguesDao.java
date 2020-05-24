package pl.League.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.League.DataBase.BaseConnection;
import pl.League.models.Club;
import pl.League.models.Leagues;

public class LeaguesDao {
	
	private static Connection connectionWithDateBase=BaseConnection.getConnection();

	public static List<Leagues> findAll(){
		List<Leagues> leagues=new ArrayList<Leagues>();
		try {
		String query="select * from football_leagues.leagues;";
		PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
		ResultSet result=statement.executeQuery();
		while(result.next()) {
			leagues.add(new Leagues(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4)));
		}
		}catch(SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
		return leagues;
	}
	
	public static Leagues findByLeagueName(String league_name) {
		Leagues leagues=new Leagues();
		try {
			String query="select * from football_leagues.leagues where name_league=?;";
			PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
			statement.setString(1, league_name);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				leagues=new Leagues(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4));
			}
		}catch(SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
		return leagues;
	}
}
