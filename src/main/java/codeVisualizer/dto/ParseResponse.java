package codeVisualizer.dto;

import utils.Node;

public class ParseResponse {
    private Node astRoot;
    private String message;

    public ParseResponse(Node astRoot, String message) {
        this.astRoot = astRoot;
        this.message = message;
    }

    // Getters and setters
    public Node getAstRoot() {
        return astRoot;
    }

    public void setAstRoot(Node astRoot) {
        this.astRoot = astRoot;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}