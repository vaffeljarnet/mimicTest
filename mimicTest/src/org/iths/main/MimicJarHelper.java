package org.iths.main;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class MimicJarHelper {

	private HttpServiceCaller service;
	private final static String host="http://localhost:8080/"; 
	
	public boolean jarIsRunning() {
		service = new HttpServiceCaller();
		if(!service.executeGetRequest(host).equals("Error")) {
			resetMimic();
			return true;
		}else if(service.executeGetRequest(host).equals("Error")) {
			startMimic();
			return true;
		}else {
			return false;
		}
	}
	
	public void resetMimic() {
		killMimic();
		wait(100);
		startMimic();
		wait(100);
	}
	
	public void startMimic() {
		try {
			Desktop.getDesktop().open(new File("commonFiles\\runnableJars\\currentRelease\\mimic.jar"));
		} catch (IOException e) {
			System.err.println("Please start mimic.jar manually before running tests again. Location in repository: \\commonFiles\\runnableJars\\releaseSprint2\\mimic.jar");
		}
	}
	
	public void killMimic() {
		service = new HttpServiceCaller();
		service.executeGetRequest("http://localhost:8080/KillMimic");
		wait(100);
	}
	
	public String errorString() {
		return "Please start mimic.jar manually before running tests again. Location in repository: \\commonFiles\\runnableJars\\releaseSprint2\\mimic.jar";
	}
	
	public void wait(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
