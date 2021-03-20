package components.barchart.bar;

import java.util.List;

public interface BarPairInterface {
	List<BarInterface> getBars();
	void setX(int newX);
	int getX();
	void setY(int newY);
	int getY();
}
