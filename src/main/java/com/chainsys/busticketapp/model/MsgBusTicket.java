package com.chainsys.busticketapp.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

import com.chainsys.busticketapp.logger.Logger;

public class MsgBusTicket {
	static Logger logger=Logger.getInstance();
	public static int msg()
    {
        String authkey = "243477AVOV0jN2Q5bc967d9";
        String mobiles = "6369541046";
        String senderId = "VIGNES";
        String country = "91";
        Random rand=new Random();
        int message=rand.nextInt(99999);
        String route="4";
        URLConnection myURLConnection=null;
        URL myURL=null;
        BufferedReader reader=null;
        String mainUrl="https://api.msg91.com/api/v2/sendsms?";
        StringBuilder sbPostData= new StringBuilder(mainUrl);
        sbPostData.append("authkey="+authkey);
        sbPostData.append("&mobiles="+mobiles);
        sbPostData.append("&message=Your OTP for BusTicket Registration is "+message);
        sbPostData.append("&route="+route);
        sbPostData.append("&country=" + country);
        sbPostData.append("&sender="+senderId);
        mainUrl = sbPostData.toString();
        try
        {
            myURL = new URL(mainUrl);
            myURLConnection = myURL.openConnection();
            myURLConnection.connect();
            reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
            String response;
            while ((response = reader.readLine()) != null)
                logger.info(response);
            reader.close();
        }
        catch (IOException e)
        {
                logger.error(e.getMessage());
        }
        return message;
    }
	
}
