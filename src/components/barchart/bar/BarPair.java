package components.barchart.bar;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"x", "y", "bars"})
@EditablePropertyNames({})
public class BarPair implements BarPairInterface {
	
	public static final int MARGIN = 5, BAR_WIDTH = 10;
	private List<BarInterface> bars;
	private int x, y;
	
	public BarPair(int newX, int newY) {
		
		setX(newX);
		setY(newY);
		
		bars = new ArrayList<BarInterface> ();
		
		BarInterface leftBar = new Bar();
		leftBar.setX(x);
		leftBar.setY(y);
		leftBar.setWidth(BAR_WIDTH);
		leftBar.setHeight(0);
		leftBar.setColor(Color.RED);
		
		BarInterface rightBar = new Bar();
		rightBar.setX(x + BAR_WIDTH + MARGIN);
		rightBar.setY(y);
		rightBar.setWidth(BAR_WIDTH);
		rightBar.setHeight(0);
		rightBar.setColor(Color.BLUE);
		
		bars.add(leftBar);
		bars.add(rightBar);
	}
	

	@Override
	public List<BarInterface> getBars() {
		return bars;
	}

	@Override
	@Visible(false)
	public void setX(int newX) {
		x = newX;
	}

	@Override
	@Visible(false)
	public int getX() {
		return x;
	}

	@Override
	@Visible(false)
	public void setY(int newY) {
		y = newY;
	}

	@Override
	@Visible(false)
	public int getY() {
		return y;
	}

}
