package us.ringos_house.ServerKey.Shared;

public class Strings 
{
	
	//Mod Info
    public static final String id = "ServerKey";
    public static final String modName = "ServerKey";
    public static final String ver = "@VERSION@";
    public static final String channel = id;
    public static final String depend = "required-after:Forge@[7.7.1.650,)";
    public static final String domain = "us.ringos_house.";
    
    public static final String packetChannel = id;
    
    public static final String proxy = domain + id + ".sided.proxy.";
    public static final String clientProxy = proxy + "ClientProxy";

    
    //config strings
    public static final String ServerCategory = id + ".Server";
    public static final String ClientCategory = id + ".Client";
    public static final String serverKey = "ServerKey";
    public static final String kickMessage = "KickMessage";
}
