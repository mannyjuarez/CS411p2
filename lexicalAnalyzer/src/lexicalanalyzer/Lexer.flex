package lexicalanalyzer;

import java_cup.runtime.*;
import java_cup.runtime.Symbol;

%%
%class Lexer

%line
%column

%cup

%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

%}

%{
        String type;
%}

id                  = [A-Za-z$] [A-Za-z_$0-9]*
ws                  = [\ \t]
Line                = [\r|\n|\r\n]
integer             = [0-9][0-9]*
hexInt              = 0[xX][0-9A-Fa-f]+
singlecom           = "//".*
comment             = "/*" ~"*/"
DoubleLiteral       = ({FLit1}|{FLit2}|{FLit3}) {Exponent}?
FLit1               = [0-9]+ \. [0-9]* 
FLit2               = \. [0-9]+ 
FLit3               = [0-9]+ 
Exponent            = \.[eE] [+-]? [0-9]+
stringchar          = \"[^\n\"]*\"

%%


    "if"                {return symbol(sym._if);}
    "implements"        {return symbol(sym._implements);}
    "interface"         {return symbol(sym._interface);}
    "newarray"             {return symbol(sym._newarray);}
    "println"           {return symbol(sym._println);}
    "readln"            {return symbol(sym._readln);}
    "return"            {return symbol(sym._return);}
    "string"            {return symbol(sym._string);}
    "void"              {return symbol(sym._void);}
    "while"             {return symbol(sym._while);}
    "int"               {return symbol(sym._int);}
    "boolean"           {return symbol(sym._boolean);}
    "true"              {return symbol(sym._booleanconstant);}
    "false"             {return symbol(sym._booleanconstant);}
    "break"             {return symbol(sym._break);}
    "class"             {return symbol(sym._class);}
    "double"            {return symbol(sym._double);}
    "else"              {return symbol(sym._else);}
    "extends"           {return symbol(sym._extends);}
    "for"               {return symbol(sym._for);}
    "="                 {return symbol(sym._assignop);}
    "*"                 {return symbol(sym._multiplication);}
    "/"                 {return symbol(sym._division);}
    "%"                 {return symbol(sym._mod);}
    "<"                 {return symbol(sym._less);}
    "<="                {return symbol(sym._lessequal);}
    ">"                 {return symbol(sym._greater);}
    ">="                {return symbol(sym._greaterequal);}
    "=="                {return symbol(sym._equal);}
    "!="                {return symbol(sym._notequal);}
    "&&"                {return symbol(sym._and);}
    "||"                {return symbol(sym._or);}
    "!"                 {return symbol(sym._not);}
    ";"                 {return symbol(sym._semicolon);}
    ","                 {return symbol(sym._comma);}
    "."                 {return symbol(sym._period);}
    "["                 {return symbol(sym._leftbracket);}
    "]"                 {return symbol(sym._rightbracket);}
    "{"                 {return symbol(sym._leftbrace);}
    "}"                 {return symbol(sym._rightbrace);}
    "("                 {return symbol(sym._leftparen);}
    ")"                 {return symbol(sym._rightparen);}
    "+"                 {return symbol(sym._plus);}
    "-"                 {return symbol(sym._minus);}
    {id}                {type = yytext(); return symbol(sym._id);} 
    {integer}           {return symbol(sym._intconstant);}
    {hexInt}            {return symbol(sym._intconstant);}
    {ws}                {}
    {Line}              { System.out.println();}
    {singlecom}         {}
    {comment}           {}
    {DoubleLiteral}     {return symbol(sym._doubleconstant);}
    {stringchar}        {return symbol(sym._stringconstant);}
