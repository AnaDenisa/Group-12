import java.util.ArrayList;

class TreeBuildersUtils {

  private static <T> Node<T> balanceTreeHelper(ArrayList<Node<T>> nodes, int start, int end) {

    if (start > end) return null;

    int mid = (start + end) / 2;
    Node<T> node = nodes.get(mid);

    node.setLeft(balanceTreeHelper(nodes, start, mid - 1));
    node.setRight(balanceTreeHelper(nodes, mid + 1, end));

    return node;
  }

  /* builds a balanced tree from the ArrayList nodes gives as parameter */
  static <T> Node<T> buildBalancedTree(ArrayList<Node<T>> nodesList) {
    return balanceTreeHelper(nodesList, 0, nodesList.size() - 1);
  }
}
