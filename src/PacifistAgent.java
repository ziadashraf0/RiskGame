import java.util.LinkedList;

/**
 * Created by ziad on 11/24/19.
 */
public class PacifistAgent {
    public void search(Graph graph,Colour colour)
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

        attack(map,colour);

    }

    public void attack(LinkedList<City> map , Colour colour){
        int soldiers=Integer.MAX_VALUE;
        int attacked=0;
         int index=0;
        for (int i =0 ; i<map.size();i++){
            if (map.get(i).armies<soldiers){
                soldiers=map.get(i).armies;
                index=i;
            }
        } // get the city with the fewest armies

        if((map.get(index).color!=colour)){
            for (int i=0 ; i<map.get(index).neighbours.size();i++){ // looping on neighbours of the country with fewest armies
                if((map.get(index).neighbours.get(i).color==colour)&&(map.get(index).armies<map.get(index).neighbours.get(i).armies)){
                   map.get(index).color=colour; // if this neighbour(i) is mine and has greater armies
                   map.get(index).neighbours.get(i).armies--;
                   map.get(index).armies=1;
                    System.out.println("pacifist attack ==> " + map.get(index).ID + " attacked by city ID : "  + map.get(index).neighbours.get(i).ID );
                    attacked=1;
                    break;
                }
            }
        }
        if(attacked==0){
            System.out.println("pacifist cannot attack!");
        }

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
