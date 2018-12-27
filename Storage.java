import java.util.ArrayList;

public class Storage extends Building implements Warehouse{
	private ArrayList<Ressource> stocks;

	public Storage(String s, ArrayList<Ressource> c){
		super (s +" Warehouse", c);
		stocks = new ArrayList<Ressource>();
		stocks.add(new Ressource(s, 1000));
	}

	public Storage(Storage s){
		super(s.getName(), s.getCost());
		stocks = s.getStocks();
	}


	public void levelUp(){
		super.levelUp();
		for (Ressource r : stocks){
			r.increaseQuantity(200*this.getLevel());
		}
	}

	public ArrayList<Ressource> getStocks(){
		return stocks;
	}
	public String toString(){
		String s = super.toString();
		s += "\nCapacity : ";
		for (Ressource r : getStocks()){
			s+= r.toString2() + "   " ;
		}
		return s;
	}
}
