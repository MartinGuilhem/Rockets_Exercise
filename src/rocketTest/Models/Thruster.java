package rocketTest.Models;

public class Thruster implements Runnable {
	
//	atributos
	private static int CONT=1;
	private int ThrusterID;
	private int maxPower;
	private int currentPower;
	private int targetPower;
		
//	constructor
	public Thruster(int maxPower) {
		this.ThrusterID= CONT;
		CONT++;
		this.maxPower=maxPower;
		this.currentPower = 0;
		this.targetPower = 0;
		
	}

	
//	GETTERS y SETTERS
	public int getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}
	
	public int getCurrentPower() {
		return currentPower;
	}

	public void setCurrentPower(int currentPower) {
		this.currentPower = currentPower;
	}
	
	public int getTargetPower() {
		return targetPower;
	}

	public void setTargetPower(int targetPower) {
		this.targetPower = targetPower;
	}
	
	
	@Override
	public String toString() {
		return "Thruster [ID:"+ThrusterID+", maxPower=" + maxPower + ", currentPower=" + 
				currentPower + ", targetPower=" + targetPower + "]\n";
	}
	
	
	@Override
	public void run() {
		
		try {
			if(currentPower<targetPower) {
				do {
					currentPower++;
					System.out.println("Thruster "+ThrusterID+" || Current Power: "+currentPower+ " || Target power "+targetPower);
					Thread.sleep(300);
				}while(currentPower!=targetPower);
				System.out.println("\n The Thruster: "+ThrusterID+" Reached the Target Power: ("+targetPower+")");
			}
			else if(currentPower>targetPower) {
				do {
					currentPower--;
					System.out.println("Thruster "+ThrusterID+" || Current Power: "+currentPower+ " || Target power "+targetPower);
					Thread.sleep(300);
				}while(currentPower!=targetPower);
				System.out.println("\n The Thruster: "+ThrusterID+" Reached the Target Power: ("+targetPower+")");
			}
			else {
				System.out.println("The Truster is already at the required power.");
			}
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
