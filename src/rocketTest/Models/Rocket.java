package rocketTest.Models;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

//	atributos
	private String Code;
	private List<Thruster> thrusterList;
	
	
//	constructor
	public Rocket(String code) {
		super();
		Code = code;
		this.thrusterList = new ArrayList<Thruster>();
	}

	
//	getters y setters	
	public String getCode() {
		return Code;
	}


	public void setCode(String code) {
		Code = code;
	}


	public List<Thruster> getThrusterList() {
		return thrusterList;
	}


	public void setThrusterList(List<Thruster> thrusterList) {
		this.thrusterList = thrusterList;
	}
	
	public static double sumOfPowers(Rocket rocket) {
		double sum=0;
				
		for(int i=0; i<rocket.getThrusterList().size(); i++) {
			sum=sum+rocket.getThrusterList().get(i).getMaxPower();
		}
		return sum;
	}
	
	
//	Accelerate or Decelerate
	public void PowerToTarget(double targetPower) {
		for(Thruster thruster: thrusterList)
		{
			thruster.setTargetPower(targetPower);
			Thread t = new Thread(thruster);
			t.start();
		}
	}
	
	
	@Override
	public String toString() {
		return "Rocket [Code=" + Code + ", thrusterList=\n" + thrusterList + "]";
	}

	
}
