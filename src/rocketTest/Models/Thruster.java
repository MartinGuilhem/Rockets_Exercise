package rocketTest.Models;

import java.util.ArrayList;

public class Thruster implements Runnable {
	
//	atributos
	private static int CONT=1;
	private int ThrusterID;
	private double maxPower;
	private double currentPower;
	private double targetPower;
	private boolean maxPowerAlert=false;
		
//	constructor
	public Thruster(double maxPower) {
		this.ThrusterID= CONT;
		CONT++;
		this.maxPower=maxPower;
		this.currentPower = 0;
		this.targetPower = 0;
		
	}

	
//	### GETTERS, SETTERS y TO STRING ###
	
	public double getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(double maxPower) {
		this.maxPower = maxPower;
	}
	
	public double getCurrentPower() {
		return currentPower;
	}

	public void setCurrentPower(double currentPower) {
		this.currentPower = currentPower;
	}
	
	public double getTargetPower() {
		return targetPower;
	}

	
	@Override
	public String toString() {
		return "Thruster [ID:"+ThrusterID+", maxPower=" + String.format("%.2f", maxPower) + ", currentPower=" + 
				String.format("%.2f", currentPower) + ", targetPower=" + String.format("%.2f", targetPower) + "]\n";
	}
	
	
	
	
//	###
//	Setea el Target Power al thruster, pero si el target es mayor al maximo admisible setea el maximo admisible
	public void setTargetPower(double targetPower) {
		if(targetPower>=maxPower)
		{
			this.targetPower = maxPower;
			maxPowerAlert=true;
		}else {
		this.targetPower = targetPower;
		}
	}
	
	
	
	
//	###
//	 Da como resultado la potencia a aplicarle a cada thruster. Luego cada thruster se limitará 
//	    a su maxPower, pero la sumatoria de todos las potencias aplicadas alcanzaran la potencia objetivo 
	public static double powerDistribute(ArrayList<Double> listMaxPowerThrusters, double targetPowerVel) 
	{		
		double distribution = targetPowerVel / listMaxPowerThrusters.size();
		double lack = 0.00; //potencia que no entra en thruster
		double result;
		ArrayList<Double> torrentesRestantes = new ArrayList<Double>();
		
		for(int i=0; i<listMaxPowerThrusters.size(); i++) 
		{
			result=listMaxPowerThrusters.get(i)-distribution; // t1MaxPower - reparticion
			if(result<=0.00) { //hay sobrante sin poder meter en el thruster
				lack=lack-result;	//el resultado habia dado negativo para entrar, por lo que sobra incrementa
			}else {
				torrentesRestantes.add(result);					}
			}
			if(lack>0.00) {
				return powerDistribute(torrentesRestantes, lack)+distribution;
				}else {
				return distribution;
			}
	}
		

	
//	###
	
	@Override
	public void run() {
		
		try {
			
			if(currentPower<targetPower) 
			{
				do {
					currentPower++;
					System.out.println("Thruster "+ThrusterID+" || Current Power: "+String.format("%.2f", currentPower)
										+ " || Target power "+String.format("%.2f", targetPower));
					
					Thread.sleep(300);
				}while(currentPower<targetPower);
				
				if(maxPowerAlert) 
				{
					System.out.println("ALERT: Thruster: "+ThrusterID+" Reached the MAX Power ("+maxPower+")");
				}
				
				else 
				{
					System.out.println("\n The Thruster: "+ThrusterID+" Reached the Target Power: ("+String.format("%.2f", targetPower)+")");
				}
			}
	
			else if(currentPower>targetPower) 
			{
				
				do {
					currentPower--;
					System.out.println("Thruster "+ThrusterID+" || Current Power: "+String.format("%.2f", currentPower)+ " || Target power "+String.format("%.2f", targetPower));
					Thread.sleep(300);
				}while(currentPower>=targetPower);
			
				
				System.out.println("\n The Thruster: "+ThrusterID+" Reached the Target Power: ("+String.format("%.2f", targetPower)+")");
			}
			
			else 
			{
				System.out.println("The Truster is already at the required power.");
			}
			
			Thread.sleep(1000);
		}
		catch(InterruptedException e) 
		{
			e.printStackTrace();
		}
		
	}

}
