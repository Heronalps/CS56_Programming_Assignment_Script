package ProgAssignment2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.*;

public class HotWordsAnalyzerTest {

  public HotWordsAnalyzerTest() throws FileNotFoundException, IOException, Exception{

  }
  //Reads in HotWord file and Document file
  HotWordsAnalyzer hotWordsAnalyzer = new HotWordsAnalyzer("hotwords.txt", "document.txt");

  @Test
  public void countTest() throws FileNotFoundException, IOException, Exception{
    
    int total = hotWordsAnalyzer.count();
    assertEquals(18, total);
    int countXML = hotWordsAnalyzer.count("XML");
    assertEquals(5, countXML);
    int countData = hotWordsAnalyzer.count("data");
    assertEquals(-1, countData);
  }

  @Test
  public void distinctCountTest() throws FileNotFoundException, IOException, Exception{
    
    int distinctCount = hotWordsAnalyzer.distinctCount();
    assertEquals(6, distinctCount);
  }

  @Test
  public void topHotWordsTest() throws FileNotFoundException, IOException, Exception{
    
    String[] topArray1 = hotWordsAnalyzer.topHotWords(1);
    assertEquals("XML", topArray1[0]);
    assertEquals(1, topArray1.length);
    String[] topArray2 = hotWordsAnalyzer.topHotWords(0);
    assertEquals("XML", topArray2[0]);
    assertEquals(1, topArray2.length);
    String[] topArray3 = hotWordsAnalyzer.topHotWords(-5);
    assertEquals("XML", topArray3[0]);
    assertEquals(1, topArray3.length);
    String[] topArray4 = hotWordsAnalyzer.topHotWords(7);
    assertEquals("XSL", topArray4[1]);
    assertEquals(6, topArray4.length);
    String[] topArray5 = hotWordsAnalyzer.topHotWords(hotWordsAnalyzer.distinctCount());
    assertEquals(6, topArray5.length);
    assertEquals("XML", topArray5[0]);
    assertEquals("XSL", topArray5[1]);
    assertEquals("system", topArray5[2]);
    assertEquals("design", topArray5[3]);
    assertEquals("instance", topArray5[4]);
    assertEquals("association", topArray5[5]);
  }

  @Test
  public void nextHotWordsTest() throws FileNotFoundException, IOException, Exception{
    
    String[] nextArray = hotWordsAnalyzer.nextHotWords("XML");
    assertEquals(5, nextArray.length);
    assertEquals("instance", nextArray[0]);
    assertEquals("association", nextArray[1]);
    assertEquals("instance", nextArray[2]);
    assertEquals("association", nextArray[3]);
    assertEquals("XSL", nextArray[4]);
    String[] nextArray2 = hotWordsAnalyzer.nextHotWords("XSL");
    assertEquals(4, nextArray2.length);
    assertEquals("XSL", nextArray2[0]);
    assertEquals("XML", nextArray2[1]);
    assertEquals("XSL", nextArray2[2]);
    assertEquals("system", nextArray2[3]);
  }

  @Test
  public void prevHotWordsTest() throws FileNotFoundException, IOException, Exception{
    
    String[] prevArray = hotWordsAnalyzer.prevHotWords("system");
    assertEquals(1, prevArray.length);
    assertEquals("XSL", prevArray[0]);
    String[] prevArray2 = hotWordsAnalyzer.prevHotWords("design");
    assertEquals(2, prevArray2.length);
    assertEquals("system", prevArray2[0]);
    assertEquals("system", prevArray2[1]);
  }

  @Test
  public void consecutiveTest() throws FileNotFoundException, IOException, Exception{
    
    assertEquals(true, hotWordsAnalyzer.consecutive("XML", "XSL"));
    assertEquals(true, hotWordsAnalyzer.consecutive("XSL", "XSL"));
    assertEquals(false, hotWordsAnalyzer.consecutive("system", "XSL"));
    assertEquals(true, hotWordsAnalyzer.consecutive("system", "design", "XML"));
    assertEquals(false, hotWordsAnalyzer.consecutive("XML", "system", "design"));

  }
}
