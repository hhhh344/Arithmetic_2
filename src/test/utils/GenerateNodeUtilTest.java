package utils;

import org.junit.Test;


public class GenerateNodeUtilTest {

    @Test
    public void generateNodeNumber() {
        GenerateNodeUtil generateNodeUtil = new GenerateNodeUtil();
        for (int i = 0; i < 100; i++) {
            generateNodeUtil.generateNodeNumber(2);
            System.out.println(generateNodeUtil.nodeNumber.toString());
        }
    }
}