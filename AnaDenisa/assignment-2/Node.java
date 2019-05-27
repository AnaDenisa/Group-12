class Node<T> {
  private T data;
  private Node<T> left;
  private Node<T> right;

  Node(T data) {
    this.setData(data);
    this.left = null;
    this.right = null;
  }

  T getData() {
    return data;
  }

  Node<T> getLeftChild() {
    return left;
  }

  Node<T> getRightChild() {
    return right;
  }

  void setData(T data) {

    this.data = data;
  }

  void setLeft(Node<T> left) {
    this.left = left;
  }

  void setRight(Node<T> right) {
    this.right = right;
  }
}
