import java.util.List;

public class Path {

    Vertex debut;
    Vertex end;
    List<Arc> arcsBetweenVertexs;


/**
    public long getDistance(){
        long res = 0;
        for(Arc arc : arcsBetweenVertexs){
            res+= arc.weight;
        }
        return res;
    }**/

    public List<Arc> getArcs() {
        return arcsBetweenVertexs;
    }

    public Path(Vertex debut, Vertex end, List<Arc> arcsBetweenVertexs) {
        this.debut = debut;
        this.end = end;
        this.arcsBetweenVertexs = arcsBetweenVertexs;
    }

    public boolean verify(){
        boolean res = true;

        if(!this.getArcs().getFirst().debut.equals(this.debut)) res = false;
        if(!this.getArcs().getLast().end.equals(this.end)){
            res = false;
        }
        for(int i = 0; i < this.getArcs().size()-1; i++){
            Arc firstArc = this.getArcs().get(i);
            Arc secondArc = this.getArcs().get(i+1);
            // Checks to par two if the consecutive arcs do connect from one Vertex to another,
            // without "jumping"?
            if(!firstArc.end.equals(secondArc.debut)) res = false;
        }

        System.out.println("the path is correct : " + res);
        return res;
    }




}
