public interface IGraph {
    void addEdge(int source, int destination, Edge edge);
    void removeEdge(int source, int destination);
    Node getNode(int nodeIndex);
    void setNode(int nodeIndex, Node node);
    Edge getEdge(int source, int destination);
    void setEdge(int source, int destination, Edge edge);
    boolean isAdjacentNodes(int source, int destination);
    boolean isAdjacentEdges(int source, int destination);
    boolean isIncidentNodes(int nodeIndex, int source, int destination);
    boolean isIncidentEdges(int nodeIndex, int source, int destination);
    int getNumNodes();
    int getNumEdges();
    boolean hasEdges();
    boolean isEmpty();
    boolean isComplete();
}
