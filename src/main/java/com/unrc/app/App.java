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

    get("/Connect4", (req, res) -> {


      String response = "<h1 style="+"text-align:center"+">"+"Connect 4</h1>";

      response += " <form action="+"play"+">";
      // response += " <form action="+"registered"+">";


      // caja de texto para user1
      response += "<br><br>";
      response += "<br><br>";
      response += "<br><br>";
      response += "<p style="+"text-align:center"+"><i> Player 1 Name: <i><br>";
      response += "<input type="+"text"+" name="+"player1"+">";
      response += "<p style="+"text-align:center"+"><i>  Player 2 Name: <i><br>";
      response += "<input type="+"text"+" name="+"player2"+">";

      // boton
      response += "<br><br>";
      response += "<br><br>";
      response += "<input type="+"submit"+" value="+"Jugar"+">";
      response += "</form>";
      response += " <form action="+"registered"+">";
      response += "<input type="+"submit"+" value="+"Registrarse"+">";
      response += "</form>";

      response += "<br><br>";
      response += "<br><br>";
      response += "<br><br>";
      response += "<br><br>";
      response += "<br><br>";
      response += "<br><br>";
      response += "<br><br>";
      response += "<br><br>";
      response += "<p style="+"text-align:center"+"><i> Cibils - Dominguez - Juarez <i><br>";

      return response;
    });   

    get("/play", (request, response) -> {


      String ret = "<h1 style="+"text-align:center"+">"+"Connect 4</h1>";

      ret += "<form action="+"action_page.php"+">";
      ret += " <i> Seleccione Dimension Grilla: <i>";
      ret += "<select name="+"dimension"+">";
      ret += "<option value="+"6x7"+">6x7 (Default)</option>";
      ret += "<option value="+"8x7"+">8x7</option>";
      ret += "<option value="+"9x7"+">9x7</option>";
      ret += "<option value="+"10x7"+">10x7</option>";
      ret += "<option value="+"8x8"+">8x8</option>";
      ret += "</select>";
      ret += " <input type="+"submit"+" value="+"Aplicar"+">";
      ret += "</form>";

      ret += "<form action="+"rank"+">";
      ret += "<p style="+"text-align:right"+"><i> Ver Ranking Jugador 1:  <i>";
      ret += "<input type="+"submit"+" value="+"Click"+">";
      ret += "</form>";


      ret += "<form action="+"action_page.php"+">";
      ret += " <i> Seleccione color ficha Jugador 1: <i>";
      ret += " <input type="+"color"+" name="+"colorP1"+" value="+"#ff0000"+">";
      ret += " <input type="+"submit"+" value="+"Aplicar"+">";
      ret += "</form>";

      ret += "<form action="+"rank"+">";
      ret += "<p style="+"text-align:right"+"><i> Ver Ranking Jugador 2:  <i>";
      ret += "<input type="+"submit"+" value="+"Click"+">";
      ret += "</form>";


      ret += "<form action="+"action_page.php"+">";
      ret += " <i> Seleccione color ficha Jugador 2: <i>";
      ret += " <input type="+"color"+" name="+"colorP2"+" value="+"#ff0000"+">";
      ret += " <input type="+"submit"+" value="+"Aplicar"+">";
      ret += "</form>";

      ret += "<br><br>";
      ret += "<br><br>";
      ret += "<style>";
      ret += "table, th, td {";
      ret += "border: 1px solid black;";
      ret += "border-collapse: collapse;";
      ret += "}";
      ret += "th, td {";
      ret += "padding: 7px;";
      ret += "text-align: center;";
      ret += "}";
      ret += "</style>";

      ret += "<table style="+"width:100%"+">";
      ret += "<caption>J1 vs J2</caption>";
      ret += "<tr>";
      ret += "<th>C1</th>";
      ret += "<th>C2</th>";
      ret += "<th>C3</th>";
      ret += "<th>C4</th>";
      ret += "<th>C5</th>";
      ret += "<th>C6</th>";
      ret += "<th>C7</th>";
      ret += "</tr>";
      ret += "<tr>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "</tr>";
      ret += "<tr>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "</tr>";
      ret += "<tr>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "</tr>";
      ret += "<tr>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "</tr>";
      ret += "<tr>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "</tr>";
      ret += "<tr>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "<th>-</th>";
      ret += "</tr>";
      ret += "</table>";


      ret += "<br><br>";
      ret += "<br><br>";
      ret += "<p style="+"text-align:center"+"><i> Cibils - Dominguez - Juarez <i><br>";
      return ret;
    });

    get("/registered", (request, response) -> {
      String res = "<h1 style="+"text-align:center"+">"+"Connect 4</h1>";
      res += " <form action="+"Connect4"+">";
      res += "<br><br>";

      res += "<p style="+"text-align:center"+"><i> Nick: <i><br>";
      res += "<input type="+"text"+" name="+"nick"+">";

      res += "<p style="+"text-align:center"+"><i> Nombre: <i><br>";
      res += "<input type="+"text"+" name="+"nombre"+">";

      res += "<p style="+"text-align:center"+"><i> Apellido: <i><br>";
      res += "<input type="+"text"+" name="+"apellido"+">";

      res += "<p style="+"text-align:center"+"><i> E-mail: <i><br>";
      res += "<input type="+"email"+" name="+"e-mail"+">";

      res += "<p style="+"text-align:center"+"><i> Contraseña: <i><br>";
      res += "<input type="+"password"+" name="+"pass"+">";

      res += "<p style="+"text-align:center"+"><i> Dni: <i><br>";
      res += "<input type="+"text"+" name="+"dni"+">";

      res += "<p style="+"text-align:center"+"><i> Edad: <i><br>";
      res += "<input type="+"text"+" name="+"edad"+">";

      res += "<br><br>";
      res += "<input type="+"submit"+" value="+"Registrarse"+">";
      res += "</form>";
      res += "<br><br>";
      res += "<br><br>";
      res += "<br><br>";
      res += "<p style="+"text-align:center"+"><i> Cibils - Dominguez - Juarez <i><br>";

      return res;

    });

    get("/rank", (request, response) -> {
      String ran = "<h1 style="+"text-align:center"+">"+"Connect 4</h1>";
      ran += "<br><br>";
      ran += "<br><br>";
      ran += "<br><br>";
      ran += "<br><br>";
      ran += "<br><br>";
      ran += "<br><br>";
      ran += "<p style="+"text-align:center"+"><i> Sorry, In Build <i><br>";
      ran += "<br><br>";
      ran += "<br><br>";
      ran += "<br><br>";
      ran += "<br><br>";
      ran += "<br><br>";
      ran += "<br><br>";
      ran += "<br><br>";
      ran += "<p style="+"text-align:center"+"><i> Cibils - Dominguez - Juarez <i><br>";
      return ran;

    });

  }


    // Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/connect4_development", "root", "root");
    // System.out.println( "Hello World!" );
    // System.out.println();
    // Start.begin();
    // Base.close();   	
    // System.out.println( "GoodBye!! XD" );



// FALTA PARA EL VIERNES:
      // >> INTERFAZ COMPLETA! (MAIN,REGISTRARSE,JUGAR)
      // >> INTERACCION DEL REGISTRARSE CON LA BASE DE DATOS
      // >> INTERACCION DEL MAIN CON LA BASE DE DATOS

}