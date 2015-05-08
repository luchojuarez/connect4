package com.unrc.app;

import com.unrc.app.User;
import org.javalite.activejdbc.Base;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/connect4_test", "root", "root");
        // User u = new User();
        // u.set("first_name", "luciano");
        // u.set("last_name","juarez");
        // u.set("email","lucho.juarez79@gmail.com");
        // u.save();
        
        Base.close();
        	
    }
}
