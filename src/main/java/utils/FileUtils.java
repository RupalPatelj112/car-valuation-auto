package utils;

import java.util.*;
import java.util.regex.*;
import java.io.*;

public class FileUtils {
    public static List<String> extractCarRegistrations(String filePath) throws IOException {
        List<String> registrations = new ArrayList<>();
        Pattern pattern = Pattern.compile("[A-Z]{2}[0-9]{2} ?[A-Z]{3}");

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher(line.toUpperCase());
            while (matcher.find()) {
                registrations.add(matcher.group().replaceAll("\\s+", ""));
            }
        }
        reader.close();
        return registrations;
    }
}
