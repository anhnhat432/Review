/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0008DONE;

/**
 *
 * @author FPT
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LetterAndCharacterCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the content
        System.out.print("Enter your content: ");
        String content = scanner.nextLine();

        // Count the number of letters and characters
        int letterCount = 0;
        Map<String, Integer> wordCount = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isLetter(c)) {
                    letterCount++;
                }
            }
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Display the results
        System.out.println(wordCount);
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < content.length(); i++) {
            char c = content.toLowerCase().charAt(i);
            if (Character.isLetter(c)) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }
        System.out.println(charCount);
    }
}

