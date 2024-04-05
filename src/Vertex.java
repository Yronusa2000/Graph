import java.util.ArrayList;
import java.util.List;

public class Vertex {


    /**
     * {@link #identifier} should be unique to each Vertex, otherwise errors will appear in methods like
     * {@link Graph#shortestPath(Vertex, Vertex)}.
     *  * should use an uuid but would be less readable in {@link Arc#print()}.
     *  For equality test purposes, uses the default .equals().
     */
    public int identifier;
    public List<Arc> arcsToNeighbours;

    public Vertex(int identifier) {
        this.identifier = identifier;
        this.arcsToNeighbours = new ArrayList<>();
    }

    public List<Arc> getArcsToNeighbours() {
        return arcsToNeighbours;
    }

    public int getIdentifier() {
        return identifier;
    }

    public List<Vertex> getAccessibleNeighbours() {
        List<Vertex> res = new ArrayList<>();
        for(Arc arc : this.getArcsToNeighbours()){
            res.add(arc.end);
        }

        return res;
    }

    /**
     * The (weighted) arc is oriented from the actual Vertex
     * to the new one.
     * @param otherVertex The other vertex to which this vertex will be connected.
     */
    public void connect(Vertex otherVertex){
        Arc newArc = new Arc(this, otherVertex);
        if(!this.getAccessibleNeighbours().contains(otherVertex)){
            this.getArcsToNeighbours().add(newArc);
        }
    }


    public static List<Vertex> VertexsList(int n){
        List<Vertex> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            res.add(new Vertex(i));
            System.out.println(i);
        }

        return res;
    }


}
