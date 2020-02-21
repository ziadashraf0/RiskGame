import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
	public LinkedList<City> map = new LinkedList<City>();
	int hueristics=0;
	public void initializeEgypt() {
		int i;
		for( i=1;i<28;i++)
		{
			map.add(new City(i));			// assign ID for every City
			
		}
		map.get(decrement(1)).neighbours.add(map.get(decrement(2)));
		map.get(decrement(1)).neighbours.add(map.get(decrement(3)));
		map.get(decrement(1)).neighbours.add(map.get(decrement(14)));
		map.get(decrement(1)).neighbours.add(map.get(decrement(21)));

		map.get(decrement(2)).neighbours.add(map.get(decrement(1)));
		map.get(decrement(2)).neighbours.add(map.get(decrement(3)));
		
		map.get(decrement(3)).neighbours.add(map.get(decrement(1)));
		map.get(decrement(3)).neighbours.add(map.get(decrement(2)));
		map.get(decrement(3)).neighbours.add(map.get(decrement(4)));
		map.get(decrement(3)).neighbours.add(map.get(decrement(9)));
		map.get(decrement(3)).neighbours.add(map.get(decrement(10)));
		map.get(decrement(3)).neighbours.add(map.get(decrement(14)));
		
		map.get(decrement(4)).neighbours.add(map.get(decrement(3)));
		map.get(decrement(4)).neighbours.add(map.get(decrement(5)));
		map.get(decrement(4)).neighbours.add(map.get(decrement(9)));
		
		map.get(decrement(5)).neighbours.add(map.get(decrement(4)));
		map.get(decrement(5)).neighbours.add(map.get(decrement(6)));
		map.get(decrement(5)).neighbours.add(map.get(decrement(9)));
		map.get(decrement(5)).neighbours.add(map.get(decrement(10)));
		map.get(decrement(5)).neighbours.add(map.get(decrement(11)));
		map.get(decrement(5)).neighbours.add(map.get(decrement(12)));
		
		map.get(decrement(6)).neighbours.add(map.get(decrement(5)));
		
		map.get(decrement(7)).neighbours.add(map.get(decrement(8)));
		map.get(decrement(7)).neighbours.add(map.get(decrement(13)));
		
		map.get(decrement(8)).neighbours.add(map.get(decrement(7)));
		map.get(decrement(8)).neighbours.add(map.get(decrement(13)));
		map.get(decrement(8)).neighbours.add(map.get(decrement(17)));
		map.get(decrement(8)).neighbours.add(map.get(decrement(18)));

		map.get(decrement(9)).neighbours.add(map.get(decrement(3)));
		map.get(decrement(9)).neighbours.add(map.get(decrement(4)));
		map.get(decrement(9)).neighbours.add(map.get(decrement(5)));
		map.get(decrement(9)).neighbours.add(map.get(decrement(10)));
		map.get(decrement(9)).neighbours.add(map.get(decrement(11)));


		map.get(decrement(10)).neighbours.add(map.get(decrement(3)));
		map.get(decrement(10)).neighbours.add(map.get(decrement(5)));
		map.get(decrement(10)).neighbours.add(map.get(decrement(9)));
		map.get(decrement(10)).neighbours.add(map.get(decrement(11)));
		map.get(decrement(10)).neighbours.add(map.get(decrement(14)));
		
		map.get(decrement(11)).neighbours.add(map.get(decrement(5)));
		map.get(decrement(11)).neighbours.add(map.get(decrement(9)));
		map.get(decrement(11)).neighbours.add(map.get(decrement(10)));
		map.get(decrement(11)).neighbours.add(map.get(decrement(12)));
		map.get(decrement(11)).neighbours.add(map.get(decrement(14)));
		map.get(decrement(11)).neighbours.add(map.get(decrement(16)));
		
		map.get(decrement(12)).neighbours.add(map.get(decrement(5)));
		map.get(decrement(12)).neighbours.add(map.get(decrement(11)));
		map.get(decrement(12)).neighbours.add(map.get(decrement(13)));
		map.get(decrement(12)).neighbours.add(map.get(decrement(16)));
		map.get(decrement(12)).neighbours.add(map.get(decrement(17)));

		map.get(decrement(13)).neighbours.add(map.get(decrement(7)));
		map.get(decrement(13)).neighbours.add(map.get(decrement(8)));
		map.get(decrement(13)).neighbours.add(map.get(decrement(12)));
		map.get(decrement(13)).neighbours.add(map.get(decrement(17)));
		
		map.get(decrement(14)).neighbours.add(map.get(decrement(1)));
		map.get(decrement(14)).neighbours.add(map.get(decrement(3)));
		map.get(decrement(14)).neighbours.add(map.get(decrement(10)));
		map.get(decrement(14)).neighbours.add(map.get(decrement(11)));
		map.get(decrement(14)).neighbours.add(map.get(decrement(15)));
		map.get(decrement(14)).neighbours.add(map.get(decrement(16)));
		map.get(decrement(14)).neighbours.add(map.get(decrement(19)));
		map.get(decrement(14)).neighbours.add(map.get(decrement(20)));
		map.get(decrement(14)).neighbours.add(map.get(decrement(21)));
		
		map.get(decrement(15)).neighbours.add(map.get(decrement(14)));
		map.get(decrement(15)).neighbours.add(map.get(decrement(19)));

		map.get(decrement(16)).neighbours.add(map.get(decrement(11)));
		map.get(decrement(16)).neighbours.add(map.get(decrement(12)));
		map.get(decrement(16)).neighbours.add(map.get(decrement(14)));
		map.get(decrement(16)).neighbours.add(map.get(decrement(17)));
		map.get(decrement(16)).neighbours.add(map.get(decrement(19)));
		map.get(decrement(16)).neighbours.add(map.get(decrement(23)));
		
		map.get(decrement(17)).neighbours.add(map.get(decrement(8)));
		map.get(decrement(17)).neighbours.add(map.get(decrement(12)));
		map.get(decrement(17)).neighbours.add(map.get(decrement(13)));
		map.get(decrement(17)).neighbours.add(map.get(decrement(16)));
		map.get(decrement(17)).neighbours.add(map.get(decrement(18)));
		map.get(decrement(17)).neighbours.add(map.get(decrement(23)));

		map.get(decrement(18)).neighbours.add(map.get(decrement(8)));
		map.get(decrement(18)).neighbours.add(map.get(decrement(17)));
		
		map.get(decrement(19)).neighbours.add(map.get(decrement(14)));
		map.get(decrement(19)).neighbours.add(map.get(decrement(15)));
		map.get(decrement(19)).neighbours.add(map.get(decrement(16)));
		map.get(decrement(19)).neighbours.add(map.get(decrement(20)));
		map.get(decrement(19)).neighbours.add(map.get(decrement(23)));
		
		map.get(decrement(20)).neighbours.add(map.get(decrement(14)));
		map.get(decrement(20)).neighbours.add(map.get(decrement(19)));
		map.get(decrement(20)).neighbours.add(map.get(decrement(21)));
		map.get(decrement(20)).neighbours.add(map.get(decrement(22)));
		map.get(decrement(20)).neighbours.add(map.get(decrement(23)));

		map.get(decrement(21)).neighbours.add(map.get(decrement(1)));
		map.get(decrement(21)).neighbours.add(map.get(decrement(14)));
		map.get(decrement(21)).neighbours.add(map.get(decrement(20)));
		map.get(decrement(21)).neighbours.add(map.get(decrement(22)));
		map.get(decrement(21)).neighbours.add(map.get(decrement(24)));
		map.get(decrement(21)).neighbours.add(map.get(decrement(25)));
		map.get(decrement(21)).neighbours.add(map.get(decrement(27)));
		
		map.get(decrement(22)).neighbours.add(map.get(decrement(20)));
		map.get(decrement(22)).neighbours.add(map.get(decrement(21)));
		map.get(decrement(22)).neighbours.add(map.get(decrement(23)));
		map.get(decrement(22)).neighbours.add(map.get(decrement(24)));
		
		map.get(decrement(23)).neighbours.add(map.get(decrement(16)));
		map.get(decrement(23)).neighbours.add(map.get(decrement(17)));
		map.get(decrement(23)).neighbours.add(map.get(decrement(19)));
		map.get(decrement(23)).neighbours.add(map.get(decrement(20)));
		map.get(decrement(23)).neighbours.add(map.get(decrement(22)));
		map.get(decrement(23)).neighbours.add(map.get(decrement(24)));
		map.get(decrement(23)).neighbours.add(map.get(decrement(25)));
		map.get(decrement(23)).neighbours.add(map.get(decrement(27)));

		
		map.get(decrement(24)).neighbours.add(map.get(decrement(21)));
		map.get(decrement(24)).neighbours.add(map.get(decrement(22)));
		map.get(decrement(24)).neighbours.add(map.get(decrement(23)));
		map.get(decrement(24)).neighbours.add(map.get(decrement(25)));
		
		map.get(decrement(25)).neighbours.add(map.get(decrement(21)));
		map.get(decrement(25)).neighbours.add(map.get(decrement(23)));
		map.get(decrement(25)).neighbours.add(map.get(decrement(24)));
		map.get(decrement(25)).neighbours.add(map.get(decrement(26)));
		map.get(decrement(25)).neighbours.add(map.get(decrement(27)));
		
		map.get(decrement(26)).neighbours.add(map.get(decrement(25)));
		
		map.get(decrement(27)).neighbours.add(map.get(decrement(21)));
		map.get(decrement(27)).neighbours.add(map.get(decrement(23)));
		map.get(decrement(27)).neighbours.add(map.get(decrement(25)));

















		
	}
	public int decrement(int x) {
		x=x-1;
		return x;
	}
	public void initializeUSA() {

		int i;
		for( i=1;i<51;i++)
		{
			map.add(new City(i));			// assign ID for every City

		}

		map.get(decrement(1)).neighbours.add(map.get(decrement(2)));
		map.get(decrement(1)).neighbours.add(map.get(decrement(5)));
		map.get(decrement(1)).neighbours.add(map.get(decrement(50)));



		map.get(decrement(2)).neighbours.add(map.get(decrement(1)));
		map.get(decrement(2)).neighbours.add(map.get(decrement(3)));
		map.get(decrement(2)).neighbours.add(map.get(decrement(4)));
		map.get(decrement(2)).neighbours.add(map.get(decrement(5)));

		map.get(decrement(3)).neighbours.add(map.get(decrement(2)));
		map.get(decrement(3)).neighbours.add(map.get(decrement(4)));
		map.get(decrement(3)).neighbours.add(map.get(decrement(9)));
		map.get(decrement(3)).neighbours.add(map.get(decrement(49)));


		map.get(decrement(4)).neighbours.add(map.get(decrement(2)));
		map.get(decrement(4)).neighbours.add(map.get(decrement(3)));
		map.get(decrement(4)).neighbours.add(map.get(decrement(5)));
		map.get(decrement(4)).neighbours.add(map.get(decrement(8)));
		map.get(decrement(4)).neighbours.add(map.get(decrement(9)));





		map.get(decrement(5)).neighbours.add(map.get(decrement(1)));
		map.get(decrement(5)).neighbours.add(map.get(decrement(2)));
		map.get(decrement(5)).neighbours.add(map.get(decrement(4)));
		map.get(decrement(5)).neighbours.add(map.get(decrement(6)));
		map.get(decrement(5)).neighbours.add(map.get(decrement(7)));
		map.get(decrement(5)).neighbours.add(map.get(decrement(8)));

		map.get(decrement(6)).neighbours.add(map.get(decrement(5)));
		map.get(decrement(6)).neighbours.add(map.get(decrement(7)));
		map.get(decrement(6)).neighbours.add(map.get(decrement(16)));
		map.get(decrement(6)).neighbours.add(map.get(decrement(17)));

		map.get(decrement(7)).neighbours.add(map.get(decrement(5)));
		map.get(decrement(7)).neighbours.add(map.get(decrement(6)));
		map.get(decrement(7)).neighbours.add(map.get(decrement(8)));
		map.get(decrement(7)).neighbours.add(map.get(decrement(10)));
		map.get(decrement(7)).neighbours.add(map.get(decrement(15)));
		map.get(decrement(7)).neighbours.add(map.get(decrement(16)));

		map.get(decrement(8)).neighbours.add(map.get(decrement(4)));
		map.get(decrement(8)).neighbours.add(map.get(decrement(5)));
		map.get(decrement(8)).neighbours.add(map.get(decrement(7)));
		map.get(decrement(8)).neighbours.add(map.get(decrement(9)));
		map.get(decrement(8)).neighbours.add(map.get(decrement(10)));
		map.get(decrement(8)).neighbours.add(map.get(decrement(11)));

		map.get(decrement(9)).neighbours.add(map.get(decrement(3)));
		map.get(decrement(9)).neighbours.add(map.get(decrement(4)));
		map.get(decrement(9)).neighbours.add(map.get(decrement(8)));
		map.get(decrement(9)).neighbours.add(map.get(decrement(10)));
		map.get(decrement(9)).neighbours.add(map.get(decrement(11)));

		map.get(decrement(10)).neighbours.add(map.get(decrement(7)));
		map.get(decrement(10)).neighbours.add(map.get(decrement(8)));
		map.get(decrement(10)).neighbours.add(map.get(decrement(9)));
		map.get(decrement(10)).neighbours.add(map.get(decrement(11)));
		map.get(decrement(10)).neighbours.add(map.get(decrement(13)));
		map.get(decrement(10)).neighbours.add(map.get(decrement(14)));
		map.get(decrement(10)).neighbours.add(map.get(decrement(15)));

		map.get(decrement(11)).neighbours.add(map.get(decrement(8)));
		map.get(decrement(11)).neighbours.add(map.get(decrement(9)));
		map.get(decrement(11)).neighbours.add(map.get(decrement(10)));
		map.get(decrement(11)).neighbours.add(map.get(decrement(12)));
		map.get(decrement(11)).neighbours.add(map.get(decrement(13)));

		map.get(decrement(12)).neighbours.add(map.get(decrement(11)));
		map.get(decrement(12)).neighbours.add(map.get(decrement(13)));
		map.get(decrement(12)).neighbours.add(map.get(decrement(21)));
		map.get(decrement(12)).neighbours.add(map.get(decrement(22)));

		map.get(decrement(13)).neighbours.add(map.get(decrement(10)));
		map.get(decrement(13)).neighbours.add(map.get(decrement(11)));
		map.get(decrement(13)).neighbours.add(map.get(decrement(12)));
		map.get(decrement(13)).neighbours.add(map.get(decrement(14)));
		map.get(decrement(13)).neighbours.add(map.get(decrement(20)));
		map.get(decrement(13)).neighbours.add(map.get(decrement(21)));

		map.get(decrement(14)).neighbours.add(map.get(decrement(10)));
		map.get(decrement(14)).neighbours.add(map.get(decrement(13)));
		map.get(decrement(14)).neighbours.add(map.get(decrement(15)));
		map.get(decrement(14)).neighbours.add(map.get(decrement(20)));

		map.get(decrement(15)).neighbours.add(map.get(decrement(7)));
		map.get(decrement(15)).neighbours.add(map.get(decrement(10)));
		map.get(decrement(15)).neighbours.add(map.get(decrement(14)));
		map.get(decrement(15)).neighbours.add(map.get(decrement(16)));
		map.get(decrement(15)).neighbours.add(map.get(decrement(19)));
		map.get(decrement(15)).neighbours.add(map.get(decrement(20)));

		map.get(decrement(16)).neighbours.add(map.get(decrement(6)));
		map.get(decrement(16)).neighbours.add(map.get(decrement(7)));
		map.get(decrement(16)).neighbours.add(map.get(decrement(15)));
		map.get(decrement(16)).neighbours.add(map.get(decrement(17)));
		map.get(decrement(16)).neighbours.add(map.get(decrement(18)));
		map.get(decrement(16)).neighbours.add(map.get(decrement(19)));

		map.get(decrement(17)).neighbours.add(map.get(decrement(6)));
		map.get(decrement(17)).neighbours.add(map.get(decrement(16)));
		map.get(decrement(17)).neighbours.add(map.get(decrement(18)));

		map.get(decrement(18)).neighbours.add(map.get(decrement(16)));
		map.get(decrement(18)).neighbours.add(map.get(decrement(17)));
		map.get(decrement(18)).neighbours.add(map.get(decrement(19)));
		map.get(decrement(18)).neighbours.add(map.get(decrement(34)));

		map.get(decrement(19)).neighbours.add(map.get(decrement(15)));
		map.get(decrement(19)).neighbours.add(map.get(decrement(16)));
		map.get(decrement(19)).neighbours.add(map.get(decrement(18)));
		map.get(decrement(19)).neighbours.add(map.get(decrement(20)));
		map.get(decrement(19)).neighbours.add(map.get(decrement(33)));
		map.get(decrement(19)).neighbours.add(map.get(decrement(34)));

		map.get(decrement(20)).neighbours.add(map.get(decrement(13)));
		map.get(decrement(20)).neighbours.add(map.get(decrement(14)));
		map.get(decrement(20)).neighbours.add(map.get(decrement(15)));
		map.get(decrement(20)).neighbours.add(map.get(decrement(19)));
		map.get(decrement(20)).neighbours.add(map.get(decrement(21)));
		map.get(decrement(20)).neighbours.add(map.get(decrement(31)));
		map.get(decrement(20)).neighbours.add(map.get(decrement(32)));
		map.get(decrement(20)).neighbours.add(map.get(decrement(33)));

		map.get(decrement(21)).neighbours.add(map.get(decrement(12)));
		map.get(decrement(21)).neighbours.add(map.get(decrement(13)));
		map.get(decrement(21)).neighbours.add(map.get(decrement(20)));
		map.get(decrement(21)).neighbours.add(map.get(decrement(22)));
		map.get(decrement(21)).neighbours.add(map.get(decrement(23)));
		map.get(decrement(21)).neighbours.add(map.get(decrement(31)));

		map.get(decrement(22)).neighbours.add(map.get(decrement(12)));
		map.get(decrement(22)).neighbours.add(map.get(decrement(21)));
		map.get(decrement(22)).neighbours.add(map.get(decrement(23)));

		map.get(decrement(23)).neighbours.add(map.get(decrement(21)));
		map.get(decrement(23)).neighbours.add(map.get(decrement(22)));
		map.get(decrement(23)).neighbours.add(map.get(decrement(24)));
		map.get(decrement(23)).neighbours.add(map.get(decrement(31)));

		map.get(decrement(24)).neighbours.add(map.get(decrement(23)));
		map.get(decrement(24)).neighbours.add(map.get(decrement(25)));
		map.get(decrement(24)).neighbours.add(map.get(decrement(26)));
		map.get(decrement(24)).neighbours.add(map.get(decrement(31)));

		map.get(decrement(25)).neighbours.add(map.get(decrement(24)));
		map.get(decrement(25)).neighbours.add(map.get(decrement(26)));

		map.get(decrement(26)).neighbours.add(map.get(decrement(24)));
		map.get(decrement(26)).neighbours.add(map.get(decrement(25)));
		map.get(decrement(26)).neighbours.add(map.get(decrement(27)));
		map.get(decrement(26)).neighbours.add(map.get(decrement(28)));
		map.get(decrement(26)).neighbours.add(map.get(decrement(31)));

		map.get(decrement(27)).neighbours.add(map.get(decrement(26)));
		map.get(decrement(27)).neighbours.add(map.get(decrement(28)));

		map.get(decrement(28)).neighbours.add(map.get(decrement(26)));
		map.get(decrement(28)).neighbours.add(map.get(decrement(27)));
		map.get(decrement(28)).neighbours.add(map.get(decrement(29)));
		map.get(decrement(28)).neighbours.add(map.get(decrement(31)));

		map.get(decrement(29)).neighbours.add(map.get(decrement(28)));
		map.get(decrement(29)).neighbours.add(map.get(decrement(30)));
		map.get(decrement(29)).neighbours.add(map.get(decrement(31)));
		map.get(decrement(29)).neighbours.add(map.get(decrement(32)));
		map.get(decrement(29)).neighbours.add(map.get(decrement(48)));

		map.get(decrement(30)).neighbours.add(map.get(decrement(29)));
		map.get(decrement(30)).neighbours.add(map.get(decrement(32)));
		map.get(decrement(30)).neighbours.add(map.get(decrement(37)));
		map.get(decrement(30)).neighbours.add(map.get(decrement(38)));
		map.get(decrement(30)).neighbours.add(map.get(decrement(48)));

		map.get(decrement(31)).neighbours.add(map.get(decrement(20)));
		map.get(decrement(31)).neighbours.add(map.get(decrement(21)));
		map.get(decrement(31)).neighbours.add(map.get(decrement(23)));
		map.get(decrement(31)).neighbours.add(map.get(decrement(24)));
		map.get(decrement(31)).neighbours.add(map.get(decrement(26)));
		map.get(decrement(31)).neighbours.add(map.get(decrement(28)));
		map.get(decrement(31)).neighbours.add(map.get(decrement(29)));
		map.get(decrement(31)).neighbours.add(map.get(decrement(32)));

		map.get(decrement(32)).neighbours.add(map.get(decrement(20)));
		map.get(decrement(32)).neighbours.add(map.get(decrement(29)));
		map.get(decrement(32)).neighbours.add(map.get(decrement(30)));
		map.get(decrement(32)).neighbours.add(map.get(decrement(31)));
		map.get(decrement(32)).neighbours.add(map.get(decrement(33)));
		map.get(decrement(32)).neighbours.add(map.get(decrement(35)));
		map.get(decrement(32)).neighbours.add(map.get(decrement(37)));

		map.get(decrement(33)).neighbours.add(map.get(decrement(19)));
		map.get(decrement(33)).neighbours.add(map.get(decrement(20)));
		map.get(decrement(33)).neighbours.add(map.get(decrement(32)));
		map.get(decrement(33)).neighbours.add(map.get(decrement(34)));
		map.get(decrement(33)).neighbours.add(map.get(decrement(35)));

		map.get(decrement(34)).neighbours.add(map.get(decrement(18)));
		map.get(decrement(34)).neighbours.add(map.get(decrement(19)));
		map.get(decrement(34)).neighbours.add(map.get(decrement(33)));
		map.get(decrement(34)).neighbours.add(map.get(decrement(36)));

		map.get(decrement(35)).neighbours.add(map.get(decrement(32)));
		map.get(decrement(35)).neighbours.add(map.get(decrement(33)));
		map.get(decrement(35)).neighbours.add(map.get(decrement(36)));
		map.get(decrement(35)).neighbours.add(map.get(decrement(37)));

		map.get(decrement(36)).neighbours.add(map.get(decrement(34)));
		map.get(decrement(36)).neighbours.add(map.get(decrement(35)));
		map.get(decrement(36)).neighbours.add(map.get(decrement(37)));

		map.get(decrement(37)).neighbours.add(map.get(decrement(30)));
		map.get(decrement(37)).neighbours.add(map.get(decrement(32)));
		map.get(decrement(37)).neighbours.add(map.get(decrement(35)));
		map.get(decrement(37)).neighbours.add(map.get(decrement(36)));
		map.get(decrement(37)).neighbours.add(map.get(decrement(38)));

		map.get(decrement(38)).neighbours.add(map.get(decrement(30)));
		map.get(decrement(38)).neighbours.add(map.get(decrement(37)));
		map.get(decrement(38)).neighbours.add(map.get(decrement(39)));
		map.get(decrement(38)).neighbours.add(map.get(decrement(46)));
		map.get(decrement(38)).neighbours.add(map.get(decrement(47)));
		map.get(decrement(38)).neighbours.add(map.get(decrement(48)));

		map.get(decrement(39)).neighbours.add(map.get(decrement(38)));
		map.get(decrement(39)).neighbours.add(map.get(decrement(40)));
		map.get(decrement(39)).neighbours.add(map.get(decrement(43)));
		map.get(decrement(39)).neighbours.add(map.get(decrement(45)));
		map.get(decrement(39)).neighbours.add(map.get(decrement(46)));

		map.get(decrement(40)).neighbours.add(map.get(decrement(39)));
		map.get(decrement(40)).neighbours.add(map.get(decrement(41)));
		map.get(decrement(40)).neighbours.add(map.get(decrement(43)));

		map.get(decrement(41)).neighbours.add(map.get(decrement(40)));
		map.get(decrement(41)).neighbours.add(map.get(decrement(42)));
		map.get(decrement(41)).neighbours.add(map.get(decrement(43)));

		map.get(decrement(42)).neighbours.add(map.get(decrement(41)));

		map.get(decrement(43)).neighbours.add(map.get(decrement(39)));
		map.get(decrement(43)).neighbours.add(map.get(decrement(40)));
		map.get(decrement(43)).neighbours.add(map.get(decrement(41)));
		map.get(decrement(43)).neighbours.add(map.get(decrement(44)));
		map.get(decrement(43)).neighbours.add(map.get(decrement(45)));

		map.get(decrement(44)).neighbours.add(map.get(decrement(43)));
		map.get(decrement(44)).neighbours.add(map.get(decrement(45)));

		map.get(decrement(45)).neighbours.add(map.get(decrement(39)));
		map.get(decrement(45)).neighbours.add(map.get(decrement(43)));
		map.get(decrement(45)).neighbours.add(map.get(decrement(44)));

		map.get(decrement(46)).neighbours.add(map.get(decrement(38)));
		map.get(decrement(46)).neighbours.add(map.get(decrement(39)));
		map.get(decrement(46)).neighbours.add(map.get(decrement(47)));

		map.get(decrement(47)).neighbours.add(map.get(decrement(38)));
		map.get(decrement(47)).neighbours.add(map.get(decrement(46)));
		map.get(decrement(47)).neighbours.add(map.get(decrement(48)));

		map.get(decrement(48)).neighbours.add(map.get(decrement(29)));
		map.get(decrement(48)).neighbours.add(map.get(decrement(30)));
		map.get(decrement(48)).neighbours.add(map.get(decrement(38)));
		map.get(decrement(48)).neighbours.add(map.get(decrement(47)));

		map.get(decrement(49)).neighbours.add(map.get(decrement(3)));

		map.get(decrement(50)).neighbours.add(map.get(decrement(1)));

	}

