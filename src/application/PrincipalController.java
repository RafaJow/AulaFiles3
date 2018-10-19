package application;

import java.io.File;
import java.io.FileWriter;
import java.util.Properties;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class PrincipalController {
	
	@FXML TextField txtLargura;
	@FXML TextField txtAltura;
	@FXML TextField txtRazao;
	@FXML TextField txtPath;

	@FXML ColorPicker txtCor;
	
	public void gravar() {
		File f = new File(txtPath.getText());
		if(f.isFile()) {
			Properties properties = new Properties();
			properties.setProperty("Largura", txtLargura.getText());
			properties.setProperty("Altura", txtAltura.getText());
			properties.setProperty("Logo", txtPath.getText());
			properties.setProperty("Cor", "#" + Integer.toHexString(txtCor.getValue().hashCode()));
			properties.setProperty("RazaoSocial", txtRazao.getText());
			
			try {
				FileWriter fw = new FileWriter("Preferencias.properties");
				properties.store(fw, "Arquivo de preferencias");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void abreDiretorio() {
		FileChooser fc = new FileChooser();
		//DirectoryChooser dc = new DirectoryChooser();
		File selecionado = fc.showOpenDialog(null);
		if(selecionado != null) {
			txtPath.setText(selecionado.getAbsolutePath());
		}
	}
}
	
//txtPath.setText(selecionado.getAbsolutePath(C:\Users\ra-fa\Desktop\sad\sasq.jpg"));// selecionado.getAbsolutePath()
/*
public File selecionaImagem() {
	FileChooser fileChooser = new FileChooser();
	fileChooser.getExtensionFilters().add(new
			FileChooser.ExtensioFilter(
					"Imagens", "*.jpg", "*.JPG",
					"*.bmp", "*.BMP"));
	fileChooser.setInitialDirectory(new File("C:"));
	F
}

public void lerArquivo() {
	Properties prop = new Properties();
	try(FileReader fr = new FileReader(""))
}
*/
	
