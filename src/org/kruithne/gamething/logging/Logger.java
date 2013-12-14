package org.kruithne.gamething.logging;

public class Logger
{
	public static void log(Object message)
	{
		System.out.println(message);
	}

	public static void logException(Exception exception)
	{
		exception.printStackTrace();
	}
}
