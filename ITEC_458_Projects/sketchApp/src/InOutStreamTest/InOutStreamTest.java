package InOutStreamTest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

public class InOutStreamTest {

    public static void main(String[] args) {
        doReadWriteTextFile();
//        readWriteFile();
    }
    
    private static void doReadWriteTextFile() {

        try {
       
            // input/output file names
            String inputFileName  = "C:\\java\\MyProjects\\ITEC_458_Projects\\sketchApp\\src\\InOutStreamTest\\README_InputFile.txt";
            String outputFileName = "C:\\java\\MyProjects\\ITEC_458_Projects\\sketchApp\\src\\InOutStreamTest\\ReadWriteTextFile.out";

            // Create FileReader Object
            FileReader inputFileReader   = new FileReader(inputFileName);
            FileWriter outputFileReader  = new FileWriter(outputFileName);

            // Create Buffered/PrintWriter Objects
            BufferedReader inputStream   = new BufferedReader(inputFileReader);
            PrintWriter    outputStream  = new PrintWriter(outputFileReader);

            // Keep in mind that all of the above statements can be combined
            // into the following:
            //BufferedReader inputStream = new BufferedReader(new FileReader("README_InputFile.txt"));
            //PrintWriter outputStream   = new PrintWriter(new FileWriter("ReadWriteTextFile.out"));

            outputStream.println("+---------- Testing output to a file ----------+");
            outputStream.println();

            String inLine = null;

            while ((inLine = inputStream.readLine()) != null) {
                outputStream.println(inLine);
            }

            outputStream.println();
            outputStream.println("+---------- Testing output to a file ----------+");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {

            System.out.println("IOException:");
            e.printStackTrace();

        }
    }
    
    @Deprecated
    private static void readWriteFile(){
        // Stream to write file
        FileOutputStream fout;

        try {
            // Open an output stream
            fout = new FileOutputStream("myfile.txt");

            // Print a line of text
            PrintStream ps = new PrintStream(fout);
            ps.println("Hello World!");
            ps.println("This is a read/write from/to files!");
            
            // Close our output stream
            fout.close();
        } // Catches any error conditions
        catch (IOException e) {
            System.err.println("Unable to write to file");
            e.printStackTrace();
            System.exit(-1);
        }

        // Stream to read file
        FileInputStream fin;

        try {
            // Open an input stream
            fin = new FileInputStream("myfile.txt");

            // Read a line of text
            System.out.println(new DataInputStream(fin).readLine());
            System.out.println(new DataInputStream(fin).readLine());

            // Close our input stream
            fin.close();
            
        } // Catches any error conditions
        catch (IOException e) {
            System.err.println("Unable to read from file");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
