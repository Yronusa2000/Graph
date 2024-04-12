import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");



     //   List<Vertex> Vertexs = Vertex.VertexsList(10);

/**
        for(Vertex Vertex : Vertexs){
            Vertex.connect(Vertexs.getFirst());
        }

        System.out.println(Vertexs.toString());
        Graph graph = new Graph(Vertexs);
        graph.print();**/


        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);
        Vertex vertex6 = new Vertex(6);
        Vertex vertex7 = new Vertex(7);


        Arc a1to2 =  vertex1.connect(vertex2);
        Arc a1to3 = vertex1.connect(vertex3);
        Arc a1to7 = vertex1.connect(vertex7);

        Arc a2to5 = vertex2.connect(vertex5);
        Arc a2to4 = vertex2.connect(vertex4);
        Arc a2to6 = vertex2.connect(vertex6);

        Arc a3to2 = vertex3.connect(vertex2);
        Arc a3to4 = vertex3.connect(vertex4);

        Arc a4to7 = vertex4.connect(vertex7);

        Arc a6to7 = vertex6.connect(vertex7);

        Map<Arc,Integer> map = new HashMap<>();
        map.put(a1to2, 3);
        map.put(a1to3, 1);
        map.put(a1to7, 27);

        map.put(a2to4, 1);
        map.put(a2to5, 4);
        map.put(a2to6, 7);

        map.put(a3to4, 2);
        map.put(a3to2, 2);

        map.put(a4to7,1);

        map.put(a6to7, 1);

        Function<Arc,Integer> fonction = map::get;

        Graph graph = new Graph(new ArrayList<>(List.of(vertex1, vertex2, vertex3, vertex4, vertex5, vertex6,
                vertex7)));

        ShortestPathFromSource algo = new ShortestPathFromSource(graph, vertex1,map,fonction);
        algo.print();






     //   vertex1.getAccessibleNeighbours().forEach(vertex -> System.out.println(vertex.identifier));





    }
}