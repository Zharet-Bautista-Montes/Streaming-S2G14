package main;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Emisor 
{
	private static Scanner consola = new Scanner(System.in);

	public static void main(String[] args) 
	{
		System.out.println("Bienvenido al servidor de Streaming.");
		try 
		{
			System.out.println("Por favor, configure el puerto para el canal 1");
			int puerto1 = consola.nextInt(); InetAddress ip1 = InetAddress.getByName("234.4.3.2");
			Canal canal1 = new Canal(puerto1, "videos/video1.mp4", ip1);
			System.out.println("La dirección del canal 1 es: " + ip1.getHostName());
			System.out.println("Por favor, configure el puerto para el canal 2");
			int puerto2 = consola.nextInt(); InetAddress ip2 = InetAddress.getByName("234.1.0.1");
			Canal canal2 = new Canal(puerto2, "videos/video2.mp4", ip2);
			System.out.println("La dirección del canal 2 es: " + ip2.getHostName());
			System.out.println("Por favor, configure el puerto para el canal 3");
			int puerto3 = consola.nextInt(); InetAddress ip3 = InetAddress.getByName("234.2.3.4");
			Canal canal3 = new Canal(puerto3, "videos/video3.mp4", ip3);
			System.out.println("La dirección del canal 3 es: " + ip3.getHostName());
			canal1.start(); canal2.start(); canal3.start();
			System.out.println("Si desea detener el servidor, solo escriba 'STOP'");
			while(true)
			{
				if(consola.next().trim().equals("STOP")) break;
			}
			canal1.shutDown(); canal2.shutDown(); canal3.shutDown();
		}
		catch (Exception e) 
		{	e.printStackTrace(); 	}
	}

}