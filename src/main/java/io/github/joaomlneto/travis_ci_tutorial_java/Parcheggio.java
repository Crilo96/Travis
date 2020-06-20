package io.github.Crilo96.PARKING_Travis;

public class Parcheggio {
	
	private boolean[] garage;  
	
	public Parcheggio() 
	{
		 garage = new boolean[3];
	}
	
	public boolean scegliPosto(int num) 
	{
		//I posti sono solo tre
		if(num>=0 && num<=2) 
		{
			//Posso modificare il parcheggio 0 se 1 e 2 sono vuoti
			if(num==0 && !garage[1] && !garage[2]) 
			{
				garage[num]=!garage[num];
				return true;
			}
			
			//Posso modificare il parcheggio 1 solo se 2 è vuoto
			if(num==1 && !garage[2]) 
			{
				garage[num]=!garage[num];
				return true;
			}
			
			//Posso sempre modificare il parcheggio 2
			if (num==2) 
			{
				garage[num]=!garage[num];
				return true;
			}
		}
		return false;
	}
	
	public boolean pieno()
	{
		//Il parcheggio è pieno sse tutti i posti sono occupati
		if(garage[0] && garage[1] && garage[2])
		{
			return true;
		}
		return false;
	}
	
	public boolean malRiempito()
	{
		//Malriempito se 1 occupato e 0 vuoto
		if(garage[1] && !garage[0])
		{
			return true;
		}
		
		//Malriempito se 2 occupato e 1 vuoto
		if(garage[2] && !garage[1])
		{
			return true;
		}
		
		//IMPORTANTE: i controlli incrociati vengono coperti automaticamente dai due controlli sopra
		
		return false;
	}
	
	@Override
	public String toString() 
	{	
		String s="";
		for(int i=0;i<garage.length;i++) 
		{	
			if(garage[i]) 
			{
				s+="*";
			}
			else 
			{
				s+="O";
			}
		}
		return s;
	}
	
}
