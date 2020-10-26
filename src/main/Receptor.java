package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.*;

public class Receptor extends JFrame implements ActionListener
{
	private static Scanner parametrizador = new Scanner(System.in);

	private static InetAddress[] direcciones = new InetAddress[3];

	private static int[] puertos = new int[3];
	
	private DatagramSocket actual = null; 
	
	private Receptor()
	{
		super();
		setLayout(new BorderLayout());
		visualizar();
		setSize(1200, 1000);
		setVisible(true);
	}
	
	private void visualizar()
	{
		JMenuItem c1 = new JMenuItem("Canal 1");
		JMenuItem c2 = new JMenuItem("Canal 2");
		JMenuItem c3 = new JMenuItem("Canal 3");
		JMenu menu = new JMenu("Lista de canales");
		menu.add(c1); menu.add(c2); menu.add(c3);
		JMenuBar mbarra = new JMenuBar();
		JMenuItem stop = new JMenuItem("Parar");
		stop.setEnabled(false);
		mbarra.add(menu); mbarra.add(stop);
		setJMenuBar(mbarra);
		mbarra.setVisible(true);
	}
	
	private void reproducir()
	{
		try 
		{
			actual = new DatagramSocket();
		} 
		catch (Exception e) 
		{	e.printStackTrace(); 	}
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

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
}