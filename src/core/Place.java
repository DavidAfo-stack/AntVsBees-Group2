package core;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a location in the game
 * @author Joel
 * @version Fall 2014
 */
public class Place
{
	private String name; //a name we can use for debugging
	private Place exit; //where you leave this place to
	private Place entrance; //where you enter this place from
	private ArrayList<Bee> bees; //bees currently in the place
	private ArrayList<Ant> ants;
	private Ant ant; //ant (singular) currently in the place
	private boolean waterLogged; // A boolean to check if the place is full of water
	public boolean guarded = false;
	
	/**
	 * Creates a new place with the given name and exit
	 * @param name The place's name
	 * @param exit The place's exit
	 */
	public Place(String name, Place exit)
	{
		this.name = name;
		this.exit = exit;
		this.entrance = null;
		this.bees = new ArrayList<Bee>();
		this.ants = new ArrayList<Ant>();
		this.ant = null;
		waterLogged = GenerateWater();
		System.out.println(waterLogged);
	}
	
	// Returns a boolean to randomly assign water to different places.
	private boolean GenerateWater()
	{
		int i;
		
		i = (int)Math.floor(Math.random()*(100 - 0 + 1));
		
		System.out.println(i);
		
		if (i >= 80)
		{
			return true; // ==Niall= Returns true, so this place will be marked as water logged.
		}
		
		else
			return false; // ==Niall= Returns false, so this place will not be marked as water logged.
	}
	
	/**
	 * Creates a new place with the given name
	 * @param name The place's name
	 */
	public Place(String name)
	{
		this(name, null);
	}
	
	/**
	 * Returns the place's ant
	 * @return the place's ant
	 */
	public Ant getAnt()
	{
		if (ants.isEmpty())
			return ant;
		else
			return priorityAnt();
	}
	
	public Ant priorityAnt()
	{
		for (Ant a : ants)
		{
			if (a.priority)
			{
				return a;
			}
		}
		return ants.get(0);
	}
	
	/**
	 * Returns an array of the place's bees
	 * @return an array of the place's bees
	 */
	public Bee[] getBees()
	{
		return bees.toArray(new Bee[0]);
	}
	
	/**
	 * Returns a nearby bee, up to the maxDistance ahead. If multiple bees are the same distance, a random bee is chosen
	 * @param minDistance The minimum distance away (in Places) a bee can be. A value of -1 means no min distance
	 * @param maxDistance The maximum distance away (in Places) a Bee can be. A value of -1 means no max distance
	 * @return A random nearby bee.
	 */
	public Bee getClosestBee(int minDistance, int maxDistance)
	{
		Place p = this;
		for(int dist = 0; p!=null && dist <= maxDistance; dist++)
		{
			// System.out.println("Number of Bees: " + p.bees.size());
			
			if(dist >= minDistance && p.bees.size() > 0)
				return p.bees.get((int)(Math.random()*p.bees.size())); //pick a random bee
			p = p.entrance;
		}
		return null;
	}

	//new function to get all bees in the tunnel ==Niall and david==
	public ArrayList<Bee> getAllBees(int minDistance, int maxDistance) // Gets all of the bees in the current place's tunnel and returns it as an arraylist

	{
		ArrayList<Bee> beeArrayList = new ArrayList<Bee>();
		Bee[] bees;
		Place p = this;
		for (int dist = 0; p!=null && dist <= maxDistance; dist++)
		{
			System.out.println("Number of Bees: " + p.bees.size());
			if (dist >= minDistance && p.bees.size() > 0)
			{
				System.out.println("Bee found");
				beeArrayList.addAll(p.bees);
			}
			p = p.entrance;
		}
		return beeArrayList;
	}
	
	/**
	 * Returns the name of the place
	 * @return the name of the place
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the exit of the place
	 * @return the exit of the place
	 */
	public Place getExit()
	{
		return exit;
	}
	
	/**
	 * Sets the entrance to the place
	 * @param entrance The entrance to the place
	 */
	public void setEntrance(Place entrance)
	{
		this.entrance = entrance;
	}
	
	/**
	 * Returns the entrance to the place
	 * @return the entrance to the place
	 */
	public Place getEntrance()
	{
		return this.entrance;
	}
	
	/**
	 * Adds an ant to the place. If there is already an ant, this method has no effect
	 * @param ant The ant to add to the place.
	 */
	public void addInsect(Ant ant)
	{
		System.out.println("Ant arraylist " + ants);
		
		if (!ants.isEmpty())
		{
			System.out.println("Ants is not empty");
			if (ant.overlays && !guarded)
			{
				System.out.println("Adding overlay ant: " + ant);
				ants.add(ant);
				ant.setPlace(this);
				guarded = true;
				return;
			}
			else
				return;
		}
		System.out.println("Adding ant: " + ant);
		// this.ant = ant;
		ants.add(ant);
		ant.setPlace(this);
		
//		if(override/*this.ant == null*/)
//		{
//			this.ant = ant;
//			ant.setPlace(this);
//		}
//		else
//			System.out.println("Already an ant in "+this); //report error
	}
	
	/**
	 * Adds a bee to the place
	 * @param bee The bee to add to the place.
	 */
	public void addInsect(Bee bee)
	{
		bees.add(bee);
		bee.setPlace(this);
	}	

	/**
	 * Removes the ant from the place. If the given ant is not in this place, this method has no effect
	 * @param ant The ant to remove from the place
	 */
	public void removeInsect(Ant ant)
	{
		if (ants.contains(ant)) 
		{
			ants.remove(ant);
			ant.setPlace(null);
		}
		
//		if(this.ant == ant)
//		{
//			this.ant = null;
//			ant.setPlace(null);
//		}
		if (ant.overlays)
		{
			guarded = false;
		}
		else
			System.out.println(ant + " is not in "+this);
	}
	
	/**
	 * Removes the bee from the place. If the given bee is not in this place, this method has no effect
	 * @param bee The bee to remove from the place.
	 */
	public void removeInsect(Bee bee)
	{
		if(bees.contains(bee))
		{
			bees.remove(bee);
			bee.setPlace(null);
		}
		else
			System.out.println(bee + " is not in "+this);
	}
	
	public String toString()
	{
		return name;
	}
	
	public boolean getWater()
	{
		return waterLogged;
	}
	
	public void setWater(boolean set)
	{
		waterLogged = set;
	}
}
