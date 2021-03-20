package components.observershapes;

import java.awt.Stroke;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.LINE_PATTERN)
public interface ObserverObservableLine extends ObserverObservableShapeInterface{
	Stroke getStroke();
	void setStroke(Stroke newStroke);
}
