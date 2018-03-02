/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalyzer;

/**
 *
 * @author mannyjuarez
 */
public enum Symbol {
    
    _boolean(1), _break(2), _class(3), _double(4), _else(5), _extends(6), 
    _for(7), _if(8), _implements(9), _int(10), _interface(11), _newarray(12),
    _println(13), _readln(14), _return(15), _string(16), _void(17),  _while(18),
    _plus(19), _minus(20), _less(21),_multiplication(22), _division(23), 
    _mod(24),_lessequal(25), _greater(26), _greaterequal(27), _equal(28),
    _notequal(29), _and(30), _or(31), _not(32), _assignop(33), _semicolon(34), 
    _comma(35), _period(36), _leftparen(37), _rightparen(38),_leftbracket(40),
    _rightbracket(41), _leftbrace(42), _rightbrace(43), _intconstant(44), 
    _doubleconstant(45), _stringconstant(46), _booleanconstant(47), _id(48), 
    _EOF(49);
        
    public int token;
    private String type;
    private String name = Symbol.super.toString();
    
    private Symbol(int token)
    {
        this.token = token;
    }
    
    private Symbol(String type)
    {
        this.token = token;
        this.type = type;
    }
    
    public String toString()
    {
        return name.substring(1);
    }
      
}
