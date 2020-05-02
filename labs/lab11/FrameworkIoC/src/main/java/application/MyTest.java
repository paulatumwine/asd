package application;

import framework.Before;
import framework.Inject;
import framework.Test;
import framework.TestClass;

import static framework.Asserts.assertEquals;

@TestClass
public class MyTest {

    @Inject
    Calculator calculator;

    @Before
    public void init() {
        calculator.reset();
    }

    @Test
    public void testMethod1() {
        assertEquals(calculator.add(3), 3);
        assertEquals(calculator.add(6), 9);
    }

    @Test
    public void testMethod2() {
        assertEquals(calculator.add(3), 3);
        assertEquals(calculator.subtract(6), -1);
    }

}
