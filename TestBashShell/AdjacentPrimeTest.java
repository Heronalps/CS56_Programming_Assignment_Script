import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AdjacentPrimeTest {
  @Test
  public void PrevPrimeTest() {
    AdjacentPrime adjacentPrime = new AdjacentPrime();
    int primeNone = adjacentPrime.PrevPrime(2);
    assertEquals(-1, primeNone);
    int prime3 = adjacentPrime.PrevPrime(5);
    assertEquals(3, prime3);
  }
  @Test
  public void NextPrimeTest() {
    AdjacentPrime adjacentPrime = new AdjacentPrime();
    int prime3 = adjacentPrime.NextPrime(2);
    assertEquals(3, prime3);
  }
  @Test
  public void PrevGapTest() {
    AdjacentPrime adjacentPrime = new AdjacentPrime();
    int gap1 = adjacentPrime.PrevGap(3);
    assertEquals(1, gap1);
    int gapNone = adjacentPrime.PrevGap(2);
    assertEquals(-1, gapNone);
  }
  @Test
  public void NextGapTest() {
    AdjacentPrime adjacentPrime = new AdjacentPrime();
    int gap1 = adjacentPrime.NextGap(2);
    assertEquals(1, gap1);
  }
  @Test
  public void PrevPrimeWithIndexTest() {
    AdjacentPrime adjacentPrime = new AdjacentPrime();
    int primeNone = adjacentPrime.PrevPrime(2, 2);
    assertEquals(-1, primeNone);
    int prime5 = adjacentPrime.PrevPrime(17, 4);
    assertEquals(5, prime5);
  }
  @Test
  public void NextPrimeWithIndexTest() {
    AdjacentPrime adjacentPrime = new AdjacentPrime();
    int prime13 = adjacentPrime.NextPrime(2, 5);
    assertEquals(13, prime13);
  }
}