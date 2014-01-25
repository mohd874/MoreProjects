/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadWritePropertyFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 *
 * @author Saeed
 */
public class ReadWritePropertyFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        readWriteProperyFile();
    }

    private static void readWriteProperyFile() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("test.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(properties.getProperty("a"));
        System.out.println(properties.getProperty("b"));
        System.out.println(properties.getProperty("c"));
        System.out.println(properties.getProperty("d.e.f"));
        
        while(properties.elements().hasMoreElements()){
            System.out.println(properties.elements().nextElement().toString());
        }
        // Write properties file.
        try {
            properties.store(new FileOutputStream("test.properties"), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
