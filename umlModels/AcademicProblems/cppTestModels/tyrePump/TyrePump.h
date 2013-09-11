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

extern double pressure;
extern double n;
extern double temp;
extern int counter;
extern bool varMelted;
extern bool varBursted;


void pump(const int* const in_pumps, const double* const in_volume, const double* const in_pumpvolume, bool* out_tyreMelted, bool* out_tyreBursted);
//extern void (*pumpInfeasiblePaths)(const int* const, const double* const,
//		const double* const, bool*, bool*) = pump;
//extern void (*pumpExtended)(const int* const, const double* const, const double* const,
//		bool*, bool*) = pump;
void pumpExtended(const int* const in_pumps, const double* const in_volume, const double* const in_pumpvolume, bool* out_tyreMelted, bool* out_tyreBursted);
void pumpInfeasiblePaths(const int* const in_pumps, const double* const in_volume, const double* const in_pumpvolume, bool* out_tyreMelted, bool* out_tyreBursted);

#ifdef __cplusplus
}
#endif


#endif /* TYREPUMP_H_ */
