import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class LinkedListTest {

  @Test
  public void createListOf() {
    LinkedList<Integer> list = LinkedList.of(1, 5, 3, 2);
    assertEquals(1, list.head().value().intValue());
    assertEquals(5, list.head().next().value().intValue());
    assertEquals(3, list.head().next().next().value().intValue());
    assertEquals(2, list.head().next().next().next().value().intValue());
    assertNull(list.head().next().next().next().next());
  }

  @Test
  public void createEmptyList() {
    LinkedList<Integer> list = LinkedList.of();
    assertNull(list.head());
  }

  @Test
  public void appendToTheEnd() {
    LinkedList<Integer> list = LinkedList.of(1, 5, 3, 2);
    list.append(42);
    assertEquals(42, list.head().next().next().next().next().value().intValue());
    assertNull(list.head().next().next().next().next().next());
  }

  @Test
  public void prependToTheEnd() {
    LinkedList<Integer> list = LinkedList.of(1, 5, 3, 2);
    list.prepend(42);
    assertEquals(42, list.head().value().intValue());
    assertEquals(1, list.head().next().value().intValue());
  }
}
