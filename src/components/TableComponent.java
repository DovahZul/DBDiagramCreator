package components;

import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import base.Main;
import components.ComponentContent;

public class TableComponent extends ComponentContent {
	
	
public ListView list;
	public TableComponent() {
		this.setPrefWidth(130);
		this.setPrefHeight(130);
		
		
		BorderPane bp = new BorderPane();
		bp.setTop(new Text("Table blyad!"));
		
		list = new ListView();
		list.getItems().add("id : integer");
		list.getItems().add("name : string");
		list.getItems().add("age : number");
		list.prefWidthProperty().bind(this.widthProperty());
		list.prefHeightProperty().bind(this.heightProperty());
		bp.setCenter(list);
		list.setOnMouseClicked((e) ->
		{
			ListView temp = (ListView) e.getSource();
			//Main.getMainContoller().writeValueForEdit(temp.getItems());
		}
		
				);
		
		bp.getStyleClass().add("border_test");
		bp.applyCss();
		
		bp.prefWidthProperty().bind(this.widthProperty());
		bp.prefHeightProperty().bind(this.heightProperty());
		this.getChildren().add(bp);
		
		//@FXML
		//public void onCLick(){
			
		//}
	}
	
}
