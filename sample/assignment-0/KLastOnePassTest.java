import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class KLastOnePassTest {

  @Test
  public void empty() {
    LinkedList empty = LinkedList.of();
    assertNull(KLastOnePass.get(empty, 0));
    assertNull(KLastOnePass.get(empty, 1));
  }

  @Test
  public void last() {
    assertEquals(2, KLastOnePass.get(LinkedList.of(1, 5, 3, 2), 0).intValue());
  }

  @Test
  public void first() {
    assertEquals(1, KLastOnePass.get(LinkedList.of(1, 5, 3, 2), 3).intValue());
  }

  @Test
  public void middle() {
    assertEquals(5, KLastOnePass.get(LinkedList.of(1, 5, 3, 2), 2).intValue());
  }

  @Test
  public void outOfBounds() {
    assertNull(KLastOnePass.get(LinkedList.of(1, 5, 3, 2), 5));
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativeOnEmpty() {
    LinkedList empty = LinkedList.of();
    KLastOnePass.get(empty, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negative() {
    LinkedList list = LinkedList.of(1, 2, 3);
    KLastOnePass.get(list, -1);
  }
}
