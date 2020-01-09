package lengaburu;
import java.util.ArrayList;

import lengaburu.Batallion;

public class Protagonist {
	private String name;
	private ArrayList<Batallion> total_forces;
	private ArrayList<Batallion> deployed_forces;
	
	public Protagonist(String name, ArrayList<Batallion> total_forces) {
		super();
		this.setName(name);
		this.setTotal_forces(total_forces);
	}

	
	@Override
	public String toString() {
		return "Protagonist [name=" + name + ", total_forces=" + total_forces
				+ ", deployed_forces=" + deployed_forces + "]";
	}


	public Protagonist(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public ArrayList<Batallion> getTotal_forces() {
		return total_forces;
	}


	public void setTotal_forces(ArrayList<Batallion> total_forces) {
		this.total_forces = total_forces;
	}


	public ArrayList<Batallion> getDeployed_forces() {
		return deployed_forces;
	}

	public void setDeployed_forces(ArrayList<Batallion> deployed_forces) {
		this.deployed_forces = deployed_forces;
	}
	
	
}
