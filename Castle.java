import java.util.ArrayList;

public class Castle extends Building implements Warehouse{
	private ArrayList<Ressource> stocks;
	private int nbSlots;
	
	public Castle(ArrayList<Ressource> c){
		super("Castle", c);
		nbSlots = 8;
		stocks = new ArrayList<Ressource>();
		stocks.add(new Ressource("Gold", 2000));
		stocks.add(new Ressource("Wood", 2000));
		stocks.add(new Ressource("Iron", 2000));
		stocks.add(new Ressource("Stone", 2000));
		stocks.add(new Ressource("Food", 2000));
	}

	public void levelUp(){
		super.levelUp();
		nbSlots += 2;
		for (Ressource r : stocks){
			r.increaseQuantity(500*this.getLevel());
		}
	}

	public ArrayList<Ressource> getStocks(){
		return stocks;
	}

	public String toString(){
		String s = super.toString();
		s += "\nNb field slots : "+ nbSlots+ " - Capacity : ";
		for (Ressource r : getStocks()){
			s+= r.toString2() + "   " ;
		}
		return s;
	}

}

