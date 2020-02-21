import java.util.HashMap;
import java.util.LinkedList;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph=new Graph();
		graph.initializeUSA();	///////graph.initializeUSA();
		int blue=0,red=0;
		 graph.map= Game.randomizeColours(graph.map);
		
		for(int i =0;i<graph.map.size();i++) {
			System.out.println(graph.map.get(i).color);
		if(graph.map.get(i).color==Colour.BLUE)
			blue++;
		else red++;
		}
		System.out.println(blue+"   "+red);
		
	}
	
	
	
	
	
	
	
	//Generate Random cities for each player
	public static LinkedList<City> randomizeColours(LinkedList<City> map) {			
		HashMap<Integer,Boolean > cities = new HashMap<Integer, Boolean>();
        int key;

		for(int i=0;i<map.size()/2;i++)
		{
			key= (int)(Math.random()*1000)%map.size() ;
			if(!cities.containsKey(key))
			{
				cities.put(key, true);
				map.get(key).color=Colour.RED;
				
			}else {
				i--;
			}
			
			
		}
		for(int i=0;i<map.size();i++) {
			if(map.get(i).color!=Colour.RED)
					map.get(i).color=Colour.BLUE;
		}
       
		return map;
	}
}

