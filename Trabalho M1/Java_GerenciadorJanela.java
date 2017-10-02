/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_gerenciadorjanela;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author marcelo
 */
public class Java_GerenciadorJanela extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {
        PrincipalController primeiraTela = new PrincipalController();
        GerenciadorJanela.obterInstancia().inicializaPalco(primaryStage, primeiraTela);
    } 
}
