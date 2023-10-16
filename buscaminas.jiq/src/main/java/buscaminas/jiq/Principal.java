package buscaminas.jiq;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args ) {
		Scanner sc = new Scanner(System.in);
		String [][] tableroSolucion = Funciones.rellenarTablero();
		String [][] tableroOculto = new String[9][9];
		byte[] posElegida = new byte[2];
		byte eleccion=0;
		boolean perder=false;
		byte banderas = 10;
		
		for(byte i =0;i<tableroSolucion.length;i++) {
			for(byte j =0;j<tableroSolucion[i].length;j++) {
				tableroOculto[i][j]="■ ";
			}
		}	
		
		System.out.println("BUSCAMINAS!");
		//BUCLE DEL JUEGO
		do {
			System.out.println("El tablero se ve así: ");
			for(byte i =0;i<tableroSolucion.length;i++) {
				for(byte j =0;j<tableroSolucion[i].length;j++) {
					System.out.print(tableroOculto[i][j]);
				}
				System.out.println();
			}
			System.out.println("La cantidad de banderas que te quedan son: " + banderas);
			System.out.println("¿Qué casilla quieres seleccionar?");
			posElegida[0]=Byte.parseByte(JOptionPane.showInputDialog(null,"Dime la fila que quieres seleccionar"));
			posElegida[1]=Byte.parseByte(JOptionPane.showInputDialog(null,"Dime la columna que quieres seleccionar:"));
			System.out.println("Elige la acción a realizar con esa casilla");
			System.out.print("1-Expandir mapa \t2-Colocar bandera");
			
			eleccion=Byte.parseByte(JOptionPane.showInputDialog(null,"Elige la accion a realizar\n1-Expandir Mapa \t2-Colocar Bandera"));
			if(eleccion==1) {
				if(Funciones.ampliarMapa(tableroSolucion, tableroOculto, posElegida)) {
					perder=true;
				}else {
					System.out.println("El tablero quedó así:");
				}
			}else {
				Funciones.colocarBandera(tableroOculto, posElegida);
				banderas -=1;
			}
		}while(perder==false&&banderas>0);
		if(perder==false) {
			if(Funciones.comprobarResultado(tableroSolucion, tableroOculto)) {
				JOptionPane.showMessageDialog(null, "GANASTE");
			}else {
				JOptionPane.showMessageDialog(null, "PERDISTE");
			}
		}
	}
}
//"□ "