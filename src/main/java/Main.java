import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("path");
        FileWriter writer = new FileWriter("vivod.txt");
        List<String> list = Files.readAllLines(path);
        Pattern cellPhoneRegex = Pattern.compile("^(\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{2}[\\s.-]?\\d{2}$");
        for(String str : list) {
            Matcher robustMatcher = cellPhoneRegex.matcher(str);
            if(robustMatcher.matches()){
                System.out.println(str);
                writer.write(str + "\n");
                writer.flush();
            }
        }
    }
}
