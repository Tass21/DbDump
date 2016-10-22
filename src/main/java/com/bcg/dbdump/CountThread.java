package com.bcg.dbdump;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.bcg.dbdump.util.DateUtil;

// public class CountTherad implements Runnable {
public class CountThread extends Thread {

	private final static Logger logger = Logger.getLogger(CountThread.class);
	private final static int sleepTime = 1000;
	private static File workFile = new File("H:/job/procrun/log/work.txt");
	private String oldTime;
	
	public static void main(String[] args) {
		CountThread t = new CountThread();
		t.setDaemon(true);
		t.start();
		try {
			Thread.sleep(sleepTime + 10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String nowTime = "";
		String[] timeArr = null;
		String dd = "",HH = "",mm = ""; 
		
//      while (true) {  // run with main(String[] args) method 
		while (!Thread.currentThread().isInterrupted()) {
			try {
				nowTime = DateUtil.formattedDateNow("yyyy MM dd HH mm ss");
				if (nowTime.equals(oldTime)) break;
				
				FileUtils.writeStringToFile(workFile, "Every 1 Seconds " + nowTime + "\r\n", Charset.forName("UTF-8"), true);
				
				oldTime = nowTime;
				timeArr = nowTime.split(" ");
				dd = timeArr[2];
				HH = timeArr[3];
				mm = timeArr[4];
				
				if (mm.equals("05") ||  mm.equals("20") ||  mm.equals("35") ||  mm.equals("50")) {
				}
				
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
	}
}
