package components.pendulum.protractor;

import java.awt.BasicStroke;
import java.util.ArrayList;
import java.util.List;

import components.observershapes.ObserverObservableArc;
import components.observershapes.ObserverObservableLine;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"x", "y", "line", "firstArc", "secondArc"})
@EditablePropertyNames({})
public class Protractor implements ProtractorInterface{
	private List<ObserverObservableLine> line;
	private ObserverObservableArc firstArc = new ProtractorArc(), 
			secondArc = new ProtractorArc();
	private int x = 200, y = 20;
	private static final int RADIUS = 40;
	private static final double ARC_SCALE = 0.6;
	
	public Protractor() {
		line = new ArrayList<ObserverObservableLine> ();
		for (int i = -90; i <= 90; i = i + 15) {
			double r = RADIUS;
			double angle = i * Math.PI / 180;
			int height = (int) (Math.cos(angle) * r);
			int width = (int) (Math.sin(angle) * r);
			ObserverObservableLine newLine = new ProtractorLine();
			newLine.setHeight(height);
			newLine.setWidth(width);
			newLine.setX(x);
			newLine.setY(y);
			if (i % 30 == 0) {
				newLine.setStroke(new BasicStroke(1.5f));
			}
			else {
				newLine.setStroke(new BasicStroke(0.5f));
			}
			line.add(newLine);
		}
		
		firstArc.setX((int) (x - RADIUS * ARC_SCALE));
		firstArc.setY((int) (y - RADIUS * ARC_SCALE));
		firstArc.setHeight((int) (2 * RADIUS * ARC_SCALE));
		firstArc.setWidth((int) (2 * RADIUS * ARC_SCALE));
		firstArc.setStartAngle(180);
		firstArc.setEndAngle(180);
		
		secondArc.setX(x - RADIUS);
		secondArc.setY(y - RADIUS);
		secondArc.setHeight(RADIUS * 2);
		secondArc.setWidth(RADIUS * 2);
		secondArc.setStartAngle(180);
		secondArc.setEndAngle(180);
		

	}
	
	@Override
	public List<ObserverObservableLine> getLine() {
		return line;
	}
	
	@Override
	@Visible(false)
	public int getX() {
		return x;
	}
	
	@Override
	@Visible(false)
	public int getY() {
		return y;
	}
	
	@Override
	@Visible(false)
	public void setX(int newX) {
		x = newX;
		for (int i = 0; i < line.size(); i ++) {
			line.get(i).setX(x);
		}
		firstArc.setX((int) (x - ARC_SCALE * RADIUS));
		secondArc.setX((int) (x - RADIUS));
		
	}
	
	@Override
	@Visible(false)
	public void setY(int newY) {
		y = newY;
		for (int i = 0; i < line.size(); i ++) {
			line.get(i).setY(y);
		}
		firstArc.setY((int) (y - ARC_SCALE * RADIUS));
		secondArc.setY((int) (y - RADIUS));

	}

	@Override
	public ObserverObservableArc getFirstArc() {
		return firstArc;
	}

	@Override
	public ObserverObservableArc getSecondArc() {
		return secondArc;
	}



}
