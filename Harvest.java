import java.util.ArrayList;

public class Harvest extends Building{
	private ArrayList<Ressource> harvestPerDay;
	private ArrayList<Person> workers;
	private int nbWorkersMax;
	
	public Harvest(String s, ArrayList<Ressource> cost, int harvestSpeed, int nbWorkersMax){
		super(s+" Harvesting Point", cost);
		harvestPerDay = new ArrayList<Ressource>();
		harvestPerDay.add(new Ressource(s, harvestSpeed));
		workers = new ArrayList<Person>();
		this.nbWorkersMax = nbWorkersMax;
	}

	public Harvest(Harvest h){
		super(h.getName(), h.getCost());
		harvestPerDay = h.getHarvestPerDay();
		workers = h.getWorkers();
		nbWorkersMax = h.getNbWorkersMax();
	}

	public void levelUp(){
		super.levelUp();
		for (Ressource r : harvestPerDay){
			r.increaseQuantity((int)(r.getQuantity()*0.5));
		}
		nbWorkersMax += (int)(nbWorkersMax*0.4);
	}

	public ArrayList<Ressource> getHarvestPerDay(){
		return harvestPerDay;
	}

	public ArrayList<Person> getWorkers(){
		return workers;
	}

	public int getNbWorkersMax(){
		return nbWorkersMax;
	}

	public void addWorker(Person p){
		if (p.getBusy() == false){
			if (workers.size() < nbWorkersMax){
				workers.add(p);
			}
			else{
				System.out.println("There are too many workers on this harvesting point.");
			}
		}
		else{
			System.out.println("This person is already busy elsewhere.");
		}
	}

	public ArrayList<Ressource> harvesting(){
		ArrayList<Ressource> result = new ArrayList<Ressource>();
		for (Ressource r : harvestPerDay){
			result.add(new Ressource(r.getType(), (int)(r.getQuantity()*workers.size()/nbWorkersMax)));
		}
		return result;
	}
	
	public String toString(){
		String s = super.toString();
		s += "\nNb workers : "+workers.size()+"/"+nbWorkersMax + "    Production : ";
		for (Ressource r : harvesting()){
			s+= r.toString2() + "   " ;
		}
		s += "per day";
		return s;
	}
}

	
