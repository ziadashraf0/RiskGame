import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by ziad on 11/24/19.
 */
public class AgentHelper {


    public static int calculateHeuristic(LinkedList<City> map , Colour colour) {
        int bestHeurstic=-100;
        HashMap<Integer,Integer> Heuristics = new HashMap<>();
        int counter =0;
        float ratio;

        ArrayList<Integer> visited = new ArrayList<Integer>();

        for (int i=0 ; i < map.size();i++){
            if((map.get(i).color!=colour) ){
                    counter++;

                              //ratio =(float)counter /(float) map.get(i).armies;
                    //Heuristics.put(map.get(i).ID, visited.size());
                  //  System.out.println("City ID ===>" + map.get(i).ID + " can attack ===> " + counter +"cites"+ " my armies==>" + map.get(i).armies + " Heurstic ===>" + visited.size());
                }
        }
        System.out.println("cites to conquer ====> : " + counter + " cites");
//            for (int  CityID : Heuristics.keySet())
//            {
//                int variableKey = CityID;
//                float variableValue = Heuristics.get(variableKey);
//                if (variableValue==Collections.max(Heuristics.values())){
//                    System.out.println("city with best Heurstic is ID : " + variableKey);
//                    bestHeurstic=variableKey;
//                    break;
//                }
//
//            }
return counter;
        }
    public static int calculateGreedyHeuristic(LinkedList<City> map , Colour colour) {
        int bestHeurstic=-100;
        HashMap<Integer,Integer> Heuristics = new HashMap<>();
        int counter =0;
        float ratio;

        ArrayList<Integer> visited = new ArrayList<Integer>();

        for (int i=0 ; i < map.size();i++){
            if((map.get(i).color==colour)&&(map.get(i).armies>1) ){
                for(int j=0 ; j<map.get(i).neighbours.size();j++){
                    if((map.get(i).neighbours.get(j).color!=colour)&&(map.get(i).armies>map.get(i).neighbours.get(j).armies))
                        //  counter += map.get(i).neighbours.get(j).armies;
                        if(!visited.contains(map.get(i).neighbours.get(j).ID)) {
                            visited.add(map.get(i).neighbours.get(j).ID);
                            System.out.println(++counter);
                        }

                }
                //ratio =(float)counter /(float) map.get(i).armies;
                //Heuristics.put(map.get(i).ID, visited.size());
                //  System.out.println("City ID ===>" + map.get(i).ID + " can attack ===> " + counter +"cites"+ " my armies==>" + map.get(i).armies + " Heurstic ===>" + visited.size());
            }
        }
        System.out.println("Heuristic can attack : " + visited.size() + " cites");
        System.out.println("map sizeeeeeeeeeeee "+map.size());
//            for (int  CityID : Heuristics.keySet())
//            {
//                int variableKey = CityID;
//                float variableValue = Heuristics.get(variableKey);
//                if (variableValue==Collections.max(Heuristics.values())){
//                    System.out.println("city with best Heurstic is ID : " + variableKey);
//                    bestHeurstic=variableKey;
//                    break;
//                }
//
//            }
        return  visited.size();
    }


}
