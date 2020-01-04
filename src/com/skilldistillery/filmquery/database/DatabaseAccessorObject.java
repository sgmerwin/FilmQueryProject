package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}//static
	
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";

  @Override
  public Film findFilmById(int filmId) throws SQLException{
	  String user = "student";
	  String pass = "student";
	  Connection conn = DriverManager.getConnection(URL, user, pass);
	  Film film = new Film();
	  String sql = "select * from film where id = ?";
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  stmt.setInt(1, filmId);
	  ResultSet rs = stmt.executeQuery();
	    while (rs.next()) {
	      System.out.println(rs.getString("id") + " " +
	          rs.getString("title") +  " "+rs.getString("release_year")+" "+rs.getString("language_id")+" "+rs.getString("rental_duration")+" "+rs.getString("rental_rate")+" "+rs.getString("length")+" "+rs.getString("replacement_cost")+" "+rs.getString("rating")+" "+rs.getString("special_features")); 
	      film.setFilmId(filmId);
		  film.setFilmTitle(rs.getString("title"));
		  film.setFilmRelease_year(rs.getString("release_year"));
		  film.setFilmLanguage_id(Integer.parseInt(rs.getString("language_id")));
		  film.setFilmRental_duration(Integer.parseInt(rs.getString("rental_duration")));
		  film.setFilmRental_rate(Double.parseDouble(rs.getString("rental_rate")));
		  film.setFilmRental_duration(Integer.parseInt(rs.getString("length")));
		  film.setFilmRental_rate(Double.parseDouble(rs.getString("replacement_cost")));
		  film.setFilmRating(rs.getString("rating"));
		  film.setFilmSpecial_features(rs.getString("special_features"));
		  film.setFilmActors(this.findActorsByFilmId(filmId));
	    }//while
	    if(!rs.next()) {
	    	rs.close();
			stmt.close();
			conn.close();
			return null;
	    }//if
	    rs.close();
		stmt.close();
		conn.close();
		return film;	    
  }//method

@Override
public Actor findActorById(int actorId) throws SQLException{
	String user = "student";
	String pass = "student";
	Connection conn = DriverManager.getConnection(URL, user, pass);
	Actor actor = new Actor();
	String sql = "select * from actor where id = ?";
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1, actorId);
	ResultSet rs = stmt.executeQuery();
	while (rs.next()) {
		System.out.println(rs.getString("id") + " "+ rs.getString("first_name")+" "+rs.getString("last_name"));
		actor.setActorId(actorId);
		actor.setActorFirst_name(rs.getString("first_name"));
		actor.setActorFirst_name(rs.getString("last_name"));
	    }//while
	if(!rs.next()) {
    	rs.close();
		stmt.close();
		conn.close();
		return null;
    }//if
    rs.close();
	stmt.close();
	conn.close();
	return actor;
}//method

@Override
public List<Actor> findActorsByFilmId(int filmId) throws SQLException {
	String user = "student";
	String pass = "student";
	Connection conn = DriverManager.getConnection(URL, user, pass);
	String sql = "select id, first_name, last_name from actor join film_actor on actor.id = film_actor.actor_id where film_actor.film_id = ?";
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1, filmId);
	ResultSet rs = stmt.executeQuery();
	List<Actor> actorList = new ArrayList<>();
	while (rs.next()) {
		Actor actor = new Actor();
		System.out.println(rs.getString("id") + " "+ rs.getString("first_name")+" "+rs.getString("last_name"));
		actor.setActorId(Integer.parseInt(rs.getString("id")));
		actor.setActorFirst_name(rs.getString("first_name"));
		actor.setActorFirst_name(rs.getString("last_name"));
		actorList.add(actor);
	    }//while
    rs.close();
	stmt.close();
	conn.close();
	return actorList;
}

public static void main(String[] args) throws SQLException {
	DatabaseAccessorObject db = new DatabaseAccessorObject();
	db.findFilmById(2);
}

}
