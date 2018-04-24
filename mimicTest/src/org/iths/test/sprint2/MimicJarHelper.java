package org.iths.test.sprint2;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.iths.main.HttpServiceCaller;

public class MimicJarHelper {

	private HttpServiceCaller service;
	
	public boolean jarRunning() {
		service = new HttpServiceCaller();
		if(!service.executeGetRequest("localhost:8080").equals("Error")) {
			return true;
		}else if(service.executeGetRequest("localhost:8080").equals("Error")){
			startMimicJar();
			return true;
		}else {
			return false;
		}
	}
	
	public void startMimicJar() {
		try {
			Desktop.getDesktop().open(new File("commonFiles\\runnableJars\\releaseSprint2\\mimic.jar"));
		} catch (IOException e) {
			System.err.println("Please start mimic.jar manually before running tests again. Location in repository: \\commonFiles\\runnableJars\\releaseSprint2\\mimic.jar");
		}
	}
	
	public void resetMimic() {
		service = new HttpServiceCaller();
		service.executeGetRequest("localhost:8080/killMimic");
		startMimicJar();
	}
}
