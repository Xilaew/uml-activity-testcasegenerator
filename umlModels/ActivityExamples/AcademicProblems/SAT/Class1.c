/*
 * Class1.c
 *
 *  Created on: 20.08.2013
 *      Author: TH51E0
 */
#include "Class1.h"

bool s0;
bool s1;
bool s2;
bool s3;

void count(const bool* const o0, const bool* const o1,
		const bool* const o2, const bool* const o3) {
	do {
		s0=~s0;
		s1 = s0? s1:~s1;
		s2 = s0||s1? s2:~s2;
		s3 = s0||s1||s2? s3:~s3;
	} while (*o0!=s0 && *o1!=s1 && *o2!=s2 && *o3!=s3);
}


void counter(const bool* const o0, const bool* const o1,
		const bool* const o2, const bool* const o3) {
		count(o0,o1,o2,o3);
		}

void counterSAT(const bool* const o0, const bool* const o1,
		const bool* const o2, const bool* const o3) {
		count(o0,o1,o2,o3);
		}
