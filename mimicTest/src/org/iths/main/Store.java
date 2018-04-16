package org.iths.main;

import java.util.Hashtable;

public class Store
{  

	private Hashtable<String, RequestResponse> responses = new Hashtable<String, RequestResponse>();
	
	/**
	 * Learn to respond to a request
	 * 
	 * @param request
	 * @param response
	 */
	public void learnResponse(String request, String response)
	{
		responses.put(request, new RequestResponse(request, response));
	}
	
	
	/**
	 * Test method for adding a null object to the hastable value. Will not be used in final implementation
	 * @param request String
	 * @param reqRes RequestRespone
	 */
	public void learnResponseWithNull(String request, RequestResponse reqRes)
	{
		responses.put(request, reqRes);
	}
	
	/**
	 * @param request
	 * @return The response to a request
	 */
	public String getResponse(String request)
	{
		RequestResponse requestReponse = responses.get(request);
		if(requestReponse == null)
		{
			return null;
		}
		return requestReponse.getResponse();
	}
	
	/**
	 * Forget all learned responses
	 */
	public void unlearnAll()
	{
		responses = new Hashtable<String, RequestResponse>();
	}
}

