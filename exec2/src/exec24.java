import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class exec24 {
    private static void writeFibNums(Integer... foo) throws IOException {
        FileWriter fileWriter = new FileWriter("fibNums.txt");
        long prev = 0, curr = 1, next;
        int bound = (foo.length==0)?50:foo[0];
        for (int i=0;i<bound;i++) {
            next = prev+curr;
            fileWriter.write("F("+(i)+")="+prev+"\n");
            prev = curr; curr = next;
        }
        fileWriter.close();
        System.out.println("Successfully written "+bound+" numbers.");
    }

    private static void dispFibNums() throws IOException {
        File file = new File("fibNums.txt");
        Scanner s = new Scanner(file);
        while (s.hasNext()) {
            System.out.println(s.next().split("=")[1]);
        }
    }

    public static void main(String[] args) {
        try {
            writeFibNums();
            dispFibNums();
        } catch (IOException e) {
            System.out.println("Error in writing!");
        }
    }
}
