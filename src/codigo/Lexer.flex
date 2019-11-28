package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
CA = "\""[^*]~"\"" | "\"" + "\"" 
%{
    public String lexeme;
%}
%%
PROGRAMA |
FINPROG |
SI |
ENTONCES |
SINO |
FINSI |
REPITE |
VECES |
FINREP |
IMPRIME |
LEE |
while {lexeme=yytext(); return Reservadas;}
{espacio} {/*Ignore*/}
"#".* {/*Ignore*/}
"=" {return Asignacion;}
"+" {return Suma;}
"-" {return Resta;}
"*" {return Multiplicacion;}
"/" {return Division;}
">" {return MayorQue;}
"<" {return MenorQue;}
"==" {return IgualA;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
{D}("x")({L}|{D})* {lexeme=yytext(); return Numero;}
{CA}+ {lexeme=yytext(); return LiteralDeTexto;}
 . {return ERROR;}
