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
import java_cup.runtime.*;

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

        parser parse = new parser();
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.csv"));
        File file = new File("test.txt");
	BufferedReader inputFile = new BufferedReader(new FileReader(file));
        
    }
}