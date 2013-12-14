package org.kruithne.gamething.logging;

public class Logger
{
	public void log(Object message)
	{
		System.out.println(message);
	}

	public void logException(Exception exception)
	{
		exception.printStackTrace();
	}
}
