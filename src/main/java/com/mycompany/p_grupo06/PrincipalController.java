/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.p_grupo06;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author kathe
 */
public class PrincipalController implements Initializable {

    @FXML
    private Button btnIniciar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Iniciar(MouseEvent event) throws IOException {
        App.setRoot("primaryy");
        //System.out.println("Ir a la ventana de ingresar el número de preguntas");
        
    }

    @FXML
    private void Salir(MouseEvent event) {
        Platform.exit();
    }
    
}
