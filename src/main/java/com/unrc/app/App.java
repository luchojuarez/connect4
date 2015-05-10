package com.unrc.app;

import com.unrc.app.User;
import com.unrc.app.Rank;
import org.javalite.activejdbc.Base;
/**
 **Hello world!
 **
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/connect4_test", "root", "root");
		User u = new User();
		Rank r = new Rank();
		u.set("first_name", "Nicolas");
		u.set("last_name","Dominguez");
		u.set("email","lucho.juarez79@gmail.com");
		u.save();
		r.set("points","6");
		r.save();
		u.add(r);
		Base.close();   	
    }
}
