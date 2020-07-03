package rocketTest.Models;

public class Thruster {
	
//	atributos
	private static int CONT=1;
	private int ThrusterID;
	private int maxPower;
		
//	constructor
	public Thruster(int maxPower) {
		this.ThrusterID= CONT;
		CONT++;
		this.maxPower=maxPower;
	}

	
//	GETTERS y SETTERS
	public int getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}
	
	@Override
	public String toString() {
		return "Thruster [ID:"+ThrusterID+", maxPower=" + maxPower+"]";
	}

}
