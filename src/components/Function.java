package components;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Function extends Element {
	
	public Function(String text, double x, double y) {
		super(text, x, y);
		
		Rectangle r = new Rectangle(0, 0, 100, 60);
		r.setFill(Color.GREEN);
		r.setArcHeight(15);
		r.setArcWidth(15);
		r.setStroke(Color.BLACK);
		this.setBack(r);
		
		init();
	}
	
	public void resize() {
		super.resize();
		
		Rectangle r = (Rectangle) this.getBack();
		r.setWidth( this.getWidth());
		r.setHeight(this.getHeight());
	}
	
	public String getType() {
		return "Function";
	}
}
