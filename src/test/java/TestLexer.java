import java_cup.runtime.Symbol;
import lexer.Lexer;
import lexer.sym;

import java.io.FileReader;

public class TestLexer {
    public static void main(String[] args) throws Exception {
        // Specify the filename directly here
        String filename = "E:\\cod\\demo\\Lexer-Parser-PLT\\src\\main\\resources\\test3.plt";

        // Open the file for reading
        try (FileReader fileReader = new FileReader(filename)) {
            Lexer lexer = new Lexer(fileReader);  // Assuming FinalLexer takes a Reader as input
            Symbol symbol;

            // Process the tokens from the lexer
            while ((symbol = lexer.next_token()).sym != sym.EOF) {
                String tokenName = getTokenName(symbol.sym);
                System.out.println("Token: " + tokenName + ", Value: " + symbol.value);
            }
        }
    }

    private static String getTokenName(int symType) {
        switch (symType) {
            case sym.FUNCTION: return "FUNCTION";
            case sym.IF: return "IF";
            case sym.ELSE: return "ELSE";
            case sym.FOR: return "FOR";
            case sym.RETURN: return "RETURN";
            case sym.TRUE: return "TRUE";
            case sym.FALSE: return "FALSE";
            case sym.PLUS: return "PLUS";
            case sym.MINUS: return "MINUS";
            case sym.TIMES: return "TIMES";
            case sym.DIVIDE: return "DIVIDE";
            case sym.MOD: return "MOD";
            case sym.INCREMENT: return "INCREMENT";
            case sym.DECREMENT: return "DECREMENT";
            case sym.ASSIGN: return "ASSIGN";
            case sym.EQUALS: return "EQUALS";
            case sym.OR: return "OR";
            case sym.AND: return "AND";
            case sym.LESSEQUAL: return "LESSEQUAL";
            case sym.GREATEREQUAL: return "GREATEREQUAL";
            case sym.LESS: return "LESS";
            case sym.GREATER: return "GREATER";
            case sym.LPAREN: return "LPAREN";
            case sym.RPAREN: return "RPAREN";
            case sym.LBRACE: return "LBRACE";
            case sym.RBRACE: return "RBRACE";
            case sym.SEMICOLON: return "SEMICOLON";
            case sym.COMMA: return "COMMA";
            case sym.INPUT_INT: return "INPUT_INT";
            case sym.OUTPUT_INT: return "OUTPUT_INT";
            case sym.IDENTIFIER: return "IDENTIFIER";
            case sym.INTEGER_LITERAL: return "INTEGER_LITERAL";
            default: return "UNKNOWN";
        }
    }
}
