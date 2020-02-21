import java.util.LinkedList;
public class AggressiveAgent implements Agent {
	
	public int x;
	public int i,j,k;
	public int index,index1;
	public int count,count1;
	public int current_armies=20;
	public int extra_armies;
	public int MAX=20;
	public final int MIN=1;
	City max = new City(99);

 
	@Override
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
	
	@Override
	public int extraArmies(LinkedList<City> map, Colour colour) {
		// TODO Auto-generated method stub
		for(j=0;j<map.size();j++)
		{
			if(map.get(j).color == colour)
				count++;
		}
		return Math.max(3,count/3);
	}
	
	
             
	public void search(Graph graph,Colour colour)
	{LinkedList<City> map= graph.map;
		extra_armies=extraArmies(map,colour);
		for(k=0;k<map.size();k++)
		{
			if(map.get(k).armies > max.armies)
				max=map.get(k);
		}
		index=max.ID-1;
		map.get(index).armies += extra_armies;
	}
	
	public boolean can_attack(City city)
	{
		for(i=0;i<city.neighbours.size();i++)
		{
			if(city.armies > city.neighbours.get(i).armies && city.color != city.neighbours.get(i).color)
	        		return true;
		}
	return false;	
	}
	
	public void attack(Graph graph,Colour colour)
	{LinkedList<City> map=  graph.map;
		int counter=0,s=0,index1=0;
		while(can_attack(map.get(index)))
		{
			for(counter=0;counter<map.get(index).neighbours.size();counter++)
			{
				if(map.get(index).armies > map.get(index).neighbours.get(counter).armies) {
					index1=counter;
				
			}
			
			if(map.get(index).neighbours.get(index1).color != colour)
			{
				map.get(index).neighbours.get(index1).color=colour;
				map.get(index).neighbours.get(index1).armies=1;
				map.get(index).armies--;
				s=index1+1;
				System.out.println("Aggressive Attacked City " + s);
			}
		}
			search(graph,colour);
	}
}
}
	