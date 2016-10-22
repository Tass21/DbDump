package com.bcg.dbdump;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.apache.log4j.Logger;

public class CountService implements Daemon {
	
	private final static Logger logger = Logger.getLogger(CountService.class);
	private Thread countThread = null;
	private static final CountService CountService = new CountService();

	@Override
	public void destroy() {
		logger.debug("Service Destroy");
	}

	@Override
	public void init(DaemonContext arg0) throws DaemonInitException, Exception {
		countThread = new CountThread();
	}
		
	@Override
	public void start() throws Exception {
		countThread.start();
		logger.debug("Service Start");
	}

	@Override
	public void stop() throws Exception {
		countThread.interrupt();
		destroy();
	}
		
	public static void start(String [] args){
		try {
			CountService.init(null);
			CountService.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void stop(String [] args){
		try {
			CountService.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
