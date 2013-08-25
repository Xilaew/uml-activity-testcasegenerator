package tools;

import java.io.IOException;
import java.io.PrintWriter;

import org.xilaew.amplCLI.AmplFactory;
import org.xilaew.amplCLI.CLI;

public class AmplCliTest {

	public static void main(String[] args) {
		CLI cli = AmplFactory.createCLI();
		// Thread errorThread = new Thread() {
		// byte[] buff = new byte[100];
		//
		// public void run() {
		// while (true) {
		// try {
		// cli.getErrorStream().read(buff);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.err.println(buff);
		// }
		// };
		// };
		// errorThread.start();
		cli.sendCommand("option solver ilogcp;");
		cli.sendCommand("model output/assignment.mod;");
		cli.sendCommand("data output/assignment0.dat;");
		cli.sendCommand("solve;");
		cli.sendCommand("show;");
		cli.sendCommand("display a, return, x;");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while (cli.getErrorStream().available() > 0) {
				System.err.print((char) cli.getErrorStream().read());
			}
			String s;
			while ((s = cli.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Process p = null;
		// try {
		// p = Runtime.getRuntime().exec("ampl");
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// PrintWriter pw = new PrintWriter(p.getOutputStream());
		// pw.println("model output/assignment.mod;");
		// pw.println("show;");
		// pw.flush();
		// Thread.sleep(2000);
		// while (p.getInputStream().available() > 0) {
		// System.out.print((char) p.getInputStream().read());
		// }
		// ;
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// ;
		// p.exitValue();
	}
}
