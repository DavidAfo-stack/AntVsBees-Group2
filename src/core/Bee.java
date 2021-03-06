package core;

/**
 * Represents a Bee
 * @author YOUR NAME HERE
 */
public class Bee extends Insect {
	private static final int DAMAGE = 1;
	int stun_action = 0; // number of stun remaining
	int slow_action = 0;
	int turns = 0;
	int slowCounter = 0;
	
	/**
	 * Creates a new bee with the given armor
	 *
	 * @param armor The bee's armor
	 */
	public Bee(int armor) {
		super(armor);
	}

	/**
	 * Deals damage to the given ant
	 *
	 * @param ant The ant to sting
	 */
	public void sting(Ant ant) 
	{
		// // System.out.println("This bee's target is" + ant);
		
		ant.reduceArmor(DAMAGE);
		
		// // System.out.println("Damaged " + ant);
	}

	/**
	 * Moves to the given place
	 *
	 * @param place The place to move to
	 */
	public void moveTo(Place place) {
		this.place.removeInsect(this);
		place.addInsect(this);
	}

	public void leavePlace() {
		this.place.removeInsect(this);
	}

	/**
	 * Returns true if the bee cannot advance (because an ant is in the way)
	 *
	 * @return if the bee can advance
	 */
	public boolean isBlocked() {
		//===> This was modified by David to handle the Ninja Ant invincible attribute
		//The Ninja ant was implemented to not block bees in its place
		if (this.place.getAnt() != null) {
			// // System.out.println(this.place.getAnt());
			if (this.place.getAnt().blockBeePath == false) {
				return false;
			}
			return this.place.getAnt().blockBeePath;
		} else {
			return false;
			//return this.place.getAnt() != null;
		}
	}

	/**
	 * A bee's action is to sting the Ant that blocks its exit if it is blocked,
	 * otherwise it moves to the exit of its current place.
	 */
	public void action(AntColony colony) {
		/** David Afolabi
		 * 	modified to check if the armor is greater than zero
		 * 	and also check if the bee is blocked
		 * 	this is implemented because the fire ant does a high damage to the bee
		 *
		 * David=> I have created a condition to check if the ant should create a slow or stun effect
		 * as in case of the Stun and Slow thrower ant
 		 */
		if(stun_action<=0){
			if(slow_action > 0){
				slowCounter = (slowCounter+1)%3;
			}
			if(slow_action == 0 || slowCounter == 0){
				turns++;
				if (this.armor > 0 && this.isBlocked())
					sting(this.place.getAnt());
				else if (this.armor > 0)
					this.moveTo(this.place.getExit());
			}
			else if(armor > 0 && turns > 1){
				moveTo(place.getExit());
			}
		}
		stun_action = stun_action -1;
		slow_action -= 1;
	}
    //David=> stun action of the stun thrower ant
	public void stun_effect(int i) {
		if(this.stun_action<i){
			this.stun_action = i;
		}
	}
	//David => slow action of the slow thrower ant
	public void slow_effect(int i){
		if(this.slow_action < i) {
			this.slow_action = i;
		}
	}
}
