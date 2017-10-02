/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_gerenciadorjanela;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MenuController extends InterfaceUsuario{
    
    public MenuController(){
        super("MenuFXML.fxml");
    }
    
    @FXML
    private Label lblAviso;
    
    @FXML
    private TableView<Avaliacao> tabela;
    
    @FXML
    private TableColumn<Avaliacao, String> nome;
    
    @FXML
    private TableColumn<Avaliacao, String> disciplina;
            
    @FXML
    private TableColumn<Avaliacao, Double> peso;
    
    @FXML
    private TableColumn<Avaliacao, String> media;
    
    @FXML
    private TableColumn<Avaliacao, Double> nota;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome.setCellValueFactory(new PropertyValueFactory("nome"));
        disciplina.setCellValueFactory(new PropertyValueFactory("disciplina"));
        peso.setCellValueFactory(new PropertyValueFactory("peso"));
        media.setCellValueFactory(new PropertyValueFactory("media"));
        nota.setCellValueFactory(new PropertyValueFactory("nota"));
        
        Avaliacao a = new Avaliacao();
        
        tabela.setItems(obsList(a.getLista()));
    }
    
    private ObservableList<Avaliacao> obsList(ArrayList<Avaliacao> aList){        
        return FXCollections.observableArrayList(aList);
    }
        
    @FXML
    public void irParaTelaInfo(ActionEvent evento ){
        InfoController proximaTela = new InfoController();
        GerenciadorJanela.obterInstancia().abreJanela(proximaTela);
    }
    
    @FXML
    public void voltar(ActionEvent evento ){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    @FXML
    public void irParaInfoNota(ActionEvent evento ){
        Avaliacao a = tabela.getSelectionModel().getSelectedItem();
        if(a != null){
            /*InfoNotaController proximaTela = new InfoNotaController();
            ArrayList<Avaliacao> aList = a.getLista();
            int i = 0;
            while(true){
                if(a.getNome().equals(aList.get(i).getNome()) && a.getDisciplina().equals(aList.get(i).getDisciplina()) 
                         && a.getMedia().equals(aList.get(i).getMedia()) && a.getPeso() == aList.get(i).getPeso()){
                    proximaTela.setIndex(i);
                    break;
                }
                i++;
            }*/
            lblAviso.setText("");
            InfoNotaController proximaTela = new InfoNotaController();
            proximaTela.setA(a);
            GerenciadorJanela.obterInstancia().abreJanela(proximaTela);
        }
        else{
           lblAviso.setText("Selecione algum item");
        }
    }
}
