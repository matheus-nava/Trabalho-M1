
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
