import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileToList {


    public static List<String> getList () {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter full path to file, please.");
        String filePath = scanner.nextLine();

        List <String> lineList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Fle reading error " + e.getMessage());
        }

        return lineList;

    }

}
