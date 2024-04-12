import java.util.*;
import java.util.function.Function;

public class ShortestPathFromSource {

    private final Graph graph;

     //The distances between each vertex of the graph, with the source vertex.
    private final HashMap<Vertex,Integer> distancesToVertex;

     //The source vertex from which all the distances will be calculated.
    private final Vertex source;

    private final List<Vertex> predecessor;

    // The function to retrive all
    private final Map<Arc, Integer> arcLength;
    private final Function<Arc, Integer> length;

    private final List<Vertex> unvisitedVertices;

    public ShortestPathFromSource(Graph graph, Vertex source,
                                  Map<Arc,Integer> arcLength,
                                  Function<Arc, Integer> length, List<Vertex> unvisitedVertices) {

        this.graph = graph;
        this.source = source;

        this.distancesToVertex = initializeDistances();
        this.predecessor = new ArrayList<>();

        this.unvisitedVertices = this.graph.getVertexs();


        this.arcLength = arcLength;
        this.length = length;

        solve();
    }

    private HashMap<Vertex, Integer> initializeDistances() {
        //Set the distance between the debut Vertex and all other Vertexs
        this.graph.getVertexs().forEach(Vertex -> {
            distancesToVertex.put(Vertex, Integer.MAX_VALUE);
        });

        // Set the distance between origin vertex and itself at 0
        distancesToVertex.put(this.source, 0);
    }

    public Path solve() {


        //Set the distance between the debut Vertex and all other Vertexs
        this.graph.getVertexs().forEach(Vertex -> {
            distancesToVertex.put(Vertex, Integer.MAX_VALUE);
        });

        // Set the distance between origin vertex and itself at 0
        distancesToVertex.put(source, 0);


        while (!unvisitedVertices.isEmpty()) {

            // Select the unvisited vertex as the one having the smallest known distance in the hashmap.
            Vertex currentVertex = getNextVertex();

            if(distancesToVertex.get(currentVertex).equals(Integer.MAX_VALUE)) break;

            // Getting all the neighbours of the vertex, that haven't yet been visited.
            List<Vertex> unvisitedNeighbours = currentVertex
                    .getAccessibleNeighbours()
                    .stream()
                    .filter(unvisitedVertices::contains)
                    .toList();

            // For each of those unvisited neighbours, update the distance if necessary.
            unvisitedNeighbours.forEach(vertex -> {

                long distanceToOrigin = distanceToSourceMap.get(vertex) + distanceToSourceMap.get(currentVertex);
                if (distanceToSourceMap.get(vertex) > distanceToOrigin) distanceToSourceMap.put(vertex, distanceToOrigin);
            });

            unvisitedVertices.remove(currentVertex);


        }

        return null;
    }

    public int distanceTo(Vertex vertex) {
        return distancesToVertex.get(vertex);
    }

    public Optional<Integer> predecessor(int vertex) {

    }

    /**
     *
     * @return the next vertex to check in the {@link #unvisitedVertices} list.
     */

    public Vertex getNextVertex(){
        return unvisitedVertices
                .stream()
                .min(Comparator.comparingInt(distancesToVertex::get))
                .get();
    }
}