package at.spengergasse.ensurer;

// Utility Class
public class Ensurer
{
    // utility method
    public static String ensureNotNullNotBlank(String str, String defaultValue)
    {
        // guard statements
        if (str == null)
        {
            System.out.println("Fehler: String ist null");
            return defaultValue;
        }

        // guard statements
        if (str.isBlank())
        {
            System.out.println("Fehler: String ist blank");
            return defaultValue;
        }

        return str;
    }

//    if (str != null)
//    {
//        if (! str.isBlank())
//        {
//            return str;
//        }
//        else
//        {
//            System.out.println("Fehler: String ist blank");
//            return defaultValue;
//        }
//    }
//        else
//    {
//        System.out.println("Fehler: String ist null");
//        return defaultValue;
//    }
}
