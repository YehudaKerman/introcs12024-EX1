package Ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
        @Test
        void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        void int2NumberTest() {
            int base = 8;
            int num = 92;
            String result = Ex1.int2Number(num,base);
            assertEquals("134b8",result);
        }
        @Test
        void maxIndexTest() {
           String [] numArr  = {"100","134b8","GbG","1100100b2","2Fbg",null,"17FbG"};
           int max = Ex1.maxIndex(numArr);
           assertEquals(6,max);
        }

        @Test
        void number2IntTest() {
          String s2 = "AF34BDbG";
          int res = Ex1.number2Int(s2);
          assertTrue(res == 11482301);
        }
        @Test
        void numAddTest() {
                String a = "57b8";
                String b = "35bG";
                int base = 2;
                String result = Ex1.numAdd(a,b,base);
                assertEquals("1100100b2",result);
            }
    void multNumTest() {
        String a = "57b8";
        String b = "35bG";
        int base = 2;
        String result = Ex1.numAdd(a,b,base);
        assertEquals("1100100b2",result);
        }
    }
