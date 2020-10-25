package main;

import java.io.File;
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;

public class Canal extends Thread
{
	private MulticastSocket canal;

	private File emision;

	private boolean sending; 
	
	private InetAddress grupo;

	public Canal(int port, String videoname, InetAddress group)
	{
		//emision = new File(videoname); 
		sending = true; grupo = group;
		try 
		{
			canal = new MulticastSocket(port);	
			canal.joinGroup(grupo);
		}
		catch (Exception e) 
		{	e.printStackTrace(); 	}
	}

	public void shutDown()
	{
		sending = false;
	}

	public void run()
	{
		System.out.println("Está listo el canal en " + grupo.getHostName());
		while(sending)
		{
			try 
			{
				
			}
			catch (Exception e) 
			{	e.printStackTrace();	}
		}
		try 
		{	canal.leaveGroup(grupo);	}
		catch (Exception e) 
		{	e.printStackTrace();	}
	}
}