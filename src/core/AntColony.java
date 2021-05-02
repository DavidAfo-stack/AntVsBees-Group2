package core;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import ants.BodyguardAnt;
import ants.QueenAnt;

/**
 * An entire colony of ants and their tunnels.
 * @author Joel
 * @version Fall 2014
 */
public class AntColony
{
	public static final String QUEEN_NAME = "AntQueen"; //name of the Queen's place
	public static final int MAX_TUNNEL_LENGTH = 8; // ==Niall== I tried changing this, it is 8 for a reason.
	
	private int startingFood; // So that the starting amount of food can be accessed for restarting the game.
	private int food; //amount of food available
	public Place queenPlace; //where the queen is
	public ArrayList<Place> places; //the places in the colony
	private ArrayList<Place> beeEntrances; //places which bees can enter (the starts of the tunnels)
	public boolean paused; // ==Niall== True if the game is paused
	private boolean queenExists; // ==Niall== To check if the Queen exists, so that more than one cannot be placed.
	private int speed; //==Niall== A method of changing the speed of the bees for the difficulty setting.
	private int tunnelLength;
	private int numTunnels;
	
	
	/**
	 * Creates a new ant colony with the given layout.
	 * @param numTunnels The number of tunnels (paths)
	 * @param tunnelLength The length of each tunnel
	 * @param moatFrequency The frequency of which moats (water areas) appear. 0 means that there are no moats
	 * @param startingFood The starting food for this colony.
	 */
	
//	public AntColony(int numTunnels, int tunnelLength, int moatFrequency, int startingFood) I have kept this just in case any issues arise with the new function
	
	public AntColony(int numTunnels, int tunnelLength, int speed, int startingFood)
	{
		//simulation values
		this.startingFood = startingFood;
		this.food = startingFood;
		this.speed = speed;
		this.tunnelLength = tunnelLength;
		this.numTunnels = numTunnels;
		//init variables
		places = new ArrayList<Place>();
		beeEntrances = new ArrayList<Place>();
		queenPlace = new Place(QUEEN_NAME); //magic variable namexw

		tunnelLength = Math.min(tunnelLength, MAX_TUNNEL_LENGTH); //don't go off the screen!
		//set up tunnels, as a kind of linked-list
		Place curr, prev; //reference to current exit of the tunnel
		for(int tunnel=0; tunnel<numTunnels; tunnel++)
		{
			curr = queenPlace; //start the tunnel's at the queen
			for(int step=0; step<tunnelLength; step++)
			{
				prev = curr; //keep track of the previous guy (who we will exit to)

				curr = new Place("tunnel["+tunnel+"-"+step+"]", prev); //create new place with an exit that is the previous spot

				prev.setEntrance(curr); //the previous person's entrance is the new spot
				places.add(curr); //add new place to the list
			}
			beeEntrances.add(curr); //current place is last item in the tunnel, so mark that it is a bee entrance
		} //loop to next tunnel
	}

	/**
	 * Returns an array of Places in this colony. Places are ordered by tunnel, with each tunnel's places listed start to end.
	 * @return The tunnels in this colony
	 */
	public Place[] getPlaces()
	{
		return places.toArray(new Place[0]);
	}
	
	/**
	 * Returns an array of places that the bees can enter into the colony
	 * @return Places the bees can enter
	 */
	public Place[] getBeeEntrances()
	{
		return beeEntrances.toArray(new Place[0]);
	}

	/**
	 * Returns the queen's location
	 * @return The queen's location
	 */
	public Place getQueenPlace()
	{
		return queenPlace;
	}
	
	public int getStartingFood() 
	{
		return startingFood;
	}
	
	/**
	 * Returns the amount of available food
	 * @return the amount of available food
	 */
	public int getFood()
	{
		return food;
	}
	
	
	/**
	 * Increases the amount of available food
	 * @param amount The amount to increase by
	 */
	public void increaseFood(int amount)
	{
		food += amount;
	}
	
	/**
	 * Returns if there are any bees in the queen's location (and so the game should be lost)
	 * @return if there are any bees in the queen's location
	 */
	public boolean queenHasBees()
	{
		if (queenPlace.guarded)
			return false;
		
		return this.queenPlace.getBees().length  > 0;
	}
	
