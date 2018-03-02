package lexicalanalyzer;

import java_cup.runtime.*;

%%
%class Lexer

%line
%column

%cup

%{
    private symbol symbol(int type) {
        return new symbol(type, yyline, yycolumn);
    }

    private symbol symbol(int type, Object value) {
        return new symbol(type, yyline, yycolumn, value);
    }

%}

%{
        string type;
%}

id                  = [A-Za-z$] [A-Za-z_$0-9]*
ws                  = [\ \t]
newLine             = [\r|\n|\r\n]
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


    "if"                {return new symbol(sym._if);}
    "implements"        {return new symbol(sym._implements);}
    "interface"         {return new symbol(sym._interface);}
    "newarray"          {return new symbol(sym._newarray);}
    "println"           {return new symbol(sym._println);}
    "readln"            {return new symbol(sym._readln);}
    "return"            {return new symbol(sym._return);}
    "string"            {return new symbol(sym._string);}
    "void"              {return new symbol(sym._void);}
    "while"             {return new symbol(sym._while);}
    "int"               {return new symbol(sym._int);}
    "boolean"           {return new symbol(sym._boolean);}
    "true"              {return new symbol(sym._booleanconstant);}
    "false"             {return new symbol(sym._booleanconstant);}
    "break"             {return new symbol(sym._break);}
    "class"             {return new symbol(sym._class);}
    "double"            {return new symbol(sym._double);}
    "else"              {return new symbol(sym._else);}
    "extends"           {return new symbol(sym._extends);}
    "for"               {return new symbol(sym._for);}
    "="                 {return new symbol(sym._assignop);}
    "*"                 {return new symbol(sym._multiplication);}
    "/"                 {return new symbol(sym._division);}
    "%"                 {return new symbol(sym._mod);}
    "<"                 {return new symbol(sym._less);}
    "<="                {return new symbol(sym._lessequal);}
    ">"                 {return new symbol(sym._greater);}
    ">="                {return new symbol(sym._greaterequal);}
    "=="                {return new symbol(sym._equal);}
    "!="                {return new symbol(sym._notequal);}
    "&&"                {return new symbol(sym._and);}
    "||"                {return new symbol(sym._or);}
    "!"                 {return new symbol(sym._not);}
    ";"                 {return new symbol(sym._semicolon);}
    ","                 {return new symbol(sym._comma);}
    "."                 {return new symbol(sym._period);}
    "["                 {return new symbol(sym._leftbracket);}
    "]"                 {return new symbol(sym._rightbracket);}
    "{"                 {return new symbol(sym._leftbrace);}
    "}"                 {return new symbol(sym._rightbrace);}
    "("                 {return new symbol(sym._leftparen);}
    ")"                 {return new symbol(sym._rightparen);}
    "+"                 {return new symbol(sym._plus);}
    "-"                 {return new symbol(sym._minus);}
    {id}                {type = yytext(); return new symbol(sym._id);} 
    {integer}           {return new symbol(sym._intconstant);}
    {hexInt}            {return new symbol(sym._intconstant);}
    {ws}                {}
    {newLine}           {system.out.println();}
    {singlecom}         {}
    {comment}           {}
    {DoubleLiteral}     {return new symbol(sym._doubleconstant);}
    {stringchar}        {return new symbol(sym._stringconstant);}
    <<EOF>>             {return new symbol(sym._EOF); }
