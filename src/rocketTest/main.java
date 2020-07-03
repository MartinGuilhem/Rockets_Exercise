package rocketTest;

import rocketTest.Models.Rocket;
import rocketTest.Models.Thruster;

public class main {

	public static void main(String[] args) {

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

	}

}
