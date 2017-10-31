package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import components.Function;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import components.Element;


public class MainController implements Initializable {

	@FXML
	private AnchorPane content; 
	
	Function f1 = new Function("Asda", 200, 200);
	Function f2 = new Function("Asda", 200, 300);
	Function f3 = new Function("Asda", 200, 400);
	
	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("asd");
		content.getChildren().add(f1);
		content.getChildren().add(f2);
		content.getChildren().add(f3);
		
		/*content.getChildren().add(new NetworkComponent(200, 200));
		content.getChildren().add(new ClassComponent(400,400));
		content.getChildren().add(new ClassComponent(300,300));
		content.getChildren().add(new ClassComponent(100,400));
		content.getChildren().add(new Rectangle(100,200));*/
		//content.getChildren().add(new ClassComponent(100,100));
	}
	
}