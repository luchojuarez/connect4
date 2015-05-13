package com.unrc.app;
import java.util.Scanner;
import java.util.List;
import org.javalite.activejdbc.Model;

public class Start extends Model {

	// Menu de inicio
	public static void begin (){
		int respuesta=10;

		do {
			System.out.println("Presione 1 para LOGUEARSE");
			System.out.println("Presione 2 para REGISTRARSE");
			System.out.println("Presione 0 para SALIR");
			Scanner escaneo = new Scanner(System.in);
			respuesta = escaneo.nextInt();
		} while ((respuesta != 1) && (respuesta!=2) && (respuesta!=0));
		
		if (respuesta==1)
			login();
		else 
			if (respuesta==2)
				registered();
			else
				if(respuesta==0)
					System.out.println("bye");
	}

	// clase para loguear a un usuario
	private static void login (){
		System.out.println();
		System.out.print("Ingrese su nick para ingresar: ");
		String nickId = "";
		Scanner name = new Scanner(System.in);
		nickId = name.nextLine();//se le pide su nickId que es el atributo por el cual buscamos en la base
		if (search(nickId)) {//si el usuario es correcto 

			System.out.println();
			System.out.print("Ingrese su password para ingresar: ");
			String pass = "";
			Scanner word = new Scanner(System.in);
			pass = word.nextLine();//se le pide su password

			if(checkPass(nickId,pass)){//si la password es correcta ingresa
				System.out.println();
				System.out.println("Login: user IN");
			}
			else{
				System.out.println();
				System.out.println("Nick o Pass incorrectos");
				begin();				
			}
		}
		else{
			System.out.println();
			System.out.println("Nick invalido");
			begin();				
		}
	}
	
	private static void registered () {
		System.out.println();
		System.out.print("Ingrese su nick: ");
		String nickid = "";
		Scanner nick = new Scanner(System.in);
		nickid = nick.nextLine();//se le pide su nickId que es el atributo por el cual buscamos en la base

		System.out.println();
		System.out.print("Ingrese su nombre: ");
		String nameus = "";
		Scanner name = new Scanner(System.in);
		nameus = name.nextLine();//se le pide su nickId que es el atributo por el cual buscamos en la base

		System.out.println();
		System.out.print("Ingrese su apellido: ");
		String lastnameus = "";
		Scanner lastname = new Scanner(System.in);
		lastnameus = lastname.nextLine();//se le pide su nickId que es el atributo por el cual buscamos en la base

		System.out.println();
		System.out.print("Ingrese su e-mail: ");
		String mail = "";
		Scanner email = new Scanner(System.in);
		mail = email.nextLine();//se le pide su nickId que es el atributo por el cual buscamos en la base
		
		System.out.println();
		System.out.print("Ingrese su password: ");
		String pass = "";
		Scanner passw = new Scanner(System.in);
		pass = passw.nextLine();//se le pide su nickId que es el atributo por el cual buscamos en la base

		System.out.println();
		System.out.print("Ingrese su dni: ");
		String dni = "";
		Scanner doc = new Scanner(System.in);
		dni = doc.nextLine();//se le pide su nickId que es el atributo por el cual buscamos en la base

		System.out.println();
		System.out.print("Ingrese su edad: ");
		String age = "";
		Scanner edad = new Scanner(System.in);
		age = edad.nextLine();//se le pide su nickId que es el atributo por el cual buscamos en la base

		User u = new User();
		u.set("nickId",nickid);
		u.set("nameUs",nameus);
		u.set("lastNameUs",lastnameus);
		u.set("email",mail);
		u.set("password",pass);
		u.set("DNI",dni);
		u.set("age",age);
		u.saveIt();
		System.out.println();
		System.out.print("Usuario Registrado Con Exito... ");
		System.out.println();
	}

	public static boolean search (String nickId) {

		List<User> u = User.where("nickId = ?", nickId);

		//Verificamos si encontramos un usuario
		if (u.isEmpty()) return false;		
		else return true;	
	}

	//Verifica si el password es correcto
	public static boolean checkPass(String nickId, String pass){

		List<User> u = User.where("nickId = ?", nickId);
		User us = u.get(0);
		String p = (String) us.get("password"); //consult

		System.out.println(p);
		System.out.println(pass);
		System.out.println(p.length());
		System.out.println(pass.length());

		if (p==pass) return true;
		else return false;
	} 
}



//ARREGLAR CUANDO TE INGRESA UNA LETRA 
//BUSCAR BASE DE DATOS
//BASE DE DATOS