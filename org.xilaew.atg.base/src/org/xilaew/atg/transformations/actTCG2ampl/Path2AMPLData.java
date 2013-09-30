package org.xilaew.atg.transformations.actTCG2ampl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGElement;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGRealNode;
import org.xilaew.atg.model.testCaseGraphRuntime.Path;

public class Path2AMPLData {
	public static String transform(Path p) {
		Map<AbstractTCGElement, Set<Integer>> amplPath = new HashMap<AbstractTCGElement, Set<Integer>>();
		int i = 0;
		for (AbstractTCGEdge edge : p.getEdges()) {
			if (edge.getGuard() != null) {
				Set<Integer> places = null;
				if (amplPath.containsKey(edge))
					places = amplPath.get(edge);
				if (places == null)
					places = new HashSet<Integer>();
				places.add(new Integer(i));
				amplPath.put(edge, places);
			}

			AbstractTCGNode node;
			if ((node = edge.getTarget()) instanceof AbstractTCGRealNode) {
				i++;
				Set<Integer> places = null;
				if (amplPath.containsKey(node))
					places = amplPath.get(node);
				if (places == null)
					places = new HashSet<Integer>();
				places.add(new Integer(i));
				amplPath.put(node, places);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("param Pathlength := " + i + ";\n");
		for (Entry<AbstractTCGElement, Set<Integer>> entry : amplPath
				.entrySet()) {
			AbstractTCGElement e = entry.getKey();
			String s = e.getName();
			String substitute = s.replaceAll("\\s", "_");
			sb.append("set " + substitute
					+ ":=");
			for (Integer j : entry.getValue()) {
				sb.append(" " + j);
			}
			sb.append(";\n");
		}
		return sb.toString();
	}

	public static int getPathlength(Path p) {
		int i = 0;
		for (AbstractTCGEdge edge : p.getEdges()) {
			if ((edge.getTarget()) instanceof AbstractTCGRealNode) {
				i++;
			}
		}
		return i;
	}

}
