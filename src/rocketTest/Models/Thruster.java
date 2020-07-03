package rocketTest.Models;

public class Thruster {
	
	private static int CONT=1;
	private int ThrusterID;
		
	public Thruster() {
		
		this.ThrusterID= CONT;
		CONT++;
		
	}

	@Override
	public String toString() {
		return "Thruster [ID:"+ThrusterID+"]";
	}

}
