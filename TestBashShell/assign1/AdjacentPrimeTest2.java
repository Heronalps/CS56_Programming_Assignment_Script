import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AdjacentPrimeTest {
  @Test
  public void PrevPrimeTest() {
    AdjacentPrime adjacentPrime = new AdjacentPrime();
    int primeNone = adjacentPrime.prevPrime(2);
    assertEquals(-1, primeNone);
    int prime3 = adjacentPrime.prevPrime(5);
    assertEquals(3, prime3);
  }
  @Test
  public void NextPrimeTest() {
    AdjacentPrime adjacentPrime = new AdjacentPrime();
    int prime3 = adjacentPrime.nextPrime(2);
    assertEquals(3, prime3);
  }
  @Test
  public void PrevGapTest() {
    AdjacentPrime adjacentPrime = new AdjacentPrime();
    int gap1 = adjacentPrime.prevGap(3);
    assertEquals(1, gap1);
    int gapNone = adjacentPrime.prevGap(2);
    assertEquals(-1, gapNone);
  }
  @Test
  public void NextGapTest() {
    AdjacentPrime adjacentPrime = new AdjacentPrime();
    int gap1 = adjacentPrime.nextGap(2);
    assertEquals(1, gap1);
  }
  @Test
  public void PrevPrimeWithIndexTest() {
    AdjacentPrime adjacentPrime = new AdjacentPrime();
    int primeNone = adjacentPrime.prevPrime(2, 2);
    assertEquals(-1, primeNone);
    int prime5 = adjacentPrime.prevPrime(17, 4);
    assertEquals(5, prime5);
  }
  @Test
  public void NextPrimeWithIndexTest() {
    AdjacentPrime adjacentPrime = new AdjacentPrime();
    int prime13 = adjacentPrime.nextPrime(2, 5);
    assertEquals(13, prime13);
  }
}
