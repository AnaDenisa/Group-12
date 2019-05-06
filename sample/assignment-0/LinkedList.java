import javax.annotation.Nullable;

/** A singly-linked list of values. */
final class LinkedList<T> {

  /** A node within the linked list. */
  static final class Node<U> {
    private final U value;
    private Node<U> next;

    Node(U value) {
      this.value = value;
    }

    /** Returns the value associated with the node. */
    U value() {
      return value;
    }

    /** Returns the next node in the list, or {@code null} if this is the last. */
    @Nullable
    Node<U> next() {
      return next;
    }
  }

  /** Creates a {@link LinkedList} with the given values. */
  static <S> LinkedList<S> of(S... values) {
    LinkedList<S> list = new LinkedList<>();
    for (S value : values) {
      list.append(value);
    }
    return list;
  }

  /** The first node in the list, or {@code null} if the list is empty. */
  @Nullable private Node<T> head;

  LinkedList() {}

  /** Returns the first node in the list, or {@code null} if the list is empty. */
  Node<T> head() {
    return head;
  }

  /** Inserts a value at the end of the list. */
  void append(T value) {
    Node<T> node = new Node<>(value);
    if (head == null) {
      head = node;
    } else {
      Node<T> current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = node;
    }
  }

  /** Inserts a value at the beginning of the list. */
  void prepend(T value) {
    Node<T> node = new Node<>(value);
    node.next = head;
    head = node;
  }
}
