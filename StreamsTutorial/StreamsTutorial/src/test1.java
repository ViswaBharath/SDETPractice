import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class test1 {

// Count the number of names starting with alphabet A in list

    public static void regular() {

        int count=0;

        ArrayList<String> names = new ArrayList<String>();
        names.add("Akhil");
        names.add("Ram");
        names.add("Adam");
        names.add("Achuth");

        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);

            if (actual.startsWith("A")){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void streamFilter() {

        ArrayList<String> names = new ArrayList<String>();
        names.add("Akhil");
        names.add("Ram");
        names.add("Adam");
        names.add("Achuth");

        long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println("Count of names starts with A are : " + c);

        //using stream collection list
        long d = Stream.of("Akhil", "Mohan", "Ram", "Anil").filter(s -> s.startsWith("A")).count();
        System.out.println(d);

    }

    public static void streamFilterPrintAllTheNames() {

        ArrayList<String> names = new ArrayList<String>();
        names.add("Akhil");
        names.add("Ram");
        names.add("Adam");
        names.add("Achuth");

        long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println("Count of names starts with A are : " + c);

        //using stream collection list
        long d = Stream.of("Akhil", "Mohan", "Ram", "Anil").filter(s ->
        {
            s.startsWith("A");
            return true;
        }).count();
        System.out.println(d);

        // Print all the names of Arraylist
        names.stream().filter(s->s.length()>4).forEach(s -> System.out.println(s));

        //To Print single name
        names.stream().filter(s -> s.length()>4).limit(1).forEach(s -> System.out.println(s));

    }

    public static void streamMap(){

        // print names which have last letter as "a" with uppercase
      Stream.of("Akhil", "Ram", "Ayush", "Anil").filter(s -> s.endsWith("l")).map(s -> s.toUpperCase(Locale.ROOT))
              .forEach(s -> System.out.println(s));

      // Sorting
        List<String> names = Arrays.asList("Abc", "Ram", "Ade", "Azf");
        names.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
      
    }
    
    public static void main(String[] args) {
        //test1.regular();
        //test1.streamFilter();
        //test1.streamFilterPrintAllTheNames();
        test1.streamMap();

    }

}

