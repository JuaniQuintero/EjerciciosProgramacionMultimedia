package buscaminas.jiq;

import java.util.Random;

public class Funciones {
	public static String[][] rellenarTablero() {
		String [][] ret= new String[9][9];
		Random r=new Random();
		
		
		
		for(byte i =0;i<ret.length;i++) {
			for(byte j =0;j<ret[i].length;j++) {
				ret[i][j]="- ";
			}
		}
		
		for(byte i=0; i<10;i++) {
			byte pos1;
			byte pos2;
			do {
				pos1 =(byte) r.nextInt(9);
				pos2= (byte) r.nextInt(9);
			}while(ret[pos1][pos2].equals("O "));
			ret[pos1][pos2] = "O ";
		}
		
		
		byte numBombas=0;
		for(byte i =0;i<ret.length;i++) {
			for(byte j =0;j<ret[i].length;j++) {
				if(!(ret[i][j].equals("O "))) {
					
					if(i+1<ret.length&&ret[i+1][j].equals("O ")) {
						numBombas+=1;
						
					}
					
					if(j+1<ret.length&&ret[i][j+1].equals("O ")) {
						numBombas+=1;
						
					}
					
					if(i-1>=0&&ret[i-1][j].equals("O ")) {
						numBombas+=1;
						
					}
					
					if(j-1>=0&&ret[i][j-1].equals("O ")) {
						numBombas+=1;
						
					}
					
					if(i+1<ret.length&&j+1<ret.length&&ret[i+1][j+1].equals("O ")) {
						numBombas+=1;
						
					}
					
					if(i+1<ret.length&&j-1>=0&&ret[i+1][j-1].equals("O ")) {
						numBombas+=1;
						
					}
					
					if(i-1>=0&&j+1<ret.length&&ret[i-1][j+1].equals("O ")) {
						numBombas+=1;
						
					}
					
					if(i-1>=0&&j-1>0&&ret[i-1][j-1].equals("O ")) {
						numBombas+=1;
						
					}
					
					if(numBombas!=0) {
						ret[i][j]=numBombas+" ";
					}
					numBombas=0;
				}
			}
		}
		
		
		return ret;
	}
	
	
	public static boolean ampliarMapa(String[][]tabSolucion, String[][]tabOculto, byte[]casilla) {		
		boolean verificar=true;
		byte moverPos=0;
		boolean hayBomba=false;
		
		//abajo
		if(!(tabSolucion[casilla[0]][casilla[1]].equals("O "))) {
			do {
				if(casilla[0]+moverPos<tabSolucion.length&&tabSolucion[casilla[0]+moverPos][casilla[1]].equals("- ")) {
						tabOculto[casilla[0]+moverPos][casilla[1]]="□ ";
						moverPos+=1;
				}else {
					if(casilla[0]+moverPos<tabSolucion.length) {
						tabOculto[casilla[0]+moverPos][casilla[1]]=tabSolucion[casilla[0]+moverPos][casilla[1]];
					}
					verificar=false;
					moverPos=0;
				}
			}while(verificar==true);
			verificar=true;
			
			
			//arriba
			do {
				if(casilla[0]-moverPos>=0&&tabSolucion[casilla[0]-moverPos][casilla[1]].equals("- ")) {
						tabOculto[casilla[0]-moverPos][casilla[1]]="□ ";
						moverPos+=1;
				}else {
					if(casilla[0]-moverPos>=0) {
						tabOculto[casilla[0]-moverPos][casilla[1]]=tabSolucion[casilla[0]-moverPos][casilla[1]];
					}
					verificar=false;
					moverPos=0;
				}
			}while(verificar==true);	
			verificar=true;
			
			
			//derecha
			do {
				if(casilla[1]+moverPos<tabSolucion.length&&tabSolucion[casilla[0]][casilla[1]+moverPos].equals("- ")) {
						tabOculto[casilla[0]][casilla[1]+moverPos]="□ ";
						moverPos+=1;
				}else {
					if(casilla[1]+moverPos<tabSolucion.length) {
						tabOculto[casilla[0]][casilla[1]+moverPos]=tabSolucion[casilla[0]][casilla[1]+moverPos];
					}
					verificar=false;
					moverPos=0;
				}
			}while(verificar==true);
			verificar=true;
			
			
			//izquierda
			do {
				if(casilla[1]-moverPos>=0&&tabSolucion[casilla[0]][casilla[1]-moverPos].equals("- ")) {
						tabOculto[casilla[0]][casilla[1]-moverPos]="□ ";
						moverPos+=1;
				}else {
					if(casilla[1]-moverPos>=0) {
						tabOculto[casilla[0]][casilla[1]-moverPos]=tabSolucion[casilla[0]][casilla[1]-moverPos];
					}
					verificar=false;
					moverPos=0;
				}
			}while(verificar==true);	
			verificar=true;
			
			
			
			//diagonal izquierda abajo
			do {
				byte calc1=(byte) (casilla[0]+moverPos);
				byte calc2=(byte)(casilla[1]+moverPos);
				if(calc1<tabSolucion.length&&calc2<tabSolucion.length&&tabSolucion[casilla[0]+moverPos][casilla[1]+moverPos].equals("- ")) {
						tabOculto[casilla[0]+moverPos][casilla[1]+moverPos]="□ ";
						moverPos+=1;
				}else {
					if(casilla[0]+moverPos<tabSolucion.length&&casilla[1]+moverPos<tabSolucion.length) {
						tabOculto[casilla[0]+moverPos][casilla[1]+moverPos]=tabSolucion[casilla[0]+moverPos][casilla[1]+moverPos];
					}
					verificar=false;
					moverPos=0;
				}
			}while(verificar==true);
			verificar=true;

			
			//diagonal izquierda arriba
			do {
				if(casilla[0]-moverPos>=0&&casilla[1]+moverPos<tabSolucion.length&&tabSolucion[casilla[0]-moverPos][casilla[1]+moverPos].equals("- ")) {
						tabOculto[casilla[0]-moverPos][casilla[1]+moverPos]="□ ";
						moverPos+=1;
				}else {
					if(casilla[0]-moverPos>=0&&casilla[1]+moverPos<tabSolucion.length) {
						tabOculto[casilla[0]-moverPos][casilla[1]+moverPos]=tabSolucion[casilla[0]-moverPos][casilla[1]+moverPos];
					}
					verificar=false;
					moverPos=0;
				}
			}while(verificar==true);	
			verificar=true;
			
			//diagonal derecha abajo
			do {
				if(casilla[0]+moverPos<tabSolucion.length&&casilla[1]-moverPos>=0&&tabSolucion[casilla[0]+moverPos][casilla[1]-moverPos].equals("- ")) {
						tabOculto[casilla[0]+moverPos][casilla[1]-moverPos]="□ ";
						moverPos+=1;
				}else {
					if(casilla[0]+moverPos<tabSolucion.length&&casilla[1]-moverPos>=0) {
						tabOculto[casilla[0]+moverPos][casilla[1]-moverPos]=tabSolucion[casilla[0]+moverPos][casilla[1]-moverPos];
					}
					verificar=false;
					moverPos=0;
				}
			}while(verificar==true);
			verificar=true;
			
			//diagonal derecha arriba
			do {
				if(casilla[0]-moverPos>=0&&casilla[1]-moverPos>=0&&tabSolucion[casilla[0]-moverPos][casilla[1]-moverPos].equals("- ")) {
						tabOculto[casilla[0]-moverPos][casilla[1]-moverPos]="□ ";
						moverPos+=1;
				}else {
					if(casilla[0]-moverPos>=0&&casilla[1]-moverPos>=0) {
						tabOculto[casilla[0]-moverPos][casilla[1]-moverPos]=tabSolucion[casilla[0]-moverPos][casilla[1]-moverPos];
					}
					verificar=false;
					moverPos=0;
				}
			}while(verificar==true);
			
			
		}else {
			hayBomba=true;
		}
		return hayBomba;
	}
	
	
	
	public static void colocarBandera(String[][]tabOculto, byte[]casilla) {
		tabOculto[casilla[0]][casilla[1]]="🚩 ";
	}
	public static boolean comprobarResultado(String[][]tabSolucion, String[][]tabOculto) {
		boolean res=true;
		for (byte i=0;i<tabOculto.length;i++) {
			for (byte j=0;j<tabOculto.length;j++) {
				if(tabOculto[i][j].equals("🚩 ")) {
					if(!tabSolucion[i][j].equals("O ")) {
						res=false;
						return res;
					}
				}
			}
		}
		return res;
	}
}
