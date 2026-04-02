class Node {
    private boolean isWord;
    private HashMap<Character, Node> children;

    public Node() {
        isWord = false;
        children = new HashMap<>();
    }

    public Node findChild(char c) {
        return children.getOrDefault(c, null);
    }

    public Node addChild(char c) {
        if (children.containsKey(c))
            return children.get(c);
        Node n = new Node();
        children.put(c, n);
        return n;
    }

    public void makeWord() {
        isWord = true;
    }

    public boolean returnWord() {
        return isWord;
    }
}

class PrefixTree {

    private Node head;

    public PrefixTree() {
        head = new Node();
    }

    public void insert(String word) {
        Node temp = head;
        for (char c : word.toCharArray()) {
            temp = temp.addChild(c);
        }
        temp.makeWord();
    }

    public boolean search(String word) {
        Node temp = head;
        for (char c : word.toCharArray()) {
            temp = temp.findChild(c);
            if (temp == null) return false;
        }
        return temp.returnWord();
    }

    public boolean startsWith(String prefix) {
        Node temp = head;
        for (char c : prefix.toCharArray()) {
            temp = temp.findChild(c);
            if (temp == null) return false;
        }
        return true;
    }
}
