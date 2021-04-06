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
	
	/**
	 * Creates a new Ant, with a food cost of 0.
	 * @param armor The armor of the ant.
	 */
	public Ant(int armor, int food) // ==Niall== Added an int argument here named food so that the food cost can be modified in the individual ant classes
	{
		super(armor, null);
		this.foodCost = food;
		this.blockBeePath =  true; // set value to true to show that ant blocks bee
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
