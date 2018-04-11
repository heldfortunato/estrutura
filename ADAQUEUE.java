import java.util.Scanner;

public class Main{
	static int fim = -1;
	static int incio=-1;
	static int fxo =1;
	static boolean reverso=false;
	public static void addNaCabeca(int[] posicao, int valor){
		if(incio == -1){
			fim=fxo;
			incio=fxo;
		}else{
			if(reverso){
				fim++;
			}else{
				fim--;
			}
		}
		posicao[fim]=valor;
	}
	public static void addNoFim(int[] posicao, int valor){
		if(incio == -1){
			fim=fxo;
			incio=fxo;
		}else{
			if(reverso){
				incio++;
			}else{
				incio--;
			}
		}
		posicao[incio]=valor;
	}
	public static void lerDoFim(int []posicao){
		if((reverso && incio > fim)||(!reverso && fim > incio)|| fim ==-1){
			System.out.println("No job for Ada?");
			return;
		}
		System.out.println(posicao[incio]);
		if(reverso){
			incio++;
		}else{
			incio--;
		}
	}
	public static void lerDoInicio(int [] posicao){
		if((reverso && incio > fim)||(!reverso && fim > incio)|| fim ==-1){
			System.out.println("No job for Ada?");
			return;
		}
		
		System.out.println(posicao[fim]);
		if(reverso){
			fim++;
		}else{
			fim--;
		}
	}
	public static void main(String[]args){
		Scanner ir = new Scanner(System.in);
		int nq= ir.nextInt();
		int [] posicao = new int[22222];
		for(int i=0; i < nq ; i++){
			String il= ir.nextLine();
			String [] inputs = il.split(" ");
			if(inputs.length == 1){
				if("front".equals(inputs[0])){
					lerDoFim(posicao);
				}else{
					int temp = fim;
					fim = incio;
					incio = temp;
					reverso = !reverso;
				}
			}else{
				int valor = Integer.valueOf(inputs[1]);
				if("toFront".equals(inputs[0])){
					addNaCabeca(posicao,valor);
				}else if("push_back".equals(inputs[0])){
					addNoFim(posicao,valor);
				}
			}
		}
	}
}