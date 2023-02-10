import javafx.scene.control.Button;

public class InDanhBa {
    String ten;
    String sdt;
    Button Edit;
    public InDanhBa(String ten, String sdt) {
        this.ten = ten;
        this.sdt = sdt;
        this.Edit = new Button("Edit");
        this.Edit.setOnAction((event) -> {
            Danhba.editNguoidung = this;
            Danhba.stName.setText(this.ten);
            Danhba.stTelephone.setText(this.sdt);
        });
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String toString(){
        return this.ten;
    }

    public Button getEdit() {
        return Edit;
    }

    public void setEdit(Button edit) {
        Edit = edit;
    }
}
