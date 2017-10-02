package java_gerenciadorjanela;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONObject;

public class Avaliacao {
    
    private String nome;
    private String disciplina;
    private double peso;
    private String media;
    private double nota;
    
    public Avaliacao(){
        
    }
    
    public Avaliacao(String nome, String disciplina, double peso, String media){
        this.nome = nome;
        this.disciplina = disciplina;
        this.peso = peso;
        this.media = media;
    }
    
    public Avaliacao(String nome, String disciplina, double peso, String media, double nota){
        this.nome = nome;
        this.disciplina = disciplina;
        this.peso = peso;
        this.media = media;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public double getPeso() {
        return peso;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    } 
    
    public String passToJSON(Avaliacao a){
        String s;
        
        s = "{\"nome\":\""+a.getNome()+"\","
                + "\"disciplina\":\""+a.getDisciplina()+"\","
                + "\"peso\":"+a.getPeso()+","
                + "\"media\":\""+a.getMedia()+"\","
                + "\"nota\":"+a.getNota()+"}";
        
        return s;
    }
    
    public void newSave(Avaliacao a) throws IOException{
        try{
            File f = new File("itens.txt");
            FileWriter fw = new FileWriter(f, true);
            fw.write(passToJSON(a)+"\n");

            fw.close();
        }catch(Exception e){
            System.out.println("Erro: "+e);
        }
    }
    
    public ArrayList<Avaliacao> getLista() {
        ArrayList<Avaliacao> aList = new ArrayList<>();
        
        try{
            File f = new File("itens.txt");
            BufferedReader bf = new BufferedReader(new FileReader(f));
            String str;
            while((str = bf.readLine()) != null){
                JSONObject obj = new JSONObject(str);
                Avaliacao a = new Avaliacao(obj.getString("nome"), obj.getString("disciplina"), obj.getDouble("peso"), obj.getString("media"), obj.getDouble("nota"));
                aList.add(a);
            }
        }catch(Exception e){
            
        }
        
        return aList;
    }
}
