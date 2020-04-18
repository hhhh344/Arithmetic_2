package entity;

/**
 * 节点
 * @author 戮漠
 */
public class Node {
    private int type;
    private StringBuilder value;
    private boolean haveBracket;
    private int priorityValue;
    private boolean isRoot;
    private Node leftChild;
    private Node rightChild;

    public Node() {
        this.haveBracket = true;
        this.isRoot = false;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public StringBuilder getValue() {
        return value;
    }

    public void setValue(StringBuilder value) {
        this.value = value;
    }

    public boolean isHaveBracket() {
        return haveBracket;
    }

    public void setHaveBracket(boolean haveBracket) {
        this.haveBracket = haveBracket;
    }

    public int getPriorityValue() {
        return priorityValue;
    }

    public void setPriorityValue(int priorityValue) {
        this.priorityValue = priorityValue;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
