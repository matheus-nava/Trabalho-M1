/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_gerenciadorjanela;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrincipalController extends InterfaceUsuario {
    
    @FXML
    private TextField txtNome;

    public PrincipalController(){
        super("PrincipalFXML.fxml");
    }

    /** 
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void irParaMenu(ActionEvent evento){
        MenuController proximaTela = new MenuController();
        //proximaTela.setNomeUsuario( txtNome.getText() );
        GerenciadorJanela.obterInstancia().abreJanela(proximaTela);
    }
    
    @FXML
    public void irParaGrafico(ActionEvent evento){
        GraficoController proximaTela = new GraficoController();
        GerenciadorJanela.obterInstancia().abreJanela(proximaTela);
    }
    
}
