package org.eclipse.atg.model.pathsearch;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;

class Pair {
	
	@Override
	public String toString() {
		return second.toString()+"::"+first.getName();
	}

	/**
	 * 
	 */
	public Pair(AbstractTCGEdge first,Integer second){
		this.first=first;
		this.second=second;
	}
	
	public AbstractTCGEdge getFirst() {
		return first;
	}
	public void setFirst(AbstractTCGEdge first) {
		this.first = first;
	}
	public Integer getSecond() {
		return second;
	}
	public void setSecond(Integer second) {
		this.second = second;
	}
	AbstractTCGEdge first;
	Integer second;

}