import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	static int preIndc = 0,inIndc = 0, posIndc = 0;
    static boolean t = true;
    static ABinaria arv;
    static String pre[],pos[], in[];
    
    static class No{
        private int dado;
        private No esq,dir;

        public No(int c){
          this.dado = c;
        }

        public int getdado(){
          return dado;
        }
        
        public void setdado(int c){
          dado = c;
        }

        public No getEsq(){
          return esq;
        }

        public void setEsq(No e){
          esq = e;
        }
        public No getdir(){
          return dir;
        }
        public void setdir(No d){
          dir = d;
        }
        
    }
    
    static class ABinaria {
        No raiz;

        public ABinaria(){
          raiz = null;
        }

        public void setRaiz(No r){
          raiz = r;
        }
        public No busca(int valor){
          return busca(raiz,valor);
        }
        private No busca(No n, int valor){
          if(n == null){
            return null;
		  }

          if(n.getdado() == valor){
            return n;
		  }

          No aux = busca(n.getEsq(), valor);
          if (aux == null){
            aux = busca(n.getdir(), valor);
		  }

          return aux;
        }
        private void preOrdem(No n){
          if (n == null){
            return;
		  }

          if(n.getEsq() != null){
            preOrdem(n.getEsq());
		  }

          if(n.getdir() != null){
            preOrdem(n.getdir());
		  }
        }
        private void inOrdem(No n){
          if (n == null || !t){
            return;
		  }

          if(n.getEsq() != null){
            inOrdem(n.getEsq());
		  }

          if( n.getdado() != Integer.parseInt(in[inIndc++]) ){
            t = false;
            return;
          }

          if(n.getdir() != null){
            inOrdem(n.getdir());
		  }
        }
        private void posOrdem(No n){
          if (n == null || !t){
            return;
		  }

          if(n.getEsq() != null){
            posOrdem(n.getEsq());
		  }

          if(n.getdir() != null){
            posOrdem(n.getdir());
		  }

          if(n.getdado() != Integer.parseInt(pos[posIndc++])){
            t = false;
          }

        }

    }
    static No BuildA(int begin, int end){

        if(begin > end){
          return null;
		}
        
        int raiz = Integer.parseInt(pre[preIndc++]);
		
        No no = new No(raiz);
		
        if(begin == end){
          return no;
        }
        
        int indece = 0;

        for (int i = begin; i <= end ; i++) {
          if(Integer.parseInt(in[i]) == raiz)
            indece = i;
        }
        No esq = BuildA(begin, indece - 1);
        if(esq != null){
          no.setEsq(esq);
		}
	  
        No dir = BuildA(indece + 1, end);
        if(dir != null){
          no.setdir(dir);
		}
        return no;
    }
    
    
    
    
    public static void main(String[] args) throws IOException {
            int nElement;
            BufferedReader leitor;
            leitor = new BufferedReader(new InputStreamReader(System.in));
            nElement = Integer.parseInt(leitor.readLine());

            pre = new String[nElement];
            pos = new String[nElement]; 
            in = new String[nElement]; 

            String st = leitor.readLine();
            pre = st.split(" ");

            st = leitor.readLine();
            pos = st.split(" ");

            st = leitor.readLine();
            in = st.split(" ");

            if(Integer.parseInt(pre[0]) != Integer.parseInt(pos[nElement-1])){
                System.out.println("no");
                return;
             }
            if((pre.length != pos.length) || (pre.length != in.length) || (in.length != pos.length)){
                System.out.println("no");
                return;
            }

            arv = new ABinaria();
            No raiz = BuildA(0, nElement - 1);
            arv.setRaiz(raiz);
            arv.preOrdem(raiz);
            arv.inOrdem(raiz);
            arv.posOrdem(raiz);

            if(t){
                System.out.println("yes");
            }else{
                System.out.println("no");
			}
    }
    
}