public static LinkedList<Graph> expand(LinkedList<City> map,Colour colour,int armies){
		LinkedList<Graph> newStates=new LinkedList<Graph>();
	  ArrayList<int[]> allCombinationsArray =new ArrayList<int[]>();
	  int cities=0,index=0;
	  for(int i=0;i<map.size();i++)
	  {
		  if(map.get(i).color==colour)
			  cities++;
	  }
	  
	  allCombinationsArray=Combinations.run(armies, cities);					//// get all possible combinatios for  Reinforcements;
	// Combinations.allCombinations.clear();
	  for(int i=0;i<allCombinationsArray.size();i++)
	  {	
		  index=0;
	  	Graph graph=new Graph();
	  	///Deep clone the initial state(graph);
	  	for(int k=0;k<map.size();k++ )
	  		{	
	  				City temp=new City(map.get(k).ID);
	  				temp.color=map.get(k).color;
	  				temp.armies=map.get(k).armies;
	  				graph.map.add(temp);
	   		}
	  		
		  for(int j=0;j<graph.map.size();j++)
		  {
			  if(graph.map.get(j).color==colour)
			  {
				  graph.map.get(j).armies+= allCombinationsArray.get(i)[index];	
				  index++;
				  
			  }
		  }
		  newStates.add(graph);
	  }
	return newStates;
}

}
