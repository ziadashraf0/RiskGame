import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by ziad on 11/26/19.
 */
public class MiniMaxAgent {

     public int minimax(Graph graph, int armies , int depth , boolean isMax ,Colour colour,int numberOfCities){

         LinkedList<City> map =graph.map;
         int maxHeurstic = -1;
         int minHeurstic = Integer.MIN_VALUE;
         ArrayList<Integer> nextLevelResult = new ArrayList<Integer>();
            AgentHelper agentHelper = new AgentHelper();
         LinkedList<Graph> newStates=Graph.expand(graph.map, colour,MiniMaxAgent.extraArmies(graph.map, colour) );
         for(int enforcement=0;enforcement<newStates.size();enforcement++) {

         if ((depth == 0) || (agentHelper.calculateHeuristic(map,colour)==numberOfCities)){
           return agentHelper.calculateHeuristic(map,colour);
         }
                // MaxTurn
            if(isMax){
             //for states{
                 armies = search(graph,colour);
                nextLevelResult.add(minimax(graph,armies,depth-1,false,colour,numberOfCities));
                if(nextLevelResult.get(nextLevelResult.get(nextLevelResult.size()))>maxHeurstic){
                    maxHeurstic=nextLevelResult.get(nextLevelResult.size());
                } //}
                return maxHeurstic;
            }
            //Min Turn
            else {
                //for states{
                armies = search(graph,colour);
                nextLevelResult.add(minimax(graph,armies,depth-1,false,colour,numberOfCities));
                if(nextLevelResult.get(nextLevelResult.size())>minHeurstic){
                    minHeurstic=nextLevelResult.get(nextLevelResult.size());
                }//}
            }
     }                return minHeurstic;
     }
    public int  search(Graph graph,Colour colour)
    {
        LinkedList<City> map = graph.map;
        int i,numberArmies=Integer.MAX_VALUE,index=0;
        for(i=0;i<map.size();i++)
        {
            if(map.get(i).color==colour&& map.get(i).armies<numberArmies )
            {
                index=i;
            }
        }
        map.get(index).armies+=extraArmies(map, colour);

    return map.get(index).armies;

    }
    public static int  extraArmies(LinkedList<City> map, Colour colour) {
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
