package demo.app.examples;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JunitTests {

    @BeforeClass
    static public void beforeClass(){
        System.out.println("Before class");
    }

    @AfterClass
    static public void afterClass(){
        System.out.println("After class");
    }

    @Before
    public void before(){
        System.out.println("Before");
    }

    @After
    public void after(){
        System.out.println("After");
    }

    @Test
    public void testAssertEquals(){
        String result = "one".concat("two");
        assertEquals("onetwo", result);
    }

    @Test
    public void testAssertEqualsFail(){
        String result = "I do not match the expected string.";
        assertEquals("The expected string", result);
    }

    @Test
    public void testAssertTrue(){
        int a = 15;
        int b = 20;

        assertTrue(b>a);
    }

    @Test
    public void testAssertFalse(){
        int a = 15;
        int b = 20;

        assertFalse(b<a);
    }

    @Test
    public void testAssertNotNull(){
        int a = 15;

        assertNotNull(a);
    }

    @Test
    public void testAssertNull(){
        String s = null;
        assertNull(s);
    }

    @Test
    public void testMinus(){
        //arrange
        int a = 15;
        int b = 20;

        //act
        int c = b-a;

        //assert
        assertEquals(5, c);
    }

}
