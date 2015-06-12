package com.unrc.app;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses({ UserTest.class })

public class AppTest {
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Master setup");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Master tearDown");
    }
}


  //   get("/Conect4", (req, res) -> {
  //     String response = "<h1> Connect 4</h1>";
  //     response  += "<a href =\"/login\"> <h2>Iniciar Sesion<h2>";
  //     response  += "<a href =\"/registered\"> <h3>Registrarse<h3>";
  //     return response;
  //   });   

  //   get("/login", (request, response) -> {
  //     String log = "<h1> Connect 4</h1>";
  //     log  += "<a href =\"/nick\"> <h2>Nombre de Usuario<h2>";
  //     log  += "<a href =\"/pass\"> <h3>Contraseña<h3>";
  //     log  += "<a href =\"/in\"> <h4>Ingresar<h4>";
  //     log  += "<a href =\"/Conect4\"> <h5>Volver";
  //     return log;
  //   });


        

  //   get("/registered", (request, response) -> {

  //      return "Selected user: " + request.params(":name");
  //     // return "sorry, in build";
  //   });


  //   get("/in", (request, response) -> {
  //     String inUs = "<h1> Connect 4</h1>";
  //     inUs  += "<a href =\"/play\"> <h2>Jugar<h2>";
  //     inUs  += "<a href =\"/rank\"> <h3>Ranking<h3>";
  //     return inUs;
  //   });

  //   get("/nick", (request, response) -> {
  //     return "sorry, in build";
  //   });

  //   get("/pass", (request, response) -> {
  //     return "sorry, in build";
  //   });

  //   get("/play", (request, response) -> {
      
  //     String jugar = " <form action="+"Conect4"+">";
  //     // +"method="+"post"
  //     // caja de texto para user1
  //     jugar += "First name:<br>";
  //     jugar += "<input type="+"text"+" name="+"firstname"+">";
  //     jugar += "<br>";
  //     jugar += "Last name:<br>";
  //     jugar += "<input type="+"text"+" name="+"lastname"+">";
  //     // jugar += "</form>";

  //     // boton
  //     jugar += "<br><br>";
  //     jugar += "<input type="+"submit"+" value="+"Jugar"+">";
  //     jugar += "</form>";

  //     return jugar;
  //   });

  //   get("/rank", (request, response) -> {
  //     return "sorry, in build";
  //   });


  // }
