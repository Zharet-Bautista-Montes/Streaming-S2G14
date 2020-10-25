package main;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.*;

public class Receptor extends JFrame
{
	private static Scanner parametrizador = new Scanner(System.in);

	private static InetAddress[] direcciones = new InetAddress[3];

	private static int[] puertos = new int[3];
	
	private MulticastSocket actual = null; 
	
	private Receptor()
	{
		super();
		setLayout(new BorderLayout());
		visualizar();
		setSize(1500, 1200);
		setVisible(true);
	}
	
	private void visualizar()
	{
		JPanel opciones = new JPanel();
		add(opciones, BorderLayout.NORTH);
		JMenu menu = new JMenu();
		opciones.add(menu);
	}

	public static void main(String[] args) 
	{
		System.out.println("Bienvenido al receptor de canales");
		try
		{
			for(int a = 0; a < 3; a++)
			{
				System.out.println("Por favor, indique la direccion del canal " + (a+1));		
				direcciones[a] = InetAddress.getByName(parametrizador.next()); 
				System.out.println("Por favor, configure el puerto para el canal " + (a+1));
				puertos[a] = parametrizador.nextInt();
			}
			System.out.println("En breve, se desplegará el visualizador...");
			new Receptor();
		}
		catch (Exception e) 
		{	e.printStackTrace(); 	}
	}
}