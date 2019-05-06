import javax.annotation.Nullable;

/**
 * Extract the k-th to last element of the list.
 *
 * <p>This implementation scans the list a single time.
 */
final class KLastOnePass {

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

    // Start with two references to the head.
    LinkedList.Node<T> trailing = list.head();
    LinkedList.Node<T> leading = list.head();
    // This happens if the list is empty.
    if (leading == null) {
      return null;
    }
    // Move the leading one forward one by k steps, so that it leads by 'k' steps.
    for (int counter = 0; counter < k; counter++) {
      leading = leading.next();
      if (leading == null) {
        return null;
      }
    }
    // Step forward both references until the leading one gets to the last element of the list.
    while (leading.next() != null) {
      trailing = trailing.next();
      leading = leading.next();
    }
    // At this point the trailing reference is k steps before the end.
    return trailing.value();
  }

  private KLastOnePass() {} // Static utility class. No need to create an instance.
}
