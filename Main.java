import org.junit.*;
import org.junit.runner.*;
import static org.junit.Assert.*;
import store.*;
import java.util.*;

class Main {

  public static void main(String[] args) {
    System.out.println("We'll assume that stocking will be done by humans, so let's not worry about detecting defective items. A customer service part should exist in the store as well. Server should run all these for the stores as well. After that, we should imlement gui for the whole thing. The reason why I used hashmap for all these is because of we want to look up stuff very fast for now. Start worrying about effieciency and testing. GUI part comes after all the testing");
    System.out.println("Testing in Progress: Need to make edge cases for add and remove");
	org.junit.runner.JUnitCore.main("tests.ItemHeapTest");
  }
}