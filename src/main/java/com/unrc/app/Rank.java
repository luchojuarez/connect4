package com.unrc.app;

import org.javalite.activejdbc.Model;

public class Rank extends Model {

   // @Override
   
   	public String toStringR1 (){
    	return this.getString("nroRank");
	}   
   	public String toStringR (){
    	return this.getString("points");
	}   
   	public String toStringR2 (){
    	return this.getString("user_id");
	}   

}
