/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_gerenciadorjanela;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class InfoController extends InterfaceUsuario{

    public InfoController() {
        super("InfoFXML.fxml");
    }

    @FXML
    private TextField txtNome;
    
    @FXML 
    private TextField txtPeso;
    
    @FXML
    private ComboBox <String> spinnerDis;
    
    @FXML
    private ComboBox <String> spinnerMed;
    
   private ObservableList<String> listaMedia = FXCollections.observableArrayList("M1", "M2", "M3");
    
   private ObservableList<String> listaDisciplina = FXCollections.observableArrayList("PROGRAMÇÃO ORIENTADA OBJETOS 2",
   "CIRCUITOS DIGITAIS",
   "INTRODUÇÃO Á FÍSICA",
   "FÍSICA GERAL",
   "FÍSICA 3",
   "ÓPTICA E FÍSICA PARA SEMICONDUTORES",
   "QUIMICA",
   "QUIMICA 2",
   "INTRODUÇÃO AO CALCULO",
   "CALCULO 1",
   "CALCULO 2",
   "CALCULO 3",
   "CALCULO NUMÉRICO");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spinnerDis.setItems(listaDisciplina);
        spinnerMed.setItems(listaMedia);
    }
    
    @FXML
    public void voltar(ActionEvent evento ){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    @FXML
    public void salvar(ActionEvent evento ) {
        try{
            Avaliacao a = new Avaliacao(txtNome.getText(), spinnerDis.getValue(), Double.parseDouble(txtPeso.getText()), spinnerMed.getValue());
            a.newSave(a);
            GerenciadorJanela.obterInstancia().voltarEcarregar();
        }catch(IOException e){
            //System.out.println("Erro: ".e);
            e.printStackTrace();
        }
    }
}
