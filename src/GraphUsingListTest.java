import org.junit.Test;
import static org.junit.Assert.*;

public class GraphUsingListTest {

    @Test
    public void testAddEdge() {
        GraphUsingList graph = new GraphUsingList(5);
        Node node1 = new Node(1, 1);
        Node node2 = new Node(2, 2);
        Edge edge = new Edge(1, 0);

        graph.setNode(0, node1);
        graph.setNode(1, node2);

        graph.addEdge(0, 1, edge);

        assertTrue(graph.isAdjacentNodes(0, 1));
        assertTrue(graph.isAdjacentNodes(1, 0));
        assertNull(graph.getEdge(0, 0));
        assertEquals(edge, graph.getEdge(1, 0));
        assertEquals(1, graph.getNumEdges());
    }

    @Test
    public void testRemoveEdge() {
        GraphUsingList graph = new GraphUsingList(5);
        Node node1 = new Node(1, 1);
        Node node2 = new Node(2, 2);
        Edge edge = new Edge(1, 0);

        graph.setNode(0, node1);
        graph.setNode(1, node2);
        graph.addEdge(0, 1, edge);

        graph.removeEdge(0, 1);

        assertFalse(graph.isAdjacentNodes(0, 1));
        assertFalse(graph.isAdjacentNodes(1, 0));
        assertEquals(0, graph.getNumEdges());
    }

    @Test
    public void testGetNode() {
        GraphUsingList graph = new GraphUsingList(5);
        Node node = new Node(1, 1);

        graph.setNode(0, node);

        assertEquals(node, graph.getNode(0));
    }

    @Test
    public void testSetNode() {
        GraphUsingList graph = new GraphUsingList(5);
        Node node = new Node(1, 1);

        graph.setNode(0, node);

        assertEquals(node, graph.getNode(0));
    }

    @Test
    public void testIsAdjacentNodes() {
        GraphUsingList graph = new GraphUsingList(5);
        Node node1 = new Node(1, 1);
        Node node2 = new Node(2, 2);
        Edge edge = new Edge(1, 0);

        graph.setNode(0, node1);
        graph.setNode(1, node2);
        graph.addEdge(0, 1, edge);

        assertTrue(graph.isAdjacentNodes(0, 1));
        assertTrue(graph.isAdjacentNodes(1, 0));
    }

    @Test
    public void testIsAdjacentEdges() {
        GraphUsingList graph = new GraphUsingList(5);
        Node node1 = new Node(1, 1);
        Node node2 = new Node(2, 2);
        Edge edge = new Edge(1, 0);

        graph.setNode(0, node1);
        graph.setNode(1, node2);
        graph.addEdge(0, 1, edge);

        assertTrue(graph.isAdjacentEdges(0, 1));
        assertTrue(graph.isAdjacentEdges(1, 0));
    }

    @Test
    public void testIsIncidentNodes() {
        GraphUsingList graph = new GraphUsingList(5);
        Node node1 = new Node(1, 1);
        Node node2 = new Node(2, 2);
        Node node3 = new Node(3, 3);
        Edge edge = new Edge(1, 0);

        graph.setNode(0, node1);
        graph.setNode(1, node2);
        graph.setNode(2, node3);
        graph.addEdge(0, 1, edge);

        assertFalse(graph.isIncidentNodes(0, 0, 1));
        assertFalse(graph.isIncidentNodes(1, 0, 1));
        assertFalse(graph.isIncidentNodes(2, 0, 1));
    }

    @Test
    public void testIsIncidentEdges() {
        GraphUsingList graph = new GraphUsingList(5);
        Node node1 = new Node(1, 1);
        Node node2 = new Node(2, 2);
        Node node3 = new Node(3, 3);
        Edge edge = new Edge(1, 0);

        graph.setNode(0, node1);
        graph.setNode(1, node2);
        graph.setNode(2, node3);
        graph.addEdge(0, 1, edge);

        assertFalse(graph.isIncidentEdges(0, 0, 1));
        assertFalse(graph.isIncidentEdges(1, 0, 1));
        assertFalse(graph.isIncidentEdges(2, 0, 1));
    }

    @Test
    public void testGetNumNodes() {
        GraphUsingList graph = new GraphUsingList(5);

        assertEquals(5, graph.getNumNodes());
    }

    @Test
    public void testGetNumEdges() {
        GraphUsingList graph = new GraphUsingList(5);
        Node node1 = new Node(1, 1);
        Node node2 = new Node(2, 2);
        Edge edge = new Edge(1, 0);

        graph.setNode(0, node1);
        graph.setNode(1, node2);
        graph.addEdge(0, 1, edge);

        assertEquals(1, graph.getNumEdges());
    }

    @Test
    public void testHasEdges() {
        GraphUsingList graph1 = new GraphUsingList(5);
        GraphUsingList graph2 = new GraphUsingList(5);
        Node node = new Node(1, 1);
        graph2.setNode(0, node);

        assertFalse(graph1.hasEdges());
        assertFalse(graph2.hasEdges());
    }

    @Test
    public void testIsEmpty() {
        GraphUsingList graph1 = new GraphUsingList(5);
        GraphUsingList graph2 = new GraphUsingList(5);
        Node node = new Node(1, 1);
        graph2.setNode(0, node);

        assertTrue(graph1.isEmpty());
        assertTrue(graph2.isEmpty());
    }

    @Test
    public void testIsComplete() {
        GraphUsingList graph1 = new GraphUsingList(5);
        GraphUsingList graph2 = new GraphUsingList(3);
        Node node1 = new Node(1, 1);
        Node node2 = new Node(2, 2);
        Node node3 = new Node(3, 3);
        Edge edge = new Edge(1, 0);

        graph2.setNode(0, node1);
        graph2.setNode(1, node2);
        graph2.setNode(2, node3);
        graph2.addEdge(0, 1, edge);

        assertFalse(graph1.isComplete());
        assertFalse(graph2.isComplete());
    }
}