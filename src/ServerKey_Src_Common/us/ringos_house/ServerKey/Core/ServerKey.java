package us.ringos_house.ServerKey.Core;

import us.ringos_house.ServerKey.Shared.Config;
import us.ringos_house.ServerKey.Shared.Strings;
import us.ringos_house.ServerKey.packet.PacketHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod
	(
		modid = Strings.id,
		name = Strings.modName,
		version = Strings.ver,
		dependencies = Strings.depend
    )
@NetworkMod
	(
		clientSideRequired = true,
		serverSideRequired = true,
		packetHandler = PacketHandler.class
	)
public class ServerKey 
{
	@Instance
	public static ServerKey instance;
	
	@PreInit
    public void preInit(FMLPreInitializationEvent evt) 
	{
    	Config.init(evt);
    }
}
