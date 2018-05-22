import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {
	static Scanner ler;
	static PrintWriter escrever;
	static int [] tree;
	static int n,cr;
	static long m;
	public static void main(String [] args) throws IOException{
		ler = new Scanner(System.in);
		escrever = new PrintWriter(System.out, true);
		n=ler.nextInt();
		TreeSet<Integer> set = new TreeSet<Integer>();
		m=0;
		tree = new int [n+1];
		for ( int i=0; i < n; i++){
			cr = ler.nextInt();
			Integer up = set.higher (cr);
			Integer lw = set.lower (cr);
			if (up == null) up = n;
			if (lw == null) lw = 1;
			m += query (cr);
			update (up + 1, -1);
			update (lw, 1);
			set.add (cr);
			escrever.println (m);
		}
		escrever.close();
		System.exit(0);
	}
	private static int query (int pos) {
		int sum = 0;
		for (int i = pos; i > 0; i -= (i & -i)){
			sum += tree [i];
		}
		return sum;
	}
	private static void update (int pos, int val) {
		for (int i = pos; i < tree.length; i += (i & -i)){
			tree [i] += val;
		}
	}
}
		