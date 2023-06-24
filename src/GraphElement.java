public class GraphElement {
    private int label;
    private double weight;

    public GraphElement(int label, double weight) {
        this.label = label;
        this.weight = weight;
    }

    public int getLabel() {
        return label;
    }

    public double getWeight() {
        return weight;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
