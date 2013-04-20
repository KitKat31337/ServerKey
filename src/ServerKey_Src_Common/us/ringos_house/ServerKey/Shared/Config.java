package us.ringos_house.ServerKey.Shared;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config 
{
	//Common config items
	public static String ServerKey = "P@ssW0rd";
	
	//Server Config Items
	public static String KickMessage = "Your installation does not match the server.  Please contact a server operator.";
	
	public static void init(FMLPreInitializationEvent event) 
	{
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        InitializeConfig(config);
        if (config.hasChanged()) config.save();
	}

	private static void InitializeConfig(Configuration config) 
	{
		config.addCustomCategoryComment(Strings.category, "Options for ServerKey Mod");
		ServerKey = config.get(
				Strings.category, 
				Strings.serverKey, 
				ServerKey, 
				"The key to validate.  Enter any string such as a password or version").getString();
		
		if (FMLCommonHandler.instance().getSide().isServer())
		{
			KickMessage = config.get(
					Strings.category,
					Strings.kickMessage,
					KickMessage,
					"The message to give players when validation fails.").getString();
		}
	}
}
