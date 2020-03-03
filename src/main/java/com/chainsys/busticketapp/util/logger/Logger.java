package com.chainsys.busticketapp.util.logger;

import org.springframework.stereotype.Component;

@Component
public class Logger {
public static Logger getInstance() 
{
	Logger logger=new Logger();
	return logger;	
}
public void debug(Object message) 
{
System.out.println(message);	
}
public void info(Object message)
{
	System.out.println(message);
}
public void error(Object message)
{
	System.out.println(message);
}
public void input(Object message)
{
	System.out.println(message);
}
}