import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class AStarAgent implements Agent {
public static ArrayList<Graph> optimalGoals =new ArrayList<Graph>(); 
	
	@Override
	public void search(Graph graph, Colour colour) {
		// TODO Auto-generated method stub
		AStarAgent aStar=new AStarAgent();
		//Generate all possible enforcement;
		LinkedList<Graph> newStates=Graph.expand(graph.map, colour,aStar.extraArmies(graph.map, colour) );
	for(int enforcement=0;enforcement<newStates.size();enforcement++) {
    	int flag=0;

		if(flag==1)
			break;
		int key;
    	int value;
    	HashMap<Graph,Integer> explored = new HashMap<Graph,Integer>();
		ArrayList<Graph> frontier = new ArrayList<Graph>();							//Priority Queue
		graph.hueristics=AgentHelper.calculateHeuristic(graph.map, colour);
		frontier.add(graph);														//Add Initial state to the frontiers
		
		 explored.put(graph, graph.hueristics);
	        Graph currentState=new Graph();
	        
		while(frontier.size()>0) {
			currentState=frontier.get(0);						//get graph S with minimum H(n)
        	frontier.remove(0);									//deque maximum			
             explored.put(currentState, 0);
        	
             if(AgentHelper.calculateHeuristic(currentState.map, colour)==0)
             {
            	 System.out.println("winning.........");
            	 
     				for(int j=0;j<currentState.map.size();j++) {
     					System.out.println(currentState.map.get(j).ID+" "+currentState.map.get(j).color+"  "+currentState.map.get(j).armies+"  ");
     					}
     					System.out.println();
     					 flag=1;
     				optimalGoals.add(currentState);
            	 break;
             }
             if(AgentHelper.calculateHeuristic(currentState.map, colour)<=7) {
            	 System.out.println("sub optimal Goal");
            	 for(int j=0;j<currentState.map.size();j++) {
  					System.out.println(currentState.map.get(j).ID+" "+currentState.map.get(j).color+"  "+currentState.map.get(j).armies+"  ");
  					}
  					System.out.println();
  					optimalGoals.add(currentState);
            	 break;
             }
             
             
             
             ///Generate Power Set for new possible attacks
        	HashMap<Integer, Integer> canAttack = new HashMap<Integer,Integer>();
        			// get all possible cities which could be attacked
		        	for(int i=0;i<currentState.map.size();i++) {
		        		if(currentState.map.get(i).color== colour) {
		        			for(int j=0;j<currentState.map.get(i).neighbours.size();j++)
		        			{		//current city > current neighbour
		        				if(currentState.map.get(i).armies>=2&&currentState.map.get(i).armies>currentState.map.get(i).neighbours.get(j).armies&&currentState.map.get(i).neighbours.get(j).color!= colour )
		        				{		//key the city to be attacked
		        						//Value <= the city can attack by
		        					if(!canAttack.containsKey(currentState.map.get(i).neighbours.get(j).ID))
		        					{
		        						canAttack.put( currentState.map.get(i).neighbours.get(j).ID, currentState.map.get(i).ID);
		           					}	
		        				}
		        			}	
		        		}		
		        	}
		        	
        	ArrayList<ArrayList<Integer>> powerSet= AStarAgent.subsets(canAttack);
        	System.out.println(canAttack.size());
        	System.out.println(powerSet.size());
        	
        	
        	
        	
        	for(int i=0;i<powerSet.size();i++)
        	{
        		Graph g =new Graph();
        		//clone initialState
        		for(int k=0;k<currentState.map.size();k++)
        		{
        			City temp=new City(currentState.map.get(k).ID);
        				temp.armies=currentState.map.get(k).armies;
        				temp.color=currentState.map.get(k).color;
        				
        				g.map.add(temp);
        			
        		}
        		//LET'S ATTACK
        		for(int j=0;j<powerSet.get(i).size();j++)
        		{
        			if(powerSet.get(i).get(j)==null) {
        				break;
        					}
        			key= powerSet.get(i).get(j);							//to be Attacked
        			value=canAttack.get(powerSet.get(i).get(j));			//Attacker
        			 //Attacking
        			g.map.get(key-1).color=g.map.get(value-1).color;
        			g.map.get(key-1).armies=1;
        			//g.map.get(value-1).armies-=1;
        			
        			
        			
        		
        		}
        		if(!explored.containsKey(g))
        		{
        			//CALCULATE H(n)
        			g.hueristics=AgentHelper.calculateHeuristic(g.map, colour); 
        			int indx=getIndex(frontier, g);
            		frontier.add(indx,g);
	
        		}
        		        		
        	}

        	print(frontier);
        	
				}
		}
		int min=Integer.MAX_VALUE;
		int index=0;
		for(int i=0;i<optimalGoals.size();i++)
		{
			if(min>AgentHelper.calculateHeuristic(optimalGoals.get(i).map, colour)) {
				min=AgentHelper.calculateHeuristic(optimalGoals.get(i).map, colour);
				index=i;
			}
		}
		//Update map
		graph.hueristics=optimalGoals.get(index).hueristics;
		for(int i=0;i<graph.map.size();i++)
		{
			graph.map.get(i).armies=optimalGoals.get(index).map.get(i).armies;
			graph.map.get(i).color=optimalGoals.get(index).map.get(i).color;
			graph.map.get(i).ID=optimalGoals.get(index).map.get(i).ID;
		}
		Combinations.allCombinations.clear();
		optimalGoals.clear();
		
		
		
	}
	@Override
	public void initializeMap(LinkedList<City> map, Colour colour) {
		// TODO Auto-generated method stub
		 int key;
		 
			for(int i=0;i<20;i++)
			{	
				key= (int)(Math.random()*1000)%map.size() ;
				if(map.get(key).color==colour)
					map.get(key).armies++;
				else i--;
				
			}
	}

	@Override
	public int extraArmies(LinkedList<City> map, Colour colour) {
		// TODO Auto-generated method stub
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
	public static int getIndex(ArrayList<Graph> frontier,Graph graph)
	{	int index=0;
		for(index=0;index<frontier.size();index++)
		{
			if(frontier.get(index).hueristics>graph.hueristics)
				return index;
		}
		return index;
	}
	
	
	public static ArrayList<ArrayList<Integer>> subsets(HashMap<Integer, Integer> canAttack) {
		int[] nums=new int[canAttack.size()];
		int index=0;
		
		for (Map.Entry<Integer,Integer> entry : canAttack.entrySet())  {
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
            nums[index]= entry.getKey();
            index++;
		}
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		subsetsHelper(list, new ArrayList<>(), nums, 0);
		return list;
	}
 
	public static void subsetsHelper(ArrayList<ArrayList<Integer>> list , ArrayList<Integer> resultList, int [] nums, int start){
		list.add(new ArrayList<>(resultList));
		for(int i = start; i < nums.length; i++){
           // add element
			resultList.add(nums[i]);
           // Explore
			subsetsHelper(list, resultList, nums, i + 1);
           // remove
			resultList.remove(resultList.size() - 1);
		}
	}
	public void print(ArrayList<Graph> frontier) {
			for(int i=0;i<frontier.size();i++) {
				for(int j=0;j<frontier.get(i).map.size();j++) {
					System.out.println(frontier.get(i).map.get(j).ID+" "+frontier.get(i).map.get(j).color+"  "+frontier.get(i).map.get(j).armies+"  ");
					}
					System.out.println();
				}
			}
	}

