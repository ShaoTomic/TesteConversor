/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

/**
 * @author Denys Goncalves A
 */
public interface ValidarCampo {

    /**
     *
     * @param valorCampo: variável que recebe valor do campo texto da aplicação. 
     * @param opcao:variável que tem a opção de conversão escolhida.
     * @return retorna um objetvo contendo(mensagemErro, escolha, convertido)
     */
    public Resposta seletor(String valorCampo, String opcao);
}
