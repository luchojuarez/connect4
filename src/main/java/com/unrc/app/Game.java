package com.unrc.app;

import org.javalite.activejdbc.Model;
import java.util.ArrayList;




// BelongsToParents({ 
// BelongsTo(foreignKeyName="player1_id",User=Game.class), 
// BelongsTo(foreignKeyName="player2_id",User=Game.class) })

//@BelongsTo(parent = User.class, foreignKeyName = "player1_id")

//@Many2Many(other = User.class, join = "id", player1FKName = "player1_id", player2FKName = "player2_id")

public class Game extends Model {


//----------------------------------------------------------------------------------------------------------------------------------------------------------

//Contructores---------------------------------------------------------------------------------------------------------------------------------------

	private Grid g;

	public Game(){

		g = new Grid();

	}

	public Game(int x, int y){

		g = new Grid(x,y);
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------

//Methods---------------------------------------------------------------------------------------------------------------------------------------------

	/* gameOver(Cell c) retorna el estado de la partida actual
	
	@param c es la celda donde se puso la ultima ficha
	@returns un numero, donde:

		>0 indica que el juego termino ya que no hay mas casilleros disponibles
		>1 indica que el jugador que hizo el ultimo movimiento gano
		>2 indica que no hay ganador, el juego continua
	*/
	public int gameOver(Cell c){

		/* si la grilla esta llena, retorno 0 */
		if ( g.gridFull() ) return 0;	
		/* si la grilla no esta llena, evaluo el estado de la partida */
		if (g.getCant()>7){

			boolean state = false;	/* Se asume que la partida no tiene ganador */
			ArrayList<Cell> array = new ArrayList();  /*  Creamos un arreglo  */

			/* Verifico en un entorno de la ultima ficha ingresada */

			array = getHorizontal(c);
			state = check(array,c);

			if (state) return 1;

			array = getVertical(c);
			state = check(array,c);

			if (state) return 1;

			array = getLeftDiagonal(c);
			state = check(array,c);

			if (state) return 1;

			array = getRightDiagonal(c);
			state = check(array,c);

			if (state) return 1;
			
		}

		/* en caso que no encuentre ganador, retorno 2 */
		return 2;	
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Metodos usados en gameOver(c);	
//----------------------------------------------------------------------------------------------------------------------------------------------------------

	/* getVertical(Cell c) retorna un arreglo con el entorno vertical de la utlima ficha ingresada
	@param c es la celda donde se puso la ultima ficha
	@returns un arreglo con las celdas
	*/
	public ArrayList<Cell> getVertical(Cell c){

		ArrayList<Cell> array = new ArrayList();	/* Arreglo a devolver */ /*ESTA MAL EL CONSTRUCTOR*/

		int x = c.getx(); 

		/* recorro la matriz verticalmente en un entorno de c */
		for (int i= -3; i<=3;i++){

			int k = c.gety() + i;	/* columna de la celda a ingresar en el arreglo */
			
			boolean in = (k>=0) && (k<=g.gety()); /* compruebo si la posicion de la columna es valida */

			if (in) array.add( g.getCell(x,k) ); /* si es valida, la guardo en el arreglo */
		}

		return array;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	/* getHorizontal(Cell c) retorna un arreglo con el entorno horizontal de la utlima ficha ingresada
	@param c es la celda donde se puso la ultima ficha
	@returns un arreglo con las celdas
	*/
	public ArrayList<Cell> getHorizontal(Cell c){

		ArrayList<Cell> array = new ArrayList();	/* Arreglo a devolver */

		int y = c.gety();

		/* recorro la matriz horizontalmente en un entorno de c */
		for (int i= -3; i<=3;i++){

			int k = c.getx() + i;	/* fila de la celda a ingresar en el arreglo */
			
			boolean in = (k>=0) && (k<=g.getx());  /* compruebo si la posicion de la fila es valida */

			if (in) array.add( g.getCell(k,y) );  /* si es valida, la guardo en el arreglo */
		}
		
		return array;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	/* getLeftDiagonal(Cell c) retorna un arreglo con el entorno diagonal (izquierda) de la utlima ficha ingresada
	@param c es la celda donde se puso la ultima ficha
	@returns un arreglo con las celdas
	*/
	public ArrayList<Cell> getLeftDiagonal(Cell c){

		ArrayList<Cell> array = new ArrayList();	/* Arreglo a devolver */
		
		/* recorro la matriz en diagonal en un entorno de c */
		for (int i= -3; i<=3;i++){

			int t = c.getx() + i;    /* fila de la celda a ingresar en el arreglo  */
			int k = c.gety() + i;   /* columna de la celda a ingresar en el arreglo */
						
			boolean in = (k>=0) && (k<=g.gety()); /* compruebo si la posicion de la columna es valida */
			in = in && ((t>=0) && (t<=g.getx()));   /* compruebo si la posicion de la fila es valida */
 
			if (in) array.add( g.getCell(t,k) ); /* si es valida, la guardo en el arreglo */
		}
		
		return array;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	/* getRightDiagonal(Cell c) retorna un arreglo con el entorno diagonal (derecha) de la utlima ficha ingresada
	@param c es la celda donde se puso la ultima ficha
	@returns un arreglo con las celdas
	*/
	public ArrayList<Cell> getRightDiagonal(Cell c){

		ArrayList<Cell> array = new ArrayList();	/* Arreglo a devolver */

		int x = c.getx();

		/* recorro la matriz verticalmente en un entorno de c */
		for (int i= -3; i<=3;i++){

			int t = c.getx()  -  i;   /* fila de la celda a ingresar en el arreglo  */
			int k = c.gety() + i;   /* columna de la celda a ingresar en el arreglo */
									
			boolean in = (k>=0) && (k<=g.gety()); /* compruebo si la posicion de la columna es valida */
			in = in && ((t>=0) && (t<=g.getx()));   /* compruebo si la posicion de la fila es valida */

			if (in) array.add( g.getCell(t,k) ); /* si es valida, la guardo en el arreglo */
		}
		
		return array;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	/* check(ArrayList<Cell> array) retorna si el entorno evaluado contiene una combinacion ganadora
	@param array es el arreglo que contiene las celdas en un entorno
	@param c es la celda donde se puso la ultima ficha
	@returns un booleano que indica si el jugador gano o no
	*/
	public boolean check(ArrayList<Cell> array, Cell c){

		int player = c.getState(); /* indica el jugador que inserto la ultima ficha */
		boolean state = false;	   /* indica el estado de la partida, true representa que el juego termino */
		int count = 0;		   /* variable que cuenta la cantidad de fichas consecutivas del mismo jugador */
		int i = 0;		   /* variable para recorrer el arreglo */

		while ((!state) && (i<array.size()) ){

			if ( player==array.get(i).getState() ) count++;	/* si hay fichas consecutivas incremento count */
			else count = 0;					/* si encuentro una ficha del adversario, vuelvo a cero */
			i++;						/* avanzo */
			if (count==4) state = true;			/* si encountre 4 fichas consecutivas, cambio el estado */
		} 
		return state;
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------
	
	/* pushDisc(Cell c) pone una nueva ficha en la celda indicada
	@param c es la celda donde estara la nueva ficha	
	*/
	public void pushDisc(Cell c){

		if (isEmpty(c)==0){		/* si la celda esta disponible */

			g.setCell(c);	/* seteamos la celda indicada */
			g.incCant();  	/* incrementamos la cantidad de fichas en el tablero */
		}
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	/* isEmpty(Cell c) retorna el estado de una celda
	@param c es la celda a verificar el estado
	@returns un entero, donde:

		>0 = Disponible
		>1 = Ocupada por jugador 1
		>2 = Ocupada por jugador 2
	*/
	public int isEmpty(Cell c){

		Cell cell = g.getCell(c.getx(),c.gety());
		return cell.getState();
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

}

/*
linea 89 error en el constructor!


*/
