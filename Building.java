import java.util.ArrayList;

public abstract class Building{
	private ArrayList<Ressource> cost;
	private int level;
	private String name;
	private static int counter = 0;
	private int id;

	public Building(String n, ArrayList<Ressource> c){
		ArrayList<Ressource> newCost = new ArrayList<Ressource>();		
		for (Ressource r : c){
			newCost.add(new Ressource(r));
		}
		cost = newCost; 
		name = n;
		level = 1;
		counter++;
		id = counter;
	}

	// Le prix des batiments double en montant d'un niveau.
	public void levelUp(){
		level++;
		for (Ressource r : cost){
			r.setQuantity(2*r.getQuantity());
		}
	}

	public int getLevel(){
		return level;
	}
		
	public ArrayList<Ressource> getCost(){
		return cost;
	}
	
	public String getName(){
		return name;
	}

	public String toString(){
		String s =  name +" (lvl."+level+") - cost: ";
		for (Ressource r : cost){
			s += r.toString2()+"   ";
		}
		return s;
	}

		
		
}		




