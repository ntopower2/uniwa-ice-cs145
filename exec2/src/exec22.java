import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class exec22 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Give input file path: \n");
        String infilepath = s.next();
        System.out.println("Give out file path: \n");
        String outfilepath = s.next();

        try {
            File infile = new File(infilepath);
            Scanner fp = new Scanner(infile);
            FileWriter fileWriter = new FileWriter(outfilepath);
            while (fp.hasNext()) {
                fileWriter.write(fp.next()+"\n");
            }
            fileWriter.close();
            System.out.println("Copy successful!");
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found!");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Could not write out file!");
            System.exit(1);
        }
    }
}
