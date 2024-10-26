import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Date;

class Data
{
    public void makeJson(StringBuilder sb,String s,String s1)
    {
        Gson g = new Gson();
        JsonObject jo = g.fromJson(sb.toString(),JsonObject.class);
        showdata(jo,s,s1);
    }
    public void showdata(JsonObject jo,String s2,String s3)
    {
        UIAdd u = new UIAdd();
        String wc = jo.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
        System.out.println("Weather: "+wc);
        long d1 = jo.get("dt").getAsLong() * 1000;
        String d2 = new Date(d1).toString();
        double tk = jo.getAsJsonObject("main").get("temp").getAsDouble();
        int tc = (int) (tk - 273.15);
        if(s2.equals("Centigrade"))
        {
            System.out.println("Temperature(in Centigrade): "+tc);
        }
        else
        {
            System.out.println("Temperature(in Kelvin): "+tk);
        }
        double tk1 = jo.getAsJsonObject("main").get("feels_like").getAsDouble();
        int tc1 = (int) (tk1 - 273.15);
        int h = jo.getAsJsonObject("main").get("humidity").getAsInt();
        double w = jo.getAsJsonObject("wind").get("speed").getAsDouble();
        double mint = jo.getAsJsonObject("main").get("temp_min").getAsDouble();
        double maxt = jo.getAsJsonObject("main").get("temp_min").getAsDouble();
        double avgt = (maxt+mint)/2;
        System.out.println("Feels Like(in Centigrade): "+tc1);
        System.out.println("Time: "+d2);
        System.out.println("Humidity: "+h);
        System.out.println("Wind Speed: "+w);
        System.out.println("Daily Summary");
        System.out.println("Minimum Temperature Of The Day: "+mint);
        System.out.println("Maximum Temperature Of The Day: "+maxt);
        System.out.println("Average Temperature Of The Day: "+avgt);
        u.add(s3,wc,tk,tc,h,w,mint,maxt,avgt);
    }
}
