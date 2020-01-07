## FilmQueryProject

### Overview

The follow image provides a basic overview of the project.

<img src="https://github.com/sgmerwin/FilmQueryProject/blob/master/sql_1_5_20.jpg" width="500" height="500">

The following image is a screenshot of the project structure in Eclipse.

<img src="https://github.com/sgmerwin/FilmQueryProject/blob/master/sql_proj_struct_1_5_20.png" width="200" height="300">

Maven was used to handle the SQL database connection dependencies.

<img src="https://github.com/sgmerwin/FilmQueryProject/blob/master/maven_dep.png" width="250" height="100">

### Details

The user runs the main method in the App class. This generates a DatabaseAccessorObject and prints options in the terminal to retrive a film by id or retrive films by a keyword search. The keyword search, searches all of the film titles and descriptions in the database. The code for the keyword search is in the DatabaseAccessorObject's findFilmBySearch method. The findFilmBySearch method puts the words from the title in a string array and then runs a for loop comparing the keyword to each string in the array. If the for loop finds a not case sensitive match, it runs the DatabaseAccessorObject's findFilmById method which handles printing the data to the terminal. 
After the findFilmBySearch method searches the film's title, it then searches the film's description for a match with the same for loop structure. 

The complexity of the project lies in the DatabaseAccessorObject referencing the SQL database correctly to retrive the desired data. In the SQL database there is an Actor table and a Film table but, these two tables have no common reference to determine the actors that are in a particular film. The SQL database has a third table, film_actor, that provides the film id and an actor id reference on each row. 
Here is a screenshot of the film_actor structure. 

<img src="https://github.com/sgmerwin/FilmQueryProject/blob/master/film_actor.png" width="150" height="250">

To obtain the list of actors for a specific film the follow SQL statement was used. 

"select id, first_name, last_name from actor join film_actor on actor.id = film_actor.actor_id where film_actor.film_id = ?"

The SQL statement accepts a film id, gets a corresponding actor id, and then references the actor table with the actor id to get the actor's first and last name. The film class has two attributes to handle the actors associated with the film: 

protected List<Actor> filmActors; <br>
protected List<String> actors;  
  
There is a for loop in the film class getFilmActors method that iterates over the filmActors list and builds the actor list. 
Each actor's first and last name is store in the actors list as a single string using the following format:

actors.add(" "+i.getActorFirst_name()+" "+i.getActorLast_name()+" ");	

Then the actors list is printed to the terminal when the film's data is requested. 

The DatabaseAccessorObject's findFilmById method uses the following SQL statement to build a film object:

"select * from film where id = ?"

Then the findFilmById method uses the film object's attributes to obtain the film's language: 

int langID = film.getFilmLanguage_id();<br>
int filmID = film.getFilmId();<br>
sql = "select name from language join film on film.language_id = language.id where film.language_id = ? and film.id = ?;";<br>
stmt = conn.prepareStatement(sql);<br>
stmt.setInt(1, langID);<br>
stmt.setInt(2, filmID);<br>

The DatabaseAccessorObject's findActorById method uses the following SQL statement to build an actor object:

"select * from actor where id = ?"

The choice_2 method in the App class uses the following SQL statement for the keyword search:

"select id, title, description from film";

### Conclusion

This was a great project to gain experience using java to access an SQL database. 
The database has a enough size to make the project challenging. 

<img src="https://github.com/sgmerwin/FilmQueryProject/blob/master/database_size.png" width="150" height="250">

Setting up the maven dependencies and the following code blocks that are in the DatabaseAccessorObject class used to access the database were the most difficult conceptual challenges. 

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
  
  Connection conn = DriverManager.getConnection(this.URL, this.user, this.pass);<br>
	  Film film = null;<br>
	  String sql = "select * from film where id = ?";<br>
	  PreparedStatement stmt = conn.prepareStatement(sql);<br>
	  stmt.setInt(1, filmId);<br>
	  ResultSet rs = stmt.executeQuery();<br>
	    while (rs.next()) {<br>
      //code here<br>
      }<br>

Using data to define class attributes and generating lists so that a user can access the information with an efficient interface is really what java does so well. Getting familiar enough with the structure of the SQL database to productively develop the java code is certainly an added hurdle. There was a lot of testing SQL statements at the command line and looking through the outputs to get comfortable with the structure of the database. 


  
