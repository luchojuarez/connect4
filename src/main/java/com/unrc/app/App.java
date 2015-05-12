package com.unrc.app;

import com.unrc.app.User;
import com.unrc.app.Rank;
import com.unrc.app.Grid;
import com.unrc.app.Cell;
import com.unrc.app.Game;
import com.unrc.app.Hit;
import com.unrc.app.Removed;
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
		u = User.findFirst("nameUs = ?","Nicolas");
		Rank r = new Rank();
		if (u == null) {
			u.set("nameUs", "Nicolas");
			u.set("lastNameUs","Dominguez");
			u.set("email","lucho.juarez79@gmail.com");
			u.save();
			r.set("points","6");
			r.save();
			u.add(r);
		}
		Base.close();   	
    }
}
