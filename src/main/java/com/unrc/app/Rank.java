package com.unrc.app;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.Base;
import java.util.List;

public class Rank extends Model {

   // @Override
   


    public String toStringPoint(){
      return this.getString("points");
  }   

   	
   	public String toStringUser(){
    	return this.getString("user_id");
	}   
  
    public String toStringPG(){
      return this.getString("PG");
  }   

      public String toStringPE(){
      return this.getString("PE");
  }   

    public String toStringPP(){
      return this.getString("PP");
  }   


  // partida ganada
  public static void win(User us) {
    Rank ranking = Rank.findFirst("user_id = ?", us.get("id"));

    if (ranking == null) {
      Rank r = new Rank();
      r.set("user_id", us.get("id"));
      r.set("PG", 1);
      r.set("PE", 0);  
      r.set("PP", 0);  
      r.set("points", 3);
      r.save();
  
    }else{  
      ranking.set("PG", ranking.getInteger("PG")+1);
      ranking.set("points", ranking.getInteger("points")+3);
      ranking.save();
    }
  } 



  // partida empatada
  public static void draw(User us){
    Rank ranking = Rank.findFirst("user_id = ?", us.get("id"));
    
    if (ranking == null) {
      Rank r = new Rank();
      r.set("user_id", us.get("id"));
      r.set("PG", 0);
      r.set("PE", 1);  
      r.set("PP", 0);  
      r.set("points", 1);
      r.save(); 
        
    }else{  
      ranking.set("PE", ranking.getInteger("PE")+1);
      ranking.set("points", ranking.getInteger("points")+1);
      ranking.save();
    }
  }

  // partida perdida
  public static void loser(User us){
    Rank ranking = Rank.findFirst("user_id = ?", us.get("id"));
    
    if (ranking == null) {
      Rank r = new Rank();
      r.set("user_id", us.get("id"));
      r.set("PG", 0);
      r.set("PE", 0);  
      r.set("PP", 1);  
      r.set("points", 0);
      r.save(); 

    }else{  
      ranking.set("PP", ranking.getInteger("PP")+1);
      ranking.save();
      
    }
  }
// FALTAN LAS POSICIONES QUE SERIA EL NRO RANK
}



