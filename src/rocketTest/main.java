package rocketTest;

import rocketTest.Models.Rocket;
import rocketTest.Models.Thruster;

public class main {

	public static void main(String[] args) {

		Rocket rocket1 = new Rocket("x");
		rocket1.getThrusterList().add(new Thruster());
		rocket1.getThrusterList().add(new Thruster());
		rocket1.getThrusterList().add(new Thruster());
		
		Rocket rocket2 = new Rocket("LDSFJA32");
		rocket2.getThrusterList().add(new Thruster());
		rocket2.getThrusterList().add(new Thruster());
		rocket2.getThrusterList().add(new Thruster());
		rocket2.getThrusterList().add(new Thruster());
		rocket2.getThrusterList().add(new Thruster());
		rocket2.getThrusterList().add(new Thruster());
		
		System.out.println(rocket1);
		System.out.println(rocket2);

	}

}
