
package utilitaires;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilDate {
    
    static Locale frLoc= new Locale("fr","FR");

    static DateFormat df = DateFormat
                           .getDateInstance(DateFormat.SHORT,frLoc);
   
    public static String format(Date date)
    {
        return df.format(date);
    }
    
    public static Date parse(String chaine){
        try {

            return df.parse(chaine);
        
        }catch (ParseException ex) {
            
            Logger.getLogger("global").log(Level.SEVERE, null, ex);
            return null;
        
        }
    
    }
    
}
