/*
 * Tyrepump.h
 *
 *  Created on: 20.08.2013
 *      Author: TH51E0
 */

#ifndef TYREPUMP_H_
#define TYREPUMP_H_

#ifndef __cplusplus
enum Boolean{true, false};
typedef enum Boolean bool;
#endif

#ifdef __cplusplus
extern "C"{
#endif

extern int x;

bool simpleDecision(const int* const a);
bool assignmentDecision(const int* const a, const int* const y);
bool nonLinearAssignmentDecision(const int* const a);

#ifdef __cplusplus
}
#endif


#endif /* TYREPUMP_H_ */
