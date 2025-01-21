import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LettersPool {
    private ArrayList<Character> letters;

    public LettersPool() {
        letters = new ArrayList<>();
        initializeLetters();

    }

    private void initializeLetters() {
        for (int i = 0; i < 5; i++) {
            letters.add('R');
            letters.add('T');
        }
        for (int i = 0; i < 6; i++) {
            letters.add('A');
        }
    }

    public char getRandomLetter() {
        Random random = new Random();
        return letters.remove(random.nextInt(letters.size()));
    }

    public char[] getShuffledLetters() {
        Collections.shuffle(letters);

        char[] shuffledLetters = new char[letters.size()];

        for (int i = 0; i < letters.size(); i++) {
            shuffledLetters[i] = letters.get(i);
        }

        return shuffledLetters;

    }
    







}
