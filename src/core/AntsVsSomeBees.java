package core;

/**
 * A driver for the Ants vs. Some-Bees game
 */
public class AntsVsSomeBees
{
	public static int startingFood = 25; // ==Niall== I just added this so that it could be easily identified and altered.
	
	public static void main(String[] args)
	{
		AntColony colony = new AntColony(3, 8, 0, startingFood); //specify the colony [tunnels, length, moats, food]
		//Hive hive = Hive.makeTestHive(); //specify the attackers (the hive)
		Hive hive = Hive.makeFullHive();
		//Hive hive = Hive.makeInsaneHive();
		new AntGame(colony,hive); //launch the game
	}
}
