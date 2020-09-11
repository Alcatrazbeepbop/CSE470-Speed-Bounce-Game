/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcpatternmainfile;
import mvcpatternmainfile.Controller.MainController;

/**
 *
 * @author Mahir
 */
public class MVCPatternMainFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainController obj = new MainController();
        obj.startnewGame(args);
    }
    
}
