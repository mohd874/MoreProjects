/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadWritePropertyFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *
 * @author Saeed
 */
public class ReadProperty {

    String str, key;

    public static void main(String[] args) {
        ReadProperty r = new ReadProperty();
    }

    public ReadProperty() {
        try {
            int check = 0;
            while (check == 0) {
                check = 1;
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter file name which has properties extension :");
                str = bf.readLine();
                File f = new File(str + ".properties");
                if (f.exists()) {
                    Properties pro = new Properties();
                    FileInputStream in = new FileInputStream(f);
                    pro.load(in);
                    System.out.println("All key are given: " + pro.keySet());
                    System.out.print("Enter Key : ");
                    key = bf.readLine();
                    String p = pro.getProperty(key);
                    System.out.println(key + " : " + p);
                } else {
                    check = 0;
                    System.out.println("File not found!");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
