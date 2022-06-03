package com.company;

import javafx.fxml.FXML;
import javafx.scene.control.*;
public class Controler {

    @FXML
    Button scan_button;

    @FXML
    TextArea result_area;

    @FXML
    TextArea text_area_1;

    @FXML
    TextArea text_area_2;

    @FXML
    void startCheck(){

        String arg1,arg2;
        arg1=text_area_1.getText();//.toString();
        arg2=text_area_2.getText();//.toString();
        System.out.println(arg1);
        System.out.println(arg2);
        result_area.setText("Вероятность плагиата - "+ ChekedFile.check(arg1,arg2));
        ChekedFile.check(arg1,arg2);
    }

    @FXML
    void initialize(){
        System.out.println("CodeAntiPlagiat window successful initialize");
    }
}