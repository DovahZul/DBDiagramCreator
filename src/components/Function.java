package components;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Function extends Element {
	
	VBox pane;
	
	public Function(String text, double x, double y) {
		super(text, x, y);
		
		Rectangle r=new Rectangle();
		
		
		ListView<String> l = new ListView<String>();
		
		pane= new VBox();

		Label l1=new Label("blabla");
		Label l2=new Label("blabla");
		Label l3=new Label("blabla");
		Label l4=new Label("blabla");
		
		pane.getChildren().add(l1);
		pane.getChildren().add(l2);
		pane.getChildren().add(l3);
		pane.getChildren().add(l4);
	
		
		l.getItems().addAll("ASDASD","ASDASD2","ASDASD3");
		pane.getChildren().add(l);
		
		
		
		pane.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		pane.setAlignment(Pos.CENTER);
		this.getChildren().add(pane);
		
		
		init();
	}
	
	public void resize() {
		super.resize();
		
		pane.setPrefWidth(this.getWidth());
		pane.setPrefHeight(this.getHeight());
	}
	
	public String getType() {
		return "Function";
	}
}
