package base;

import components.Element;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Line;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import controllers.MainController;

public class Main extends Application {

	private static Scene scene;
	private static Element select;
	private static MainController mainController;
	
	public static Element getSelect( ) {
		return select;
	}
	
	/*public static void setProprtis(Element e) {
		select = e;
		Label lt = (Label) scene.lookup("#type");
		lt.setText(select.getType());
		TextArea ta = (TextArea) scene.lookup("#Text");
		ta.setText(select.getText());
	}*/
	
	public static Line newConnectionLine() {
		Line line = new Line();
		( (AnchorPane) scene.lookup("#Space") ).getChildren().add(line);
		return line;
	}
	
	public static void removeConnectionLine(Line line) {
		( (AnchorPane)  scene.lookup("#Space") ).getChildren().remove(line);
	}
	
	public static void main(String[] args) {
		launch();
	}

	public static MainController getMainContoller() {
		return mainController;
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent main = FXMLLoader.load(getClass().getResource("MainForm.fxml"));
		scene = new Scene(main, 1000, 800);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
