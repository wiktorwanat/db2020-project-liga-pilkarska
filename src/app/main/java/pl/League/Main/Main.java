package pl.League.Main;

import java.util.List;

import pl.League.Dao.ClubDao;
import pl.League.Dao.PlayerDao;
import pl.League.Dao.CountryDao;
import pl.League.Dao.LeaguesDao;
import pl.League.models.Club;
import pl.League.models.Player;
import pl.League.models.Country;
import pl.League.models.Leagues;

public class Main {

	public static void main(String[] args) {

		List<Club> clubs=ClubDao.findAll();
		List<Country> countries=CountryDao.findAll();
		for(Club club:clubs) {
			System.out.println(club.toString());
			}
		
		for(Country count:countries) {
			System.out.println(count.toString());
		}
		Leagues league=LeaguesDao.findByLeagueName("Ekstraklasa");
		System.out.println(league.toString());
		Club club=ClubDao.findByClubName("Legia Warszawa");
		System.out.println(club.toString());


		PlayerDao.teamValue(1);


	}

}
