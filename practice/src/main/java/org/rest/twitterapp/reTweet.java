package org.rest.twitterapp;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
 
//import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
 
 
public class reTweet {
 
	  static String AccessToken = "780225970221359104-uOzqXMdVZMVgIs4wLt9d3hhu1DHqtHW";
	  static String AccessSecret = "GZPze9Q80LLPDyjIk2Wfx4Pu8xfqSekmpor4QXkEBt5Lr";
	  static String ConsumerKey = "7Hf0FcJZHAw6biaYb23EUju9S";
	  static String ConsumerSecret = "1gSNpislbh1MwqY9HoLSVskznBegFfNP1xQItM5TwbY7nwl2JK";

	
	public static void main(String[] args) throws Exception {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(
                ConsumerKey,
                ConsumerSecret);
		
        consumer.setTokenWithSecret(AccessToken, AccessSecret);
        //url to Post/ReTweet Bill Gates tweet
        HttpPost request = new HttpPost("https://api.twitter.com/1.1/statuses/retweet/781233434295463936.json");
        consumer.sign(request);
 
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(request);
 
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Status Line"+ response.getStatusLine());
        System.out.println("New status code="+statusCode + ":" + response.getStatusLine().getReasonPhrase());
 //       System.out.println(IOUtils.toString(response.getEntity().getContent()));
	}
}