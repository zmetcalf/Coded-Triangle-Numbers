public class CodedTriangleNumbersTest
{
    public static void main(String[] args) {
        CodedTriangleNumbers ctn = new CodedTriangleNumbers();
        ctn.loadTextFile("words.txt");
        ctn.findTriangleWords();
        System.out.printf("There are %d triangle words.\n", ctn.getWordTotal());
    }
}
