public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph=new Graph();
		graph.initializeEgypt();	///////graph.initializeUSA();
		int blue=0,red=0,sum=0;
		graph.map= Game.randomizeColours(graph.map);
		AgentHelper agentHelper = new AgentHelper();


		for(int i =0;i<graph.map.size();i++) {
			System.out.println(graph.map.get(i).color+"  "+graph.map.get(i).armies);
			sum+=graph.map.get(i).armies;
			if(graph.map.get(i).color==Colour.BLUE)
				blue++;
			else red++;
		}
		System.out.println(blue+"   "+red+"  "+sum);

		PassiveAgent passiveAgent=new PassiveAgent();
		PacifistAgent pacifistAgent = new PacifistAgent();
		pacifistAgent.initializeMap(graph.map,Colour.RED);
		//passiveAgent.initializeMap(graph.map, Colour.RED);
		pacifistAgent.initializeMap(graph.map,Colour.BLUE);

		System.out.println("RED The graph Heurstic is : "+agentHelper.calculateHeuristic(graph.map,Colour.RED));

		sum=0;
		for(int i =0;i<graph.map.size();i++) {
			System.out.println(graph.map.get(i).color +"  "+graph.map.get(i).armies);

			sum+=graph.map.get(i).armies;

		}System.out.println("end"+"           "+sum);

			pacifistAgent.search(graph, Colour.RED);
		pacifistAgent.attack(graph.map,Colour.RED);


		//passiveAgent.search(graph.map, Colour.RED);
		sum=0;
		for(int i =0;i<graph.map.size();i++) {
			sum+=graph.map.get(i).armies;
			System.out.println(graph.map.get(i).color +"  "+graph.map.get(i).armies);

		}
		System.out.println("end"+"           "+sum);
	}
}