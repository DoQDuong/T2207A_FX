import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.xml.soap.Text;
import java.awt.*;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class Danhba implements Initializable {

    public Text txtInfor;
    public ObservableList<InDanhBa> listNguoidung = FXCollections.observableArrayList();
//    public ListView<InDanhBa> lv;
    public static InDanhBa editNguoidung;
    public javafx.scene.text.Text txtInfo;
    public TextField txtName;
    public TextField tlPhone;
    public static TextField stName;
    public static TextField stTelephone;
    public TableColumn<InDanhBa,String> cName;
    public TableColumn<InDanhBa,String> cTelephone;
    public TableColumn<InDanhBa,Button> cEdit;
    public TableView<InDanhBa> tablew;

    public void submit(ActionEvent actionEvent) {
        String nn = txtName.getText();
        String tp = tlPhone.getText();

        if (editNguoidung == null){
            InDanhBa s = new InDanhBa(nn, tp);
            listNguoidung.add(s);
        }else {
            for (InDanhBa s : listNguoidung){
                if (s.ten.equals(editNguoidung.ten) && s.sdt.equals((editNguoidung).sdt)){
                    s.setTen(nn);
                    s.setSdt(tp);
                }
            }
        }
        tablew.setItems(listNguoidung);
        tablew.refresh();
        editNguoidung = null;
        clearInput();
    }
    void clearInput(){
        txtName.clear();
        tlPhone.clear();
    }

    public void edit(MouseEvent mouseEvent) {
//        editNguoidung = lv.getSelectionModel().getSelectedItem();
        txtName.setText(editNguoidung.getTen());
        tlPhone.setText(editNguoidung.getSdt());
    }

    private boolean az = true;
    public void sort(ActionEvent actionEvent) {
        az = !az;
        Collections.sort(listNguoidung, new Comparator<InDanhBa>() {
            @Override
            public int compare(InDanhBa o1, InDanhBa o2) {
                if (az) {
                    return o1.ten.compareTo(o2.ten);
                } else {
                    return o2.ten.compareTo(o1.ten);
                }
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cName.setCellValueFactory(new PropertyValueFactory<>("ten"));
        cTelephone.setCellValueFactory(new PropertyValueFactory<>("sdt"));
        cEdit.setCellValueFactory(new PropertyValueFactory<>("edit"));

        stName = txtName;
        stTelephone = tlPhone;
    }
}
