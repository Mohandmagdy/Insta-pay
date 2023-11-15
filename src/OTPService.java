import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.*;
import java.io.DataOutputStream;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;
public class OTPService {
    private String code;
    public String SendOTP(String Phone)  {

            this.code = generateOTP();
            /*
            try{
            URL url = new URL("https://gatewayapi.com/rest/mtsms");
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(
                    "token=Y4C9KGdVR5Kw7VKSPh_JgpoMe7HM190OPZq4OZq26OLFWSvo-kf2CgQu0YPDhG3i"
                            + "&sender=" + URLEncoder.encode("InstaPay", "UTF-8")
                            + "&message=" + URLEncoder.encode("Greetings , your otp code is "+this.code, "UTF-8")
                            + "&recipients.0.msisdn="+Phone
            );
            wr.close();

            int responseCode = con.getResponseCode();
            System.out.println("Got response " + responseCode);
             */


            /*catch (UnsupportedEncodingException ex) {
           return null;
        }
        catch (IOException ex) {
            return null;
        }

        */
        return code;
        }







    public boolean verifyOTP(String otp) {
       if(Objects.equals(otp, this.code))return true;
       return false;
    }

    public String getOTP(){
        return code;
    }

    public String generateOTP(){
        Random r = new Random();
        String randomNumber = String.format("%04d", Integer.valueOf(r.nextInt(1001)));
        System.out.println(randomNumber);
        return randomNumber;
    }
}
