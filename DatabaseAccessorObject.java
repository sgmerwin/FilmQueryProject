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
	
	protected final String URL = "jdbc:mysql://localhost:3306/sdvid";
	protected final String user = "student";
	protected final String pass = "student";
	
	

  public String getURL() {
		return URL;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

@Override
  public Film findFilmById(int filmId) throws SQLException{	  
	  Connection conn = DriverManager.getConnection(this.URL, this.user, this.pass);
	  Film film = null;
	  String sql = "select * from film where id = ?";
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  stmt.setInt(1, filmId);
	  ResultSet rs = stmt.executeQuery();
	    while (rs.next()) {
	    	film = new Film();
	      //System.out.println(
	          //rs.getString("title") + " " +rs.getString("release_year")+" "+rs.getString("rating")+" "+rs.getString("description")+" "
	          //); 
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
		  film.setFilmDescription(rs.getString("description"));
		  film.setFilmActors(this.findActorsByFilmId(filmId));
	    }//while 
	    if(film != null) {
	    	int langID = film.getFilmLanguage_id();
	    	int filmID = film.getFilmId();
	    	sql = "select name from language join film on film.language_id = language.id where film.language_id = ? and film.id = ?;";
		    stmt = conn.prepareStatement(sql);
		    stmt.setInt(1, langID);
		    stmt.setInt(2, filmID);
			rs = stmt.executeQuery();
			while (rs.next()) {
			System.out.println("Title: "+film.getFilmTitle()+" Year: "+film.getFilmRelease_year()+" Rating: "+film.getFilmRating()+" Desc: "+film.getFilmDescription()+" Language: "+rs.getString("name"));
			System.out.println("Actors: "+film.getFilmActors());
			}//while
	    }//if
	    
	    if(film == null) {
	    	System.out.println("The film is not in the database");
	    }//if
	    rs.close();
		stmt.close();
		conn.close();
		return film;	    
  }//method

@Override
public Actor findActorById(int actorId) throws SQLException{
	Connection conn = DriverManager.getConnection(this.URL, this.user, this.pass);
	Actor actor = null;
	String sql = "select * from actor where id = ?";
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1, actorId);
	ResultSet rs = stmt.executeQuery();
	while (rs.next()) {
		//System.out.println(rs.getString("id") + " "+ rs.getString("first_name")+" "+rs.getString("last_name"));
		actor = new Actor();
		actor.setActorId(actorId);
		actor.setActorFirst_name(rs.getString("first_name"));
		actor.setActorLast_name(rs.getString("last_name"));
	    }//while
	if(actor == null) {
		System.out.println("The actor is not in the database");
    }//if
    rs.close();
	stmt.close();
	conn.close();
	return actor;
}//method

@Override
public List<Actor> findActorsByFilmId(int filmId) throws SQLException {
	Connection conn = DriverManager.getConnection(this.URL, this.user, this.pass);
	String sql = "select id, first_name, last_name from actor join film_actor on actor.id = film_actor.actor_id where film_actor.film_id = ?";
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1, filmId);
	ResultSet rs = stmt.executeQuery();
	List<Actor> actorList = new ArrayList<>();
	Actor actor = null;
	while (rs.next()) {
		actor = new Actor();
		//System.out.println(rs.getString("id") + " "+ rs.getString("first_name")+" "+rs.getString("last_name"));
		actor.setActorId(Integer.parseInt(rs.getString("id")));
		actor.setActorFirst_name(rs.getString("first_name"));
		actor.setActorLast_name(rs.getString("last_name"));
		actorList.add(actor);
	    }//while
    rs.close();
	stmt.close();
	conn.close();
	return actorList;
}

public void findFilmBySearch(String str) throws SQLException{
	  Connection conn = DriverManager.getConnection(this.URL, this.user,this.pass); 
	  String sql = "select id, title, description from film";
	  PreparedStatement stmt = conn.prepareStatement(sql); 
	  ResultSet rs =stmt.executeQuery();
	  int count = 0;
	  while (rs.next()) {
	  //System.out.println(rs.getString("title") + " "+rs.getString("description")); 
	  String[] parts = rs.getString("title").split("\\s+"); 
	  for(String i : parts) {
	  if(str.equalsIgnoreCase(i)) { 
		  int id = Integer.parseInt(rs.getString("id"));
		  this.findFilmById(id);
		  ++count;
		  }//if 
	  }//for 
	  parts = rs.getString("description").split("\\s+"); 
	  for(String i : parts) {
	  if(str.equalsIgnoreCase(i)) { 
		  int id = Integer.parseInt(rs.getString("id"));
		  this.findFilmById(id); 
		  ++count; 
		  }//if 
	  }//for 
	  }//while 
	  if(count == 0) {
	  System.out.println("No matches in the database"); 
	  }//if
}

public static void main(String[] args) throws SQLException {
	DatabaseAccessorObject db = new DatabaseAccessorObject();
	db.findFilmById(2);
}

}
