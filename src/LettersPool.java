import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LettersPool {
    private ArrayList<String> letters;

    public LettersPool() {
        letters = new ArrayList<>();
        initializeLetters();

    }

    private void initializeLetters() {
        for (int i = 0; i < 5; i++) {
            letters.add("R");
            letters.add("T");
        }
        for (int i = 0; i < 6; i++) {
            letters.add("A");
        }
    }

    public String getRandomLetter() {
        Random random = new Random();
        return letters.remove(random.nextInt(letters.size()));
    }

    public String[] getShuffledLetters() {
        Collections.shuffle(letters);

        String[] shuffledLetters = new String[letters.size()];

        for (int i = 0; i < letters.size(); i++) {
            shuffledLetters[i] = letters.get(i);
        }

        return shuffledLetters;

    }
    
    public String getLetter(String letter) {
        if (letters.remove((String) letter)) { // Remove the specified letter
            return letter; // Return the removed letter
        } else {
            throw new IllegalArgumentException("Letter '" + letter + "' not found in the pool.");
        }
    }

    public void displayLetterPool() {
        StringBuilder sb = new StringBuilder("Letter Pool: ");
        int totalLetters = letters.size();
        
        int countR = 0, countA = 0, countT = 0;
        for (String letter: letters) {
            if (letter == "R") countR++;
            else if (letter == "A") countA++;
            else if (letter == "T") countT++;
        }
        if (totalLetters > 0) {
            sb.append("R-").append(String.format("%.2f%%", (countR * 100.0 / totalLetters))).append(" ");
            sb.append("A-").append(String.format("%.2f%%", (countA * 100.0 / totalLetters))).append(" ");;
            sb.append("T-").append(String.format("%.2f%%", (countT * 100.0 / totalLetters))).append(" ");;
        } else {
            sb.append("The letter pool is empty.\n");
        }
        System.out.println(sb.toString().trim());
    }






}
