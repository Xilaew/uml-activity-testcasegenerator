package tools;

import java.io.IOException;

import org.xilaew.amplCLI.AmplFactory;
import org.xilaew.amplCLI.JAMPL;
import org.xilaew.amplCLI.JAMPL.SolveResult;

public class AmplJamplTest {

	public static void main(String[] args) throws IOException {
		JAMPL jampl = AmplFactory.createJAMPL();
		jampl.setSolver("cplex");
		jampl.loadModel("output/assignment.mod");
		jampl.loadData("output/assignment0.dat");
		SolveResult result = jampl.solve();
		printResult(result);
		jampl.setSolver("couenne");
		printResult(jampl.solve());
		System.out.println("found a result!");
		System.out.println("a is: "+jampl.getParameter("a"));
		System.out.println("x is: "+jampl.getVariable("x"));
		jampl.kill();
	}

	private static void printResult(SolveResult result) {
		switch (result) {
		case Unbounded:
		case Failure:
			System.out.println("failure");
			break;
		case Infeasible:
			System.out.println("infeasable");
			break;
		case Solved:
			System.out.println("The problem was solved");
			break;
		default:
			break;
		}
	}

}
