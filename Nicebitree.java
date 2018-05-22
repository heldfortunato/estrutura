import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader ler;
    private static PrintWriter escrever;

    public static void main(String[] args) throws IOException {
        ler = new BufferedReader(new InputStreamReader (System.in));
        escrever = new PrintWriter(System.out, true);
        
        int x = Integer.parseInt (ler.readLine());
        
        while (x-- > 0) {
            String str = ler.readLine();
            if (str.equals ("l")) {
                escrever.println (0);
                continue;
            }
            int d = 0, as = 0;
            boolean [] bl = new boolean [str.length()];
            bl [0] = true;
            for (char c : str.toCharArray()) {
                if (c == 'n') {
                    d++;
                    bl [d] = true;
                } else if (c == 'l') {
                    while (!bl [d])
                        d--;
                    bl [d] = false;
                }
                as = Math.max (as, d);
            }
            escrever.println (as);
        }
        escrever.close();
        System.exit(0);
    }
}