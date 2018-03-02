package lexicalanalyzer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mannyjuarez
 */
public class Driver {
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        File file = new File("test.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.csv"));
	BufferedReader inputFile = new BufferedReader(new FileReader(file));
        Lexer lex = new Lexer(inputFile);
        DynamicFSA dfsa = new DynamicFSA();
        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
                           'N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
			   'a','b','c','d','e','f','g','h','i','j','k','l','m',
                           'n','o','p','q','r','s','t','u','v','w','x','y','z'};
        System.out.println("SAMPLE CODE: ");
        while(true)
        {
            String s;
            Symbol t = lex.yylex();
            if (t.equals(Symbol._EOF))
                break;
            System.out.print(t + " ");
             if (t.equals(Symbol._id))
            {
                s = lex.type;
                dfsa.check(s);
            } 
        }
        writer.write("");
        for (int i = 0; i < dfsa._switch.length - 2; i++)
        {
            writer.append(alphabet[i] + ",");
        }
        writer.append("\n");
        for (int i = 0; i < dfsa._switch.length - 2; i++)
        {
            writer.write(dfsa._switch[i] + ",");
        }
        writer.append("\n");
        for (int i = 0; i < dfsa.symbol.length; i++)
        {
            writer.append(dfsa.symbol[i] + ",");
        }
        writer.append("\n");
        for (int i = 0; i < dfsa.next.length; i++)
        {
            writer.append(dfsa.next[i] + ",");
        }
        writer.close();
        file = new File("test2.txt");
        writer = new BufferedWriter(new FileWriter("output2.csv"));
        inputFile = new BufferedReader(new FileReader(file));
        lex = new Lexer(inputFile);
        dfsa = new DynamicFSA();
        System.out.println("\n\nTest Program: ");
         while(true)
        {
            String s;
            Symbol t = lex.yylex();
            if (t.equals(Symbol._EOF))
                break;
            System.out.print(t + " ");
             if (t.equals(Symbol._id))
            {
                s = lex.type;
                dfsa.check(s);
            } 
        }
        writer.write("");
        for (int i = 0; i < dfsa._switch.length - 2; i++)
        {
            writer.append(alphabet[i] + ",");
        }
        writer.append("\n");
        for (int i = 0; i < dfsa._switch.length - 2; i++)
        {
            writer.write(dfsa._switch[i] + ",");
        }
        writer.append("\n");
        for (int i = 0; i < dfsa.symbol.length; i++)
        {
            writer.append(dfsa.symbol[i] + ",");
        }
        writer.append("\n");
        for (int i = 0; i < dfsa.next.length; i++)
        {
            writer.append(dfsa.next[i] + ",");
        }
        writer.close();
    }
}
