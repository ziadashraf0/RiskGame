/**
 * Created by ziad on 11/25/19.
 */

    import java.awt.Point;
    import java.util.*;
    import java.lang.Math;
    public class AStar {
        LinkedList<City> state;
        float Heaurstic;
        public AStar(LinkedList<City> state, float Heaurstic) {
            this.state = state;
            this.Heaurstic= Heaurstic;

        }
        public int compareTo(AStar b) {
            if(Heaurstic>b.Heaurstic){
                return 1;
            }else if(Heaurstic<b.Heaurstic){
                return -1;
            }else{
                return 0;
            }
        }
        public LinkedList<City> launch (LinkedList<City>  state ,  Colour colour){

            AgentHelper agentHelper = new AgentHelper() ;
         PriorityQueue<AStar> frontier = new PriorityQueue<AStar>();
         ArrayList<LinkedList<City>> explored = new ArrayList<LinkedList<City>>();
         ArrayList<String> a = new ArrayList<String>();

         int cost =0;
            // expand state
            //for heuristic : expands
            ArrayList<LinkedList<City>> expands = new ArrayList<LinkedList<City>>();

        // float heuristic =  agentHelper.calculateHeuristic(state,colour); // calculate best heuristic
         frontier.add(new AStar(state,Heaurstic));
            while(! frontier.isEmpty()){
            state =(frontier.peek().state);
            explored.add(state);

            if(agentHelper.calculateHeuristic(state,colour)==-100){
                return  state;
            }

            for (int i =0 ; i<expands.size();i++){
                // if expands.get(i).color = colour
                  if(! frontier.contains(expands.get(i)))
                frontier.add(new AStar(expands.get(i),agentHelper.calculateHeuristic(expands.get(i),colour)));

            }

            }
return null;
     }

    }


