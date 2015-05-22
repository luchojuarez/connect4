package com.unrc.app;
import java.util.Date; 
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.List;
import com.unrc.app.User;
import com.unrc.app.Rank;
import org.javalite.activejdbc.Model;

public class Start extends Model {

	// Menu de inicio
	public static void begin (){
		String respuesta;
		char[] charArray;
		char res;
		do {
			System.out.println();
			System.out.println("Presione 1 para LOGUEARSE");
			System.out.println("Presione 2 para REGISTRARSE");
			System.out.println("Presione 3 para DARSE DE BAJA");			
			System.out.println("Presione 4 para CONSULTAR SI EXISTE USUARIO");
			System.out.println("Presione 0 para SALIR");
			System.out.println();
			Scanner escaneo = new Scanner(System.in);
			respuesta = escaneo.nextLine();
			charArray = respuesta.toCharArray();
			res = charArray[0];
		} while ((res != '1') && (res!='2')&& (res!='3')&& (res!='4') && (res!='0'));
		
		switch (res) {
			case '1': login();
				break;
			case '2': registered();
				break;
			case '3': drop();
				break;
			case '4':{
				System.out.println();
				System.out.print("Ingrese el nick para consultar: ");
				String nickId = "";
				Scanner name = new Scanner(System.in);
				nickId = name.nextLine();
				if (search(nickId)){//si el usuario esta 
					System.out.println();
					System.out.print("El usuario existe ");
					System.out.println();
					begin();
				}
				else{
					System.out.println();
					System.out.print("El usuario NO existe ");
					System.out.println();
					begin();
				}
				break;
			}
			case 0: System.out.println("bye");
				break;
		}
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
				MenuPlayer.mainMenu(nickId);
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
	
		boolean flag;
		String aux = "";
		
		do{	
			flag = true;
			System.out.println();
			System.out.print("Ingrese su nick: ");
			Scanner nick = new Scanner(System.in);
			aux = nick.nextLine();
			if(search(aux)){//EN AUX SE LLEVA EL NICK INGRESADO POR TECLADO
				System.out.println("nick ya existente..Ingrese otro");
				flag = false; 
			}
		} while(flag == false);


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
		u.set("nickId",aux);//EN AUX SE LLEVA EL NICK INGRESADO POR TECLADO
		u.set("nameUs",nameus);
		u.set("lastNameUs",lastnameus);
		u.set("email",mail);
		u.set("password",pass);
		u.set("DNI",dni);
		u.set("age",age);
		u.saveIt();

		// cuando se crea un user se le crea automaticamente su ranking
		Rank r = new Rank();
		r.set("PG",0);
		r.set("PE",0);
		r.set("PP",0);
		r.set("points",0);
		r.set("nroRank",u.get("id"));
		r.saveIt();
		u.add(r);
// FIJARSE QUE NO TE PONE LA CLAVE FORANEA(el user_id no funciona)

		System.out.println();
		System.out.print("Usuario Registrado Con Exito... ");
		System.out.println();
		MenuPlayer.mainMenu(aux);
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
		System.out.print("Ingrese su nick para darse de baja:");
		String nickId = "";
		Scanner names = new Scanner(System.in);
		nickId = names.nextLine();//se le pide su nickId que es el atributo por el cual buscamos en la base
		if (search(nickId)) {//si el usuario existe

			List<User> us  = User.where("nickId = ?", nickId);

			String ni = us.get(0).getString("nickId");
			String name = us.get(0).getString("nameUs");
			String lastname = us.get(0).getString("lastNameUs");
			String mail = us.get(0).getString("email");
			String dni = us.get(0).getString("DNI");
			String year = us.get(0).getString("age");
			Removed r = new Removed();
			r.set("nick",ni);
			r.set("name",name);
			r.set("lastName",lastname);
			r.set("mail",mail);
			r.set("dni",dni);
			r.set("years",year);
			r.set("day",getFechaActual());
			r.save();
			User u = us.get(0);
			u.deleteCascade();

			System.out.println();
			System.out.println("Usuario eliminado Con Exito... ");
			System.out.println();
			begin();
		}
		else{
			System.out.println();
			System.out.println("El usuario no puede darse de baja porque no esta Registrado");
			begin();
		}
	}			 

    public static String getFechaActual() {
        Date ahora = new Date();
 		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        return formato.format(ahora);
    }

}



//ARREGLAR CUANDO TE INGRESA UNA LETRA 
/*CONSULTAS:
	-- no anda el user_id (te complica el delete y las claves foraneas) >>>>>>>>>(LISTO)<<<<<<<<<
	-- no anda el deleteCascade() (como no anda el user_id no encuentra lo que tiene que eliminar) >>>>>>>>>(LISTO)<<<<<<<<<

	-- user1 y user2 en schema -- override (esto va en la clase game (partida))>>>>>>>>>(LISTO)<<<<<<<<<
	-- hacer que cree una partida logee al segundo jugador y "empieze a jugar">>>>>>>>>(LISTO)<<<<<<<<<

	-- como pasar la fecha en removeds >>>>>>>>>(LISTO)<<<<<<<<<
	-- hacer que cuando cree el usuario automaticamente le cargue el ranking >>>>>>>>>(LISTO)<<<<<<<<<
	-- hacer que le muestre el ranking >>>>>>>>>(LISTO)<<<<<<<<<
	

	-- diferencia entre save y saveit es que el saveir te lanza una ecxeption si no puede guardar
		y se captura con untry y un catch y el save te devuelve false si no puede guardar
		y lo capturas solo con un if(r.save())....

	-- en menuPlayer cuando se crea el objeto game tmb crear un objeto grid para pedirle la dimension
		de la grilla y pasarle el id de la grilla a la tabla game el pedido de dimension
		puede estar dsp de que se loguue el segundo player pero antes de guardar el g y dsp hacer
		los add

*/