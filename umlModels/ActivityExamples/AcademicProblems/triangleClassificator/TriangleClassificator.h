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

int classify(const int* const x, const int* const y, const int* const z);
float classifyNoLogic(const float* const x, const float* const y, const float* const z);

#ifdef __cplusplus
}
#endif


#endif /* TYREPUMP_H_ */
