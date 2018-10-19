package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class LerArquivoPropertiesController {

	String razaoSocial;
	String cor;
	String logo;
	int largura;
	int altura;
	
	@FXML AnchorPane pane;
	@FXML Label label;
	@FXML ImageView img;
	
	@FXML
	public void initialize() {
		lerArquivo();
		pane.setMinWidth(largura);
		pane.setMinHeight(altura);
		label.setText(razaoSocial);
		try {
			img.setImage(new Image(new FileInputStream(logo)));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		pane.setStyle("-fx-background-color: #"+cor.substring(4));
	}
	
	private void lerArquivo() {
		Properties prop = new Properties();
		try (FileReader fr = new FileReader("Preferencias.properties")) {
			prop.load(fr);
			razaoSocial = prop.getProperty("RazaoSocial");
			cor = prop.getProperty("Cor");
			logo = prop.getProperty("Logo");
			largura = Integer.parseInt(prop.getProperty("Largura"));
			altura = Integer.parseInt(prop.getProperty("Altura"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
