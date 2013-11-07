import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;

public class CodedTriangleNumbers
{
    private String listOfWords = "";
    private String[] wordArray;
    private int triangleWordCount = 0;

    public CodedTriangleNumbers() {
    }

    public void loadTextFile(String fileName) {
        Charset charset = Charset.forName("US-ASCII");
        Path file = Paths.get(fileName);

        try(BufferedReader reader = Files.newBufferedReader(file,charset)) {
            String line = null;
            while((line = reader.readLine()) != null) {
                listOfWords += line;
            }
        }
        catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        wordArray = listOfWords.split(",");
    }

    public void findTriangleWords() {
        for(String i : wordArray) {
            if(checkIfTriangleWord(calculateWordSum(i))) {
                triangleWordCount++;
            }
        }
    }

    public int getWordTotal() {
        return triangleWordCount;
    }

    private int calculateWordSum(String word) {
        char[] charNameArray = new char[word.length() - 2];
        int nameTotal = 0;

        word.getChars(1, (word.length() - 1), charNameArray, 0);

        for(int i : charNameArray) {
            nameTotal += (i - 64);
        }
        return nameTotal;
    }

    private boolean checkIfTriangleWord(int total) {
        int triangleNum = 0;
        int counter = 1;

        while(total > triangleNum) {
            triangleNum += counter;
            counter++;

            if(triangleNum == total) {
                return true;
            }
        }
        return false;
    }
}
