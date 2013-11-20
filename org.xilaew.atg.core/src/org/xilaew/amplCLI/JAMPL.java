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
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.Output;

/**
 * @author TH51E0
 * 
 */
public class JAMPL {

	protected String getSolver() {
		return solver;
	}

	public CLI getCli() {
		return cli;
	}

	public void kill() {
		cli.kill();
	}

	public enum SolveResult {
		Solved, Infeasible, Failure, Unbounded;
	}

	CLI cli;

	final String parameter = "^(\\w+)\\s=\\s(-?\\d+)$";
	final String matrixRow = "";
	final String solveResult = "";

	private String solver;

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
		cli.sendCommand("reset;");
		cli.sendCommand("model;");
		cli.sendCommand(amplModel);
	}

	public void setSolver(String solverName) {
		this.solver = solverName;
		cli.sendCommand("option solver " + solverName + ";");
	}

	/**
	 * Ask AMPL to solve the current Problem. This method blocks until a solve
	 * result is returned.
	 * 
	 * @return
	 * @throws IOException
	 */
	public SolveResult solve() throws IOException {
		String lastLines[] = new String[10];
		int i = 0;
		cli.sendCommand("solve;");
		skipOutput();
		cli.sendCommand("display solve_result;");
		String line = null;
		SolveResult result = null;
		Pattern pattern = Pattern.compile("solve_result\\s*=\\s*(.*)");
		while (result == null) {
			line = cli.readLine();
			if (line != null) {
				// System.out.println(line);
				lastLines[i++ % 10] = line;
				Matcher matcher = pattern.matcher(line);
				if (matcher.matches()) {
					result = SolveResult.Failure;
					if (matcher.group(1).contains("solved")) {
						result = SolveResult.Solved;
					}
					if (matcher.group(1).contains("infeasible")) {
						result = SolveResult.Infeasible;
					}
					if (matcher.group(1).contains("unbounded")) {
						result = SolveResult.Unbounded;
					}
				}
			} else {
				for (String l : lastLines) {
					Output.debug(l, this);
				}
				Output.debug("End of AMPL output Stream reached", this);
				throw new IOException("NULL line read from AMPL");
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

	public Double getParameter(String varName) throws IOException {
		skipOutput();
		Double result = null;
		cli.sendCommand("display " + varName + ";");
		Pattern p = Pattern.compile("^(" + varName
				+ ")\\s=\\s(-?\\d+\\.?\\d*)$");
		while (result == null) {
			String line = cli.readLine();
			Matcher m = p.matcher(line);
			// System.out.println(line);
			if (m.matches()) {
				result = Double.parseDouble(m.group(2));
			}
		}
		return result;
	}

	public List<Double> getVariable(String varName) throws IOException {
		skipOutput();
		SortedMap<Integer, Double> map = new TreeMap<Integer, Double>();
		List<Double> result = null;
		cli.sendCommand("display " + varName + ";");
		Pattern p1 = Pattern
				.compile("^(" + varName + ")\\s\\[\\*\\]\\s:=\\s*$");
		while (result == null) {
			String line = cli.readLine();
			Matcher m1 = p1.matcher(line);
			// System.out.println(line);
			if (m1.matches()) {
				// Read complete trace of the Variable
				Pattern p2 = Pattern
						.compile("\\s*(\\d+)\\s+((-?\\d+\\.?\\d*)|NaN)");
				boolean reading = true;
				while (reading) {
					line = cli.readLine();
					Matcher m = p2.matcher(line);
					// System.out.println(line);
					reading = false;
					while (m.find()) {
						map.put(Integer.decode(m.group(1)),
								Double.valueOf(m.group(2)));
						reading = true;
					}
				}
				result = new ArrayList<Double>(map.size());
				for (Double d : map.values()) {
					result.add(d);
				}
			}
		}
		return result;
	}

}
