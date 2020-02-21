
import java.util.LinkedList;

public class City {
	public LinkedList<City> neighbours = new LinkedList<City>();

	public int armies=1;
	public Colour color;
	public int ID;
	public City(int iD) {
		super();
		ID = iD;
	}
}