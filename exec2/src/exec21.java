import javafx.util.Pair;
import java.util.HashMap;
import java.util.Scanner;

public class exec21 {
    private static Pair<String, Float> getMean(String line) {
        Scanner s = new Scanner(line);
        float mo = 0; int i=0;
        String am = s.next(), temp = s.next();
        while (!temp.equals("end")) {
            i++;
            mo += Float.parseFloat(s.next());
            temp = s.next();
        }
        mo = (i==0)?0:mo/i;
        return new Pair<>(am, mo);
    }

    public static void main(String[] args) {
//        String test = "061125 Programming1 6.1 DB1 7.0 Math1 5.5 end\n" +
//                "071234 DB2 5.5 Programming1 4.0 PSD 4.5 Java 7.3 end\n" +
//                "051058 Math2 7.5 PSD 6.3 end\n081092 end\n" +
//                "071234 DB2 5.5 Math1 5.5 Java 5.0 end\n000000\n";
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        HashMap<String, Float> mo = new HashMap<>(10);
        Pair<String, Float> temp;
        while (!line.startsWith("000000")) {
            temp = getMean(line);
            if (mo.containsKey(temp.getKey()))
                mo.put(temp.getKey(), (mo.get(temp.getKey())+temp.getValue())/2);
            else mo.put(temp.getKey(), temp.getValue());
            line = s.nextLine();
        }
        System.out.println("Average of "+mo.size()+" students:");
        for (String i:mo.keySet()) {
            System.out.println("AM: "+i+" -> "+mo.get(i).toString());
        }
    }
}

