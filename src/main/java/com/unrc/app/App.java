package com.unrc.app;

import com.unrc.app.User;
import com.unrc.app.Rank;
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

<<<<<<< HEAD
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/connect4_test", "root", "root");
        // User u = new User();
        // u.set("first_name", "luciano");
        // u.set("last_name","juarez");
        // u.set("email","lucho.juarez79@gmail.com");
        // u.save();
        
=======
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/connect4_development", "root", "root");
        User u = new User();
        Rank r = new Rank();
        u.set("first_name", "luciano");
        u.set("last_name","juarez");
        u.set("email","lucho.juarez79@gmail.com");
        u.save();
        r.set("points","1");
        r.save();
        u.add(r);        
>>>>>>> 3503d56011d49447ede206d00fe7b989329195d9
        Base.close();
        	
    }
}
