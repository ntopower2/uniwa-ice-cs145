import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class exec23 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        System.out.println("Give input file path: \n");
        String infilepath = s.next();
        File file = new File(infilepath);
        Scanner fp = new Scanner(file);
        int[] occurrences = new int[11];
        char[] target = {'Α', 'α', 'Γ', 'γ', 'Ω', 'ω', '1', '3', '5', '7', '9'};

        System.out.format("Contents of %s :\n", infilepath);
        while (fp.hasNextLine()) {
            char[] line = fp.nextLine().toCharArray();
            System.out.println(line);
            for (char c:line) for (int i=0;i<target.length;i++) if (target[i]==c) occurrences[i]++;
        }
        System.out.println("Stats :");
        for (int i=0;i<target.length;i++) System.out.println(target[i]+"->"+occurrences[i]);
    }
}