	//place an ant if there is enough food available
	/**
	 * Places the given ant in the given tunnel IF there is enough available food. Otherwise has no effect
	 * @param place Where to place the ant
	 * @param ant The ant to place
	 */
	public void deployAnt(Place place, Ant ant)
	{	
		if (place.getWater() && !ant.canSwim)
		{
			paused = true;
			JOptionPane.showMessageDialog(null, "This ant cannot swim!");
			paused = false;
			return;
		}
		
		if (ant instanceof QueenAnt)
			{
			if (QueenPlacer(place, ant))
			{
				//continues, else it stops anything else from running
			}
			else
			{
				paused = true;
				JOptionPane.showMessageDialog(null, "A Queen ant has already been placed in the colony!");
				paused = false;
				return;
			}
		}
		
		if(this.food >= ant.getFoodCost()/* && place.getAnt() == null*/) // ==Niall== Edit made here, added place.getAnt() == null to make sure food is only taken when the place is empty.
		{
			if (place.getAnt() != null) // If there is an ant in the place
			{
				if (ant.overlays) // If the ant you are trying to place is an overlay ant
				{
					if (!place.guarded) // If the place is not being guarded
					{
						this.food -= ant.getFoodCost();
						place.addInsect(ant);
						place.guarded = true;
						return;
					}
				}
//				paused = true;
//				JOptionPane.showMessageDialog(null, "There is already an ant here");
//				paused = false;
			}
			if (place.getAnt() == null)
			{
				if (ant.overlays)
					place.guarded = true;
				this.food -= ant.getFoodCost();
				place.addInsect(ant);
				return;
			}
		}
		// ==Niall== Added this else statement to ensure that the correct error is displayed.
		if (place.getAnt() != null) // ==Niall== These JOption panes should be paired with a future pause system to pause the game when they are showing.
			{
				paused = true;
				JOptionPane.showMessageDialog(null, "There is already an ant here");
				paused = false;
				return;
			}
			else
		{
			System.out.println("Not enough food remains to place "+ant);
			paused = true;
			JOptionPane.showMessageDialog(null, "Not enough food to place ant");
			paused = false;
		}
	}

	boolean QueenPlacer(Place place, Ant ant)
	{
		if (!queenExists)
		{
			System.out.println("Deploying queen");
			
			queenPlace = place;
			queenExists = true;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Removes the ant inhabiting the given Place
	 * @param place Where to remove the ant from
	 */
	public void removeAnt(Place place, boolean gameOver)
	{
		if(place.getAnt() != null)
		{
			if (place.getAnt() instanceof QueenAnt && !gameOver)
			{
				paused = true;
				JOptionPane.showMessageDialog(null, "You cannot remove the queen ant!");
				paused = false;
				return;
			}
			
			if (place.getAnt() instanceof BodyguardAnt)
			{
				place.guarded = false;
			}
			place.removeInsect(place.getAnt());
		}
	}
	
	/**
	 * Returns a list of all the ants currently in the colony
	 * @return a list of all the ants currently in the colony
	 */
	public ArrayList<Ant> getAllAnts()
	{
		ArrayList<Ant> ants = new ArrayList<Ant>();
		for(Place p : places)
		{
			if(p.getAnt() != null)
			{
				for (Ant ant : p.getAnts())
				{
					ants.add(ant); // Altered this so that it goes through the arraylist in each place and checks for multiple ants.
					// Allows for ants to function correctly when overlaid by a bodyguard ant.
				}
			}
		}
		return ants;
	}
	
	/**
	 * Returns a list of all the bees currently in the colony
	 * @return a list of all the bees currently in the colony
	 */
	public ArrayList<Bee> getAllBees()
	{
		ArrayList<Bee> bees = new ArrayList<Bee>();
		for(Place p : places)
		{
			for(Bee b : p.getBees())
				bees.add(b);
		}
		return bees;
	}
	
	public String toString()
	{
		return "Food: "+this.food+"; "+getAllBees() + "; "+getAllAnts();
	}
	
	public boolean getPaused()
	{
		return paused;
	}

	public int getSpeed() 
	{
		return speed;
	}
	
	/** Purges the current colony of all ants and bees, and returns a new colony.
	 * 
	 * @return AntColony
	 */
	public AntColony purgeColony()
	{
		AntColony newColony;
		
		System.out.println("Purging colony");
		
		queenPlace = new Place(QUEEN_NAME);
		queenExists = false;
		
		ArrayList<Ant> ants;
		
		ants = getAllAnts();
		
		for (Ant ant : ants)
		{
			ant.reduceArmor(100);
			
			System.out.println("Ant Damaged");
		}
		
		ArrayList<Bee> bees;
		bees = getAllBees();
		for (Bee b : bees)
		{
			b.reduceArmor(100);
		}
		
		newColony = new AntColony(numTunnels, tunnelLength, speed, startingFood);
		return newColony;
	}
	
}
