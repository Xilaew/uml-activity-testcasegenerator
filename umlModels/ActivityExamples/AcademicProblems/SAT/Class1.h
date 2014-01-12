/*
 * Tyrepump.h
 *
 *  Created on: 20.08.2013
 *      Author: TH51E0
 */

#ifndef CLASS1_H_
#define CLASS1_H_

#ifndef __cplusplus
enum Boolean {true, false};
typedef enum Boolean bool;
#endif

#ifdef __cplusplus
extern "C" {
#endif

extern bool s0;
extern bool s1;
extern bool s2;
extern bool s3;

void count(const bool* const o0, const bool* const o1, const bool* const o2,
		const bool* const o3);
void counter(const bool* const o0, const bool* const o1, const bool* const o2,
		const bool* const o3);
void counterSAT(const bool* const o0, const bool* const o1, const bool* const o2,
		const bool* const o3);

#ifdef __cplusplus
}
#endif

#endif /* CLASS1_H_ */
