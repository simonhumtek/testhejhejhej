import java.util.*;
import javafx.util.Pair;

public class Graph {
    int[][] graph;
    private ArrayList<Vertex> Vertices = new ArrayList<>();
    Graph(int vertices) {
        graph = new int[vertices][vertices];
    }
    public void addEdge(int from, int to, int cost){
        graph[from-1][to-1]=cost;
    }
    public Vertex addvertex(String id) {
        Vertex newvertex = new Vertex(id);
        Vertices.add(newvertex);
        return newvertex;
    }

    public void addvertex(Vertex v) {
        Vertices.add(v);
    }
    public Vertex getvertex(String s)
    {
        for(Vertex v : Vertices )
        {
            if (v.Name==s)
                return v;
        }
        return null;
    }

    public void newedge(Vertex from, Vertex to, int dist, int tim) {
        Edge newedge=new Edge(from,to);
        newedge.distance=dist;
        newedge.time=tim;
    }

    public Pair<Integer, Map<Vertex, Vertex>> ShortestDistance(Vertex start, Vertex end)
    {
        //write something something here
        Map<Vertex,Vertex> PredecessorMap= new HashMap<>();
        Map<Vertex,Integer> DistanceMap=new HashMap<>();
        // initialize arrays
        for(Vertex v: Vertices)
        {
            DistanceMap.put(v,1000);
            PredecessorMap.put(v, null);
        }



        //implement Dijkstra
        public int[] Dijkstra(int start) {
        int[] shortestdistance = new int[graph.length];
        int[] predecessor = new int[graph.length];
        boolean[] handled = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            predecessor[i] = -1; // not existing vertex
            handled[i] = false;
            shortestdistance[i] = 200;
        }
        shortestdistance[start - 1] = 0;

        int v, u;
        int udist, vdist = 200;
        for (int count = 0; count < graph.length; count++) {
            v = findMin(shortestdistance, handled);
            vdist=shortestdistance[v];
            System.out.println("Smallest node " + v+ " distance " +shortestdistance[v]);
            for (int i = 0; i < graph.length; i++) {
                if (graph[v][i] > 0) {
                    if (graph[v][i] + vdist < shortestdistance[i]) {
                        shortestdistance[i] = graph[v][i] + vdist;
                        predecessor[i] = v;
                    }
                }
            }
            handled[v] = true;
        }
        return predecessor;
    }




        return (new Pair<Integer,Map<Vertex,Vertex>> (DistanceMap.get(end), PredecessorMap));
    }

    private int findMin(int[] shortestdistance, boolean[] handled) {
    }

    public Vertex getmin(Map<Vertex,Integer> qmap){
       // Your code
        return null;
    }
}



class Vertex{
    public String Name;
    public ArrayList<Edge> OutEdges = new ArrayList<>();
    public  Vertex(String id){
        Name=id;
    }
    public void addOutEdge(Edge outedge){
        OutEdges.add(outedge);
    }
    public ArrayList<Edge> getOutEdges(){return OutEdges;}
}

class Edge{
    private Vertex fromvertex;
    private Vertex tovertex;
    public int distance=0;
    public int time=0;

    public Vertex getTovertex() {
        return tovertex;
    }

    public Edge(Vertex from, Vertex to){
        fromvertex=from;
        tovertex=to;
        fromvertex.addOutEdge(this);
        //If not directional
        tovertex.addOutEdge(this);
    }
}