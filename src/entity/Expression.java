package entity;

import java.util.List;

/**
 * @author 戮漠
 */
public class Expression {
    /**
     *
     二叉树的根节点
     */
    private Node root;
    /**
     *
     表达式的结果
     */
    private StringBuilder result;

    /**
     * 调用后续遍历方法将二叉树的节点存进List
     * @param nodeList
     */
    public void postOrderTraversal(List<Node> nodeList){
        postOrderTraversal(this.root, nodeList);
    }

    /**
     * 后序遍历二叉树并将节点存进List
     * @param node
     * @param nodeList
     */
    public void postOrderTraversal(Node node, List<Node> nodeList){
        if (node!=null){
            postOrderTraversal(node.getLeftChild(), nodeList);
            postOrderTraversal(node.getRightChild(), nodeList);
            nodeList.add(node);
        }
    }
}
