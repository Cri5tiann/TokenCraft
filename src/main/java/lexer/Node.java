package lexer;

import java.util.ArrayList;
import java.util.List;

public class Node {
    String value;
    List<Node> children;

    public Node(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public String toString() {
        return printTree(this, "", true);
    }

    private String printTree(Node node, String prefix, boolean isTail) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append(isTail ? "└── " : "├── ").append(node.value).append("\n");

        for (int i = 0; i < node.children.size(); i++) {
            boolean isLastChild = (i == node.children.size() - 1);
            sb.append(printTree(node.children.get(i), prefix + (isTail ? "    " : "│   "), isLastChild));
        }

        if (node.children.size() > 0) {
            sb.append(printTree(node.children.get(node.children.size() - 1),
                    prefix + (isTail ? "    " : "│   "), true));
        }
        return sb.toString();
    }
}
