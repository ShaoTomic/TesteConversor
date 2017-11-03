/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import javax.swing.JOptionPane;

/**
 *
 * @author Denys Goncalves A
 */
public class StrategyValidacao implements ValidarCampo{
    
    public Arabico arabico = new Arabico();
    public Romano romano = new Romano();
    public int algArabico, numArabico, numeroRecebido;
    public String algRomano, mensagemErro, valorRecebido;
    Resposta resposta = new Resposta();
    
    @Override
    public Resposta seletor(String valorCampo, String opcao) {
        
        if ((valorCampo == null) && (valorCampo.isEmpty()))
        {
            mensagemErro = "Campo vazio!";
            JOptionPane.showMessageDialog(null,mensagemErro);
        } else {
            switch (opcao) {
                case "Arabico" : 
                    if (valorCampo.matches("^[IiVvXxLlCcDdMm]*$")){
                        valorCampo = valorCampo.toUpperCase();
                        algRomano = valorCampo;
                        numArabico = arabico.converterArabico(algRomano); //!!!
                        valorRecebido = String.valueOf(numArabico);
                        resposta.setConvertido(valorRecebido);
                        resposta.setEscolha(opcao);
                        return resposta;
                        //TO-DO Inserir resposta e uma forma de levar o valor até a pagina
                    } else {
                        mensagemErro = "Valor não compatível para converção em Arabico";
                        JOptionPane.showMessageDialog(null,mensagemErro);   
                    }
                break;
                
                case "Romano" :
                    if (valorCampo.matches("^[0-9]*$")) {
                        try {
                                algArabico = Integer.parseInt(valorCampo);
                            } catch (NumberFormatException e) {
                                mensagemErro= "Numero com formato errado!";
                                JOptionPane.showMessageDialog(null,mensagemErro);
                            }    
                        if ((algArabico < 1) && (algArabico > 3999)){
                            mensagemErro = "Intervalo de Números não aceito!";
                            JOptionPane.showMessageDialog(null,mensagemErro);
                        } else {
                            valorRecebido = romano.converterRomano(algArabico);
                            
                            //converter int para String
                            resposta.setConvertido(valorRecebido);
                            resposta.setEscolha(opcao);
                            return resposta;
                        }
                break;}
            }
        }
        return resposta;
    }
    
//Getters&Setters
    public Arabico getArabico() {
        return arabico;
    }

    public void setArabico(Arabico arabico) {
        this.arabico = arabico;
    }

    public Romano getRomano() {
        return romano;
    }

    public void setRomano(Romano romano) {
        this.romano = romano;
    }

    public int getAlgArabico() {
        return algArabico;
    }

    public void setAlgArabico(int algArabico) {
        this.algArabico = algArabico;
    }

    public String getAlgRomano() {
        return algRomano;
    }

    public void setAlgRomano(String algRomano) {
        this.algRomano = algRomano;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    public String getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(String valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }
    
}