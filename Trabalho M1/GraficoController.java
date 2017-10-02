
package java_gerenciadorjanela;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;

public class GraficoController extends InterfaceUsuario{
    
    @FXML
    private BarChart grafico;
    
    @FXML
    private ComboBox <String> spinnerDis;

    public GraficoController() {
        super("GraficoFXML.fxml");
    }

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
    }
    
    @FXML
    public void voltar(ActionEvent evento){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    @FXML
    public void consultar(ActionEvent evento){
        Avaliacao a = new Avaliacao();
        ArrayList<Avaliacao> aList = a.getLista();
        ArrayList <XYChart.Series> mList = new ArrayList<>();
        
        String dis = spinnerDis.getValue();
        
        for(int i = 0; i < aList.size(); i++){
            if(aList.get(i).getDisciplina().equals(dis)){
                mList.add(getDataGrafic(aList, i));
            }
        }
        
        CategoryAxis xAxis = new CategoryAxis();      
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Disciplina");
        yAxis.setLabel("Minha Nota");
        
        for(int i = 0; i < mList.size(); i++){
            grafico.getData().add(mList.get(i));
        }
    }
    
    private XYChart.Series getDataGrafic(ArrayList<Avaliacao> aList, int i){
        XYChart.Series materia = new XYChart.Series();
        materia.setName(aList.get(i).getNome());
        materia.getData().add(new XYChart.Data(aList.get(i).getMedia(), aList.get(i).getNota()));
        
        return materia;
    }
}
