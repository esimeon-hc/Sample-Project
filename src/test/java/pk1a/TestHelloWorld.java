package test.java.pk1a;

//dfsfdfsfdsf//dfsfdfsfdsf//dfsfdfsfdsf//dfsfdfsfdsf//dfsfdfsfdsf//dfsfdfsfdsf//dfsfdfsfdsf
//tester1
//tester1
//tester1
//tester1
//tester1
//tester1
//tester1//tester1
//tester1//tester1


import main.java.pk1.HelloWorld;
import junit.framework.*;

public class  TestHelloWorld extends TestCase {
  public void testSimpleMessage() {
     String message = new HelloWorld("World222").sayHello();
     Assert.assertEquals("Test Hello Machine", "Hello, World222", message);
  }
}

