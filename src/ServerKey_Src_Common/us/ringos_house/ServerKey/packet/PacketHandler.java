package us.ringos_house.ServerKey.packet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import us.ringos_house.ServerKey.Shared.Strings;
import us.ringos_house.ServerKey.Validation.ClientValidation;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler 
{
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		//We received a packet
		try
		{
			//Load this into a stream
			ByteArrayInputStream streamByte = new ByteArrayInputStream(packet.data);
			DataInputStream stream = new DataInputStream(streamByte);
			try
			{
				//Tell the server to validate the message
				ClientValidation.Validate(stream.readUTF());
			}
			finally
			{
				//close everything
				stream.close();
				streamByte.close();
			}
		}
		//catch ALL exceptions
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void SendValidation(String myServerKey)
	{
		try
		{
			//Setup a stream for the new packet
			ByteArrayOutputStream streambyte = new ByteArrayOutputStream();
			DataOutputStream stream = new DataOutputStream(streambyte);
			try
        	{
				//add the serverKey to validate
        		stream.writeUTF(myServerKey);
        	}
        	finally
        	{
        		//close our streams
        		stream.close();
        		streambyte.close();
        	}
			//send the packet
			PacketDispatcher.sendPacketToServer(new Packet250CustomPayload(Strings.packetChannel, streambyte.toByteArray()));
		}
		//catch ALL exceptions
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
