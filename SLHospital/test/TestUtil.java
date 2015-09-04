
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anawatj
 */
public class TestUtil {
    
    
    @Test
    public void testConvertDate() throws ParseException
    {
        String date = "2015-08-30T17:00:00.000Z";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",Locale.ENGLISH);
        Date ret = format.parse(date);
        System.out.println(ret);
    }
}
