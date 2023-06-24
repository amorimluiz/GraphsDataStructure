import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphUsingMatrixTest {
    private GraphUsingMatrix graph;

    @Before
    public void setUp() {
        graph = new GraphUsingMatrix(3); // Inicializa o grafo com 3 nós
    }

    @Test
    public void testAddEdge() {
        Edge edge = new Edge(7, 8);

        graph.addEdge(0, 1, edge);

        Assert.assertTrue(graph.isAdjacentNodes(0, 1));
        Assert.assertTrue(graph.isAdjacentNodes(1, 0));
        Assert.assertEquals(edge, graph.getEdge(0, 1));
        Assert.assertEquals(edge, graph.getEdge(1, 0));
    }

    @Test
    public void testRemoveEdge() {
        Edge edge = new Edge(7, 8);

        graph.addEdge(0, 1, edge);
        graph.removeEdge(0, 1);

        Assert.assertFalse(graph.isAdjacentNodes(0, 1));
        Assert.assertFalse(graph.isAdjacentNodes(1, 0));
        Assert.assertNull(graph.getEdge(0, 1));
        Assert.assertNull(graph.getEdge(1, 0));
    }

    @Test
    public void testIsAdjacentNodes() {
        Assert.assertFalse(graph.isAdjacentNodes(0, 1));
        Assert.assertFalse(graph.isAdjacentNodes(1, 0));

        Edge edge = new Edge(7, 8);
        graph.addEdge(0, 1, edge);

        Assert.assertTrue(graph.isAdjacentNodes(0, 1));
        Assert.assertTrue(graph.isAdjacentNodes(1, 0));
    }

    @Test
    public void testIsAdjacentEdges() {
        Assert.assertFalse(graph.isAdjacentEdges(0, 1));
        Assert.assertFalse(graph.isAdjacentEdges(1, 0));

        Edge edge = new Edge(7, 8);
        graph.addEdge(0, 1, edge);

        Assert.assertTrue(graph.isAdjacentEdges(0, 1));
        Assert.assertTrue(graph.isAdjacentEdges(1, 0));
    }

    @Test
    public void testIsIncidentNodes() {
        Assert.assertFalse(graph.isIncidentNodes(0, 1, 2));
        Assert.assertFalse(graph.isIncidentNodes(1, 0, 2));
        Assert.assertFalse(graph.isIncidentNodes(2, 0, 1));

        Edge edge = new Edge(7, 8);
        graph.addEdge(0, 1, edge);

        Assert.assertFalse(graph.isIncidentNodes(0, 1, 2));
        Assert.assertFalse(graph.isIncidentNodes(1, 0, 2));
        Assert.assertFalse(graph.isIncidentNodes(2, 0, 1));
    }

    @Test
    public void testIsIncidentEdges() {
        Assert.assertFalse(graph.isIncidentEdges(0, 1, 2));
        Assert.assertFalse(graph.isIncidentEdges(1, 0, 2));
        Assert.assertFalse(graph.isIncidentEdges(2, 0, 1));

        Edge edge = new Edge(7, 8);
        graph.addEdge(0, 1, edge);

        Assert.assertFalse(graph.isIncidentEdges(0, 1, 2));
        Assert.assertFalse(graph.isIncidentEdges(1, 0, 2));
        Assert.assertFalse(graph.isIncidentEdges(2, 0, 1));
    }

    @Test
    public void testGetNode() {
        Node nodeA = new Node(1, 2);
        Node nodeB = new Node(3, 4);
        Node nodeC = new Node(5, 6);

        graph.setNode(0, nodeA);
        graph.setNode(1, nodeB);
        graph.setNode(2, nodeC);

        Assert.assertEquals(nodeA, graph.getNode(0));
        Assert.assertEquals(nodeB, graph.getNode(1));
        Assert.assertEquals(nodeC, graph.getNode(2));
    }

    @Test
    public void testSetNode() {
        Node nodeA = new Node(1, 2);
        Node nodeB = new Node(3, 4);
        Node nodeC = new Node(5, 6);

        graph.setNode(0, nodeA);
        graph.setNode(1, nodeB);
        graph.setNode(2, nodeC);

        Assert.assertEquals(nodeA, graph.getNode(0));
        Assert.assertEquals(nodeB, graph.getNode(1));
        Assert.assertEquals(nodeC, graph.getNode(2));
    }

    @Test
    public void testGetEdge() {
        Edge edge = new Edge(7, 8);

        graph.addEdge(0, 1, edge);

        Assert.assertEquals(edge, graph.getEdge(0, 1));
        Assert.assertEquals(edge, graph.getEdge(1, 0));
    }

    @Test
    public void testSetEdge() {
        Edge edge = new Edge(7, 8);

        graph.setEdge(0, 1, edge);

        Assert.assertEquals(edge, graph.getEdge(0, 1));
        Assert.assertEquals(edge, graph.getEdge(1, 0));
    }

    @Test
    public void testGetNumNodes() {
        Assert.assertEquals(3, graph.getNumNodes());
    }

    @Test
    public void testGetNumEdges() {
        Assert.assertEquals(0, graph.getNumEdges());

        Edge edge = new Edge(7, 8);
        graph.addEdge(0, 1, edge);

        Assert.assertEquals(1, graph.getNumEdges());
    }

    @Test
    public void testHasEdges() {
        Assert.assertFalse(graph.hasEdges());

        Edge edge = new Edge(7, 8);
        graph.addEdge(0, 1, edge);

        Assert.assertTrue(graph.hasEdges());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(graph.isEmpty());

        Edge edge = new Edge(7, 8);
        graph.addEdge(0, 1, edge);

        Assert.assertFalse(graph.isEmpty());
    }

    @Test
    public void testIsComplete() {
        Assert.assertFalse(graph.isComplete());

        Edge edge1 = new Edge(7, 8);
        graph.addEdge(0, 1, edge1);

        Assert.assertFalse(graph.isComplete());

        Edge edge2 = new Edge(9, 10);
        graph.addEdge(0, 2, edge2);
        graph.addEdge(1, 2, edge2);

        Assert.assertTrue(graph.isComplete());
    }
}