package components;

import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import components.ComponentContent;
//import components.ComponentsSet;
import components.SelectionModel;

public class Space extends Pane {
	private SelectionModel selectionModel;
	
	private boolean componentFocusFlag = false;

	private static final EventHandler<DragEvent> dragOver = (e) -> {
		e.acceptTransferModes(TransferMode.ANY);
        /*DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.color(0.4, 0.5, 0.5));
        myTestButton.setEffect(dropShadow);*/
	};	
	
	/*
	private static final EventHandler<DragEvent> dragExited = (e) -> {
		e.acceptTransferModes(TransferMode.ANY);
        //myTestButton.setEffect(null);
        e.consume();
	};	
	
	private static final EventHandler<DragEvent> dragDrop = (e) -> {
		Space space = (Space) e.getSource();
		//added = bp.getCenter().getClass();
		Dragboard db = ((DragEvent) e).getDragboard();
		String name = db.getString();
		
		ComponentContent content = ComponentsSet.createContent(name);
		if (content == null) return;
		ComponentView temp = new ComponentView(e.getX() - content.getPrefWidth() / 2, e.getY() - content.getPrefHeight() / 2, content);
		space.getChildren().add(temp);
	};	
	*/
	//onclick HERE
	public void setComponentFocus(boolean flag) {
		componentFocusFlag = flag;
	}
	
	public boolean isComponentFocus() {
		return componentFocusFlag;
	}
	
	private static final EventHandler<MouseEvent> thisPressListener = (e) -> {
		Space tmp = (Space) e.getSource();
		tmp.selectionModel.beginSelection(e.getX(), e.getY());
	};
	
	private static final EventHandler<MouseEvent> thisDragListener = (e) -> {
		Space tmp = (Space) e.getSource();
		tmp.selectionModel.continueSelection(e.getX(), e.getY());
	};
	
	private static final EventHandler<MouseEvent> thisReleaseListener = (e) -> {
		Space tmp = (Space) e.getSource();
		tmp.selectionModel.endSelection();
	};
	
	public SelectionModel getSelectionModel() {
		return selectionModel;
	}
	
	public void addComponent(ComponentView c) {
		this.getChildren().add(c);
	}
	
	public Space() {
		super();
		
		this.setOnDragOver(dragOver);
	//	this.setOnDragEntered(dragExited);
	//	this.setOnDragDropped(dragDrop);
		selectionModel = new SelectionModel(this);
		
		this.setOnMousePressed(thisPressListener);
		this.setOnMouseDragged(thisDragListener);
		this.setOnMouseReleased(thisReleaseListener);
		
		this.getChildren().addListener(new ListChangeListener<Node>() {
			@Override
			public void onChanged(Change<? extends Node> change) {
				while (change.next()) {
					if (change.wasRemoved()) {
						for (Object item : change.getRemoved()) {
							if (!(item instanceof ComponentView)) continue;
							selectionModel.remove((ComponentView) item);
						}
					}
				}
			}
		
		});
	}
}
