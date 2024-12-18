package com.portaone.oleksandr_orlov;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PuzzleCheck {

    public static void main(String[] args) {
        System.out.println(puzzleCheck());

    }

    public static StringBuilder puzzleCheck() {

        List<String> lineList = FileToList.getList();

        StringBuilder result = new StringBuilder();

        Set<String> usedLines = new HashSet<>();

        for (int i = 0; i < lineList.size(); i++) {
            if (!result.isEmpty()) {
                break;
            } else if (lineList.get(i) != null || !lineList.get(i).isEmpty()) {
                String currentLine = lineList.get(i);
                for (int j = 0; j < lineList.size(); j++) {
                    if (i != j) {
                        String otherLine = lineList.get(j);
                        if (currentLine.substring(0, 2).equals(otherLine.substring(otherLine.length() - 2))){
                            result.append(currentLine);
                            usedLines.add(currentLine);
                            break;
                        }else if (currentLine.substring(currentLine.length() - 2).equals(otherLine.substring(0,2))) {
                            result.append(currentLine);
                            usedLines.add(currentLine);
                            break;
                        }
                    }
                }
            }
        }

        boolean added;

        do {
            added = false;

            for (String line : lineList) {
                if (line == null || line.isEmpty() || usedLines.contains(line)) {
                    continue;
                }
                if (line.substring(0, 2).equals(result.substring(result.length() - 2))) {
                    result.append(line.substring(2));
                    usedLines.add(line);
                    added = true;
                    break;
                } else if (line.substring(line.length() - 2).equals(result.substring(0, 2))) {
                    result.insert(0, line.substring(0, line.length() - 2));
                    usedLines.add(line);
                    added = true;
                    break;
                }
            }
        } while (added);

        return result;

    }

}
