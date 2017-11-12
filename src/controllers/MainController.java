package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import components.Function;
import components.Space;
import components.TableComponent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import components.ComponentView;
import components.Element;


public class MainController implements Initializable {

	@FXML private AnchorPane content; 
	@FXML private static TextArea text;
	@FXML private BorderPane root_BordePane;
	public Space s;
	
	Function f1 = new Function("Asda", 200, 200);
	Function f2 = new Function("Asda", 200, 300);
	Function f3 = new Function("Asda", 200, 400);
	
	
	TableComponent f4 = new TableComponent();
	ComponentView t=new ComponentView(0, 0, f4);
	
	public static void setProperties(Element e) {
		Element select = e;
		System.out.println(select.getText());
	}
	
	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("asd");
		s=new Space();
		root_BordePane.setCenter(s);
	//	s.getChildren().add(f1);
		s.getChildren().add(f2);
		s.getChildren().add(f3);
		s.getChildren().add(t);
		
		/*content.getChildren().add(new NetworkComponent(200, 200));
		content.getChildren().add(new ClassComponent(4cm pf l;fd00,400));
		content.getChildren().add(new ClassComponent(300,300));
		content.getChildren().add(new ClassComponent(100,400));
		content.getChildren().add(new Rectangle(100,200));*/
		//content.getChildren().add(new ClassComponent(100,100));
	}
	
}