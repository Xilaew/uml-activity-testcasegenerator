/*
 * tyrepump.c
 *
 *  Created on: 20.08.2013
 *      Author: TH51E0
 */
#include "TriangleClassificator.h"
#include "stdio.h"

int classify(const int* const x, const int* const y, const int* const z) {
	//lengths greater 0?
	if (*x > 0 && *y > 0 && *z > 0) {
		//Triangle inequality
		if (*x < *y + *z && *y < *x + *z && *z < *y + *x) {
			//valid triangle
			if (*x == *y && *y == *z) {
				//Equilateral
				return 3;
			} else if (*x == *y || *y == *z || *z == *x) {
				//Isoscalane
				return 2;
			} else {
				//Scalane
				return 1;
			}
		} else {
			//invalid triangle
			return -1;
		}
	} else {
		//invalid triangle
		return -1;
	}
}

double classifyNoLogic(const double* const x, const double* const y,
		const double* const z) {
	//lengths greater 0?
	if (*x > 0 && *y > 0 && *z > 0) {
		//Triangle inequality
		if (*x < *y + *z && *y < *x + *z && *z < *y + *x) {
			//valid triangle
			if (*x == *y && *y == *z) {
				//Equilateral
				return 3;
			} else if (*x == *y || *y == *z || *z == *x) {
				//Isoscalane
				return 2;
			} else {
				//Scalane
				return 1;
			}
		} else {
			//invalid triangle
			return -1;
		}
	} else {
		//invalid triangle
		return -1;
	}
}

