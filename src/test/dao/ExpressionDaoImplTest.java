package dao;

import entity.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExpressionDaoImplTest {
    ExpressionDaoImpl expressionDao = new ExpressionDaoImpl();

    @Test
    public void generateExpression() {
        for (int i = 0; i < 20; i++) {
            List<Node> nodeList = new ArrayList<>();
            expressionDao.generateExpression(10);
            expressionDao.expression.postOrderTraversal(nodeList);
            for (Node item : nodeList){
                System.out.printf(item.getValue().toString() + " ");
            }
            System.out.println();
        }

    }
}