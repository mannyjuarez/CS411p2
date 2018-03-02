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
public class DynamicFSA {

    public int[] _switch;
    public char[] symbol;
    public int[] next;
    // position of the next open spot in the symbol array.
    public int available; 

    public DynamicFSA() {
        _switch = new int[54];
        for (int i = 0; i < _switch.length; i++) {
            _switch[i] = -1;
        }
        symbol = new char[100];
        next = new int[100];
        for (int i = 0; i < next.length; i++) {
            next[i] = -1;
        }
        available = 0;
    }

    //returns the corresponding index of each character in the _switch array.
    private int convert(char c) {
        if (c >= 65 && c <= 90) {
            return c - 65;
        } else if (c >= 97 && c <= 122) {
            return c - 71;
        } else if (c == 95) {
            return 52;
        } else if (c == 36) {
            return 53;
        }
        return -1;
    }
    
    // This method add the words in to the FSA
    private boolean add(char[] word, int ili, int si, int ns) {

        if (_switch[ili] < 0) {
            _switch[ili] = available;
            for (int i = 1; i < word.length; i++) {
                symbol[available++] = word[i];
            }
        } else {
            next[si] = available;
            for (int i = ns; i < word.length; i++) {
                symbol[available++] = word[i];
            }
        }
        return true;
    }

    
     /* if the word is a new identifier return it followed by a '@'.
     */
    public String check(String str) {
        char[] w = str.toCharArray();
        char[] word = new char[w.length + 1];
        String temp;
        for (int i = 0; i < w.length; i++) {
            word[i] = w[i];
        }
        word[w.length] = '@';
        int nextSymbol = 0;
        int firstLetterIndex = convert(word[nextSymbol++]);

        if (firstLetterIndex < 0) {
            return null;
        }

        int symbolIndex = _switch[firstLetterIndex];
        if (symbolIndex < 0) {
            temp = str + "? ";
            add(word, firstLetterIndex, symbolIndex, nextSymbol);
            return temp;
        } else {
            boolean exit = false;
            while (!exit) {
                if (symbol[symbolIndex] == word[nextSymbol] || 
                        (symbol[symbolIndex] == '*' 
                            && word[nextSymbol] == '@')) {
                    if (word[nextSymbol] != '@') {
                        symbolIndex++;
                        nextSymbol++;
                    } else {
                        temp = str + symbol[symbolIndex] + " ";
                        return temp;
                    }
                } else if (next[symbolIndex] >= 0) {
                    symbolIndex = next[symbolIndex];
                } else {
                    temp = str + "? ";
                    add(word, firstLetterIndex, symbolIndex, nextSymbol);
                    return temp;
                }
            }
        }
        return null;
    }

    //return the  element in switch array with index i
    public int getSwitch(int i) {
        return _switch[i];
    }

    //return the element in symbol array with index i
    public char getSymbol(int i) {
        return symbol[i];
    }

    //return the element in next array with index i
    public int getNext(int i) {
        return next[i];
    }
}
