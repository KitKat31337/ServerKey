package us.ringos_house.ServerKey.Shared;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config 
{
	//Common config items
	public static String ServerKey = "P@ssW0rd";
	
	//Server Config Items
	public static String KickMessage = "&5ServerKey Validation Failed.  Contact your server operator.";
	
	public static void init(FMLPreInitializationEvent event) 
	{
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        InitializeConfig(config);
        if (config.hasChanged()) config.save();
	}

	private static void InitializeConfig(Configuration config) 
	{
		if (FMLCommonHandler.instance().getSide().isServer())
		{
			config.addCustomCategoryComment(Strings.ServerCategory, "Options for ServerKey Mod");
			KickMessage = config.get(
					Strings.ServerCategory,
					Strings.kickMessage,
					KickMessage,
					"The message to give players when validation fails.\n" +
					"Use colors by &<color Code> (http://www.minecraftwiki.net/wiki/Formatting_codes)").getString();
			ServerKey = config.get(
					Strings.ServerCategory, 
					Strings.serverKey, 
					ServerKey, 
					"The key to validate.  Enter any string such as a password or version").getString();
		}
		else
		{
			config.addCustomCategoryComment(Strings.ClientCategory, "Options for ServerKey Mod for the client");
			ServerKey = config.get(
					Strings.ClientCategory, 
					Strings.serverKey, 
					ServerKey, 
					"The key to validate.  Enter any string such as a password or version").getString();
		}
	}
}
