package us.ringos_house.ServerKey.Validation;

import net.minecraft.entity.player.EntityPlayerMP;
import us.ringos_house.ServerKey.Shared.Config;
import us.ringos_house.ServerKey.Shared.FunctionHelpers;

public class ClientValidation 
{
	public static void Validate(String key, EntityPlayerMP ePlayer)
	{
		//need to make sure the key sent matches the server
		if (!Config.ServerKey.equals(key))
		{
			//Key does not match, kick them with the message
			ePlayer.playerNetServerHandler.kickPlayerFromServer(FunctionHelpers.formatColors(Config.KickMessage));
		}
	}
}
