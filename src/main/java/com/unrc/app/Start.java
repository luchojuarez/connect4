package com.unrc.app;
import java.util.Scanner;
import org.javalite.activejdbc.Model;

public class Start extends Model {

	// Menu de inicio
	public static void begin (){
		int respuesta=10;

		do {
			System.out.println("Presione 1 para LOGUEARSE");
			System.out.println("Presione 1 para REGISTRARSE");
			System.out.println("Presione 0 para SALIR");
			Scanner escaneo = new Scanner(System.in);
			respuesta = escaneo.nextInt();
		} while ((respuesta != 1) && (respuesta!=2) && (respuesta!=0));
		
		if (respuesta==1)
			login();
		else 
			if (respuesta==2)
				registered();
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

			if(pass == ""){//si la password es correcta ingresa
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
		
	}
	public static boolean search (String nickId) {
		return true;
	} 
}



//ARREGLAR CUANDO TE INGRESA UNA LETRA 
//registered
//BUSCAR BASE DE DATOS
//BASE DE DATOS