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
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/connect4_development", "root", "root");
        //User u = User.findFirst("first_name =?","luciano");
        Rank r = new Rank();
        u.set("first_name", "juan  ");
        u.set("last_name","cibils");
        u.set("email","lucho.juarez79@gmail.com");
        u.save();
        u.save();
        r.set("points","1");
        r.save();
        u.add(r);        
        Base.close();
        	
    }
}
