package rocketTest;

import java.util.ArrayList;
import java.util.Scanner;

import rocketTest.Models.Rocket;
import rocketTest.Models.Thruster;

public class main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double cSpeed=0, tSpeed=0;
		double targetPowerVel=0;
		double totalPowerR1=0;
		double totalPowerR2=0;
		double totalPower=0;
		double distribution=0;
		double x=0;
		ArrayList<Double> listMaxPowerThrusters = new ArrayList<Double>();

		
		
		Rocket rocket1 = new Rocket("32WESSDS");
		rocket1.getThrusterList().add(new Thruster(10));
		rocket1.getThrusterList().add(new Thruster(30));
		rocket1.getThrusterList().add(new Thruster(80));
		
		Rocket rocket2 = new Rocket("LDSFJA32");
		rocket2.getThrusterList().add(new Thruster(30));
		rocket2.getThrusterList().add(new Thruster(40));
		rocket2.getThrusterList().add(new Thruster(50));
		rocket2.getThrusterList().add(new Thruster(50));
		rocket2.getThrusterList().add(new Thruster(30));
		rocket2.getThrusterList().add(new Thruster(10));
		
		System.out.println(rocket1);
		System.out.println(rocket2);
		
		
/*	Ecuacion para hallar targetPower con la velocidad final y actual como parametros
  
		System.out.println("\n\n INSERT Current SPEED: ");
		cSpeed=Double.parseDouble(sc.nextLine());
		
		System.out.println("\n\n INSERT Target SPEED: ");
		tSpeed=Double.parseDouble(sc.nextLine());
		
		targetPowerVel=Math.pow(((tSpeed-cSpeed)/100), 2);
*/		
		
		
		targetPowerVel=100.00;
		
		System.out.println("#######\nTARGET POWER = "+String.format("%.2f", targetPowerVel)+"\n");
		
//		Sumo todas las potencias maximas del rocket 1 
		totalPowerR1=Rocket.sumOfPowers(rocket1);
		
//		Sumo todas las potencias del rocket 2
		totalPowerR2=Rocket.sumOfPowers(rocket2);
		
		totalPower=totalPowerR1+totalPowerR2;
		
		
		
		
//		Si targetPower dado por la velocidad deseada es mayor al posible da error
		
		if(targetPowerVel>totalPower) {
			System.out.println("Error, not enough power to reach speed");
		}
		
		else {
			
//			Si es menor al total admisible por el rocket 1, no necesito el Rocket2
			if(targetPowerVel<=totalPowerR1) 
			{
				System.out.println("#######\n Only Rocket 1 Required.\n");
				//agrego cada maxPower (Rocket1) de cada thruster en lista
				for(int j=0; j<rocket1.getThrusterList().size(); j++) {
					x=rocket1.getThrusterList().get(j).getMaxPower();
					listMaxPowerThrusters.add(x); 
				}
				
//				Funcion powerDistribute: devuelve la potencia que debo aplicarle a cada thruster y 
//				   que cada uno limitando segun su maximo la suma dara la potencia todal requerida  
				distribution=Thruster.powerDistribute(listMaxPowerThrusters, targetPowerVel);
				distribution=(int)distribution;

				System.out.println("#########\nLa total Distribucion es: "+String.format("%.2f", distribution)+"\n\n");		

				rocket1.PowerToTarget(distribution);

			}			
			
//			Si es mayor al total admisible por el rocket 1, usare ambos rockets
			
			else { //if(targetPowerVel>totalPowerR1)
				
				//agrego las max powers del rocket2 a la lista
				for(int j=0; j<rocket2.getThrusterList().size(); j++) {	
					x=rocket2.getThrusterList().get(j).getMaxPower();
					listMaxPowerThrusters.add(x);
				}
				
				distribution=Thruster.powerDistribute(listMaxPowerThrusters, targetPowerVel);
				System.out.println("#########\nThe resulting power distribution is: "+String.format("%.2f", distribution)+"\n\n");		

				distribution=(int)distribution;
				
				rocket1.PowerToTarget(distribution);
				rocket2.PowerToTarget(distribution);
				
				
			}
			
		}
		
		
		
		

	}

}
