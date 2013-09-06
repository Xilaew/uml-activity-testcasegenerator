/**
 * An slightly more convenient Interface to AMPL seated on top of the Simple CLI. 
 * Some Convenience functions for loading model, data and adding objective functions etc. are provided.
 */
package org.xilaew.amplCLI;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author TH51E0
 * 
 */
public class JAMPL {

	public CLI getCli() {
		return cli;
	}

	public void kill() {
		cli.kill();
	}

	public enum SolveResult {
		Solved, Infeasable, Failure, Unbounded;
	}

	CLI cli;

	final String parameter = "^(\\w+)\\s=\\s(-?\\d+)$";
	final String matrixRow = "";
	final String solveResult = "";

	public void loadData(File file) {
		cli.sendCommand("data " + file.getAbsolutePath() + ";");
	}	
	
	public void loadData(String amplData) {
		cli.sendCommand("reset data;");
		cli.sendCommand("data;");
		cli.sendCommand(amplData);
		cli.sendCommand("model;");
	}

	public void loadModel(File file) {
		cli.sendCommand("model " + file.getAbsolutePath() + ";");
	}	
	
	public void loadModel(String amplModel) {
		cli.sendCommand("reset model;");
		cli.sendCommand("model;");
		cli.sendCommand(amplModel);
	}

	public void setSolver(String solverName) {
		cli.sendCommand("option solver " + solverName + ";");
	}

	/**
	 * Ask AMPL to solve the current Problem. This method blocks until a solve
	 * result is returned.
	 * 
	 * @return
	 */
	public SolveResult solve() {
		cli.sendCommand("solve;");
		skipOutput();
		cli.sendCommand("display solve_result;");
		String line = null;
		SolveResult result = null;
		Pattern pattern = Pattern.compile("solve_result\\s*=\\s*(.*)");
		while (result == null) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			line = cli.readLine();
			System.out.println(line);
			if (line != null) {
				Matcher matcher = pattern.matcher(line);
				if (matcher.matches()) {
						result = SolveResult.Failure;
					if (matcher.group(1).contains("solved")) {
						result = SolveResult.Solved;
					}
					if (matcher.group(1).contains("infeasible")) {
						result = SolveResult.Infeasable;
					}
					if (matcher.group(1).contains("unbounded")) {
						result = SolveResult.Unbounded;
					}
				}
			}
		}
		return result;
	}

	public void skipOutput() {
		try {
			cli.getInputStream().skip(Integer.MAX_VALUE);
			cli.bin = new BufferedReader(new InputStreamReader(
					cli.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Double getParameter(String varName) {
		skipOutput();
		Double result = null;
		cli.sendCommand("display " + varName + ";");
		Pattern p = Pattern.compile("^(" + varName + ")\\s=\\s(-?\\d+\\.?\\d*)$");
		while (result == null) {
			String line = cli.readLine();
			Matcher m = p.matcher(line);
			System.out.println(line);
			if (m.matches()) {
				result = Double.parseDouble(m.group(2));
			}
		}
		return result;
	}

	public List<Double> getVariable(String varName) {
		skipOutput();
		List<Double> result = null;
		cli.sendCommand("display " + varName + ";");
		Pattern p = Pattern.compile("^(" + varName + ")\\s\\[\\*\\]\\s:=\\s*$");
		while (result == null) {
			String line = cli.readLine();
			Matcher m = p.matcher(line);
			System.out.println(line);
			if (m.matches()) {
				result = new ArrayList<Double>();
			}
		}
		p = Pattern.compile("^\\s*\\d+\\s+((-?\\d+\\.?\\d*)|NaN)");
		while (true) {
			String line = cli.readLine();
			Matcher m = p.matcher(line);
			System.out.println(line);
			if (m.matches()){
				if (m.group(1).equals("NaN")){
					result.add(Double.NaN);
				}else{
					result.add(Double.parseDouble(m.group(1)));
				}
			}else break;
		}
		return result;
	}

}
