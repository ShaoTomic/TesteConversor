/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

/**
 *
 * @author Duo_R
 */
public class ChaveValor {
        String literalRomano;
        int valorCorrespondente;
        
        public ChaveValor(String literalRomano, int valorCorrespondente) {
        this.literalRomano = literalRomano;
        this.valorCorrespondente = valorCorrespondente;
       }

        public String getLiteralRomano() {
            return literalRomano;
        }

        public void setLiteralRomano(String literalRomano) {
            this.literalRomano = literalRomano;
        }

        public int getValorCorrespondente() {
            return valorCorrespondente;
        }

        public void setValorCorrespondente(int valorCorrespondente) {
            this.valorCorrespondente = valorCorrespondente;
        }
}
