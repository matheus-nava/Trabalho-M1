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
    
   private ObservableList<String> listaDisciplina = FXCollections.observableArrayList(
                "Ética Em Informática",
                "Matemática Computacional",
                "Algoritmos E Programação 1",
                "Álgebra 1",
                "Introdução Ao Cálculo",
                "Iniciação Técnico-Científica",
                "Introdução À Engenharia De Computação",
                "Introdução À Física",
                "Cálculo 1",
                "Algoritmos E Programação 2",
                "Circuitos Digitais",
                "Desenho Técnico",
                "Física Geral",
                "Álgebra 2",
                "Cálculo 2",
                "Estruturas De Dados",
                "Programação Orientada A Objetos 1",
                "Arquitetura De Computadores 1",
                "Física",
                "Química 1",
                "Arquitetura De Computadores 2",
                "Programação Orientada A Objetos 2",
                "Cálculo 3",
                "Análise De Circuitos Elétricos",
                "Química 2",
                "Ótica E Física Para Semicondutores",
                "Resistência Dos Materiais",
                "Banco De Dados",
                "Sistemas Operacionais",
                "Matemática Aplicada À Engenharia",
                "Engenharia De Software 1",
                "Probabilidade E Estatística",
                "Eletrônica Básica",
                "Interface Humano - Computador",
                "Engenharia De Software 2",
                "Redes De Computadores 1",
                "Cálculo Numerico",
                "Linguagens Formais",
                "Eletrônica Aplicada",
                "Análise E Controle De Processos",
                "Engenharia Econômica",
                "Redes De Computadores 2",
                "Grafos",
                "Controle Lógico De Sistemas",
                "Microcontroladores",
                "Projeto De Sistemas Digitais",
                "Inteligência Artificial",
                "Projeto De Sistemas Embarcados",
                "Sistemas Em Tempo Real",
                "Comunicação Digital",
                "Processador Digital De Sinais",
                "Sistemas Robóticos",
                "Simulação Discreta",
                "Gerência De Projetos",
                "Tópicos Especiais Em Engenharia De Computação",
                "Tópicos Especiais Em Hardware",
                "Administração De Negócios De Base Tecnológica",
                "Tóp. Especiais Em Integração Software Hardware",
                "Sistemas Distribuídos ");

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
