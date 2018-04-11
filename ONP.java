import java.util.Scanner;
import java.util.Stack;

public class Main{
	public static void main(String [] args){
		Scanner sc = new Scanner (System.in);
		String st= new String();
		int count = sc.nextInt();
		
		while(count > 0){
			st=sc.next();
			Stack strk= new Stack();
			String rp = new String();
			int tam = st.length();
			char cr;
			for(int i=0;i<tam; i++){
				cr= st.charAt(i);
				if(cr=='+'|| cr=='-'|| cr=='*'||cr=='/'||cr=='^'){
					strk.add(cr);
				}else if(cr==')'){
					rp= rp + strk.pop();
				}else if(cr=='('){
					continue;
				}else{
					rp= rp+cr;
				}
			}
			System.out.println(rp);
			count--;
		}
	}
}
