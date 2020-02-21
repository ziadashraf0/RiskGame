import java.util.HashMap;
import java.util.LinkedList;

public class PassiveAgent {
	public void search(LinkedList<City> map,Colour colour)
	{
		int i,numberArmies=Integer.MAX_VALUE,index=0;
		for(i=0;i<map.size();i++)
		{
			if(map.get(i).color==colour&& map.get(i).armies<numberArmies )
			{
				index=i;
			}
		}
		map.get(index).armies+=extraArmies(map, colour);

	}


	public void initializeMap(LinkedList<City> map,Colour colour) {
		int key;

		for(int i=0;i<20;i++)
		{	System.out.println(i);
			key= (int)(Math.random()*1000)%map.size() ;
			if(map.get(key).color==colour)
				map.get(key).armies++;
			else i--;

		}
	}
	public int  extraArmies(LinkedList<City> map,Colour colour) {
		int i,count=0;
		for(i=0;i<map.size();i++)
		{
			if(map.get(i).color==colour)
			{
				count++;
			}
		}
		return Math.max(3, count/3);
	}

}