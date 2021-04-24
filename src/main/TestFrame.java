package main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import components.mainpanel.MainPanel;
import components.mainpanel.MainPanelInterface;

public class TestFrame {
	public static void main(String[] args) {
		MainPanelInterface panel = new MainPanel();
		OEFrame frame = ObjectEditor.edit(panel);
		frame.setSize(1400, 1050);
		frame.setLocation(600, 0);
	}
}
