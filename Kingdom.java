import java.util.ArrayList;

public class Kingdom{
	private String name;
	private ArrayList<Building> buildingList;
	private ArrayList<Person> freeCitizen;
	private ArrayList<Ressource> totalStocks;
	private ArrayList<Ressource> currentRessources;

	public Kingdom(String n){
		name = n;
		buildingList = new ArrayList<Building>();
		buildingList.add(new Castle(new ArrayList<Ressource>(){
			{
				add(new Ressource("Gold", 500));
				add(new Ressource("Wood", 400));
				add(new Ressource("Stone", 600));
			}
		}));
		freeCitizen = new ArrayList<Person>();
		for (int i = 0; i<100; i++){
			freeCitizen.add(new Person());
		}

		totalStocks = new ArrayList<Ressource>();
		totalStocks.add(new Ressource("Gold", 2000));
		totalStocks.add(new Ressource("Wood", 2000));
		totalStocks.add(new Ressource("Iron", 2000));
		totalStocks.add(new Ressource("Stone", 2000));
		totalStocks.add(new Ressource("Food", 2000));
		
		currentRessources = new ArrayList<Ressource>();
		currentRessources.add(new Ressource("Gold", 2000));
		currentRessources.add(new Ressource("Wood", 2000));
		currentRessources.add(new Ressource("Iron", 2000));
		currentRessources.add(new Ressource("Stone", 2000));
		currentRessources.add(new Ressource("Food", 2000));

	}
	

	public void setTotalStocks(){
		ArrayList<Ressource> newTotalStocks = new ArrayList<Ressource>();
		newTotalStocks.add(new Ressource("Gold", 0));
		newTotalStocks.add(new Ressource("Wood", 0));
		newTotalStocks.add(new Ressource("Iron", 0));
		newTotalStocks.add(new Ressource("Stone", 0));
		newTotalStocks.add(new Ressource("Food", 0));
		for (Building b : buildingList){
			if (b instanceof Warehouse){	
				for (Ressource r1 : ((Warehouse)b).getStocks()){
					for (Ressource r2 : newTotalStocks){
						if (r1.correctType(r2)){
							r2.increaseQuantity(r1.getQuantity());
						}
					}
				}
			}
		}

		totalStocks = newTotalStocks;
	}			
	
	public boolean isAffordable(ArrayList<Ressource> cost){
		boolean result = true;
		for (Ressource r1 : cost){
			for (Ressource r2 : currentRessources){
				if (r1.correctType(r2)){
					if (r1.getQuantity() > r2.getQuantity()){
						result = false;
					}
				}
			}
		}
		return result;
	}
	
	public void payPrice(ArrayList<Ressource> cost){
		if (isAffordable(cost) == true){
			for (Ressource r1 : cost){
				for (Ressource r2 : currentRessources){
					if (r1.correctType(r2)){
						r2.decreaseQuantity(r1.getQuantity());
					}
				}
			}	
		}	
		else{
			System.out.println("You do not have enough ressources.");
		}
	}

	public void build(Building b){
		if (isAffordable(b.getCost()) == true){
			payPrice(b.getCost());
			if (b instanceof Harvest)
				buildingList.add(new Harvest((Harvest)b));
			if (b instanceof Storage)
				buildingList.add(new Storage((Storage)b));
		}
		else{
			System.out.println("You cannot build this yet.");
		}
	}



}




