package main;

import javax.swing.JButton;
import javax.swing.JSlider;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import components.mainpanel.MainPanel;
import components.mainpanel.MainPanelInterface;
import components.pendulum.load.Load;
import components.pendulum.load.LoadInterface;
import components.pendulum.protractor.Protractor;
import components.pendulum.protractor.ProtractorInterface;
import components.pendulum.string.PendulumString;
import components.pendulum.string.PendulumStringInterface;
import javafx.scene.control.Slider;

public class TestFrame {
	public static void main(String[] args) {
		MainPanelInterface panel = new MainPanel();
		OEFrame frame = ObjectEditor.edit(panel);
	}
}
