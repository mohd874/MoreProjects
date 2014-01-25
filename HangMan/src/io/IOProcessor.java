/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Saeed
 */
public class IOProcessor {

    String wordsFileName = "words.txt";
    String topTenFileName = "topTen.txt";
    
    ArrayList<String> secretWords;
    ArrayList<String> bossWords;
    String[][] topTen;
    
    public IOProcessor() throws FileNotFoundException, IOException {
        URL wordsUrl = getClass().getResource(wordsFileName);
        URL topTenUrl = getClass().getResource(topTenFileName);

        File wordsFile = new File(wordsUrl.getFile());
        File topTenFile = new File(topTenUrl.getFile());

        String wordsFilePath = wordsFile.getAbsolutePath().replace("%20", " ");
        String topTenFilePath = topTenFile.getAbsolutePath().replace("%20", " ");

        FileReader wordsReader = new FileReader(wordsFileName);
        FileReader topTenReader = new FileReader(topTenFileName);

        BufferedReader wordsStream   = new BufferedReader(wordsReader);
        BufferedReader topTenStream   = new BufferedReader(topTenReader);
        
        String inLine = null;
        
        secretWords = new ArrayList<String>();
        bossWords = new ArrayList<String>();
        topTen = new String[10][2];
        
        StringTokenizer st = null;
        
//        int WORD = 0;
//        int WORD_LVL = 1;
//        int IS_BOSS = 2;
        
        String currentWordString = null;
        String currentWordLvlString = null;
        String isBossString = null;
        
        while ((inLine = wordsStream.readLine()) != null) {
            st = new StringTokenizer(inLine,":");
            
            currentWordString = st.nextToken();
            currentWordLvlString = st.nextToken();
            isBossString = st.nextToken();
            
            if(Integer.parseInt(isBossString) == 0){
                secretWords.add(currentWordString);
            }else{
                bossWords.add(currentWordString);
            }
        }
        
        int count = 0;
        while ((inLine = topTenStream.readLine()) != null) {
            st = new StringTokenizer(inLine,":");
            String name = st.nextToken();
            String score = st.nextToken();
//            int rank = Integer.parseInt(st.nextToken());
            topTen[count][0] = name;
            topTen[count][1] = score;
        }
        
        wordsStream.close();
        topTenStream.close();
    }

    public String[][] getTopTenScores() {
        return topTen;
    }

    public String getTheBoss(int bossLvl)  {
        return bossWords.get((bossLvl-1));
    }

    public ArrayList<String> getAllSecretWords()  {
        return secretWords;
    }

    public boolean isNewHighScore(int newScore)  {
        for (int i = 0; i < topTen.length; i++) {
            String[] scores = topTen[i];
            if(Integer.parseInt(scores[1]) < newScore){
                return true;
            }
        }
        return true;
    }

    public void addNewHighScore(String playerName, int newScore) throws IOException {
        URL topTenUrl = getClass().getResource(topTenFileName);

        File topTenFile = new File(topTenUrl.getFile());

        String topTenFilePath = topTenFile.getAbsolutePath().replace("%20", " ");

        FileWriter topTenReader = new FileWriter(topTenFilePath);

        PrintWriter outputStream = new PrintWriter(topTenReader);
        
        int count = 0;
        int rank = 1;
        while(count < 11){
            for (int i = 0; i < topTen.length; i++) {
                String[] scores = topTen[i];
                if(Integer.parseInt(scores[1]) >= newScore){
                    outputStream.print(topTen[0]+":"+topTen[1]);
                }else{
                    outputStream.print(playerName+":"+newScore);
                }
            }
        }
        
        outputStream.close();
    }
}
