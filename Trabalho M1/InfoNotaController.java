/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_gerenciadorjanela;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.JSONObject;

public class InfoNotaController extends InterfaceUsuario{
    
    private Avaliacao a;
    
    @FXML
    private TextField nota;
    
    @FXML
    private Label nomeTxt;
            
    @FXML
    private Label disciplinaTxt;
            
    @FXML
    private Label mediaTxt;

    public InfoNotaController() {
        super("InfoNotaFXML.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nomeTxt.setText("Nome: " + this.a.getNome());
        disciplinaTxt.setText("Disciplina: " + this.a.getDisciplina());
        mediaTxt.setText("Média: " + this.a.getMedia());
    }
    
    @FXML
    public void voltar(ActionEvent evento ){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    @FXML
    public void voltarMenu(ActionEvent evento ){
        GerenciadorJanela.obterInstancia().voltar(2);
    }
    
    @FXML
    public void salvar(ActionEvent evento) throws FileNotFoundException, IOException{
        String notaS = nota.getText();
        try{
            double notaD = Double.parseDouble(notaS);
            Avaliacao a = new Avaliacao();
            ArrayList<Avaliacao> aList = a.getLista();
            File f = new File("itens.txt");
            BufferedReader bf = new BufferedReader(new FileReader(f));
            String str;
            String newS = "";
            int i = 0;
            while((str = bf.readLine()) != null){
                if(this.a.getNome().equals(aList.get(i).getNome()) && this.a.getDisciplina().equals(aList.get(i).getDisciplina()) 
                         && this.a.getMedia().equals(aList.get(i).getMedia()) && this.a.getPeso() == aList.get(i).getPeso()){
                    JSONObject obj = new JSONObject(str);
                    a = new Avaliacao(obj.getString("nome"), obj.getString("disciplina"), obj.getDouble("peso"), obj.getString("media"), notaD);
                    newS += a.passToJSON(a)+"\n";
                }
                else{
                    newS += str+"\n";
                }
                i++;
            }
            reescrever(newS, f);
            GerenciadorJanela.obterInstancia().voltarEcarregar();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void reescrever(String newS, File f){
        try{
            FileWriter fw = new FileWriter(f);
            fw.write(newS);

            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setA(Avaliacao a) {
        this.a = a;
    }
}
