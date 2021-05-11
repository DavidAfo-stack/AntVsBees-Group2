package core;

/**
 * A class representing a basic Ant
 * 
 * @author YOUR NAME HERE
 */
public abstract class Ant extends Insect
{
	protected int foodCost; //the amount of food needed to make this ant
	protected boolean blockBeePath; //An attribute to track if ant blocks bee==> Implemented by David.
	protected boolean canSwim; // ==Niall== Determines if the ant can be placed in water filled places;
	protected boolean priority = false;
	boolean overlays = false;
	public boolean unique; // ==Niall== Sets the ant to be unique and therefore a duplicate cannot be created
	public boolean buff = false; // ==Niall== A check for whether or not the ant's damage is buffed by the queen ant.
	protected int defaultDamage; // ==Niall== A way of keeping track of the ant's default damage while being able to modify it in code.
	
	/**
	 * Creates a new Ant, with a food cost of 0.
	 * @param armor The armor of the ant.
	 */
	public Ant(int armor, int food) // ==Niall== Added an int argument here named food so that the food cost can be modified in the individual ant classes
	{
		super(armor, null);
		this.foodCost = food;
		this.blockBeePath =  true; // set value to true to show that ant blocks bee
		this.canSwim = false; // If this constructor is called, then it is not the scuba or queen ant, and therefore cannot swim
	}

	public Ant(int armor, int food, boolean swim)
	{
		super(armor, null);
		this.foodCost = food;
		this.blockBeePath =  true; // set value to true to show that ant blocks bee
		this.canSwim = true; // If this constructor is called, then it is either the scuba or queen ant, and therefore can swim
	}
	
	/*
	 * This constructor is for the creation of the bodyguard ant.
	 */
	public Ant(int armor, int food, boolean swim, boolean priority, boolean overlays)
	{
		super(armor, null);
		this.foodCost = food;
		this.blockBeePath =  true; // set value to true to show that ant blocks bee
		this.canSwim = swim; // If this constructor is called, then it is either the scuba or queen ant, and therefore can swim
		this.priority = priority; // Sets if the ant is a priority target.
		// // System.out.println("making overlays true");
		// // System.out.println(overlays);
		this.overlays = overlays;
	}
	
	/**
	 * Returns the ant's food cost
	 * @return the ant's good cost
	 */
	public int getFoodCost()
	{
		return foodCost;
	}
	
	/**
	 * Removes the ant from its current place
	 */
	public void leavePlace()
	{
		this.place.removeInsect(this);
	}

}
