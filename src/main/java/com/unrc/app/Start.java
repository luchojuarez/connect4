package com.unrc.app;
import java.util.Scanner;
import org.javalite.activejdbc.Model;

public class Start extends Model {
	// suponemos que el usuario esta registrado
	public static void begin (){
		int respuesta=9;
		do {
			System.out.println("presione 1 para registrarse");
			System.out.println("presione 2 loguearse");
			System.out.println("presione 0 para salir");
			Scanner escaneo = new Scanner(System.in);
			respuesta = escaneo.nextInt();
		} while ((respuesta != 1) && (respuesta!=2) && (respuesta!=0));
		
		if (respuesta==2)
			login();
		else 
			if (respuesta==1)
				registered();
	}

	private static void login (){
		System.out.print("Ingrese su nick para registrarse: ");
		String nickId = "";
		Scanner escaneo = new Scanner(System.in);
		nickId = escaneo.nextLine();
		if (search(nickId)) {
			System.out.println("Login: user IN");
			//el nickid esta disponible
			//continuar registrando
		}
	}
	private static void registered () {

	}
	public static boolean search (String nickId) {
		return true;
	} 
}