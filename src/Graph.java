

import java.util.*;

public class Graph {

    public List<Vertex> vertices;

    public Graph(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public int size(){
        return this.getVertices().size();
    }


    public List<Vertex> getVertices() {
        return vertices;
    }

    public void addVertex(Vertex vertex){
        this.vertices.add(vertex);
    }

    public int nbLeavingArcs(int vertex){
        Vertex vertexVertex = this.getVertices().get(vertex);
        return vertexVertex.getArcsToNeighbours().size();
    }
    public Arc getLeavingArcs(int vertex, int index){
        return this.getVertices().get(vertex).getArcsToNeighbours().get(index);
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
        System.out.println("printing graph : ");

        for(Vertex vertex : this.getVertices()){
            for(Arc arc : vertex.getArcsToNeighbours()){
                arc.print();
            }
        }

    }


}
