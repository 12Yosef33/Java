
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import edu.duke.*;
public class WordFrequencies {
    private ArrayList <String> myWords;
    private ArrayList <Integer> myFreqs;
    
    public WordFrequencies () {
        myWords = new ArrayList <String> ();
        myFreqs = new ArrayList <Integer> ();
    }
    
    public void findUnique () {
        myWords.clear();
        myFreqs.clear();
        
        FileResource fr = new FileResource();
        for (String word : fr.words()) {
            word = word.toLowerCase();
            int index = myWords.indexOf (word);
            
            if (index == -1) {
                myWords.add (word);
                myFreqs.add (1);
            }
            
            else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);
            }
        }
    }
    
    
    public int findIndexOfMax () {
        int max = myFreqs.get(0);
        int index = 0;
        for (int k = 1; k < myFreqs.size(); k++) {
            if (max < myFreqs.get(k)){
                max = myFreqs.get(k);
                index = k;
            }
        }
        return index;
    }
            
    public void tester () {
        findUnique();
        System.out.println ("# unique words: " + myWords.size());
        for (int k = 0; k < myWords.size(); k++) {
            System.out.println (myFreqs.get(k) + "\t" + myWords.get(k));
        }
        System.out.println ("The word that occurs most often and its count are: " + myWords.get(findIndexOfMax()) + " " + (findIndexOfMax()+1));
    }
}
