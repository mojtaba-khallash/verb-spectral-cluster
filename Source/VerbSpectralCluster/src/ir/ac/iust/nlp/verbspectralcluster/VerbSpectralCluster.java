package ir.ac.iust.nlp.verbspectralcluster;

/*
* Copyright (C) 2013 Iran University of Science and Technology
*
* This file is part of "Verb Spectral Cluster" Project, as available 
* from http://nlp.iust.ac.ir This file is free software;
* you can redistribute it and/or modify it under the terms of the GNU General 
* Public License (GPL) as published by the Free Software Foundation, in 
* version 2 as it comes in the "COPYING" file of the VirtualBox OSE 
* distribution. VirtualBox OSE is distributed in the hope that it will be 
* useful, but WITHOUT ANY WARRANTY of any kind.
*
* You may elect to license modified versions of this file under the terms 
* and conditions of either the GPL.
*/

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Mojtaba Khallash
 */
public class VerbSpectralCluster {

    // -v 0 -i <input-file> -o <output-file>
    public static void main(String[] args) {        
        boolean visisble = true;
        String input = "";
        String output = "";
        
        showIntroduction();

        boolean exception = false;
        try {
            for (int i = 0; i< args.length; i++) {
                switch (args[i]) {
                    case "-v":
                        i++;
                        String val = args[i];
                        if (!(val.equals("0") || val.equals("1"))) {
                            throw new Exception();
                        }
                        visisble = val.equals("1");
                        break;
                    case "-i":
                        i++;
                        input = args[i];
                        break;
                    case "-o":
                        i++;
                        output = args[i];
                        break;
                }
            }
            
            if (visisble == false && 
                (input.length() == 0 ||
                 output.length() == 0)) {
                throw new Exception();
            }
        } catch (Exception e) {
            exception = true;
            visisble = false;
        }
        finally {
            if (visisble == false) {
                if (exception == true) {
                    showHelp();
                    System.exit(1);
                }
                else {
                    try {
                        ApplyInCoNLL.Start(input, output);
                        System.exit(0);
                    } catch(Exception ex) {
                        System.exit(1);
                    }
                }
            }
            else {
                showHelp();
            }
        }
        
        SpectralCluster application = new SpectralCluster();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(application);
            application.pack();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        application.setVisible(visisble);
    }
    
    private static void showIntroduction() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("                          VerbSpectralCluster 1.0");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("                            Mojtaba Khallash");
        System.out.println();
        System.out.println("             Iran University of Science and Technology (IUST)");
        System.out.println("                                 Iran");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println();        
    }
    
    private static void showHelp() {
        System.out.println("Required Arguments:");
        System.out.println("        -v <visibility (0|1)>");
        System.out.println("        -i <input file>");
        System.out.println("        -o <output file>");        
    }
}