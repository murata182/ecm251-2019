package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.BasicCalculator;


public class Controller {
    @FXML
    private TextField txtValue1;
    @FXML
    private TextField txtValue2;
    @FXML
    private Label lblRes;
    @FXML
    public void sum(){
        BasicCalculator casio = new BasicCalculator();
        lblRes.setText("" + casio.getAdd(txtValue1.getText(), txtValue2.getText()));
    }
    @FXML
    public void sub(){
        BasicCalculator casio = new BasicCalculator();
        lblRes.setText("" + casio.getSub(txtValue1.getText(), txtValue2.getText()));
    }
    @FXML
    public void mult(){
        BasicCalculator casio = new BasicCalculator();
        lblRes.setText("" + casio.getMult(txtValue1.getText(), txtValue2.getText()));
    }
    @FXML
    public void div(){
        BasicCalculator casio = new BasicCalculator();
        lblRes.setText("" + casio.getDiv(txtValue1.getText(), txtValue2.getText()));
    }

}
