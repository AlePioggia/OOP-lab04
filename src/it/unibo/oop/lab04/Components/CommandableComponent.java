package it.unibo.oop.lab04.Components;

public class CommandableComponent extends Component{

	public CommandableComponent(boolean isOn, boolean isConnected, String compName) {
		super(isOn, isConnected, true, compName);
	} 

}
