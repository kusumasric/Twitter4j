package org.kuuma.jsp;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class accinfo {


	  static String AccessToken = "780225970221359104-uOzqXMdVZMVgIs4wLt9d3hhu1DHqtHW";
	  static String AccessSecret = "GZPze9Q80LLPDyjIk2Wfx4Pu8xfqSekmpor4QXkEBt5Lr";
	  static String ConsumerKey = "7Hf0FcJZHAw6biaYb23EUju9S";
	  static String ConsumerSecret = "1gSNpislbh1MwqY9HoLSVskznBegFfNP1xQItM5TwbY7nwl2JK";

	
	public static  void getaccinfo() throws ClientProtocolException, IOException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(
              ConsumerKey,
              ConsumerSecret);
		
      consumer.setTokenWithSecret(AccessToken, AccessSecret);
      //updates profile description(can update other parameters as name,location as well
      HttpPost request = new HttpPost("https://api.twitter.com/1.1/account/update_profile.json?description=Now%20this%20is%20new.");
      consumer.sign(request);

      HttpClient client = new DefaultHttpClient();
      HttpResponse response = client.execute(request);

      int statusCode = response.getStatusLine().getStatusCode();
      System.out.println("Status Line"+ response.getStatusLine());
      System.out.println("New status code="+statusCode + ":" + response.getStatusLine().getReasonPhrase());
  //    System.out.println(IOUtils.toString(response.getEntity().getContent()));*/

	}
}
	
	
	
	

