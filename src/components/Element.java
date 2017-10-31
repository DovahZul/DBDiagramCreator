package components;

import java.util.HashMap;
import java.util.Map;

import components.Connection;
import base.Main;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public abstract class Element extends AnchorPane {
	private Shape back = null;
	private Text text;
	private Rectangle resize,
					  rightConnect,
					  bottomConnect,
					  leftConnect,
					  topConnect;
	
	private Map<Element, Connection> connections;
	
	private static double mouse_x, mouse_y;
	
	private static EventHandler<MouseEvent> moveEvent = (event) -> {
		((Shape) event.getSource()).getParent().setLayoutX(event.getSceneX() - mouse_x);
		((Shape) event.getSource()).getParent().setLayoutY(event.getSceneY() - mouse_y);
		((Element) ((Shape) event.getSource()).getParent()).updateConnectionLine();
	};
	
	private static EventHandler<MouseEvent> clickEvent = (event) -> {
		mouse_x = event.getSceneX() - ((Shape) event.getSource()).getParent().getLayoutX();
		mouse_y = event.getSceneY() - ((Shape) event.getSource()).getParent().getLayoutY();
		Main.setProprtis((Element) ((Shape) event.getSource()).getParent());
	};
	
	private static EventHandler<MouseEvent> resizeEvent = (event) -> {
		Element currentElement = (Element) ((Rectangle) event.getSource()).getParent();
		
		//double x = event.getSceneX() - currentElement.getLayoutX() - currentElement.getParent().getParent().getParent().getParent().getLayoutX();
		//double y = event.getSceneY() - currentElement.getLayoutY() - currentElement.getParent().getParent().getParent().getParent().getLayoutY();
		double x = event.getX();
		double y = event.getY();
		
		
		if (x > 100) {
			currentElement.setWidth(x);
		}
		else {
			currentElement.setWidth(100);
		}
		
		if (y > 60) {
			currentElement.setHeight(y);
		}
		else {
			currentElement.setHeight(60);
		}
		
		currentElement.resize();
	};
	
	public void setBack(Shape b) {
		this.back = b;
		back.setOnMousePressed(clickEvent);
		back.setOnMouseDragged(moveEvent);
		this.getChildren().add(back);
	}
	
	public Object getBack() {
		return this.back;
	}
	
	public String  getType() {
		return null;
	}
	
	public String getText() {
		return text.getText();
	}
	
	public void setText(String t) {
		text.setText(t);
	}
	
	public void connectOut(Element e, int sideThis, int sideFr) {
		Connection conn = connections.get(e);
		if (conn != null) {
			if (conn.lineOut != null) {
				return;
			}
		} else {
			conn = new Connection();
		}
		
		Line line = Main.newConnectionLine();
		conn.lineOut = line;
		conn.sideOut = sideThis;
		conn.element = e;
		
		if (connections.get(e) == null) {
			connections.put(e, conn);
		}
		
		updateConnectionLine();
		e.addConnectIn(conn, sideFr);
	}
	
	public void addConnectIn(Connection c, int side) {
		Connection conn = connections.get(c.element);
		if (conn == null) {
			conn = new Connection();
		}
		
		conn.lineIn = c.lineOut;
		conn.sideIn = side;
		conn.element = c.element;
		
		if (connections.get(c.element) == null) {
			connections.put(c.element, conn);
		}
		updateConnectionLine();
	}
	
	public Element(String text, double x, double y) {
		connections = new HashMap<Element, Connection>();
		//this.getStyleClass().add("component");
		this.setLayoutX(x);
		this.setLayoutY(y);
		this.setWidth(100);
		this.setHeight(60);
		
		this.text = new Text(text);
		this.text.setTextAlignment(TextAlignment.CENTER);
		this.text.setOnMousePressed(clickEvent);
		this.text.setOnMouseDragged(moveEvent);
		
		this.rightConnect = new Rectangle();
		this.rightConnect.setFill(Color.BLUE);
		this.rightConnect.setArcHeight(15);
		this.rightConnect.setArcWidth(15);
		this.rightConnect.setVisible(false);
		
		this.bottomConnect = new Rectangle();
		this.bottomConnect.setFill(Color.BLUE);
		this.bottomConnect.setArcHeight(15);
		this.bottomConnect.setArcWidth(15);
		this.bottomConnect.setVisible(false);
		
		this.leftConnect = new Rectangle();
		this.leftConnect.setFill(Color.BLUE);
		this.leftConnect.setArcHeight(15);
		this.leftConnect.setArcWidth(15);
		this.leftConnect.setVisible(false);
		
		this.topConnect = new Rectangle();
		this.topConnect.setFill(Color.BLUE);
		this.topConnect.setArcHeight(15);
		this.topConnect.setArcWidth(15);
		this.topConnect.setVisible(false);
		
		this.resize = new Rectangle();
		resize.setOnMouseDragged(resizeEvent);
	}
	
	public void init() {
		this.getChildren().add(this.text);
		this.getChildren().add(this.rightConnect);
		this.getChildren().add(this.bottomConnect);
		this.getChildren().add(this.leftConnect);
		this.getChildren().add(this.topConnect);
		this.getChildren().add(this.resize);
		resize();
	}
	
	public void resize() {
		this.text.setLayoutX(0);
		this.text.setLayoutY(this.getHeight() / 2 + 6);
		this.text.setWrappingWidth(this.getWidth());
		this.text.maxHeight(this.getHeight() / 2 - 10);
		
		this.rightConnect.setX(this.getWidth() - 24);
		this.rightConnect.setY(24);
		this.rightConnect.setWidth(24);
		this.rightConnect.setHeight(this.getHeight() - 48);
		
		this.bottomConnect.setX(24);
		this.bottomConnect.setY(this.getHeight() - 24);
		this.bottomConnect.setWidth(this.getWidth() - 48);
		this.bottomConnect.setHeight(24);
		
		this.leftConnect.setX(0);
		this.leftConnect.setY(24);
		this.leftConnect.setWidth(24);
		this.leftConnect.setHeight(this.getHeight() - 48);
		
		this.topConnect.setX(24);
		this.topConnect.setY(0);
		this.topConnect.setWidth(this.getWidth() - 48);
		this.topConnect.setHeight(24);
		
		this.resize.setX(this.getWidth() - 10);
		this.resize.setY(this.getHeight() - 10);
		this.resize.setWidth(10);
		this.resize.setHeight(10);
		
		updateConnectionLine();
	}
	
	public void updateConnectionLine() {
		Object[] mass = connections.values().toArray();
		for (int i = 0; i < mass.length; i++) {
			System.out.println(this.text.getText());
			Connection conn = (Connection) mass[i];
			if (conn.lineIn != null) {
				switch (conn.sideIn) {
					case 0:
						conn.lineIn.setEndX(this.getLayoutX() + this.getWidth());
						conn.lineIn.setEndY(this.getLayoutY() + this.getHeight() / 2);
						break;
					case 1:
						conn.lineIn.setEndX(this.getLayoutX() + this.getWidth() / 2);
						conn.lineIn.setEndY(this.getLayoutY() + this.getHeight());
						break;
					case 2:
						conn.lineIn.setEndX(this.getLayoutX());
						conn.lineIn.setEndY(this.getLayoutY() + this.getHeight() / 2);
						break;
					case 3:
						conn.lineIn.setEndX(this.getLayoutX() + this.getWidth() / 2);
						conn.lineIn.setEndY(this.getLayoutY());
				}
			}
			
			if (conn.lineOut != null) {
				switch (conn.sideOut) {
					case 0:
						conn.lineOut.setStartX(this.getLayoutX() + this.getWidth());
						conn.lineOut.setStartY(this.getLayoutY() + this.getHeight() / 2);
						break;
					case 1:
						conn.lineOut.setStartX(this.getLayoutX() + this.getWidth() / 2);
						conn.lineOut.setStartY(this.getLayoutY() + this.getHeight());
						break;
					case 2:
						conn.lineOut.setStartX(this.getLayoutX());
						conn.lineOut.setStartY(this.getLayoutY() + this.getHeight() / 2);
						break;
					case 3:
						conn.lineOut.setStartX(this.getLayoutX() + this.getWidth() / 2);
						conn.lineOut.setStartY(this.getLayoutY());
				}
			}
		}
	}
}


