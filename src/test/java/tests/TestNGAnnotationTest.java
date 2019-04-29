package tests;

import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;

public class TestNGAnnotationTest {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }


    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @Test
    public void aTest(){
        System.out.println("A Test run");
        assertTrue(false);
        
    }
    @Test
    public void bTest(){
        System.out.println("b Test run");
    }
}
