/*
 * tyrepump.c
 *
 *  Created on: 20.08.2013
 *      Author: TH51E0
 */
#include "Class1.h"
#include "stdio.h"

int x;

bool simpleDecision(const int* const a){
	if (*a>=5){
		return true;
	}
	return false;
}

bool assignmentDecision(const int* const a, const int* const y){
	x=2*x+*y;
	if(x<=*a){
		return false;
	}
	if(x>=*a+1){
		return true;
	}
}

bool nonLinearAssignmentDecision(const int* const a){
	x=(2*x*x+3)/(*a);
	if(x<=*a){
		return false;
	}
	if(x>=*a+1){
		return true;
	}
}
