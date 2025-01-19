# TokenCraft Technical Documentation

<div align="center">

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://github.com/Cri5tiann/TokenCraft)

</div>

---

<details>
<summary>📋 Table of Contents</summary>

- [System Architecture](#system-architecture)
  - [Lexical Analysis](#1-lexical-analysis-lexer)
  - [Syntactic Analysis](#2-syntactic-analysis-parser)
  - [Abstract Syntax Tree](#3-abstract-syntax-tree)
  - [Error Handling](#4-error-handling)
  - [Testing Framework](#5-testing-framework)
  - [Build System](#6-build-system-integration)
  - [Performance](#7-performance-considerations)
  - [Limitations](#8-known-limitations)
  - [Future Work](#9-future-enhancements)
- [Appendix](#appendix)

</details>

## System Architecture

### 1. Lexical Analysis (Lexer)

<details>
<summary>1.1 Implementation Details</summary>

```java
%class Lexer
%unicode
%cup
%line
%column
```
</details>

<details>
<summary>1.2 Token Definitions</summary>

```java
// Keywords
FUNCTION, IF, ELSE, FOR, RETURN, TRUE, FALSE

// Operators
PLUS(+), MINUS(-), TIMES(*), DIVIDE(/), MOD(%)
INCREMENT(++), DECREMENT(--)
ASSIGN(=), EQUALS(==)
OR(||), AND(&&)
LESSEQUAL(<=), GREATEREQUAL(>=), LESS()

// Delimiters
LPAREN, RPAREN, LBRACE, RBRACE, SEMICOLON, COMMA

// Special Functions
INPUT_INT, OUTPUT_INT

// Literals
IDENTIFIER: [a-zA-Z][a-zA-Z0-9_]*
INTEGER_LITERAL: [0-9]+
```
</details>

<details>
<summary>1.3 Regular Expressions</summary>

```java
LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
InputCharacter = [^\r\n]
Digit          = [0-9]
Integer        = {Digit}+
Identifier     = [a-zA-Z][a-zA-Z0-9_]*
```
</details>

### 2. Syntactic Analysis (Parser)

<details>
<summary>2.1 Grammar Specification</summary>

```bnf
program ::= function_declaration

function_declaration ::= 
    FUNCTION IDENTIFIER ( parameter_list? ) { statement_list }

parameter_list ::= 
    parameter
    | parameter_list COMMA parameter
```

</details>

<details>
<summary>2.2 Operator Precedence</summary>

```java
precedence left OR;
precedence left AND;
precedence left EQUALS;
precedence left LESS, LESSEQUAL, GREATER, GREATEREQUAL;
precedence left PLUS, MINUS;
precedence left TIMES, DIVIDE, MOD;
precedence right INCREMENT, DECREMENT;
precedence left ELSE;
```
</details>

### 3. Abstract Syntax Tree

<details>
<summary>3.1 Node Structure</summary>

```java
public class Node {
    String value;
    List children;

    public Node(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        children.add(child);
    }
}
```
</details>

#### 3.2 Tree Generation
Each production rule generates corresponding nodes:

```java
expression ::= expression:e PLUS term:t
    {:
        Node plusNode = new Node("+");
        plusNode.addChild((Node) e);
        plusNode.addChild((Node) t);
        RESULT = plusNode;
    :}
```

#### 3.3 Tree Visualization
```java
private String printTree(Node node, String prefix, boolean isTail) {
    StringBuilder sb = new StringBuilder();
    sb.append(prefix)
      .append(isTail ? "|__ " : "|-- ")
      .append(node.value)
      .append("\n");
    
    for (int i = 0; i < node.children.size(); i++) {
        boolean isLastChild = (i == node.children.size() - 1);
        sb.append(printTree(node.children.get(i),
                prefix + (isTail ? "    " : "|   "),
                isLastChild));
    }
    return sb.toString();
}
```

### 4. Error Handling

#### 4.1 Lexical Errors
```java
{Digit}+{Identifier} {
    System.err.println("Error: Invalid numeric identifier at line " + 
                      (yyline+1) + ", column " + (yycolumn+1));
}
```

#### 4.2 Syntax Errors
- Mismatched parentheses tracking
- Invalid expression detection
- Missing semicolon recovery
- Invalid function declaration handling

#### 4.3 Error Recovery Strategies
- Panic mode implementation
- Error synchronization points
- Token stream resynchronization
- Error cascade prevention

### 5. Testing Framework

#### 5.1 Lexer Testing
```java
public class TestLexer {
    public static void main(String[] args) throws Exception {
        String filename = "test.plt";
        try (FileReader fileReader = new FileReader(filename)) {
            Lexer lexer = new Lexer(fileReader);
            Symbol symbol;
            while ((symbol = lexer.next_token()).sym != sym.EOF) {
                String tokenName = getTokenName(symbol.sym);
                System.out.println("Token: " + tokenName + 
                                 ", Value: " + symbol.value);
            }
        }
    }
}
```

#### 5.2 Parser Testing
```java
public class TestParser {
    public static void main(String[] args) {
        String filePath = "test.plt";
        try {
            FileReader fileReader = new FileReader(filePath);
            Lexer lexer = new Lexer(fileReader);
            Parser parser = new Parser(lexer);
            Symbol result = parser.parse();
            Node root = (Node) result.value;
            System.out.println(root.toString());
            fileReader.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

### 6. Build System Integration

#### 6.1 Build Process
1. JFlex lexer generation
2. CUP parser generation
3. Java compilation
4. Resource file management

#### 6.2 File Structure
```
tokencraft/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── lexer/
|   |   |   |    ├── Lexer
|   |   |   |    ├── lexer.flex
|   |   |   |    └── sym
│   │   │   ├── parser/
|   |   |   |    ├── Parser
|   |   |   |    └── Parser.cup
|   |   |   ├── utils 
│   │   │   |    └── Node.java
│   │   │   ├── TestLexer.java
│   │   │   └── TestParser.java
│   │   └── resources/
│   │       └── test4.plt
│   └── test/
│       └── java/
└── examples/
    └── *.plt
```

### 7. Performance Considerations

#### 7.1 Lexer Optimization
- Buffer management
- Character class optimization
- State machine minimization

#### 7.2 Parser Optimization
- LALR(1) state reduction
- AST memory management
- Symbol table optimization

### 8. Known Limitations

- [ ] No floating-point number support
- [ ] Limited to single-file programs
- [ ] No function overloading
- [ ] No type system implementation

### 9. Future Enhancements

- [ ] Type system implementation
- [ ] Function overloading support
- [ ] Standard library development
- [ ] Optimization passes
- [ ] Code generation phase

## Appendix

<details>
<summary>A. Token Type Mappings</summary>

```java
private static String getTokenName(int symType) {
    switch (symType) {
        case sym.FUNCTION: return "FUNCTION";
        case sym.IF: return "IF";
        // ... (complete mapping)
    }
}
```
</details>

<details>
<summary>B. Error Messages</summary>

```java
// Lexical Errors
"Error: Invalid numeric identifier at line %d, column %d"
"Error: Unsupported keyword at line %d, column %d"
"Error: Invalid numeric format at line %d, column %d"
"Error: Illegal character at line %d, column %d"

// Syntax Errors
"Error: Mismatched parentheses"
"Error: Missing semicolon"
"Error: Invalid expression"
"Error: Invalid function declaration"
```
</details>

<details>
<summary>C. Performance Metrics</summary>

|
 Component 
|
 Complexity 
|
 Memory Usage 
|
|
-----------
|
------------
|
--------------
|
|
 Lexing 
|
 O(n) 
|
 O(1) 
|
|
 Parsing 
|
 O(n) 
|
 O(n) 
|
|
 AST Construction 
|
 O(n) 
|
 O(n) 
|

where n is the input size in characters.
</details>

---

<div align="center">

**[Back to README](README.md)** • **[Report Issues][issues]** • **[Request Features][features]**

</div>

[issues]: https://github.com/Cri5tiann/TokenCraft/issues
[features]: https://github.com/Cri5tiann/TokenCraft/issues/new?labels=enhancement
