/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import java.util.ArrayList;

/**
 *
 * @author Denys Goncalves A
 */
public class Arabico implements ConverterArabico{
    ArrayList<ChaveValor> lista = new ArrayList<>();
    int contList[];
    
    public void adicionarValores(){
        lista.add(new ChaveValor("I", 1));
        lista.add(new ChaveValor("V", 5));
        lista.add(new ChaveValor("X", 10));
        lista.add(new ChaveValor("L", 50));
        lista.add(new ChaveValor("C", 100));
        lista.add(new ChaveValor("D", 500));
        lista.add(new ChaveValor("M", 1000));
    }

    int algarismoConvertido, iLista;
    String mensagemErro;
    
   
 
    private String filtrarRomano(int tamanhoString, String algarismoRomano ){
        adicionarValores();
        ;
        
        contList = new int[lista.size()];
        
        for (int i = 0; i < tamanhoString; i++) {
            
            char ch, comparador;
            ch = algarismoRomano.charAt(i);
            
            //Varrer a lista de possiveis algarismos romanos
            int cont=0;
            iLista = lista.size()- 1; 
            while(cont<lista.size()){
                comparador = lista.get(iLista).literalRomano.charAt(0);
                if(comparador == ch){ //!!!            
                    contList[iLista] ++;
                } 
                iLista--;
                cont++;
            }    
        }        
        //Conferir os contadores para ver se algum estouro
        for(int j=0;j<contList.length;j++){
            //if(contList[j]==0){
            if(j==0){
                if(contList[j]>3)
                {
                    mensagemErro="Estourou";
                    return mensagemErro;
                }
            } else if(j%2==0){
                    if(contList[j]>4){
                        mensagemErro="Estourou";
                        return mensagemErro;
                    }
            } else {
                if(contList[j]>1){
                    mensagemErro="Estourou";
                    return mensagemErro;
                }
            }
        }
        return"OK";    
    }
    
    @Override
    public int converterArabico(String algarismoRomano) {

        int compString = algarismoRomano.length();
        String resFiltro;
        resFiltro = filtrarRomano(compString, algarismoRomano);
        if (!"OK".equals(resFiltro)){
            return 0;
        }
        //Letra
        char algMaior,algMedio, algMenor; 
        //Numero
        int vlrMaior, vlrMedio, vlrMenor;
        
        //enquanto contador é menor que comprimento da String
        int i=0;
        while(i < compString ){
            char ch;
            ch = algarismoRomano.charAt(i);
            
            //reinicia a lista depois de ter sido percorrida
            iLista = lista.size()-1;
  
            //Varre a lista com algoritmos romanos para comparar
            int j=0;
            while(j<=iLista){

                //Letra
                algMaior = lista.get(iLista).literalRomano.charAt(0); 
                algMedio = lista.get(iLista-1).literalRomano.charAt(0);
                algMenor = lista.get(iLista-2).literalRomano.charAt(0);
                //Numero
                vlrMaior = lista.get(iLista).valorCorrespondente;
                vlrMedio = lista.get(iLista-1).valorCorrespondente;
                vlrMenor = lista.get(iLista-2).valorCorrespondente;
                            
                if(algMenor == ch){
                    if(i+1==compString/* || iLista==2*/){
                        algarismoConvertido += vlrMenor;
                        j=iLista;//Testa para fim de algarismo
                        i++;
                    }else{
                        if(algMedio == algarismoRomano.charAt(i+1)){
                            algarismoConvertido += (vlrMedio-vlrMenor);
                            i+=2; //Adiciona + 2 porque resolve 2 algarismos.
                            j=iLista;
                        }else if(algMaior == algarismoRomano.charAt(i+1)){
                            algarismoConvertido += (vlrMaior-vlrMenor);
                            i+=2; //Adiciona + 2 porque resolve 2 algarismos.
                            j=iLista;
                        }else{
                            algarismoConvertido += vlrMenor;
                            i++;
                            j=iLista;
                        }
                    }
                } else if (algMedio == ch){
                    algarismoConvertido += vlrMedio;
                    i++;
                    j=iLista;
                }else if (algMaior == ch){  
                    algarismoConvertido += vlrMaior;
                    j=iLista;
                    i++;  
                }
                iLista = iLista - 2;
                j++;
            }
            //i++; incrementar assim que computa e soma é melhor;
        }
        return algarismoConvertido;
    }   
}