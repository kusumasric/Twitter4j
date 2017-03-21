package org.kuuma.jsp;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
 
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

public class getRecentmessagesSent {

	static String AccessToken = "780539740785299456-7HtD6BqnemBxvtGR5EMJODpSlKUwxRH";
	  static String AccessSecret = "VbFFoVxf8oV1LTh19bBYGUypNref9jns0Mb040TClip09";
	  static String ConsumerKey = "cmHZIXj8dWRcgJOBKfjFt4fzT";
	  static String ConsumerSecret = "FROl68xM5q2KUzxKwrGK5uRwM5khakpQEgTUNM4FjG1yIOfxFg";

	
	public static void main(String[] args) throws Exception {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(
              ConsumerKey,
              ConsumerSecret);
		
      consumer.setTokenWithSecret(AccessToken, AccessSecret);
      //url to get the latest tweet
      HttpGet request = new HttpGet("https://api.twitter.com/1.1/direct_messages/sent.json?count=10&since_id=780539740785299456");
      consumer.sign(request);

      HttpClient client = new DefaultHttpClient();
      HttpResponse response = client.execute(request);
      //Archana's code
      JSONArray temp1 = new JSONArray(EntityUtils.toString(response.getEntity()));
      JSONArray results ;
      
      System.out.println("Printing information for messages sent from Twitter ");
      for(int i = 0; i< temp1.length(); i++)
      {
        //  System.out.println(temp1.getJSONObject(i).get("recipient"));
          	//"recipient:{"screen_name"}
          System.out.println(temp1.getJSONObject(i).getString("text"));
          System.out.println("------------------------------ ");
        
      } 

      /*int statusCode = response.getStatusLine().getStatusCode();
      System.out.println("Status Line"+ response.getStatusLine());
      System.out.println("New status code="+statusCode + ":" + response.getStatusLine().getReasonPhrase());
      System.out.println(IOUtils.toString(response.getEntity().getContent()));*/
	}
}
