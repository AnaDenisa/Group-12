import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class KLastTest {

  @Test
  public void empty() {
    LinkedList empty = LinkedList.of();
    assertNull(KLast.get(empty, 0));
    assertNull(KLast.get(empty, 1));
  }

  @Test
  public void last() {
    assertEquals(2, KLast.get(LinkedList.of(1, 5, 3, 2), 0).intValue());
  }

  @Test
  public void first() {
    assertEquals(1, KLast.get(LinkedList.of(1, 5, 3, 2), 3).intValue());
  }

  @Test
  public void middle() {
    assertEquals(5, KLast.get(LinkedList.of(1, 5, 3, 2), 2).intValue());
  }

  @Test
  public void outOfBounds() {
    assertNull(KLast.get(LinkedList.of(1, 5, 3, 2), 5));
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativeOnEmpty() {
    LinkedList empty = LinkedList.of();
    KLast.get(empty, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negative() {
    LinkedList list = LinkedList.of(1, 2, 3);
    KLast.get(list, -1);
  }
}
