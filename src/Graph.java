

import java.util.*;
import java.util.concurrent.RunnableScheduledFuture;

public class Graph {

    public List<Vertex> vertices;

    public Graph(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public int size(){
        return this.getVertexs().size();
    }


    public Path shortestPath(Vertex debut, Vertex end) {

        List<Vertex> unvisitedVertices = this.vertices;

        HashMap<Vertex, Long> distanceToStartMap = new HashMap<>();
        //Set the distance between the debut Vertex and all other Vertexs
        this.getVertexs().forEach(Vertex -> {
            distanceToStartMap.put(Vertex, Long.MAX_VALUE);
        });

        // Set the distance between origin vertex and itself at 0
        distanceToStartMap.put(debut, 0L);


        while (!unvisitedVertices.isEmpty()) {

            // Select the unvisited vertex as the one having the smallest known distance in the hashmap.

            Vertex currentVertex = unvisitedVertices
                    .stream()
                    .min(Comparator.comparingDouble(distanceToStartMap::get))
                    .get();

            if(distanceToStartMap.get(currentVertex).equals(Long.MAX_VALUE)) break;

            // Getting all the neighbours of the vertex, that haven't yet been visited.
            List<Vertex> unvisitedNeighbours = currentVertex
                    .getAccessibleNeighbours()
                    .stream()
                    .filter(unvisitedVertices::contains)
                    .toList();

            // For each of those unvisited neighbours, update the distance if necessary.
            unvisitedNeighbours.forEach(vertex -> {

                long distanceToOrigin = distanceToStartMap.get(vertex) + distanceToStartMap.get(currentVertex);
                if (distanceToStartMap.get(vertex) > distanceToOrigin) distanceToStartMap.put(vertex, distanceToOrigin);
            });

            unvisitedVertices.remove(currentVertex);


        }

        return null;
    }

    public List<Vertex> getVertexs() {
        return vertices;
    }

    public void addVertex(Vertex vertex){
        this.vertices.add(vertex);
    }

    public int nbLeavingArcs(int vertex){
        Vertex vertexVertex = this.getVertexs().get(vertex);
        return vertexVertex.getArcsToNeighbours().size();
    }
    public Arc getLeavingArcs(int vertex, int index){
        return this.getVertexs().get(vertex).getArcsToNeighbours().get(index);
    }

    public Iterator<Arc> leavingArcs(int vertex){
        return null;
    }
    // facultatif
    public Iterator<Integer> vertices(){
        return null;
    }
    public Iterator<Arc> arcs(){
        return null;
    }

    public void print(){

        List<Arc> visitedArcs = new ArrayList<>();
        for(Vertex vertex : this.getVertexs()){
            for(Arc arc : vertex.getArcsToNeighbours()){
                if(!visitedArcs.contains(arc)) arc.print();
                visitedArcs.add(arc);
            }
        }

    }


}
