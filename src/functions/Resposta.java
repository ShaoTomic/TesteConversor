/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

/**
 *
 * @author Denys Goncalves A
 */
public class Resposta {
    
    
    String escolha;
    String convertido;

    public Resposta(String escolha, String convertido) {
        this.escolha = escolha;
        this.convertido = convertido;
    }
    
    public Resposta (){  
    }
    
    public String getEscolha() {
        return escolha;
    }

    public void setEscolha(String escolha) {
        this.escolha = escolha;
    }

    public String getConvertido() {
        return convertido;
    }

    public void setConvertido(String convertido) {
        this.convertido = convertido;
    }
}
