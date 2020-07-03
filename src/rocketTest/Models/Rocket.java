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
	
	@Override
	public String toString() {
		return "Rocket [Code=" + Code + ", thrusterList=" + thrusterList + "]";
	}

	
}
