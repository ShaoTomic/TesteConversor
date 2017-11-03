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
public class Romano implements ConverterRomano{
    
    String romanoConvertido;
    StringBuilder sb = new StringBuilder();
    
    ArrayList<ChaveValor> lista = new ArrayList<>();
     public void adicionarValores(){
        lista.add(new ChaveValor("I", 1));
        lista.add(new ChaveValor("V", 5));
        lista.add(new ChaveValor("X", 10));
        lista.add(new ChaveValor("L", 50));
        lista.add(new ChaveValor("C", 100));
        lista.add(new ChaveValor("D", 500));
        lista.add(new ChaveValor("M", 1000));
    }

    private void adicionarRepetidos(int contador,char caracterRomano){
        for (int i = contador; i>0 ; i--) {
                        sb.append(caracterRomano);
                    }
    }

    @Override
    public String converterRomano(int algarismoAlgebrico) {
        adicionarValores();
        int iLista = 2, i;
        
        //Letra
        char algMaior,algMedio, algMenor; 
        //Numero
        int vlrMaior, vlrMedio, vlrMenor, contDigitos;

        int numDigitos = (int) Math.log10(algarismoAlgebrico)+1;
        contDigitos = numDigitos;
        // log10 para pegar os digitos, o Casting é porque o valor é Double
        int quociente;
        int potencia; 
        
        
        i=0;
        while(i < numDigitos){ 
            potencia = (int) Math.pow(10, numDigitos);
            
            int resto = algarismoAlgebrico%contDigitos;
            //reinicia a lista depois de ter sido percorrida
            iLista = lista.size()-1;
            
            //Varre a lista com algoritmos romanos para comparar
            int j=0;
            while(iLista>j){
                algMaior = lista.get(j+2).literalRomano.charAt(0);
                algMedio = lista.get(j+1).literalRomano.charAt(0);
                algMenor = lista.get(j).literalRomano.charAt(0);
                vlrMaior = lista.get(j+2).valorCorrespondente;
                vlrMedio = lista.get(j+1).valorCorrespondente;
                vlrMenor = lista.get(j).valorCorrespondente;
            
                if(resto <= vlrMedio-(2*vlrMenor)){
                    //Trata de ex: (1 a 3)
                    quociente = resto/vlrMenor;
                    adicionarRepetidos(quociente, algMenor);
                    iLista= j;
                } else if(resto > vlrMedio & 
                    resto < vlrMaior-vlrMenor){
                    //Trata de ex: (6 a 8)
                    quociente = (resto-vlrMedio)/vlrMenor;
                    adicionarRepetidos(quociente, algMenor);
                    sb.append(algMedio);
                    iLista= j;
                } else if (resto == vlrMedio-vlrMenor){
                    //Trata de ex:4
                    sb.append(algMedio);
                    sb.append(algMenor);
                    iLista= j;
                } else if (resto == vlrMedio){
                    //Trata de ex:5
                    sb.append(algMedio);
                    iLista= j;
                } else if(resto == (vlrMaior-vlrMenor)) {
                    //Trata de ex: 9
                    sb.append(algMaior);
                    sb.append(algMenor);
                    iLista= j;
                } else if(resto == vlrMaior){
                    //Trata de ex: 10
                    sb.append(algMaior);
                    i++;
                    iLista= j;
                }
                //iLista = iLista + 2;//Se vai ao contrário então é descrescente?
                j=+2;
            }   
            i++;    contDigitos++;
        }  
        romanoConvertido = sb.reverse().toString();
        
        return romanoConvertido;
    }
}
