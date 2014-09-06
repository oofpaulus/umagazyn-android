package umagazyn.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import umagazyn.network.parts.CallbacResultPart;
import umagazyn.network.parts.interfaces.AsyncCallback;
import umagazyn.network.parts.interfaces.LoginCallback;
import umagazyn.network.parts.ResultPart;

import android.os.AsyncTask;
import android.util.Log;

public class ServerConnector extends AsyncTask<JSONObject ,Void,String> {
	
	private ResultPart resultPart[] = null;
	private AsyncCallback callback;
	private String url;
	
	public ServerConnector(AsyncCallback callback, String url, ResultPart ... resultPart)
	{
		this.resultPart = resultPart;
		this.callback = callback;
		this.url = url;
		
	}
	
	private static HttpResponse makeRequest(String uri, String json) {

        try {
            HttpPost httpPost = new HttpPost(uri);
            httpPost.setEntity(new StringEntity(json));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            return new DefaultHttpClient().execute(httpPost);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

	
    private static String inputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;
 
        inputStream.close();
        return result;
    }
    
	
	@Override
	protected String doInBackground(JSONObject... params) {
	
		InputStream inputStream = null;
	    String result = "";
		
		Map<String, String> comment = new HashMap<String,String>();
	    comment.put("subject", "Using the GSON library");
	    comment.put("message", "Using libraries is convenient.");
	    HttpResponse httpResp = makeRequest(url, params[0].toString());
	    try {
			inputStream = httpResp.getEntity().getContent();
			result = inputStreamToString(inputStream);
	    }
	    catch (Exception e)
	    {
	    	return "";
	    }
		
		return result;
	}
	
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		
		CallbacResultPart callbackResult = new CallbacResultPart();
		for (ResultPart rPart : resultPart )
		{
			callbackResult.CallbackObjectWithJson(callback, result, rPart);
		}
		
	}
	
}

