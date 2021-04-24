package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Serialize
{
	static String filePath = "./Player Profiles/";
	static ArrayList<PlayerProfile> playerProfiles = new ArrayList<PlayerProfile>();
	
	public Serialize() throws ClassNotFoundException, IOException
	{	
		// LoadFiles(); // Removed this as it caused files to be loaded twice.
	}
	
	public void Serializer(PlayerProfile entry) throws IOException, ClassNotFoundException
	{
		FileOutputStream outStream = new FileOutputStream(filePath + entry.getPlayerName() + ".dat", false); // Serializes the file, naming it after the player's profile, and will overwrite any duplicate.
		
		ObjectOutputStream objOutFile = new ObjectOutputStream(outStream);
		objOutFile.writeObject(entry);
		objOutFile.close();
	}
	
	public  void CheckForProfileFolder()
	{
		File f = new File(filePath);
		
		if (!f.exists())
			f.mkdir(); // If the filePath does not exist, then it will create a new folder named Player Profiles.
	}
	
	public  void LoadFiles() throws IOException, ClassNotFoundException
	{
		playerProfiles.clear();
		
		System.out.println("Load Files has been called");
		
		CheckForProfileFolder();
		
		String[] fileNames;
		
		File f = new File(filePath);
		fileNames = f.list();
		
		for (String fileName : fileNames)
		{	
			PlayerProfile pp = Deserializer(fileName, f);
			
			if (pp != null)
			{
				playerProfiles.add(pp);
			}
			else 
			{
				System.out.println("No profile found");
				
				return;
			}
		}
	}
	
	public  PlayerProfile Deserializer(String fileName, File f) throws IOException, ClassNotFoundException
	{
		Object obj = null;
		
		if (f.exists())
		{
			FileInputStream inStream = new FileInputStream(f + "/" + fileName);
			ObjectInputStream objInFile = new ObjectInputStream(inStream);
			
			obj = objInFile.readObject();
			
			objInFile.close();
			return
					(PlayerProfile)obj;
			
		}
		else
			return (PlayerProfile) obj;
	}
	
}
