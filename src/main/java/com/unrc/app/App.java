package com.unrc.app;

import com.unrc.app.Play;
import com.unrc.app.Start;
import com.unrc.app.MenuPlayer;
import com.unrc.app.User;
import com.unrc.app.Rank;
import com.unrc.app.Grid;
import com.unrc.app.Cell;
import com.unrc.app.Game;
import com.unrc.app.Hit;
import com.unrc.app.Removed;
import org.javalite.activejdbc.Base;
import static spark.Spark.*;



/**
 **Hello world!
 **
 */
public class App{
	// private User player1;
	// private User player2;


  public static void main( String[] args ){

    get("/Conect4", (req, res) -> {
      String response = "<h1> Connect 4</h1>";
      response  += "<a href =\"/login\"> <h2>Iniciar Sesion<h2>";
      response  += "<a href =\"/registered\"> <h3>Registrarse<h3>";
      return response;
    });   

    get("/login", (request, response) -> {
      String log = "<h1> Connect 4</h1>";
      log  += "<a href =\"/nick\"> <h2>Nombre de Usuario<h2>";
      log  += "<a href =\"/pass\"> <h3>Contraseña<h3>";
      log  += "<a href =\"/in\"> <h4>Ingresar<h4>";
      log  += "<a href =\"/Conect4\"> <h5>Volver";
      return log;
    });


    get("/registered", (request, response) -> {
      return "sorry, in build";
    });


    get("/in", (request, response) -> {
      String inUs = "<h1> Connect 4</h1>";
      inUs  += "<a href =\"/play\"> <h2>Jugar<h2>";
      inUs  += "<a href =\"/rank\"> <h3>Ranking<h3>";
      return inUs;
    });

    get("/nick", (request, response) -> {
      return "sorry, in build";
    });

    get("/pass", (request, response) -> {
      return "sorry, in build";
    });

    get("/play", (request, response) -> {
      return "sorry, in build";
    });

    get("/rank", (request, response) -> {
      return "sorry, in build";
    });


  }

		// Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/connect4_development", "root", "root");
  //       System.out.println( "Hello World!" );
  //       System.out.println();
		// Start.begin();
		// Base.close();   	
  //       System.out.println( "GoodBye!! XD" );
  // }
}
