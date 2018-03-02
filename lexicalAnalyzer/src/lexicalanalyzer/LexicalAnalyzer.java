/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalyzer;

import java.io.File;

/**
 *
 * @author mannyjuarez
 */
public class LexicalAnalyzer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String path = "Lexer.flex";
       File file = new File(path);
        jflex.Main.generate(file);
    }
    
}
