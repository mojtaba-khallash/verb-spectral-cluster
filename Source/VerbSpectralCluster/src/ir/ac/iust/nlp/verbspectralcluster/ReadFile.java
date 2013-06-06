package ir.ac.iust.nlp.verbspectralcluster;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mojtaba Khallash
 */
public class ReadFile {

    private static String name = "SpectralClusteringResults.txt";

    public static HashMap<Integer, List<String>> GetList() {
        try {
            InputStream is = ReadFile.class.getClassLoader().getResourceAsStream(name);
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "UTF8"));
        
            HashMap<Integer, List<String>> map = new HashMap<>();
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\t");
                int id = Integer.parseInt(split[0]);
                List<String> list = map.get(id);
                if (list == null) {
                    list = new LinkedList<>();
                }
                list.add(split[2]);
                map.put(id, list);
            }
            
            return map;
        } catch (FileNotFoundException ex) {
            System.out.println("Cannot Find Cotpus File:");
            System.out.println("  - " + name);
            System.exit(1);
        } catch (Exception ex) {
            System.exit(1);
        }
        
        return null;
    }
}