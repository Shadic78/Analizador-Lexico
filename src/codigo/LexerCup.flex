package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
CA = "\""[^*]~"\"" | "\"" + "\"" 
%{
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
PROGRAMA  {return new Symbol(sym.PROGRAMA, yychar, yyline, yytext());}
FINPROG  {return new Symbol(sym.FINPROG, yychar, yyline, yytext());}
SI  {return new Symbol(sym.SI, yychar, yyline, yytext());}
ENTONCES  {return new Symbol(sym.ENTONCES, yychar, yyline, yytext());}
SINO  {return new Symbol(sym.SINO, yychar, yyline, yytext());}
FINSI  {return new Symbol(sym.FINSI, yychar, yyline, yytext());}
REPITE  {return new Symbol(sym.REPITE, yychar, yyline, yytext());}
VECES  {return new Symbol(sym.VECES, yychar, yyline, yytext());}
FINREP  {return new Symbol(sym.FINREP, yychar, yyline, yytext());}
IMPRIME  {return new Symbol(sym.IMPRIME, yychar, yyline, yytext());}
LEE  {return new Symbol(sym.LEE, yychar, yyline, yytext());}
{espacio} {/*Ignore*/}
"#".* {/*Ignore*/}
"=" {return new Symbol(sym.Asignacion, yychar, yyline, yytext());}
"+" {return new Symbol(sym.Suma, yychar, yyline, yytext());}
"-" {return new Symbol(sym.Resta, yychar, yyline, yytext());}
"*" {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}
"/" {return new Symbol(sym.Division, yychar, yyline, yytext());}
">" {return new Symbol(sym.MayorQue, yychar, yyline, yytext());}
"<" {return new Symbol(sym.MenorQue, yychar, yyline, yytext());}
"==" {return new Symbol(sym.IgualA, yychar, yyline, yytext());}
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}
{D}("x")({L}|{D})* {return new Symbol(sym.Numero, yychar, yyline, yytext());}
{CA}+ {return new Symbol(sym.LiteralDeTexto, yychar, yyline, yytext());}
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}

