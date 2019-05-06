import javax.annotation.Nullable;

/** Extract the k-th to last element of the list. */
final class KLast {

  /**
   * Returns the k-th to last element of the list.
   *
   * <p>If no such element exist, returns {code null}.
   *
   * @throws IllegalArgumentException if the given {@code k} is negative.
   */
  @Nullable
  public static <T> T get(LinkedList<T> list, int k) {
    if (k < 0) {
      throw new IllegalArgumentException("k should be positive");
    }
    // Compute the length of the list first.
    int length = 0;
    for (LinkedList.Node<T> current = list.head(); current != null; current = current.next()) {
      length++;
    }

    // Position of the k-th to last element.
    int position = length - k - 1;

    // Find the element at the given position and return it.
    if (position < 0) {
      return null;
    }
    for (LinkedList.Node<T> current = list.head(); current != null; current = current.next()) {
      if (position == 0) {
        return current.value();
      }
      position--;
    }
    return null;
  }

  private KLast() {} // Static utility class. No need to create an instance.
}
