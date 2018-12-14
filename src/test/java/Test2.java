import lesson_6.test.Task2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test2 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] { 1, 1, 4, 4 }, new int[] { 5, 2, 3, 5 }},
                {new int[] { 4, 1, 4, 1 }, new int[] { 1, 1, 4, 3 }},
                {new int[] { 5, 5, 3, 3 }, new int[] { 1, 4, 1, 4 }},
        });
    }

    private int[] a;
    private int[] b;
    private Task2 t;

    public Test2(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

    @Before
    public void init() {
        t = new Task2();
    }

    @Test
    public void test1() {
        Assert.assertTrue(t.doTask2(a));
    }

    @Test
    public void test2() {
        Assert.assertFalse(t.doTask2(b));
    }
}
