# FilmQueryProject

### Overview

The follow image provides a basic overview of the project.

<img src="https://github.com/sgmerwin/FilmQueryProject/blob/master/sql_1_5_20.jpg" width="500" height="500">

The following image is a screenshot of the project structure in Eclipse.

<img src="https://github.com/sgmerwin/FilmQueryProject/blob/master/sql_proj_struct_1_5_20.png" width="200" height="300">

Maven was used to handle the SQL database connection dependencies.

<img src="https://github.com/sgmerwin/FilmQueryProject/blob/master/maven_dep.png" width="250" height="100">

### Details

The user runs the main method in the App class. This generates a DatabaseAccessorObject and prints options in the terminal to retrive a film by id or retrive films by a keyword search. The keyword search, searches all of the film titles and descriptions in the database. The code for the keyword search is in the App class choice_2 method. The choice_2 method puts the words from the title in a string array and then runs a for loop comparing the keyword to each string in the array. If the for loop finds a not case sensitive match, it runs the DatabaseAccessorObject's findFilmById method which handles printing the data to the terminal. 
After the choice_2 method search the film's title, it then searches the film's description for a match with the same for loop structure. 

The complexity of the project lies in the DatabaseAccessorObject referencing the SQL database correctly to retrive the desired data. 

"select id, first_name, last_name from actor join film_actor on actor.id = film_actor.actor_id where film_actor.film_id = ?"
