package org.eclipse.atg.model;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;

public class Pair {
	
	@Override
	public String toString() {
		return second.toString()+"::"+first.getName();
	}

	/**
	 * 
	 */
	Pair(AbstractTCGEdge first,Integer second){
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