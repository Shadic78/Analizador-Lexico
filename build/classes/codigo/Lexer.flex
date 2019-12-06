package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r]+
CA = "\""[^*]~"\"" | "\"" + "\"" 
%{
    public String lexeme;
%}
%%
PROGRAMA  {lexeme=yytext(); return PROGRAMA;}
FINPROG  {lexeme=yytext(); return FINPROG;}
SI  {lexeme=yytext(); return SI;}
ENTONCES  {lexeme=yytext(); return ENTONCES;}
SINO  {lexeme=yytext(); return SINO;}
FINSI  {lexeme=yytext(); return FINSI;}
REPITE  {lexeme=yytext(); return REPITE;}
VECES  {lexeme=yytext(); return VECES;}
FINREP  {lexeme=yytext(); return FINREP;}
IMPRIME  {lexeme=yytext(); return IMPRIME;}
LEE  {lexeme=yytext(); return LEE;}
{espacio} {/*Ignore*/}
"#".* {/*Ignore*/}
"=" {lexeme=yytext(); return Asignacion;}
"+" {lexeme=yytext(); return Suma;}
"-" {lexeme=yytext(); return Resta;}
"*" {lexeme=yytext(); return Multiplicacion;}
"/" {lexeme=yytext(); return Division;}
">" {lexeme=yytext(); return MayorQue;}
"<" {lexeme=yytext(); return MenorQue;}
"\n" {lexeme=yytext(); return SaltoDeLinea;}
"==" {lexeme=yytext(); return IgualA;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
{D}("x")({L}|{D})* {lexeme=yytext(); return Numero;}
{CA}+ {lexeme=yytext(); return LiteralDeTexto;}
 . {return ERROR;}
