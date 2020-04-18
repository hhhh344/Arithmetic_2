package dao;

import constant.Constant;
import entity.Expression;
import entity.Node;
import utils.GenerateNodeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 戮漠
 */
public class ExpressionDaoImpl {
    Random random = new Random();
    Expression expression;
    GenerateNodeUtil generateNodeUtil = new GenerateNodeUtil();
    Node root;
    List<Integer> temp;
    List<Node> operatorNodeList;

    /**
     * 生成一个表达式
     * @param range
     */
    public void generateExpression(int range){
        expression = new Expression();
        generateOperatorTree();
        generateNumberLeaf(range);
        expression.setRoot(root);
    }

    /**
     * 生成一个相连的操作符树
     */
    public void generateOperatorTree(){
        int operatorCount = generateNodeUtil.generateRandom(1, Constant.OPERATOR_COUNT);
        operatorNodeList  = new ArrayList<>();

        //生成操作符并存进List
        for (int i = 0; i < operatorCount; i++) {
            Node node = new Node();
            generateNodeUtil.generateNode(node);
            operatorNodeList.add(node);
        }
        //通过这个数组来寻找要将操作符链接起来的位置
        temp = new ArrayList<>();
        //通过这个操作符和操作树的个数
        for (int i = 0; i < 2*operatorCount; i++) {
            temp.add(i);
        }
        for (int i = 0; i < operatorCount; i++) {
            if (i == 0){
                root = operatorNodeList.get(i);
                root.setRoot(true);
            }
            else {
                int randomIndex = random.nextInt(i+1);
                int opeNodeListIndex = temp.get(randomIndex)/2;
                if (temp.get(randomIndex)%2 == 0){
                    //将节点插入随机找到的前面节点的左子树
                    operatorNodeList.get(opeNodeListIndex).setLeftChild(operatorNodeList.get(i));
                }
                else {
                    //将节点插入右子树
                    operatorNodeList.get(opeNodeListIndex).setRightChild(operatorNodeList.get(i));
                }
                temp.remove(randomIndex);
            }
        }
    }

    /**
     * 将操作数链接到操作符树
     * @param range
     */
    public void generateNumberLeaf(int range){
        for (int i = 0; i < temp.size(); i++) {
            Node node = new Node();
            generateNodeUtil.generateNode(node, range);
            int opeNodeListIndex = temp.get(i)/2;
            if (temp.get(i)%2 == 0){
                //将节点插入随机找到的前面节点的左子树
                operatorNodeList.get(opeNodeListIndex).setLeftChild(node);
            }
            else {
                //将节点插入右子树
                operatorNodeList.get(opeNodeListIndex).setRightChild(node);
            }
        }
    }
}
