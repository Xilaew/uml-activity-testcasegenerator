/**
 * 
 */
package org.xilaew.amplCLI;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author TH51E0
 * 
 */
public class CLI {

	/**
	 * @return
	 */
	public InputStream getErrorStream() {
		return ampl.getErrorStream();
	}

	/**
	 * @return
	 */
	public InputStream getInputStream() {
		return ampl.getInputStream();
	}

	/**
	 * @return
	 */
	public OutputStream getOutputStream() {
		return ampl.getOutputStream();
	}

	Process ampl;
	PrintWriter pout;
	BufferedReader bin;
	BufferedReader berr;

	private void setStreams() {
		bin = new BufferedReader(new InputStreamReader(ampl.getInputStream()));
		pout = new PrintWriter(ampl.getOutputStream());
		berr = new BufferedReader(new InputStreamReader(ampl.getErrorStream()));
	}

	/**
	 * The default constructor just opening an AMPL console. The working
	 * directory will be the same as of the calling process.
	 * 
	 * @throws IOException
	 */
	protected CLI() throws IOException {
		super();
		ampl = Runtime.getRuntime().exec("ampl");
		setStreams();
	}

	/**
	 * Starts a new AMPL process with additional command line arguments,
	 * environment arguments and Working directory specified. All options are
	 * optional you can also pass null.
	 * 
	 * @param args
	 *            additional command line arguments to the AMPL program
	 * @param envp
	 *            additional environment Variables
	 * @param dir
	 *            working directory for the newly created process
	 * @throws IOException
	 */
	protected CLI(List<String> args, List<String> envp, File dir)
			throws IOException {
		super();
		String[] cmd = new String[1 + (args != null ? args.size() : 0)];
		String[] env = new String[0];
		util.Config.getProperty("AMPL_PATH");
		cmd[0] = util.Config.getProperty("AMPL_PATH") + "ampl";
		if (args != null) {
			int i = 1;
			for (String s : args) {
				cmd[i++] = s;
			}
		}
		if (envp != null) {
			env = envp.toArray(env);
		}
		if (dir != null) {
			ampl = Runtime.getRuntime().exec(cmd, env, dir);
		} else {
			Runtime.getRuntime().exec(cmd, env);
		}
		setStreams();
	}

	/**
	 * starts a new AMPL Process with the Specified command file. AMPL will
	 * directly execute all commands from the command file.
	 * 
	 * @param runFile
	 *            filename of command file to be run
	 * @throws IOException
	 */
	public CLI(String runFile) throws IOException {
		super();
		String[] cmd = { "ampl", runFile };
		ampl = Runtime.getRuntime().exec(cmd);
		setStreams();
	};

	/**
	 * Reads the console output of AMPL line by line. This method is blocking.
	 * When there can´t be read any more e.g. because the AMPL subprocess has
	 * terminated null will be returned.
	 * 
	 * @return one line of console output from AMPL
	 */
	public String readLine() {
		try {
			return bin.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void sendCommand(String command) {
		pout.println(command);
		pout.flush();
	}

	/**
	 * closes the AMPL application. Its input, output and error stream will not
	 * be usable any more. Later calls to write or read methods to 
	 */
	public void kill() {
		try {
			bin.close();
			pout.close();
			ampl.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
