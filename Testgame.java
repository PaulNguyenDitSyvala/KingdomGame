import java.util.ArrayList;

public class Testgame{
	public static void main(String[] args){
		Kingdom k = new Kingdom("The Great Kingdom");
		ArrayList<Ressource> costGoldWarehouse = new ArrayList<Ressource>();
		costGoldWarehouse.add(new Ressource("Gold", 1000));
		costGoldWarehouse.add(new Ressource("Wood", 50));

		Storage s1 = new Storage("Gold", costGoldWarehouse);

		k.build(s1);
		System.out.println(s1.toString());

		k.build(s1);
		k.build(s1);


	}
}

