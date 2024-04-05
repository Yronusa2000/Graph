import java.util.Iterator;

public interface Graph {

    public int nbLeavingArcs(int vertex);
    public Arc getLeavingArcs(int vertex, int index);

    public Iterator<Arc> leavingArcs(int vertex);
    // facultatif
    public Iterator<Integer> vertices();
    public Iterator<Arc> arcs();


}
