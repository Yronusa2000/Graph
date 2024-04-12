import java.util.*;
import java.util.function.Function;

public class ShortestPathFromSource {

    private Graph graph;


     //The source vertex from which all the distances will be calculated.
    private final Vertex source;

    // Contains for each Vertex, the Path with the shortest distance that leads to it.
    private final HashMap<Vertex,Path> predecessor;

    // The function to retrieve each arc's length, and the appropriate map that holds that information.
    private final Map<Arc, Integer> arcLength;
    private final Function<Arc, Integer> length;

    // The list of vertices that have yet to be explored by the object.
    private HashSet<Vertex> unvisitedVertices;

    //The distances between each vertex of the graph, with the source vertex.
    private HashMap<Vertex,Integer> distancesToVertex;

    public ShortestPathFromSource(Graph graph, Vertex source,
                                  Map<Arc,Integer> arcLength,
                                  Function<Arc, Integer> length) {

        this.graph = graph;

        this.source = source;

        this.distancesToVertex = new HashMap<>();
        this.predecessor = new HashMap<>();

        this.unvisitedVertices = new HashSet<>(this.graph.getVertices());


        this.arcLength = arcLength;
        this.length = length;

        solve();

    }

    private void initializeDistances() {
        //Set the distance between the debut Vertex and all other Vertexs
        this.graph.getVertices().forEach(Vertex -> {
            distancesToVertex.put(Vertex, Integer.MAX_VALUE);
        });

        // Set the distance between origin vertex and itself at 0
        distancesToVertex.put(this.source, 0);
    }

    /**
     *
     * @return the next vertex to check in the {@link #unvisitedVertices} list.
     */

    private Vertex getNextVertex(){
        return this.unvisitedVertices
                .stream()
                .min(Comparator.comparingInt(distancesToVertex::get))
                .get();
    }

    public Path solve() {

        initializeDistances();;

        while (!unvisitedVertices.isEmpty()) {
            // Select the unvisited vertex as the one having the smallest known distance in the hashmap.
            Vertex currentVertex = getNextVertex();

            // If the smallest distance is Integer.MAX_VALUE, it means that there are no path leading to
            // the other vertices.
            if(distancesToVertex.get(currentVertex).equals(Integer.MAX_VALUE)) break;

            // Getting all the neighbours of the vertex, that haven't yet been visited.
            List<Arc> arcsToNeighbours = getArcsToUnvisitedNeighbours(currentVertex);


            // For each of those unvisited neighbours, update the distance if necessary.
            arcsToNeighbours.forEach(arc -> {
                Vertex neighbour = arc.end;

                // The distance between the source and the neighbour is the
                // distance between the source and the current vertex
                // + the distance between the current vertex and the neighbour.
                int distanceFromSource = distancesToVertex.get(currentVertex) + length(arc);
                if (distancesToVertex.get(neighbour) > distanceFromSource){
                    distancesToVertex.put(neighbour, distanceFromSource);
                }
            });

            unvisitedVertices.remove(currentVertex);


        }

        return null;
    }

    public int distanceTo(Vertex vertex) {
        return distancesToVertex.get(vertex);
    }

    public int length(Arc arc){
        return this.arcLength.get(arc);
    }


    /**
     *
     * @param vertex the vertex from which the arcs will be got.
     * @return the list of all arcs that lead to an unvisited neighbour.
     */
    public List<Arc> getArcsToUnvisitedNeighbours(Vertex vertex){
        // Getting from a vertex all its arc leading to an unvisited neighbour.
        return vertex
                .getArcsToNeighbours()
                .stream()
                .filter(arc -> {
                    return unvisitedVertices.contains(arc.end);
                })
                .toList();
    }

    public void print(){
        System.out.println("Distances between vertex " + this.source.identifier + " and other vertices: ");

        for(Vertex v : this.graph.getVertices()){
            System.out.println(v.identifier + " : " + this.distanceTo(v));
        }

    }

}