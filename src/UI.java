import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;
public class UI {
    public static void API(String s1,String s2)
    {
        Data d = new Data();
        HttpURLConnection c = getHttpURLConnection(s1);
        InputStream i;
        try {
            i = c.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InputStreamReader r = new InputStreamReader(i);
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(r);
        while(sc.hasNext())
        {
            sb.append(sc.nextLine());
        }
        sc.close();
        d.makeJson(sb,s2,s1);
        c.disconnect();
    }
    private static HttpURLConnection getHttpURLConnection (String s1)
    {
        String key = "";
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + s1 + "&appid=" + key;
        URL u;
        try
        {
            u = new URL(url);
        }
        catch (MalformedURLException e)
        {
            throw new RuntimeException(e);
        }
        HttpURLConnection c;
        try
        {
            c = (HttpURLConnection) u.openConnection();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        try
        {
            c.setRequestMethod("GET");
        }
        catch (ProtocolException e)
        {
            throw new RuntimeException(e);
        }
        return c;
    }
    public static void main(String[] args)
    {
        String c;
        String u;
        Scanner s=new Scanner(System.in);
        while(true) {
            System.out.println("Enter 1 City From: Delhi, Mumbai, Chennai, Bengaluru, Kolkata, Hyderabad");
            c=s.next();
            System.out.println("In which unit you want to see temperature(Enter 1 from): Kelvin, Celsius");
            u=s.next();
            if((c.equals("Delhi") || c.equals("Mumbai") || c.equals("Chennai") || c.equals("Bengaluru") || c.equals("Kolkata") || c.equals("Hyderabad") && (u.equals("Kelvin")) || u.equals("Celsius")))
            {
                API(c,u);
                break;
            }
        }
    }
}
