package org.kuuma.jsp;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class Tweetsmypage {

		 static String AccessToken = "780539740785299456-7HtD6BqnemBxvtGR5EMJODpSlKUwxRH";
	     static String AccessSecret = "VbFFoVxf8oV1LTh19bBYGUypNref9jns0Mb040TClip09";
	     static String ConsumerKey = "cmHZIXj8dWRcgJOBKfjFt4fzT";
	     static String ConsumerSecret = "FROl68xM5q2KUzxKwrGK5uRwM5khakpQEgTUNM4FjG1yIOfxFg";
	     static String tweetAllTweets="https://api.twitter.com/1.1/statuses/user_timeline.json";
	     static String tweetRecentMessagesUri="https://api.twitter.com/1.1/direct_messages/sent.json?count=10&since_id=780539740785299456";
	     static String tweetReTweets="https://api.twitter.com/1.1/statuses/retweets_of_me.json?count=50&since_id=780539740785299456";
	     static String getmsgtweetUri="https://api.twitter.com/1.1/direct_messages.json?since_id=780539740785299456";
	     static String getUserbyIdUri="https://api.twitter.com/1.1/users/search.json?q=Twitter%20API&page=1&count=3";
	     static String getFavoriteListUri="https://api.twitter.com/1.1/favorites/list.json?count=2&screen_name=nisha_r121";
	     static String followElonUri="https://api.twitter.com/1.1/friendships/create.json?user_id=44196397&follow=true";
	     static String updateyourProfileUri="https://api.twitter.com/1.1/account/update_profile.json?description=Work%20until%20you%20get%20it.";
	     	     
	     public static JSONArray getAllTweets() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException, ParseException, JSONException{ 
	    	 JSONArray tweet=Tweetson(tweetAllTweets);
	    	 return tweet;
	    	 }
	     public static JSONArray tweetRecentMessages() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException, ParseException, JSONException{ 
	    	 JSONArray tweet=Tweetson(tweetRecentMessagesUri);
	    	 return tweet;
	    	 }
	     public static JSONArray tweetReTweets() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException, ParseException, JSONException{ 
	    	 JSONArray tweet=Tweetson(tweetReTweets);
	    	 return tweet;
	    	 }
	     //Get all the messages in ur Inbox
	     public static JSONArray getmsgtweet() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException, ParseException, JSONException{ 
	    	 JSONArray tweet=Tweetson(getmsgtweetUri);
	    	 return tweet;
	    	 }
	     public static JSONArray getUsebyId() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException, ParseException, JSONException{ 
	    	 JSONArray tweet=Tweetson(getUserbyIdUri);
	    	 return tweet;
	    	 }
	     public static JSONArray getFavoriteList() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException, ParseException, JSONException{ 
	    	 JSONArray tweet=Tweetson(getFavoriteListUri);
	    	 return tweet;
	    	 }
	     
	     public static void followElon() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException, ParseException, JSONException{ 
	    	 OAuthConsumer consumer = new CommonsHttpOAuthConsumer(
	                 ConsumerKey,
	                 ConsumerSecret);
	    	 consumer.setTokenWithSecret(AccessToken, AccessSecret);
	         //Follow a celeb
	         HttpPost request = new HttpPost(followElonUri);
	         consumer.sign(request);
	         HttpClient client = new DefaultHttpClient();
	         HttpResponse response = client.execute(request);
	         int statusCode = response.getStatusLine().getStatusCode();
	         System.out.println("New status code="+statusCode + ":" + response.getStatusLine().getReasonPhrase());
	     	 }
	     
	     public static void updateyourProfileDesc() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException, ParseException, JSONException{ 
	    	 OAuthConsumer consumer = new CommonsHttpOAuthConsumer(
	                 ConsumerKey,
	                 ConsumerSecret);
	    	 consumer.setTokenWithSecret(AccessToken, AccessSecret);
	         //Follow a celeb
	         HttpPost request = new HttpPost(updateyourProfileUri);
	         consumer.sign(request);
	         HttpClient client = new DefaultHttpClient();
	         HttpResponse response = client.execute(request);
	         int statusCode = response.getStatusLine().getStatusCode();
	         System.out.println("New status code="+statusCode + ":" + response.getStatusLine().getReasonPhrase());
	    	 }
	     
	    public static JSONArray Tweetson(String tweetAllTweets) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException, ParseException, JSONException{
	      
	      OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey,ConsumerSecret);
	      consumer.setTokenWithSecret(AccessToken, AccessSecret);
	      //API url to get the all tweets
	      HttpGet request = new HttpGet(tweetAllTweets);
	      consumer.sign(request);
          HttpClient client = new DefaultHttpClient();
	      HttpResponse response = client.execute(request);        
	      JSONArray temp1 = new JSONArray(EntityUtils.toString(response.getEntity()));
          return temp1;
	  }
	
	  
		
		
		
	
	
	
}
