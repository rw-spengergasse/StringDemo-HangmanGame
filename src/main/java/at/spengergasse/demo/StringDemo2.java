package at.spengergasse.demo;

public class StringDemo2
{
    public static void main(String[] args)
    {
        filenameExtension("starwars.mp4");
        countCharacters("Die Spengercool ist wirklich cool", "cool");
    }

    /**
     * Zerlege den path in filename und extension und verwandle den filename in uppercase.
     *
     * Beispiel:
     * path = starwars.mp4
     * filename = STARWARS
     * extension = mp4
     */
    public static void filenameExtension(String path)
    {
        // int indexOfDot = path.indexOf(".");
        int indexOfDot = path.lastIndexOf(".");
        if (indexOfDot >= 1 && indexOfDot < path.length()-1)
        {
            String filename = path.substring(0, indexOfDot);
            String extension = path.substring(indexOfDot + 1, path.length());
            String filenameUpper = filename.toUpperCase();
            System.out.printf("filename: %s\nextension: %s%n", filenameUpper, extension);
        }
        else
            System.out.println("Parameter `path` muss im Format `filename.ext` sein.");
    }


    /**
     * Zähle Vorkommnisse der Zeichenkette `findMe` in `text`.
     *
     * Beispiel:
     * text = "Die Spengercool ist wirklich cool. Auch die Schüler sind cool";
     * findMe = "cool"
     * count = 3;
     */
    public static void countCharacters(String text, String findMe)
    {
        int count = 0;
        int foundAt = 0;

        while ((foundAt = text.indexOf(findMe, foundAt)) >= 0)
        {
            System.out.println("found at " + foundAt);
            foundAt += findMe.length();
            count++;
        }

        System.out.println("counted: " + count);
    }
}
