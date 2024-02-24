import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReaderPhoneNumber {
    public static void main(String[] args) {

        readAndPrintValidPhoneNumbers("file.txt");
    }

    public static void readAndPrintValidPhoneNumbers(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            Pattern pattern = Pattern.compile("\\(?(\\d{3})\\)?[-.\\s]?(\\d{3})[-.\\s]?(\\d{4})");

            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String phoneNumber = matcher.group();
                    if (isValidPhoneNumber(phoneNumber)) {
                        System.out.println(phoneNumber);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Регулярний вираз для перевірки валідності номера телефону
        Pattern pattern = Pattern.compile("^\\(?(\\d{3})\\)?[-.\\s]?(\\d{3})[-.\\s]?(\\d{4})$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
