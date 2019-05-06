public final class Main {

  public static void main(String... args) {
    LinkedList<String> list = new LinkedList<>();
    for (String arg : args) {
      list.append(arg);
    }
    for (int k = 0; true; k++) {
      String value = KLast.get(list, k);
      System.out.println(k + "-to-last element is " + value);
      if (value == null) {
        break;
      }
    }
  }

  private Main() {}
}
