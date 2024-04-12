import java.util.HashMap;
import java.util.function.Function;

public class Arc {

    public static HashMap<Arc,Integer> arcLength;
    Function<Arc,Integer> length = arcLength::get;



    Vertex debut;
    Vertex end;

    public Arc(Vertex vertexOne, Vertex vertexTwo) {
        this.debut = vertexOne;
        this.end = vertexTwo;
    }


    public void print(){
        System.out.println("VERTEX " + debut.getIdentifier() + " to VERTEX " + end.getIdentifier());
    }
}
