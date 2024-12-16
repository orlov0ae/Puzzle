import java.util.List;
import java.util.Scanner;

public class PuzzleCheck {

    public static void main(String[] args) {
        System.out.println(puzzleCheck());

    }

    public static StringBuilder puzzleCheck() {

        List<String> lineList = FileToList.getList();

        StringBuilder result = new StringBuilder();
        String firstResult = "";

        for (int i = 0; i < lineList.size(); i++) {
            if (!result.isEmpty()) {
                break;
            } else if (lineList.get(i) != null) {
                String currentLine = lineList.get(i);
                for (int j = 0; j < lineList.size(); j++) {
                    if (i != j) {
                        String otherLine = lineList.get(j);
                        if (currentLine.substring(0, 2).equals(otherLine.substring(otherLine.length() - 2))){
                            result.append(currentLine);
                            firstResult = currentLine;
                        }else if (currentLine.substring(currentLine.length() - 2).equals(otherLine.substring(0,2))) {
                            result.append(currentLine);
                            firstResult = currentLine;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < lineList.size(); i++) {

            String current = lineList.get(i);

            if (lineList.get(i) != null || !lineList.get(i).isEmpty() || !current.equals(firstResult)) {
                if (current.substring(0, 2).equals(result.substring(result.length() - 2))) {
                    result.append(current.substring(2));
                } else if (current.substring(current.length() - 2).equals(result.substring(0, 2))) {
                    result.insert(0, current.substring(0, current.length() - 2));
                }
            }

        }

        return result;

    }

}
