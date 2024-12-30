import java_cup.runtime.*;

%%

%class Lexer
%unicode
%cup
%line
%column

%{
    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }
%}

/* Basic Definitions */
LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
InputCharacter = [^\r\n]
Digit          = [0-9]
Integer        = {Digit}+
Identifier     = [a-zA-Z][a-zA-Z0-9_]*

%%

/* Keywords */
"function"      { return symbol(sym.FUNCTION); }
"if"            { return symbol(sym.IF); }
"else"          { return symbol(sym.ELSE); }
"for"           { return symbol(sym.FOR); }
"return"        { return symbol(sym.RETURN); }
"true"          { return symbol(sym.TRUE); }
"false"         { return symbol(sym.FALSE); }

/* Operators */
"+"             { return symbol(sym.PLUS); }
"-"             { return symbol(sym.MINUS); }
"*"             { return symbol(sym.TIMES); }
"/"             { return symbol(sym.DIVIDE); }
"%"             { return symbol(sym.MOD); }
"++"            { return symbol(sym.INCREMENT); }
"--"            { return symbol(sym.DECREMENT); }
"="             { return symbol(sym.ASSIGN); }
"=="            { return symbol(sym.EQUALS); }
"||"            { return symbol(sym.OR); }
"&&"            { return symbol(sym.AND); }
"<="            { return symbol(sym.LESSEQUAL); }
">="            { return symbol(sym.GREATEREQUAL); }
"<"             { return symbol(sym.LESS); }
">"             { return symbol(sym.GREATER); }

/* Separators */
"("             { return symbol(sym.LPAREN); }
")"             { return symbol(sym.RPAREN); }
"{"             { return symbol(sym.LBRACE); }
"}"             { return symbol(sym.RBRACE); }
";"             { return symbol(sym.SEMICOLON); }
","             { return symbol(sym.COMMA); }

/* Functions */
"input_int"     { return symbol(sym.INPUT_INT); }
"output_int"    { return symbol(sym.OUTPUT_INT); }

{Digit}+{Identifier} {
    System.err.println("Error: Invalid numeric identifier <" + yytext() + "> at line " + (yyline+1) + ", column " + (yycolumn+1));
    // Continue scanning
}

/* Whitespace */
{WhiteSpace}    { /* ignore */ }

"while"|"do"|"switch" {
    System.err.println("Error: Unsupported keyword <" + yytext() + "> at line " + (yyline+1) + ", column " + (yycolumn+1));
}

{Digit}+"."{Digit}+ {
    System.err.println("Error: Invalid numeric format (floating-point) <" + yytext() + "> at line " + (yyline+1) + ", column " + (yycolumn+1));
}

/* Literals */
{Integer}       { return symbol(sym.INTEGER_LITERAL, Integer.parseInt(yytext())); }
{Identifier}    { return symbol(sym.IDENTIFIER, yytext()); }

/* Error fallback - Panic mode recovery */
[^]            {
    System.err.println("Illegal character <" + yytext() + "> at line " + (yyline+1) + ", column " + (yycolumn+1));
    // Continue scanning
}