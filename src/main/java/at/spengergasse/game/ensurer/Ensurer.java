package at.spengergasse.game.ensurer;

// Utility Class
public abstract class Ensurer
{
    // Klassen Methode
    // utility method


    // Generic datatype T, it's ANY reference type
    public static <T> T ensureNotNull(T value, String paramName) throws IllegalArgumentException
    {
        if (value == null)
            throw new IllegalArgumentException(String.format("%s was null", paramName));

        return value;
    }


    /**
     * Ensures that value is not null not blank and returns the original value.
     *
     * @param value a string
     * @throws IllegalArgumentException if value is null or blank
     * @return the original passed in value
     */
    public static String ensureNotNullNotBlank(String value, String paramName) throws IllegalArgumentException
    {
        ensureNotNull(value, paramName);

        if (value.isBlank())
            throw new IllegalArgumentException(String.format("%s was blank", paramName));

        return value;
    }
}






//    public static String ensureNotNull(String value, String paramName) throws IllegalArgumentException
//    {
//        if (value == null)
//            throw new IllegalArgumentException(String.format("%s was null", paramName));
//
//        return value;
//    }




//    public static String ensureNotNullNotBlank(String str, String defaultValue)
//    {
//         guard statements
//        if (str == null)
//        {
//            System.out.println("Fehler: String ist null");
//            return defaultValue;
//        }
//
//         guard statements
//        if (str.isBlank())
//        {
//            System.out.println("Fehler: String ist blank");
//            return defaultValue;
//        }
//
//        return str;
//    }
