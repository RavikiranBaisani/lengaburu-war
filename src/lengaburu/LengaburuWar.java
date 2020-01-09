package lengaburu;

import java.util.ArrayList;
import java.util.Scanner;

public class LengaburuWar {
	
	private ArrayList<Batallion> prepareBatallions(String name){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter "+name+"'s batallions' details");
		
		ArrayList<Batallion> batallions = new ArrayList<Batallion>();
		Batallion batallion ;
		for (BatallionType batallionType: BatallionType.values()) {
			System.out.println("Please enter the total number of "+batallionType.toString());
			int num = sc.nextInt();
			switch (batallionType){
				case ELEPHANT:
					batallion = new Elephant(batallionType, num);
					batallions.add(batallion);
					break;
				case HORSE:
					batallion = new Horse(batallionType, num);
					batallions.add(batallion);
					break;
				case ARMOUREDTANK:
					batallion = new ArmTank(batallionType, num);
					batallions.add(batallion);
					break;
				case SLINGGUN:
					batallion = new SlingGun(batallionType, num);
					batallions.add(batallion);
					break;
			}
		}
		return batallions;
	}
	
	private Protagonist initializeBatallions(String name) {
		Protagonist p = new Protagonist(name);
		ArrayList<Batallion> batallions = prepareBatallions(name);
		p.setTotal_forces(batallions);
		p.setDeployed_forces(batallions);
		return p;
	}
	
	private void deployBatallions(Protagonist p){
		ArrayList<Batallion> batallions = prepareBatallions(p.getName());
		p.setDeployed_forces(batallions);
	}
	/**
	 * Method to find if p2 can win over p1
	 * @param p1
	 * @param p2
	 */
	private void combat(Protagonist p1, Protagonist p2){
		ArrayList<Batallion> b1 = p1.getDeployed_forces();
		ArrayList<Batallion> b2 = p2.getDeployed_forces();
		int[] min_combat_batallion = new int[b2.size()];
		int[] rem_forces = new int[b2.size()];
		boolean flag = true;
		
		for(int i=0;i<b1.size();i++){
			min_combat_batallion[i] = (int)Math.ceil((float)b1.get(i).getCount()/2);
		}
		
		for(int i=0;i<b1.size();i++){
			rem_forces[i] = b2.get(i).getCount() - min_combat_batallion[i];
		}
		for(int i=0; i<rem_forces.length; i++){
        	if(rem_forces[i]<0){
        		boolean availability = substitute(rem_forces, i);
        		if(!availability){
        			flag = false;
        			break;
        		}
        	}
        }
        if(!flag){
        	for(int i=0;i<b2.size();i++){
        		b2.get(i).setCount(Math.min(b2.get(i).getCount(),(b2.get(i).getCount()-rem_forces[i])));
        	}
        	System.out.println("Lengaburu deploys "+b2.toString()+" and Loses");
        }else{
        	for(int i=0;i<b2.size();i++){
        		b2.get(i).setCount(b2.get(i).getCount()-rem_forces[i]);
        	}
        	System.out.println("Lengaburu deploys ..."+ b2.toString()+" and Wins");
        }
		
	}
	
	private boolean substitute(int[] batallion, int i){
    	int deficit ;
    	//In case of insufficient strength, see if forces can be borrowed from left neighbor
    	if(batallion[i] < 0 && i-1>=0 && batallion[i-1]>0){
			deficit = batallion[i] * -2;
			if(batallion[i-1] >= deficit){
				batallion[i] = 0;
				batallion[i-1] -= deficit;
			}else{
				batallion[i] += (int)Math.ceil((float)batallion[i-1]/2);
				batallion[i-1] = 0;
			}
		}
    	//if still negative then see if forces can be borrowed from it's right neighbor
		if(batallion[i] < 0 && i+1<batallion.length && batallion[i+1]>0){
			deficit = (int)Math.ceil((float)-batallion[i] / 2);
			if(batallion[i+1] >= deficit){
				batallion[i] = 0;
				batallion[i+1] -= deficit;
			}else{
				batallion[i] += batallion[i+1] * 2;
				batallion[i+1] = 0;
			}
		}
		return batallion[i] >=0 ;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengaburuWar war = new LengaburuWar();
		
		//Initialization
		Protagonist falicornia = war.initializeBatallions("Falicornia");
		Protagonist lengaburu = war.initializeBatallions("Lengaburu");
		
		
		
		//Forces deployment
		System.out.println("Please enter the details of batallions deployed by Falicornia...");
		war.deployBatallions(falicornia);
		
		//System.out.println(lengaburu);
		//System.out.println(falicornia);
		
		war.combat(falicornia, lengaburu);

		
	}

}
