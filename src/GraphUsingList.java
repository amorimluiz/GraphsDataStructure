import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GraphUsingList implements IGraph {
    private final int numNodes;
    private int numEdges;
    private final List<List<Integer>> adjacencyList;
    private final List<Node> nodeList;
    private final List<List<Edge>> edgeList;

    public GraphUsingList(int numNodes) {
        this.numNodes = numNodes;
        this.numEdges = 0;
        this.adjacencyList = new ArrayList<>(numNodes);
        this.nodeList = new ArrayList<>(numNodes);
        this.edgeList = new ArrayList<>(numNodes);

        for (int i = 0; i < numNodes; i++) {
            this.adjacencyList.add(new ArrayList<>());
            this.nodeList.add(new Node(0, 0));
            this.edgeList.add(new ArrayList<>());
            for (int j = 0; j < numNodes; j++) {
                this.edgeList.get(i).add(null);
            }
        }
    }

    @Override
    public void addEdge(int source, int destination, Edge edge) {
        this.adjacencyList.get(source).add(destination);
        this.adjacencyList.get(destination).add(source);

        this.edgeList.get(source).set(destination, edge);
        this.edgeList.get(destination).set(source, edge);

        this.numEdges++;
    }

    @Override
    public void removeEdge(int source, int destination) {
        List<Integer> sourceList = this.adjacencyList.get(source);
        List<Integer> destinationList = this.adjacencyList.get(destination);

        List<Edge> sourceEdgeList = this.edgeList.get(source);
        List<Edge> destinationEdgeList = this.edgeList.get(destination);

        int sourceIndex = sourceList.indexOf(destination);
        int destinationIndex = destinationList.indexOf(source);

        sourceList.remove(sourceIndex);
        destinationList.remove(destinationIndex);

        sourceEdgeList.remove(sourceIndex);
        destinationEdgeList.remove(destinationIndex);

        this.numEdges--;
    }

    @Override
    public Node getNode(int nodeIndex) {
        return this.nodeList.get(nodeIndex);
    }

    @Override
    public void setNode(int nodeIndex, Node node) {
        this.nodeList.set(nodeIndex, node);
    }

    @Override
    public Edge getEdge(int source, int destination) {
        final Optional<Edge> optionalEdge = this.edgeList
            .get(source)
            .stream()
            .filter(node -> node != null && (node.getLabel() == destination || node.getLabel() == source))
            .findFirst();

        return optionalEdge.orElse(null);
    }

    @Override
    public void setEdge(int source, int destination, Edge edge) {
        this.edgeList.get(source).set(destination, edge);
        this.edgeList.get(destination).set(source, edge);
    }

    @Override
    public boolean isAdjacentNodes(int source, int destination) {
        return this.adjacencyList.get(source).contains(destination);
    }

    @Override
    public boolean isAdjacentEdges(int source, int destination) {
        return isAdjacentNodes(source, destination);
    }

    @Override
    public boolean isIncidentNodes(int nodeIndex, int source, int destination) {
        return isAdjacentNodes(nodeIndex, source) && isAdjacentNodes(nodeIndex, destination);
    }

    @Override
    public boolean isIncidentEdges(int nodeIndex, int source, int destination) {
        return isIncidentNodes(nodeIndex, source, destination);
    }

    @Override
    public int getNumNodes() {
        return numNodes;
    }

    @Override
    public int getNumEdges() {
        return numEdges;
    }

    @Override
    public boolean hasEdges() {
        return numEdges > 0;
    }

    @Override
    public boolean isEmpty() {
        return numEdges == 0;
    }

    @Override
    public boolean isComplete() {
        int maxNumEdges = numNodes * (numNodes - 1) / 2;
        return numEdges == maxNumEdges;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Adjacency List:\n");
        for (int i = 0; i < adjacencyList.size(); i++) {
            stringBuilder.append(i).append(" -> ");
            for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                if (j == adjacencyList.get(i).size() - 1) {
                    stringBuilder.append(adjacencyList.get(i).get(j));
                    break;
                }
                stringBuilder.append(adjacencyList.get(i).get(j)).append(", ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}