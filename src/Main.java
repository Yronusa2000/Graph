import java.util.ArrayList;
import java.util.List;

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

        List<Arc> arcsOfPath = new ArrayList<>();

        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);
        Vertex vertex6 = new Vertex(6);


        vertex1.connect(vertex2);
        arcsOfPath.add(vertex1.getArcsToNeighbours().getFirst());
        vertex2.connect(vertex3);
        arcsOfPath.add(vertex2.getArcsToNeighbours().getFirst());
        vertex3.connect(vertex4);
        arcsOfPath.add(vertex3.getArcsToNeighbours().getFirst());
        vertex4.connect(vertex5);
        arcsOfPath.add(vertex4.getArcsToNeighbours().getFirst());
        vertex5.connect(vertex6);
        arcsOfPath.add(vertex5.getArcsToNeighbours().getFirst());

        Path path = new Path(vertex1, vertex6, arcsOfPath);

        vertex1.connect(vertex3);
        vertex1.connect(vertex3);
        vertex1.connect(vertex4);
        vertex1.connect(vertex4);
        vertex1.connect(vertex4);
        vertex1.connect(vertex5);

        vertex1.getAccessibleNeighbours().forEach(vertex -> System.out.println(vertex.identifier));




    }
}