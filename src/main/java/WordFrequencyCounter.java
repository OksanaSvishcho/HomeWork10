import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Map<String, Integer> wordFrequencyMap = calculateWordFrequency("word");
        printWordFrequency(wordFrequencyMap);
    }

    public static Map<String, Integer> calculateWordFrequency(String fileName) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordFrequencyMap;
    }

    public static void printWordFrequency(Map<String, Integer> wordFrequencyMap) {

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordFrequencyMap.entrySet());

        Collections.sort(entries, (a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
