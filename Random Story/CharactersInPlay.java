
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList <String> name;
    private ArrayList <Integer> count;
    
    public CharactersInPlay (){
        name = new ArrayList <String> ();
        count = new ArrayList <Integer> ();
    }
    
    public void update (String person) {
            int index = name.indexOf (person);
            
            if (index == -1) {
                name.add (person);
                count.add (1);
            }
            
            else {
                int value = count.get(index);
                count.set(index, value+1);
            }
    }
    
    public void findAllCharacters() {
        FileResource fr = new FileResource();
        name.clear();
        count.clear();
        
        for (String line : fr.lines()) {
            int ind = line.indexOf(".");
            if (ind != -1) {
                update (line.substring(0, ind));
            }
        }
    }

    public int findIndexOfMax () {
        int max = count.get(0);
        int index = 0;
        for (int k = 1; k < count.size(); k++) {
            if (max < count.get(k)){
                max = count.get(k);
                index = k;
            }
        }
        return index;
    }
    
    public void  tester() {
        findAllCharacters();
        int charCount = 0;
        for (int k = 0; k < name.size(); k++) {
            if (count.get(k) > 1) {
                System.out.println (count.get(k) + "\t" + name.get(k));
                charCount ++;
            }
        }
        System.out.println ("Number of Characters is " + charCount);
        System.out.println ("The character with maximum speaking parts is : " + name.get(findIndexOfMax()));
    }
}
