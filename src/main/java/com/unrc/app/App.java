package com.unrc.app;

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
public class App
{
	// private User player1;
	// private User player2;
    public static void main( String[] args )
    {
            get("/hello", (req, res) -> {
                String response = "<h1> Connect 4</h1>";
                response  += "<a href =\"/play\"> Jugar</a>";
                return response;
             });   

            get("/play", (request, response) -> {
//            response.status(401);
            return "Go Away!!!";
        });

    }

		// Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/connect4_development", "root", "root");
  //       System.out.println( "Hello World!" );
  //       System.out.println();
		// Start.begin();
		// Base.close();   	
  //       System.out.println( "GoodBye!! XD" );
}
