package org.iths.test.sprint2;

import java.util.HashMap;
import java.util.Scanner;

import org.iths.main.RequestResponse;

public class MockTestSprint2 {

	private HashMap<String, RequestResponse> list = new HashMap<>();

	public MockTestSprint2() {

	}

	/**
	 * 	
	 * @param request
	 * @return
	 */
	public String sendGetRequest(String getRequest) {
		if(getRequest.contains("?storeRequest=")) {

			String request = getRequest.replace("localhost:8080/", "");
			int index = request.indexOf("?");
			request = request.substring(0, index);

			index = getRequest.indexOf("=");
			String response = getRequest.substring(index, getRequest.length());
			response = response.replace("=", "");

			list.put(request, new RequestResponse(request, response));

			return list.get(request).getResponse();						
		}else if(getRequest.contains("?learn")) {

			boolean cont = true;

			String request = getRequest.replace("localhost:8080/", "");

			int index = request.indexOf("?");
			request = request.substring(0, index);
			Scanner sc = new Scanner(System.in);
			System.out.print("Please input answer to the question: ");
			String response = sc.nextLine();

			if(list.containsKey(request)) {
				System.out.print("Request already have an answer:"+list.get(request).getResponse());
				System.out.print("Do you want to replace it with: "+response+"? Enter Yes/No:");
				String reply = sc.nextLine();
				if(reply.equalsIgnoreCase("Yes")) {
					list.replace(request, new RequestResponse(request, response));
					System.out.println("New request stored");
					sc.close();
				}else{
					System.out.println("No changes has been made");
					cont = false;
					sc.close();
				}
			}else{
				if(cont) {
					list.put(request, new RequestResponse(request, response));
					System.out.println("New request stored");
					sc.close();
				}
			}
			
			return list.get(request).getResponse();	
		}else if (getRequest.contains("localhost:8080/") && !getRequest.contains("?storeRequest=") && !getRequest.contains("?learn=")){
			String request = getRequest.replace("localhost:8080/", "");
			if(!list.containsKey(request)) {
				return "No answer to this question";
			}else {
				return list.get(request).getResponse();
			}
			
		}else {
			return "Invalid request";
		}
	}

}
