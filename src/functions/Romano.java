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
        int vlrMaior, vlrMedio, vlrMenor;
        int contDigitos;
        
        //Por acreditar que tem algo de errado misturar log10 com pow então
        
        int numDigitos = Integer.toString(algarismoAlgebrico).length();

        contDigitos = 1; //Não da pra alterar a lógica de potencia por contador de digitos
        // log10 para pegar os digitos, o Casting é porque o valor é Double
        int quociente, potencia; int resto;

        
        i=0;
        while(i <= numDigitos && algarismoAlgebrico !=0){ 
    
            potencia = (int) Math.pow(10, contDigitos);

            resto = algarismoAlgebrico%potencia;
            //reinicia a lista depois de ter sido percorrida
            iLista = lista.size()-1;
            boolean sairLista = false;
            //Varre a lista com algoritmos romanos para comparar
            int j=0;
            while(iLista>j && sairLista == false ){ // se não for igual não está saindo do looping, adicionar pra ver o que acontece
               
                algMaior = lista.get(j+2).literalRomano.charAt(0);
                algMedio = lista.get(j+1).literalRomano.charAt(0);
                algMenor = lista.get(j).literalRomano.charAt(0);
                vlrMaior = lista.get(j+2).valorCorrespondente;
                vlrMedio = lista.get(j+1).valorCorrespondente;
                vlrMenor = lista.get(j).valorCorrespondente;
            
                if(resto==0 && resto!= vlrMaior){
                    sairLista=true; 
                }else if(resto <= vlrMedio-(2*vlrMenor)){
                    //Trata de ex: (1 a 3)
                    quociente = resto/vlrMenor;
                    adicionarRepetidos(quociente, algMenor);
                    sairLista=true;
                } else if(resto > vlrMedio & 
                    resto < vlrMaior-vlrMenor){
                    //Trata de ex: (6 a 8)
                    quociente = (resto-vlrMedio)/vlrMenor;
                    adicionarRepetidos(quociente, algMenor);
                    sb.append(algMedio);
                    sairLista=true;
                } else if (resto == vlrMedio-vlrMenor){
                    //Trata de ex:4
                    sb.append(algMedio);
                    sb.append(algMenor);
                    sairLista=true;
                } else if (resto == vlrMedio){
                    //Trata de ex:5
                    sb.append(algMedio);
                    sairLista=true;
                } else if(resto == (vlrMaior-vlrMenor)) {
                    //Trata de ex: 9
                    sb.append(algMaior);
                    sb.append(algMenor);
                    sairLista=true;
                } else if(resto == vlrMaior){
                    //Trata de ex: 10
                    sb.append(algMaior);
                    i+=2;
                    sairLista=true;
                } else if (j+2==iLista){
                    //como não tem casal do milhar completa é uma alternativa
                    quociente = algarismoAlgebrico/vlrMaior;
                    adicionarRepetidos(quociente, algMaior);
                }
                //iLista = iLista + 2; se quem é o iterador é o J não tem porque mexer no iLista
                j+=2; // Caso não combine com nenhum valor desta casa decimal
            }   
            i++;    contDigitos++; 
            algarismoAlgebrico -= resto;//Testar pra ver se é isso mesmo
        }  
        romanoConvertido = sb.reverse().toString();
        
        return romanoConvertido;
    }
}
