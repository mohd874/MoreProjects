/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PathsTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saeed
 */
public class PathsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            new Paths();
        } catch (IOException ex) {
            Logger.getLogger(PathsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

class Paths{

    public Paths() throws IOException {
        URL wordsUrl = getClass().getResource("text.txt");
        
        File wordsFile = new File(wordsUrl.getFile());
        
        System.out.println(wordsFile.getAbsolutePath());
        System.out.println(wordsFile.getAbsolutePath().replace("%20", " "));
        System.out.println(wordsFile.getCanonicalPath());
        System.out.println(wordsFile.getPath());
        
    }
}