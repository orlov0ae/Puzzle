import java.util.List;

public class PuzzleCheck {

    public String puzzleCheck() {

        List<String> lineList = FileToList.getList();

        String result = "";

        boolean isFirst = true;

        for (int i = 0; i < lineList.size(); i++) {

            if (i == 0) {
               continue;
            } else if (lineList.get(i) == null || lineList.get(i).isEmpty()) {
                continue;
            } else {

            }

        }

    }

}
