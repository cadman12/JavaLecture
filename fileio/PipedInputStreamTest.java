package edu.pnu.fileio;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Calendar;

// 에러가 나고 실행 안됨.
public class PipedInputStreamTest {

	public static void main(String[] args) {

//		try(PipedInputStream pis = new PipedInputStream();
//			PipedOutputStream pos = new PipedOutputStream(pis);) {
//
//			Thread thread1 = new Thread() {
//				public void run() {
//					try {
//						while(true) {
//							Thread.sleep(1000);
//							String time = Calendar.getInstance().getTime().toString();
//							byte[] b = time.getBytes();
//							pos.write(b);
//						}
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			};
//			thread1.start();
			
//			Thread thread2 = new Thread() {
//				public void run() {
//					byte[] byteBowl = new byte[1024];
//					try {
//						while(true) {
//							Thread.sleep(1500);
//							
//							int read = pis.read(byteBowl);
//							System.out.println(new String(byteBowl, 0, read));
//						}
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			};
//			thread2.start();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
			
		try {
			PipedInputStream pipedInputStream = new PipedInputStream();
			PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);
			
			Thread oneThread = new Thread() {
				public void run() {
					int count = 0;
					try {
						while(true) {
							try {
								Thread.sleep(1000);
								String strData = "There is no easy day[" + count + "]";
								pipedOutputStream.write(strData.getBytes());
							} catch (Exception e) {
								e.printStackTrace();
							}
							count++;
						}
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			};
			oneThread.start();
			Thread twoThread = new Thread() {
					public void run() {
						byte[] bytes = new byte[1024];
						while (true) {
							try {
								Thread.sleep(1000);
								int readData = pipedInputStream.read(bytes);
								String strReadData = new String(bytes, 0, readData);
								
								System.out.println(strReadData);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				};
				twoThread.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");
	}
}
