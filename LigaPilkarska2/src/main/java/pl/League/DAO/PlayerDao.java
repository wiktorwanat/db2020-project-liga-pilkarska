package pl.League.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import pl.League.DataBase.BaseConnection;
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

// PRZEROB TO TAK ZEBY ZWRACALO SAME STRINGI JUZ A NIE iD I POPRAW TO POZNIEJ W GUI
	public static List findPlayer(String surname,String first_name,String position) {
		List info=new ArrayList();
		try {
			String query="select first_name,surname,born_date,club_name,country_name,position,foot,market_value from football_leagues.player left join club on club.club_id=player.player_id left join country on country.country_id=player.player_id where surname=? and first_name=? and position=? limit 1;";
			PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
			statement.setString(1, surname);
			statement.setString(2, first_name);
			statement.setString(3, position);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				info.add(result.getString(1));
				info.add(result.getString(2));
				info.add(result.getDate(3));
				info.add(result.getString(4));
				info.add(result.getString(5));
				info.add(result.getString(6));
				info.add(result.getString(7));
				info.add(result.getDouble(8));
			}
		}catch(SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
		return info;
	}
	
	public static void addPlayer(String firstName,String surname,String position,String foot,String market_value,String clubName,String countryName,String dateOfBorn) {
		try {
			int countryId=CountryDao.findByCountryName(countryName).getCountry_id();
			int clubId=ClubDao.findByClubName(clubName).getClub_id();
			String query="insert into football_leagues.player (player_id,first_name,surname,born_date,clubID,countryID,position,foot,market_value) select * from (select null,?,?,?,?,?,?,?,?)as tmp where not exists (select first_name,surname,clubID from football_leagues.player where first_name=? and surname=? and clubID=?) LIMIT 1;";
			PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
			statement.setString(1, firstName);
			statement.setString(2, surname);
			statement.setDate(3,  Date.valueOf(dateOfBorn));
			statement.setInt(4, clubId);
			statement.setInt(5, countryId);
			statement.setString(6, position);
			statement.setString(7, foot);
			statement.setDouble(8, Double.parseDouble(market_value));
			statement.setString(9, firstName);
			statement.setString(10, surname);
			statement.setInt(11, clubId);
			int result=statement.executeUpdate();
			System.out.println("Query executed- created new Player ");
		}catch(SQLException sqlexc){
			System.out.println(sqlexc.getMessage());
		}
	}
	public static void updatePlayer(String firstName,String surname,String position,String foot,String market_value,String clubName,String countryName,String dateOfBorn) {
		try {
			String query="update football_leagues.player set first_name=?,surname=?,born_date=?,clubID=(select club_id from football_leagues.club where club_name=?),countryID=(select country_id from football_leagues.country where country_name=?),position=?,foot=?,market_value=? where first_name=? and surname=? and position=?;";
			PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
			statement.setString(1, firstName);
			statement.setString(2, surname);
			statement.setDate(3,  Date.valueOf(dateOfBorn));
			statement.setString(4, clubName);
			statement.setString(5, countryName);
			statement.setString(6, position);
			statement.setString(7, foot);
			statement.setDouble(8, Double.parseDouble(market_value));
			statement.setString(9, firstName);
			statement.setString(10, surname);
			statement.setString(11, position);
			int result=statement.executeUpdate();
			System.out.println("Query executed- Player updated");
		}catch(SQLException sqlexc){
			System.out.println(sqlexc.getMessage());
		}
	}
	public static List<Player> mostValuablePlayersFromClub(String clubName){
		List<Player> players=new ArrayList<Player>();
		try {
		String query="select * from football_leagues.player where clubID=(select club_id from football_leagues.club where club_name=?) order by market_value desc limit 5;";
		PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
		statement.setString(1, clubName);
		ResultSet result=statement.executeQuery();
		while(result.next()) {
			players.add(new Player(result.getInt(1),result.getString(2),result.getString(3),result.getDate(4),result.getInt(5),result.getInt(6),result.getString(7),result.getString(8),result.getDouble(9)));
		}
		}catch(SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
		return players;
	}
	
	public static String[] calculateFootedPlayers(String leg)
	{
		String[] tab=new String[5];
		try {
			String query="Select club_name, COUNT(player_id) as number from player inner JOIN club on player.clubID=club.club_id where player.foot =? GROUP BY clubID order by number desc limit 5;";
			PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
			statement.setString(1, leg);
			ResultSet result=statement.executeQuery();
			int i=0;
			while(result.next()) {
				tab[i]=result.getString(1)+" - "+result.getInt(2);
				i++;
			}
		}catch(SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
		return tab;
	}
	

	public static void deletePlayerByName(String first_name,String surname,String position) {
		try {
			String query="delete from football_leagues.player where first_name=? and surname=? and position=?;";
			PreparedStatement statement=connectionWithDateBase.prepareStatement(query);
			statement.setString(1, first_name);
			statement.setString(2, surname);
			statement.setString(3, position);
			int result=statement.executeUpdate();
		}catch(SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
	}
}