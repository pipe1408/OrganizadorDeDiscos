import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuPrincipalController implements Initializable {
    @javafx.fxml.FXML
    private TextField txt_disco_id;
    @javafx.fxml.FXML
    private TextField txt_disco_filtro;
    @javafx.fxml.FXML
    private TextField txt_disco_nombre;
    @javafx.fxml.FXML
    private TextField txt_disco_autor;
    @javafx.fxml.FXML
    private TextField txt_disco_interprete;
    @javafx.fxml.FXML
    private TextField txt_disco_year;
    @javafx.fxml.FXML
    private TextField txt_song_filtro;
    @javafx.fxml.FXML
    private TextField txt_song_id;
    @javafx.fxml.FXML
    private TextField txt_song_nombre;
    @javafx.fxml.FXML
    private TextField txt_song_autor;
    @javafx.fxml.FXML
    private TextField txt_song_interprete;
    @javafx.fxml.FXML
    private ComboBox<String> cmbox_disco_pais;
    @FXML
    private RadioButton rb_disco_clasica;
    @FXML
    private ToggleGroup rbgroup_disco_tipo;
    @FXML
    private RadioButton rb_disco_pais;
    @FXML
    private CheckBox check_disco_uautor;
    @FXML
    private CheckBox check_disco_uinterp;
    @FXML
    private Button btn_disco_transfer;
    @FXML
    private Button btn_song_transfer;
    @FXML
    private Button btn_disco_guardar;
    @FXML
    private Button btn_disco_eliminar;
    @FXML
    private Button btn_song_guardar;
    @FXML
    private Button btn_song_eliminar;
    @FXML
    private Button btn_song_nuevo;
    @FXML
    private TableView<Disco> tbl_disco;
    @FXML
    private TableColumn<Disco, String> tblc_disco_id;
    @FXML
    private TableColumn<Disco, String> tblc_disco_name;
    @FXML
    private TableColumn<Disco, String> tblc_disco_author;
    @FXML
    private TableColumn<Disco, String> tblc_disco_year;
    @FXML
    private TableColumn<Disco, String> tblc_disco_interp;
    @FXML
    private TableView<Cancion> tbl_song;
    @FXML
    private TableColumn<Cancion, String> tblc_song_id;
    @FXML
    private TableColumn<Cancion, String> tblc_song_name;
    @FXML
    private TableColumn<Cancion, String> tblc_song_author;
    @FXML
    private TableColumn<Cancion, String> tblc_song_interp;
    @FXML
    private ComboBox<String> cmbox_disco_filtro;
    @FXML
    private ComboBox<String> cmbox_song_filtro;
    @FXML
    private Button btn_disco_newcountry;

    //INITIALIZABLES

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list_disc_filter = cmbox_disco_filtro.getItems();
        ObservableList<String> list_song_filter = cmbox_song_filtro.getItems();
        Database_Connect db_con = new Database_Connect();
        db_con.CreateDB();

        list_disc_filter.add("Todos");
        list_disc_filter.add("Código");
        list_disc_filter.add("Nombre");
        list_disc_filter.add("Autor");
        list_disc_filter.add("Año");
        list_disc_filter.add("Interprete");
        cmbox_disco_filtro.setItems(list_disc_filter);

        list_song_filter.add("Todos");
        list_song_filter.add("Disco");
        list_song_filter.add("Nombre");
        list_song_filter.add("Autor");
        list_song_filter.add("Intérprete");
        cmbox_song_filtro.setItems(list_song_filter);
    }

    //DISC MANAGEMENT

    @FXML
    private void DiscEnableDetails() {
        txt_disco_year.setDisable(false);
        txt_disco_nombre.setDisable(false);
        check_disco_uautor.setDisable(false);
        check_disco_uinterp.setDisable(false);
        rb_disco_clasica.setDisable(false);
        rb_disco_pais.setDisable(false);
        btn_disco_guardar.setDisable(false);
    }

    @FXML
    private void DiscToggleAuthInt() {
        txt_disco_autor.setDisable(!check_disco_uautor.isSelected());
        txt_disco_interprete.setDisable(!check_disco_uinterp.isSelected());
        DiscToggleTransferButton();
    }

    @FXML
    private void DiscToggleTransferButton() {
        btn_disco_transfer.setDisable(txt_disco_autor.getText().trim().isEmpty() || !check_disco_uinterp.isSelected());
    }

    @FXML
    public void DiscAuthToInterp() {
        txt_disco_interprete.setText(txt_disco_autor.getText());
    }

    @FXML
    public void DiscToggleCountrySelection() {
        cmbox_disco_pais.setDisable(!rb_disco_pais.isSelected());
        btn_disco_newcountry.setDisable(!rb_disco_pais.isSelected());
    }

    //SONG MANAGEMENT

    @FXML
    public void SongEnableDetails() {

    }

    @FXML
    public void SongAuthToInterp() {
    }
}
