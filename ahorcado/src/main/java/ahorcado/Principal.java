package ahorcado;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		Random r = new Random();
		//Array con las posibles palabras del ahorcado
		String [] listaPalabras= {"gato","perro","cocodrilo","serpiente","elefante"};
		byte vidas=6;
		String letra="";
		
		//Se elige una palabra al azar del array de palabras
		String palabra= listaPalabras[(byte)r.nextInt(listaPalabras.length)];
		byte letrasRestantes=(byte) palabra.length();
		String [] palabraEncriptada = new String [palabra.length()];
		
		//Variable utilizada para el JOptionPane
		String palabraEncriptadaEnPantalla="";
		
		//Guardo en cada posición del array un guión.
		for(byte i = 0; i<palabra.length();i++) {
			palabraEncriptada[i]= "_ ";
		}
		
		JOptionPane.showMessageDialog(null, "Bienvenido al juego del ahorcado!");
		//System.out.println("Bienvenido al juego del ahorcado!");
		
		
		while(vidas!=0 && letrasRestantes!=0) {
			JOptionPane.showMessageDialog(null, "Intentos permitidos: " + vidas);
			//System.out.println("Intentos permitidos: " + vidas);
			palabraEncriptadaEnPantalla="";
			
			
			/*Recorro el array palabra encriptada y guardo sus valores en la variable que luego utilizo para mostrar
			los guiones en el JOptionPane*/
			for(byte i = 0; i<palabraEncriptada.length;i++) {
				//System.out.print(palabraEncriptada[i]);
				palabraEncriptadaEnPantalla+=palabraEncriptada[i];
			}
			JOptionPane.showMessageDialog(null, "La palabra se ve así: \n" + palabraEncriptadaEnPantalla);
			
			
			
			letrasRestantes=(byte)palabraEncriptada.length;
			//System.out.println("");
			//System.out.println("Ingresa una letra: ");
			
			//Hago un bucle para que obligue a la persona a ingresar una letra
			while(letra.equals("")) {
				try {
					letra = JOptionPane.showInputDialog("Dime una letra").toLowerCase();
				}catch(NullPointerException e) {
					System.out.println("Error");
				}
			}
			
			/*Compruebo si la letra está en la palabra, si lo está reemplazo lo que haya en el array por la letra 
			cuando coincida con la posicion de la letra en la palabra y modifico el valor de la variable letrasRestantes. Si
			no está la letra se resta una vida.*/
			if(palabra.contains(letra)) {
				for(byte i= 0; i<palabra.length();i++) {
					if(palabra.charAt(i)==letra.charAt(0)) {
						palabraEncriptada[i]=letra + " ";
					}
				}
				letrasRestantes=0;
				for(byte i = 0;i<palabraEncriptada.length;i++) {
					if(palabraEncriptada[i].equals("_ ")) {
						letrasRestantes+=1;
					}
				}
			}else {
				vidas-=1;
			}
			letra="";
		}
		
		if(vidas!=0) {
			JOptionPane.showMessageDialog(null,"Felicidades ganaste :D");
		}else {
			JOptionPane.showMessageDialog(null,"Perdiste :(");
		}
		JOptionPane.showMessageDialog(null,"La palabra era: " + palabra);
	}

}
