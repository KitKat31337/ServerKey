package us.ringos_house.ServerKey.packet;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import us.ringos_house.ServerKey.Shared.Strings;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PlayerTracker implements IPlayerTracker 
{

	@Override
	public void onPlayerLogin(EntityPlayer player) 
	{
		try
		{
			//Setup a stream for the new packet
			ByteArrayOutputStream streambyte = new ByteArrayOutputStream();
			DataOutputStream stream = new DataOutputStream(streambyte);
			try
        	{
				//add the serverKey to validate
        		stream.writeUTF("VALIDATE");
        	}
        	finally
        	{
        		//close our streams
        		stream.close();
        		streambyte.close();
        	}
			//send the packet
			PacketDispatcher.sendPacketToPlayer(new Packet250CustomPayload(Strings.packetChannel, streambyte.toByteArray()), (Player)player);
		}
		//catch ALL exceptions
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onPlayerLogout(EntityPlayer player) { }
	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {	}

	@Override
	public void onPlayerRespawn(EntityPlayer player) { }

}
