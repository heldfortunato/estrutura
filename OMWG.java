import java.io.*;
import java.util.*;
import java.*;


public class Main{
	static BufferedReader ler;
	static PrintWriter escrever;
	static int tc;
	public static void main(String [] args) throws IOException{
		ler = new BufferedReader(new InputStreamReader (System.in));
		escrever = new PrintWriter(System.out, true);
		tc = Integer.parseInt(ler.readLine());
		for(int i=0; i<tc;i++){
			String [] n = ler.readLine().split(" ");
			int n1 = Integer.parseInt(n[0]);
			int n2 = Integer.parseInt(n[1]);
			escrever.println(solution(n1,n2));
		}
	}
	static int solution(int n1, int n2) {
		int newN1 = n1+ 2;
		int newN2 = n2 + 2;
		int[][] matrix = new int[newN1][newN2];
		int acc = 0;
		for (int i = 1; i < newN1 - 1; i++) {
			for (int j = 1; j < newN2 - 1; j++) {
				int left = matrix[i][j - 1];
				int right = matrix[i][j + 1];
				int up = matrix[i + 1][j];
				int down = matrix[i - 1][j];
				matrix[i][j] = 1;
				acc = acc + left + right + up + down;
			}
		} 
		return acc;
	}
}