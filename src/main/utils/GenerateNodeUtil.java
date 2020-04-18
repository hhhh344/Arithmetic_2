package utils;

import constant.Constant;
import entity.Node;

import java.util.Random;

/**
 * @author 戮漠
 */
public class GenerateNodeUtil {
    Random random = new Random();
    StringBuilder nodeNumber;
    StringBuilder nodeOperator;
    int priorityValue;

    /**
     * 生成一个操作符节点
     * @param node
     * @return
     */
    public void generateNode(Node node){
        generateNodeOperator();
        getPriorityValue();
        node.setType(Constant.OPERATOR_TYPE);
        node.setValue(nodeOperator);
        node.setPriorityValue(priorityValue);
    }

    /**
     * 生成一个操作数节点
     * @param node
     * @param range
     */
    public void generateNode(Node node, int range){
        generateNodeNumber(range);
        node.setType(Constant.NUMBER_TYPE);
        node.setValue(nodeNumber);
    }

    /**
     * 随机生成min~max直接的整数
     * @param min 生成数的最小值（包括）
     * @param max 生成数的最大值（包括）
     * @return
     */
    public int generateRandom(int min, int max){
        int randomNumber = random.nextInt(max-min+1);
        return randomNumber + min;
    }

    /**
     * 生成随机数
     * @param range
     */
    public void generateNodeNumber(int range){
        int a, b, c;
        int numberType = generateRandom(0,1);

        if(range > 1 && numberType == 1 ){
            a = generateRandom(0, range);
            b = generateRandom(1,range-1);
            c = generateRandom(b,range);
        }
        else {
            a = generateRandom(0, range);
            b = 0;
            c = 1;
        }
        nodeNumber = new StringBuilder(a+"'"+b+"/"+c);
    }

    /**
     * 生成操作符
     */
    public void generateNodeOperator(){
        nodeOperator = new StringBuilder();
        String[] ope = new String[]{"+","-","*","/"};
        nodeOperator.append(ope[random.nextInt(4)]);
    }

    public void getPriorityValue(){
        switch (nodeOperator.toString()) {
            case "+":
            case "-":
                priorityValue = 1;
                break;
            case "*":
            case "/":
                priorityValue =  2;
                break;
            default:
                throw new RuntimeException("没有该类型的操作符!");
        }
    }
}
