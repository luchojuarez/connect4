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
import java.util.Scanner;
import java.util.List;
import java.util.*;
import spark.ModelAndView;
import spark.TemplateEngine;

import java.io.IOException;
import java.io.StringWriter;
import org.eclipse.jetty.io.RuntimeIOException;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;




/**
 **Hello world!
 **
 */
public class App{
	// private User player1;
	// private User player2;

  
      public static void main( String[] args ){

            before((request, response) -> {
              Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/connect4_development", "root", "root");
            });

            
            after((request, response) -> {
                  Base.close();
            });        
  
            
            //ingresa a la pantalla principal
            get("/Connect4", (request, response) -> {
                  Map<String, Object> attributes = new HashMap<>();
                  List <User> users = User.findAll();
                  attributes.put("users",users);

                  String player1 = request.queryParams("comboboxUs1");
                  String player2 = request.queryParams("comboboxUs2");

                  attributes.put("us1",player1);
                  attributes.put("us2",player2);
                  return new ModelAndView(attributes, "Connect4.moustache");                                   
            }, new MustacheTemplateEngine());


            //ingresa a la pantalla de registro
            get("/registered", (request, response) -> {
                  return new ModelAndView(null, "registered.moustache");                                   
            }, new MustacheTemplateEngine());


            //registra usuario 
            post("/registrar", (request, response) -> {
                  String nick = request.queryParams("nick");
                  String name = request.queryParams("nombre");
                  String lastName = request.queryParams("apellido");
                  String mail = request.queryParams("e-mail");
                  String pass = request.queryParams("pass");
                  String dni = request.queryParams("dni");
                  String age = request.queryParams("edad");
                  boolean reg = Start.registered(nick,name,lastName,mail,pass,dni,age);
                  if (reg){
                        Map<String, Object> attributes = new HashMap<>();
                        List <User> users = User.findAll();
                        attributes.put("users",users);

                        String player1 = request.queryParams("comboboxUs1");
                        String player2 = request.queryParams("comboboxUs2");

                        attributes.put("us1",player1);
                        attributes.put("us2",player2);
                        return new ModelAndView(attributes, "Connect4.moustache");                                   
                  }
                  else{
                        return new ModelAndView(null, "registered.moustache"); 
                  }
               
            }, new MustacheTemplateEngine());


            //ingresa a la pantalla de Jugar despues de crear un nuevo game y grid
            post("/play", (request, response) -> {
                  Map<String, Object> attributes = new HashMap<>();
                  String player1 = request.queryParams("comboboxUs1");
                  String player2 = request.queryParams("comboboxUs2");
                  System.out.println("----------"+player1);
                  System.out.println("----------"+player2);

                  // control de usuarios diferentes
                  if(player1.equals(player2)){
                        List <User> users = User.findAll();
                        attributes.put("users",users);

                        attributes.put("us1",player1);
                        attributes.put("us2",player2);
                        return new ModelAndView(attributes, "Connect4.moustache");                                   
                  }
                  else{
                        attributes.put("us1",player1);
                        attributes.put("us2",player2);
                        attributes.put("turno",player1);
                        Game g = new Game();
                        String table = g.getGrid().toStringTable();
                        boolean reg = MenuPlayer.newGame(player1,player2,g);
                        System.out.println("----------"+g.get("id"));
                        attributes.put("game_id",g.get("id"));
                        attributes.put("table", table);
                        if(reg){
                          return new ModelAndView(attributes, "play.moustache");
                        }
                        else{
                            return new ModelAndView(attributes, "Connect4.moustache");                                   
                        }
                  }      
            }, new MustacheTemplateEngine());
            
            
            get("/play", (request, response) -> {
                  Map<String, Object> attributes = new HashMap<>();

                  String player1 = request.queryParams("us1");
                  String player2 = request.queryParams("us2");
                  String game_id = request.queryParams("game_id");
                  String turno = request.queryParams("turno");
                  String boton = request.queryParams("C");
                  
                  List<Game> ga  = Game.where("id = ?", game_id);
                  Game game = new Game();
                  game = ga.get(0); 

                  int id_grid = (int) game.get("grid_id");

                  List<Grid> grid = Grid.where("id = ?", id_grid);
                 
                 List<Cell> celdas = Cell.where("grid_id = ?",id_grid);  

                 game.set_Cells(celdas);

                 Grid g = grid.get(0);               

                 
                  turno = Play.turn(player1,player2,turno);
                  attributes.put("us1",player1);
                  attributes.put("us2",player2);
                  attributes.put("game_id",game_id);
                  attributes.put("turno",turno);
                  int y = Character.getNumericValue(boton.charAt(3));
                  Cell c = game.pushDisc(y,Play.player_actual(player1,player2,turno)); 
                  
                  if (c!=null){

                  c.set("X",c.getx());    
                  c.set("Y",c.gety());    
                        c.set("state",c.getState());  
                        c.save();
                        g.add(c);

                        //Check winner

                        int partida = game.gameOver(c);

            //>0 indica que el juego termino ya que no hay mas casilleros disponibles
            // >1 indica que el jugador que hizo el ultimo movimiento gano
            // >2 indica que no hay ganador, el juego continua

                        if (partida==0){

                              String actual = Play.turn(player1,player2,turno);
                              String draw = "<h2 style="+"\"text-align:center\""+"><i>"+"Empatee..!<i><br></h2>";
                              List<User> l_us = User.where("nickId = ?", actual);
                              User u1 = l_us.get(0);
                              Rank.draw(u1);
                              List<User> us = User.where("nickId = ?", turno);
                              User u2 = us.get(0);
                              Rank.draw(u2);     
                              attributes.put("result",draw);
                              game.set("dateEnd",Start.getFechaActual());
                              game.save();
                        }

                        if (partida==1){

                              String actual = Play.turn(player1,player2,turno);
                              String winner = "<h2 style="+"\"text-align:center\""+"><i> Ganador!!!:"+actual +"<i><br></h2>";
                              List<User> l_us = User.where("nickId = ?", actual);
                              User u1 = l_us.get(0);
                              System.out.println("||||||||||||||||---->>>>>>>>"+actual);
                              System.out.println("||||||||||||||||---->>>>>>>>"+turno);
                              System.out.println("||||||||||||||||---->>>>>>>>"+u1.get("nickId"));
                              Rank.win(u1);
                              game.set("dateEnd",Start.getFechaActual());
                              game.save();
                              // u.add(game);
                              List<User> us = User.where("nickId = ?", turno);
                              User u2 = us.get(0);
                              System.out.println("||||||||||||||||---->>>>>>>>"+actual);
                              System.out.println("||||||||||||||||---->>>>>>>>"+turno);
                              System.out.println("||||||||||||||||---->>>>>>>>"+u2.get("nickId"));
                              Rank.loser(u2);                            
                              attributes.put("result",winner);

                        }

                        if(partida==2){

                              String table = request.queryParams("table");
                              table = game.getGrid().toStringTable(); 
                              attributes.put("table", table);

                        }

                    
                  }

                   
                   return new ModelAndView(attributes, "play.moustache");
                  }, new MustacheTemplateEngine());

      
	

	 


 
            //ingresa a la pantalla que te muestra los ranking
            get("/rank", (request, response) -> {
                  Map<String, Object> attributes = new HashMap<>();
                  List <Rank> ranking = Rank.findAll()
                  .orderBy("points desc");

                  List <Rank> position = Rank.findAll()
                  .orderBy("nroRank asc");

                  attributes.put("ranking",ranking);
                  attributes.put("pos",position);

                  return new ModelAndView(attributes, "rank.moustache");
            }, new MustacheTemplateEngine());


            get("/volverConnect4", (request, response) -> {
                  Map<String, Object> attributes = new HashMap<>();
                  List <User> users = User.findAll();
                  attributes.put("users",users);

                  String player1 = request.queryParams("comboboxUs1");
                  String player2 = request.queryParams("comboboxUs2");

                  attributes.put("us1",player1);
                  attributes.put("us2",player2);
                  return new ModelAndView(attributes, "Connect4.moustache");                                   
            }, new MustacheTemplateEngine());


            // post("/save", (request, response) -> {
            //     return new ModelAndView(null, "play.moustache");
            // }, new MustacheTemplateEngine());

            post("/load", (request, response) -> {
                  // Map<String, Object> attributes = new HashMap<>();

                  // String gameId = request.queryParams("comboboxGame");
                  // String player1 = request.queryParams("us1");
                  // String player2 = request.queryParams("us2");
                  // attributes.put("us1",player1);
                  // attributes.put("us2",player2);
                  // attributes.put("us2",game_id);
                  Map<String, Object> attributes = new HashMap<>();

                  String j1 = request.queryParams("comboboxUs1");
                  String j2 = request.queryParams("comboboxUs2");

                  System.out.println("<><><><><><><><><><><><>"+j1);
                  System.out.println("<><><><><><><><><><><><>"+j2);
                  List<Game> juegos = Game.where("player1_id = ?",j1);
                  attributes.put("juegos",juegos);
                  attributes.put("us1",j1);
                  attributes.put("us2",j2);


                return new ModelAndView(attributes, "load.moustache");
            }, new MustacheTemplateEngine());

            get("/load", (request, response) -> {
                  Map<String, Object> attributes = new HashMap<>();
                  List <User> users = User.findAll();
                  attributes.put("users",users);

                  String player1 = request.queryParams("comboboxUs1");
                  String player2 = request.queryParams("comboboxUs2");
                  String juegos = "";

                  attributes.put("us1",player1);
                  attributes.put("us2",player2);
                  attributes.put("juegos",juegos);

                  // Map<String, Object> attributes = new HashMap<>();

                  // String j1 = request.queryParams("comboboxUs1");
                  // String j2 = request.queryParams("comboboxUs2");

                  // System.out.println("<><><><><><><><><><><><>"+j1);
                  // System.out.println("<><><><><><><><><><><><>"+j2);
                  // List<Game> juegos = Game.where("player1_id = ?",j1);
                  // attributes.put("juegos",juegos);
                  // attributes.put("us1",j1);
                  // attributes.put("us2",j2);


                return new ModelAndView(attributes, "load.moustache");
            }, new MustacheTemplateEngine());


            // post("/cargar", (request, response) -> {
            //       Map<String, Object> attributes = new HashMap<>();

            //       String gameId = request.queryParams("comboboxGame");
            //       String player1 = request.queryParams("us1");
            //       String player2 = request.queryParams("us2");
            //       attributes.put("us1",player1);
            //       attributes.put("us2",player2);
            //       attributes.put("game_id",gameId);
            //     return new ModelAndView(attributes, "play.moustache");
            // }, new MustacheTemplateEngine());


      }





  
// FALTA PARA EL VIERNES:
      // >> INTERFAZ COMPLETA! (MAIN,REGISTRARSE,JUGAR)
      // >> INTERACCION DEL REGISTRARSE CON LA BASE DE DATOS >>> LISTO <<<
      // >> INTERACCION DEL MAIN CON LA BASE DE DATOS
      // >> como sacar los parametros del combobox >>> LISTO <<<

      // >> como obtener los ranking
      // >> como manejar los graficos de las fichas
      // >> recuperar partida
      // >> ranking
      // >> fichas
      // >> que no pueda jugar el mismo jugador contra el
      

      // control de usuarios diferentes
      // cargar partida


}