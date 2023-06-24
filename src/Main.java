import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Main {
    public static Random random = new Random(System.currentTimeMillis());

    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract("_ -> param1")
    public static <Graph extends IGraph> Graph fillGraph(@NotNull Graph graph) {
        final int numNodes = graph.getNumNodes();
        for (int i = 0; i < numNodes; i++) {
            final int randomNumber = random.nextInt(0, numNodes);
            Edge edge = new Edge(i, 0);
            graph.addEdge(randomNumber, i, edge);
        }

        return graph;
    }

    public static void main(String[] args) {
        final int numNodes = 20;
        GraphUsingList graphUsingList = fillGraph(new GraphUsingList(numNodes));
        GraphUsingMatrix graphUsingMatrix = fillGraph(new GraphUsingMatrix(numNodes));
        System.out.println(graphUsingList + "\n" + graphUsingMatrix);
    }
}