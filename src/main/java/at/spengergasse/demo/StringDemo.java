package at.spengergasse.demo;

import java.util.Locale;

public class StringDemo
{
    public static void main(String[] args)
    {
        /**
         * String are a immutable sequence of characters
         * StringBuilder is a mutable sequence of characters
         *
         * 1) Vergleich bei Referenztypen:
         *   a == b VERGLEICHT OB HAUPTSPEICHER ADRESSEN IDENT SIND
         *   a.equals.(b) VERGLEICHT OB INHALTE IDENT SIND
         *
         * 2) Unveränderbar:
         *   Strings sind IMMUTABLE (unveränderbar)
         *   Die String Methoden liefern IMMER eine neue Instanz zurück.
         *
         *   Why are Strings immutable?
         *   https://www.baeldung.com/java-string-immutable
         */



        // --- String Equality Demo ---

        // Literal Pool
        String s1 = "Rene";
        String s2 = "Rene";
        String s3 = "Ren" + "e" + "r" + "j";

        // Literal Pool
        String s4 = "Ren";

        // += New Instance on Heap
        s4 = s4 + "e";

        // Heap
        String s5 = new String("Rene");
        String s6 = new String("Rene");

//        System.out.println(s1 == s2); // true
//        System.out.println(s1 == s3); // true
//        System.out.println(s1 == s4); // false
//        System.out.println(s1 == s5); // false
//        System.out.println(s5 == s6); // false

//        System.out.println(s1.equals(s4)); // true
//        System.out.println(s1.equals(s5)); // true




        // --- String Methods Demo ---


//        System.out.println( "Rene".charAt(0) );
//        System.out.println( "Rene".contains("Ren") );
//        System.out.println( "A".compareTo("B") );
//        System.out.println( "\r\n\t".isBlank() );
//        System.out.println( " Rene ".strip() );
//        System.out.println( "Rene".repeat(3) );
//        System.out.println( "Rene".length() );
//        System.out.println( "Rene".toUpperCase() );
//        System.out.println( "Rene".toLowerCase() );
//        System.out.println( "Rene".indexOf("e") );
//        System.out.println( "Rene".lastIndexOf("e") );
//        System.out.println( "Rene".substring(1, 3) );
//          String formatted = String.format("|%8s| |%8d| |%10.2f|", "Rene", 10, 3.14);
//        System.out.printf("|%-8s| |%-8d| |%6.4f|", "Rene", 10, 3.1415923565);

        // primitive Type -> String
//        String stringX = String.valueOf('x');
        String stringInt = String.valueOf(42);

        // String -> int,  long
        int zahl42 = Integer.parseInt("42");

        // String -> Integer
        Integer zahl42Boxed = Integer.valueOf("42");
        int zahl42Primitive = zahl42Boxed.intValue();



        // --- String Concatenation Demo ---


//        long start = System.nanoTime();
//        String str = "Rene";
//        for (int i = 0; i < 100_000; i++)
//        {
//            str = str + "x";
//        }
//
//        long end = System.nanoTime();
//        System.out.println("concat time: " + (end-start));




        // --- String Builder Demo ---

        // Initial Capacity of 16 characters
        // StringBuilder sb = new StringBuilder();


//        long start = System.nanoTime();
//        StringBuilder sb = new StringBuilder();
//        sb.append("Rene");
//
//        for (int i = 0; i < 100_000; i++)
//        {
//            sb.append(i);
//        }
//
//        long end = System.nanoTime();
//        System.out.println("concat time: " + (end-start));




        // --- String.format ---

        // JEDES % braucht einen Parameter

        // %s ... String
        // %d ... int, long
        // %f ... double, float

        // Beispiel:
        // %5.2f ... double/float 5 Stellen Rechtsbündig mit 2 Nachkommenstellen

        // LINKS BÜNDIG mit Minus
        // Ausgabe: |x    | |10      | |3,14      |
//        System.out.println(String.format("|%-5s| |%-8d| |%-10.2f|", "x", 10, 3.14));

        // RECHTS BÜNDIG ohne Minus
        // |    x| |      10| |      3,14|
//        System.out.println(String.format("|%5s| |%8d| |%10.2f|", "x", 10, 3.14));
    }
}
