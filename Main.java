package atividadesStrutura;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	static Scanner leitor;
	static int i,ii,sS,sQ;
	static ArrayList<Integer> s,q,c;
	static Boolean f;
	/**
	 * 
	 * Variaveis estaticas : listas, inteiros e booleans;
	 */
	public static void main(String []args){
		leitor = new Scanner ( System.in);
		/**
		 * inicializa��o do leitor;
		 */
		sS = leitor.nextInt();
		s = new ArrayList<Integer>();
		for( i =0; i < sS ; i++){
			s.add(leitor.nextInt());
		}
		/**
		 * Segmento para primeira entrada s;
		 */
		sQ = leitor.nextInt();
		q = new ArrayList<Integer>();
		for( i =0; i < sQ ; i++){
			q.add(leitor.nextInt());
		}
		/**
		 * segmento para segunda entrada q;
		 */
		c= new ArrayList<Integer>();
		for(i =0; i < sS ; i++){
			ii=0;
			f = true;
			while(ii < sQ ){
				if(s.get(i).equals(q.get(ii))){
					f= false;
					break;
				}
				ii++;
			}				
			if(f){
				c.add(s.get(i));
			}
			/**
			 * teste de verifica��o de valores iguais. buscar solu��o para esse if no while e retirar o boolean; e o segundo if
			 */
		}
		for(i = 0 ; i < c.size() ; i++){
	        System.out.println(c.get(i));
		}
	}
}