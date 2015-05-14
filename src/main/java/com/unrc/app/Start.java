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
			System.out.println("Presione 3 para DARSE DE BAJA");
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
				if(respuesta==3)
					drop();
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
		
		do{
			System.out.println();
			System.out.print("Ingrese su nick: ");
			String nickid = "";
			Scanner nick = new Scanner(System.in);
			nickid = nick.nextLine();
			if(search(nickid))
				System.out.println("nick ya existente..Ingrese otro"); 
		}while(search(nickid));

		System.out.println();
		System.out.print("Ingrese su nombre: ");
		String nameus = "";
		Scanner name = new Scanner(System.in);
		nameus = name.nextLine();

		System.out.println();
		System.out.print("Ingrese su apellido: ");
		String lastnameus = "";
		Scanner lastname = new Scanner(System.in);
		lastnameus = lastname.nextLine();

		System.out.println();
		System.out.print("Ingrese su e-mail: ");
		String mail = "";
		Scanner email = new Scanner(System.in);
		mail = email.nextLine();
		
		System.out.println();
		System.out.print("Ingrese su password: ");
		String pass = "";
		Scanner passw = new Scanner(System.in);
		pass = passw.nextLine();

		System.out.println();
		System.out.print("Ingrese su dni: ");
		String dni = "";
		Scanner doc = new Scanner(System.in);
		dni = doc.nextLine();

		System.out.println();
		System.out.print("Ingrese su edad: ");
		String age = "";
		Scanner edad = new Scanner(System.in);
		age = edad.nextLine();

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

		List<User> us  = User.where("nickId = ?", nickId);
		String p = us.get(0).getString("password");

		if (p.equals(pass)) return true; //passworld correcto
		else return false;
	} 

	//metodo para que el usuario se pueda dar de baja
	private static void drop(){
		System.out.println();
		System.out.print("Ingrese su nick para darse de baja..");
		String nickId = "";
		Scanner name = new Scanner(System.in);
		nickId = name.nextLine();//se le pide su nickId que es el atributo por el cual buscamos en la base
		if (search(nickId)) {//si el usuario existe
			List<User> us  = User.where("nickId = ?", nickId);

			String nick = us.get(0).getString("nickId");
			String name = us.get(0).getString("nameUs");
			String lastname = us.get(0).getString("lastNameUs");
			String mail = us.get(0).getString("email");
			String dni = us.get(0).getString("DNI");
			String year = us.get(0).getString("age");

			Removed r = new Removed();
			java.util.Date fecha = new Date();
			r.set("dateRemov",fecha);
			r.set("nick",nickid);
			r.set("name",nameus);
			r.set("lastName",lastnameus);
			r.set("mail",mail);
			r.set("dni",dni);
			r.set("years",age);
			r.saveIt();



			System.out.println();
			System.out.print("Usuario Registrado Con Exito... ");
			System.out.println();

			
		}
		else{
			System.out.println();
			System.out.println("El usuario no puede darse de baja porque no esta Registrado");
			begin();
		}			 

}



//ARREGLAR CUANDO TE INGRESA UNA LETRA 
