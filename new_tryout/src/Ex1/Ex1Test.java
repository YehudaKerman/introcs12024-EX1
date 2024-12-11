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
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    void int2NumberTest() {
        int[] numArr = {1, 26, -5, 100, 53, 9, 12, 5, 6465};
        int[] baseArr = {10, 5, 9, 8, 11, 16, 2, 20, 15};
        boolean ok = true;
        String[] resArr = {"1bA", "101b5", "", "144b8", "49bB", "9bG", "1100b2", "", "1DB0bF"};
        for (int i = 0; i < baseArr.length - 1 && ok; i = i + 1) {
            String result = Ex1.int2Number(numArr[i], baseArr[i]);
            ok = Ex1.equals(resArr[i], result);
        }
        assertTrue(ok);

    }

    @Test
    void maxIndexTest() {
        String[] numArr = {"100", "134b8", "GbG", "1100100b2", "2Fbg", null, "17FbG"};
        int max = Ex1.maxIndex(numArr);
        assertEquals(6, max);
    }

    @Test
    void number2IntTest() {
        String[] numArr = {"1bA", "101b5", "", "144b8", "49bB", "9bG", "1100b2", "GbG", " 13b8", "12 6bG"};
        int[] resArr = {1, 26, -1, 100, 53, 9, 12, -1, -1, -1};
        boolean ok = true;
        for (int i = 0; i < resArr.length - 1 && ok; i = i + 1) {
            int result = Ex1.number2Int(numArr[i]);
            ok = result == resArr[i];
        }
        assertTrue(ok);
    }

    @Test
    void numAddTest() {
        String[] a = {"57b8", "16ADbG", "12b3", "2AbB"};
        String[] b = {"35bG", "3BAbD", "20b4", "34b5"};
        int[] base = {2, 15, 7, 6};
        String[] arrRes = {"1100100b2", "1DB0bF", "16b7", "41bD"};
        boolean ok = true;
        for (int i = 0; i < a.length - 1 && ok; i++) {
            String res = Ex1.numAdd(a[i], b[i], base[i]);
            if (!res.equals(arrRes[i])) {
                ok = false;
            }
        }
        assertTrue(ok);
    }

    @Test
    void multNumTest() {
        String[] a = {"57b8", "16ADbG", "12b3", "2AbB"};
        String[] b = {"35bG", "3BAbD", "20b4", "34b5"};
        int[] base = {2, 15, 7, 13};
        String[] arrRes = {"100110010011b2", "50A300bF", "55b7", "3A9bD"};
        boolean ok = true;
        for (int i = 0; i < a.length - 1 && ok; i++) {
            String res = Ex1.multNUm(a[i], b[i], base[i]);
            if (!res.equals(arrRes[i])) {
                ok = false;
            }
        }
    }
    @Test
    void int2CharTest(){
        int [] intBaseArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,-1,20};
        char [] baseRes = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','!','!'};
        boolean ok = true;
        for (int i = 0; i < intBaseArr.length-1&&ok; i = i + 1) {
            char res = Ex1.int2Char(intBaseArr[i]);
            if (res != baseRes[i]) {
                ok = false;
            }
        }
        assertTrue(ok);
    }
    @Test
    void isBase10(){
        String [] good = {"1","120", "25", "65","95"};
        for (int i = 0; i < good.length-1; i = i + 1) {
            boolean ok = Ex1.isBase10(good[i]);
            assertTrue(ok);
        }
        String [] not_good = {"1101b2", "65b7", "b2", " 3b8", "AbG"};
        for (int i = 0; i < not_good.length-1; i = i + 1) {
            boolean not_ok = Ex1.isBase10(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void converteChar2BaseOrIntCharTest(){
        int [] intBaseArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,-1,-1};
        char [] baseArr = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','&','J'};
        boolean ok = true;
        for (int i = 0; i < intBaseArr.length-1&&ok; i = i + 1) {
           int res = Ex1.converteChar2BaseOrInt(baseArr[i]);
            if (res != intBaseArr[i]) {
                ok = false;
            }
        }
        assertTrue(ok);
    }
    @Test
    void converteChar2BaseOrIntStrTest(){
        String[] num = {"57b8", "16ADbG", "12b3", "2AbB","35bG", "3BAbD", "20b4", "34b5","100110010011b2", "50A300bF", "55b7", "3A9bD"};
        int[] base = {8, 16, 3, 11,16,13,4,5,2,15,7,13};
        boolean ok = true;
        for (int i = 0; i < num.length-1&&ok; i = i + 1) {
            int res = Ex1.converteChar2BaseOrInt(num[i]);
            if (res != base[i]) {
                ok = false;
            }
        }
        assertTrue(ok);
    }
    @Test
    void equalsTest(){
        String[] num = {"57b8", "16ADbG", "12b3", "2AbB","3BAbD", "20b4", "34b5","55b7"};
        String [] compNum = {"2FbG","1011010101101b2","5b9","44b7","5bA","1836bD","10101b2","98b6"};
        boolean [] resArr = {true,true,true,true,false,false,false,false};
        boolean ok = true;
        for (int i = 0; i < num.length-1&&ok; i = i + 1) {
            boolean res = Ex1.equals(num[i], compNum[i]);
            if (res != resArr[i]) {
                ok = false;
            }
        }
        assertTrue(ok);
    }
    @Test
    void maxIndex(){
        String[] num = {"57b8", "16ADbG", "12b3", "2AbB","3BAbD", "20b4", "34b5","22632b7","55b7"};
        int res = Ex1.maxIndex(num);
        assertTrue(res == 1);
    }
}
