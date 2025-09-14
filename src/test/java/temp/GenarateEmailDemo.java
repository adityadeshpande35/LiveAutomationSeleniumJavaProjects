package temp;

import java.util.Date;

public class GenarateEmailDemo {

    public  static void main(String[] args)
    {
        Date date= new Date();
        String dateString=date.toString();
        String noSpaceDateString=dateString.replace(" ","");
        String noSpaceAndnoColumnDateString=noSpaceDateString.replace("\\:","");
        String emailWithTimeStamp=noSpaceAndnoColumnDateString+"@gmail.com";
        System.out.println(emailWithTimeStamp);
    }
}
