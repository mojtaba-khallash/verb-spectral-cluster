package ir.ac.iust.nlp.verbspectralcluster;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Mojtaba Khallash
 */
public class ApplyInCoNLL {
    
    public static PrintStream out = System.out;

    public static void Start(String input, String output) throws Exception {
        
        out.println();
        out.println("Started: " + new Date(System.currentTimeMillis()));
        
        int numFeats = 0;
        
        HashMap<Integer, List<String>> map = ReadFile.GetList();
        
        File outFile = new File(output);
        if (outFile.exists())
            outFile.delete();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(input), "UTF8")); 
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(output, true), "UTF-8"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().length() != 0) {
                    String[] split = line.split("\t");
                    int id = Integer.parseInt(split[0]);
                    String lexeme = split[1];
                    String lemma = split[2];
                    String cpos = split[3];
                    String fpos = split[4];
                    String feat = split[5];
                    int head = Integer.parseInt(split[6]);
                    String dependency = split[7];

                    if (cpos.equals("V")) {
                        // get semantic verb class
                        String SVC = getSemantivVerbClass(map, lemma);
                        if (SVC.length() != 0) {
                            numFeats++;
                            if (feat.equals("_")) {
                                feat = SVC;
                            } else {
                                feat += "|" + SVC;
                            }
                        }
                    }

                    StringBuilder os = new StringBuilder();
                    os.append(id).append("\t").append(lexeme).append("\t").append(lemma).append("\t").append(cpos).append("\t").append(fpos).append("\t").append(feat).append("\t").append(head).append("\t").append(dependency).append("\t_\t_");
                    writer.write(os.toString() + "\n");
                } else {
                    writer.write("\n");
                }
            }
        }
        
        out.println("Number of added feats: " + numFeats);
        out.println("Finished: " + new Date(System.currentTimeMillis()));
    }

    private static String getSemantivVerbClass(HashMap<Integer, List<String>> map, String verb) {
        String verbID = "";
        verb = verb.replaceAll("ي", "ی");

        Iterator<Integer> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            int id = iter.next();
            List<String> list = map.get(id);
            boolean find = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(verb)) {
                    verbID = "verbClassID=" + String.valueOf(id);
                    find = true;
                    break;
                }
            }
            if (find == true) {
                break;
            }
        }

        return verbID;
    }
}