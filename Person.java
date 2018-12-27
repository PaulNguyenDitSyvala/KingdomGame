public class Person{
	private int id;
	private static int counter = 0;
	private boolean busy;
	private final int maxHp;
	private int currentHp;

	public Person(int maxHp, int currentHp, boolean busy){
		counter++;
		id = counter;
		this.busy = busy;
		this.maxHp = maxHp;
		this.currentHp = currentHp;
	}

	public Person(){
		this(100,100,false);
	}

	public Person(Person p){
		this(p.maxHp, p.currentHp, p.busy);
	}

	public boolean getBusy(){
		return busy;
	}

	public int getId(){
		return id;
	}

	public int getCurrentHp(){
		return currentHp;
	}

}






