package pl.League.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.League.DataBase.BaseConnection;
import pl.League.models.Club;
import pl.League.models.Player;

public class PlayerDao {
	
	private static Connection connectionWithDateBase=BaseConnection.getConnection();

	public static List<Player> findAll(){
		List<Player> players=new ArrayList<Player>();
		try {
		String query="select * from football_leagues.player;";
		PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
		ResultSet result=statement.executeQuery();
		while(result.next()) {
			players.add(new Player(result.getInt(1),result.getString(2),result.getString(3),result.getDate(4),result.getInt(5),result.getInt(6),result.getString(7),result.getString(8),result.getDouble(9)));
		}
		}catch(SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
		return players;
	}

	//funkcja odczytująca wartość piłkarzy w drużynie
	public static void teamValue(int clubID){
		try {
			long  wartosc=0;
			String query="select  SUM(market_value) from football_leagues.player where clubID=?;";
			PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
			statement.setInt(1, clubID);
			ResultSet result=statement.executeQuery();
			while(result.next())
			{
				wartosc+=result.getDouble(1);
			}

			System.out.println("wartosc klubu to: "+ wartosc);
		}
		catch(SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
	}



	public static Player findBySurName(String surname) {
		Player player=new Player();
		try {
			String query="select * from football_leagues.player where surname=?;";
			PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
			statement.setString(1, surname);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				player=new Player(result.getInt(1),result.getString(2),result.getString(3),result.getDate(4),result.getInt(5),result.getInt(6),result.getString(7),result.getString(8),result.getDouble(9));
			}
		}catch(SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
		return player;
	}
}
