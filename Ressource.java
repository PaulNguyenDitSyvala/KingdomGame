public class Ressource{
	private String type;
	private int quantity;

	public Ressource(String t){
		quantity = 0;
		type = t;
	}

	public Ressource(String t, int n){
		quantity = n;
		type = t;
	}

	public Ressource(Ressource r){
		quantity = r.quantity;
		type = r.type;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setQuantity(int n){
		quantity = n;
	}

	public void increaseQuantity(int n){
		quantity += n;
	}

	public void decreaseQuantity(int n){
		if (n <= quantity)
			quantity -= n;
		else
			System.out.println("You do not have enough "+type);
	}

	public String getType(){
		return type;
	}

	public String toString(){
		return type + " : "+ quantity;
	}

	public String toString2(){
		return quantity + " " + type;
	}

	public boolean correctType(Ressource r){
		return (type.equals(r.type));  // equals pour comparer les String  
	}

}

