public class GraphUsingMatrix implements IGraph {
    private final int numNodes;
    private final int[][] adjMatrix;
    private final Node[] nodes;
    private final Edge[][] edges;

    public GraphUsingMatrix(int numNodes) {
        this.numNodes = numNodes;
        this.adjMatrix = new int[numNodes][numNodes];
        this.nodes = new Node[numNodes];
        this.edges = new Edge[numNodes][numNodes];

        for (int i = 0; i < numNodes; i++) {
            this.nodes[i] = new Node(0, 0);
            for (int j = 0; j < numNodes; j++) {
                this.adjMatrix[i][j] = 0;
            }
        }
    }

    @Override
    public void addEdge(int source, int destination, Edge edge) {
        this.adjMatrix[source][destination] = 1;
        this.adjMatrix[destination][source] = 1;

        this.edges[source][destination] = edge;
        this.edges[destination][source] = edge;
    }

    @Override
    public void removeEdge(int source, int destination) {
        this.adjMatrix[source][destination] = 0;
        this.adjMatrix[destination][source] = 0;

        this.edges[source][destination] = null;
        this.edges[destination][source] = null;
    }

    @Override
    public Node getNode(int nodeIndex) {
        return this.nodes[nodeIndex];
    }

    @Override
    public void setNode(int nodeIndex, Node node) {
        this.nodes[nodeIndex] = node;
    }

    @Override
    public Edge getEdge(int source, int destination) {
        return this.edges[source][destination];
    }

    @Override
    public void setEdge(int source, int destination, Edge edge) {
        this.edges[source][destination] = edge;
        this.edges[destination][source] = edge;
    }

    @Override
    public boolean isAdjacentNodes(int source, int destination) {
        return this.adjMatrix[source][destination] == 1;
    }

    @Override
    public boolean isAdjacentEdges(int source, int destination) {
        return this.adjMatrix[source][destination] == 1 || this.adjMatrix[destination][source] == 1;
    }

    @Override
    public boolean isIncidentNodes(int nodeIndex, int source, int destination) {
        return this.adjMatrix[nodeIndex][source] == 1 && this.adjMatrix[nodeIndex][destination] == 1;
    }

    @Override
    public boolean isIncidentEdges(int nodeIndex, int source, int destination) {
        return this.adjMatrix[nodeIndex][source] == 1 && this.adjMatrix[nodeIndex][destination] == 1;
    }

    @Override
    public int getNumNodes() {
        return this.numNodes;
    }

    @Override
    public int getNumEdges() {
        int count = 0;
        for (int i = 0; i < this.numNodes; i++) {
            for (int j = i + 1; j < this.numNodes; j++) {
                if (this.adjMatrix[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public boolean hasEdges() {
        for (int i = 0; i < this.numNodes; i++) {
            for (int j = 0; j < this.numNodes; j++) {
                if (this.adjMatrix[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.getNumEdges() == 0;
    }

    @Override
    public boolean isComplete() {
        for (int i = 0; i < this.numNodes; i++) {
            for (int j = 0; j < this.numNodes; j++) {
                if (i != j && this.adjMatrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Adjacency Matrix:\n");
        for (int i = 0; i < this.numNodes; i++) {
            sb.append("[ ");
            for (int j = 0; j < this.numNodes; j++) {
                sb.append(this.adjMatrix[i][j]).append(" ");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
}
