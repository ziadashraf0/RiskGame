import java.util.LinkedList;

public interface Agent {
	public void search(Graph graph,Colour colour);
	public void initializeMap(LinkedList<City> map,Colour colour);
	public int  extraArmies(LinkedList<City> map,Colour colour);

}
