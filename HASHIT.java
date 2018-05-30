import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;

class HASHIT{
	static String hash[];
	static int hashTam=0;
	
	static int h(String chave){
		int h=0, n=chave.length();
		for(int i =0;i<n;i++){
			h+=(((int)chave.charAt(i))*(i+1));
		}
		return 19*h;
	}
	static int Hash(String chave){
		return  h(chave)%101;
		//retornar a chave hash.
	}
	static int procurar(String chave){
		int edr=-1;
		for(int i=0; i<101;i++){
			if(hash[i]!=null && hash[i].equals(chave)){
				edr=i;
				break;
			}
		}
		return edr;
		// faz uma pesquisa na tabela hash.
	}
	static void adicionar(String chave){
	int edr=procurar(chave);
    int j,chaveHash=Hash(chave);
    if(edr==-1){
        for(j=0;j<20;j++){
            edr=(chaveHash+j*(j+23)) % 101;
            if(hash[edr]==null){
                hash[edr]=chave;
                hashTam++;
                break;
                }
            }
        }
	//adiciona na tabela hash
    }

    static void remover(String chave){
        int edr=procurar(chave);
        if(edr!=-1){
            hash[edr]=null;
            hashTam--;
        }
	//remove da tabela hash;
    }
	public static void main(String [] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine().trim());
        int n;
        String linha,chave,op,pdz[];
        while(t-->0){
            hash=new String[101];
            hashTam=0;
            n=Integer.parseInt(br.readLine().trim());
            while(n-->0){
                linha=br.readLine().trim();
                pdz=linha.split(":");
                if(pdz[0].equals("ADD")){
                    adicionar(pdz[1]);
                }else{
                    remover(pdz[1]);
                }
            }
            System.out.println(hashTam);
            for(int i=0;i<101;i++){
                if(hash[i]!=null){
                    System.out.println(i+":"+hash[i]);
                }
            }
        }
	}
}
			