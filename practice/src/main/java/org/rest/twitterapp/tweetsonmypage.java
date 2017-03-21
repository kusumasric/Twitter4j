package org.rest.twitterapp;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

 

public class tweetsonmypage {

    static String AccessToken = "778288643693608960-XYbzPT5NNKQVxzszGqHNnfN0BZgDNXI";
    static String AccessSecret = "umIHL5HUKJ8WQv3LNt7PPuQS5boY39LZzED3VjLFsIV4d";
    static String ConsumerKey = "2TDNCPMGcN6BGhTJoU3HIfuSY";
    static String ConsumerSecret = "DsEB2A3kxHDYyy0O3PcQhLTyRI2z1uvxm7hrqyGVRX9DcL68OA";

    public static void main(String arg[]) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException, ParseException, JSONException{
        
      OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey,ConsumerSecret);
      
      consumer.setTokenWithSecret(AccessToken, AccessSecret);
      //API url to get the all tweets
      HttpGet request = new HttpGet("https://api.twitter.com/1.1/statuses/user_timeline.json");
      consumer.sign(request);

      HttpClient client = new DefaultHttpClient();
      HttpResponse response = client.execute(request);        
      JSONArray temp1 = new JSONArray(EntityUtils.toString(response.getEntity()));
      
      
      for(int i = 0; i< temp1.length(); i++)
      {
      
          System.out.println("Printing information for Tweet "+i+1);
          System.out.println(temp1.getJSONObject(i).getString("created_at"));

          System.out.println(temp1.getJSONObject(i).getString("text"));
          System.out.println("------------------------------ ");
        
      } 
       
  }
	
	
	
	
}
