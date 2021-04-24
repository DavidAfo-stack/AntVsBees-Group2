package core;

import java.io.Serializable;

public class PlayerProfile implements Serializable
{
	private String playerName;
	
	public PlayerProfile()
	{
		playerName = null;
	}
	
	public PlayerProfile(String name)
	{
		playerName = name;
	}

	public String getPlayerName() {
		return playerName;
	}
}
