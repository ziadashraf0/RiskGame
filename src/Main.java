public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int V = 28;
        Graph.graph graph = new Graph.graph(V);
        Graph.addEdge(graph,1,3);
        Graph.addEdge(graph,1,2);
        Graph.addEdge(graph,1,14);
        Graph.addEdge(graph,2,3);
        Graph.addEdge(graph,3,14);
        Graph.addEdge(graph,3,10);
        Graph.addEdge(graph,3,9);
        Graph.addEdge(graph,3,4);
        Graph.addEdge(graph,4,9);
        Graph.addEdge(graph,4,5);
        Graph.addEdge(graph,5,6);
        Graph.addEdge(graph,5,9);
        Graph.addEdge(graph,5,12);
        Graph.addEdge(graph,5,11);
        Graph.addEdge(graph,5,10);
        Graph.addEdge(graph,7,8);
        Graph.addEdge(graph,7,13);
        Graph.addEdge(graph,8,13);
        Graph.addEdge(graph,8,17);
        Graph.addEdge(graph,8,18);
        Graph.addEdge(graph,9,10);
        Graph.addEdge(graph,10,11);
        Graph.addEdge(graph,10,14);
        Graph.addEdge(graph,11,12);
        Graph.addEdge(graph,11,16);
        Graph.addEdge(graph,11,14);
        Graph.addEdge(graph,12,16);
        Graph.addEdge(graph,12,13);
        Graph.addEdge(graph,12,17);
        Graph.addEdge(graph,13,17);
        Graph.addEdge(graph,14,16);
        Graph.addEdge(graph,14,15);
        Graph.addEdge(graph,14,19);
        Graph.addEdge(graph,14,20);
        Graph.addEdge(graph,15,19);
        Graph.addEdge(graph,16,17);
        Graph.addEdge(graph,16,19);
        Graph.addEdge(graph,16,23);
        Graph.addEdge(graph,17,23);
        Graph.addEdge(graph,17,18);
        Graph.addEdge(graph,19,11);
        Graph.addEdge(graph,19,20);
        Graph.addEdge(graph,20,23);
        Graph.addEdge(graph,20,21);
        Graph.addEdge(graph,20,22);
        Graph.addEdge(graph,21,1);
        Graph.addEdge(graph,21,14);
        Graph.addEdge(graph,21,22);
        Graph.addEdge(graph,21,24);
        Graph.addEdge(graph,21,25);
        Graph.addEdge(graph,21,27);
        Graph.addEdge(graph,22,23);
        Graph.addEdge(graph,22,24);
        Graph.addEdge(graph,23,19);
        Graph.addEdge(graph,23,24);
        Graph.addEdge(graph,23,25);
        Graph.addEdge(graph,23,27);
        Graph.addEdge(graph,24,25);
        Graph.addEdge(graph,25,26);
        Graph.addEdge(graph,25,27);

        Graph.printGraph(graph);



        ;
























    }
    public void Egypt(Graph.graph graph,int V){
         graph=new Graph.graph(V);


    }

}
