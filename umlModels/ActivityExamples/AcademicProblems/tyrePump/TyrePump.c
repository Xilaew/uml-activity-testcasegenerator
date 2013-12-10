/*
 * tyrepump.c
 *
 *  Created on: 20.08.2013
 *      Author: TH51E0
 */
#include "TyrePump.h"
#include "stdio.h"

double pressure;
double n;
double temp;
int counter;
bool varMelted;
bool varBursted;

void pump(const int* const in_pumps, const double* const in_volume,
		const double* const in_pumpvolume, bool* out_tyreMelted,
		bool* out_tyreBursted) {
	*out_tyreMelted = false;
	*out_tyreBursted = false;
	varBursted = false;
	varMelted = false;
	counter = *in_pumps;
	do {
		//do pump
		n = n + (pressure * (*in_pumpvolume)) / (temp * 0.287058); //Correct
		pressure = (pressure * (*in_volume + *in_pumpvolume) * (*in_volume + *in_pumpvolume))
				/ ((*in_volume) * (*in_volume));
		temp = (pressure * *in_volume) / (0.287058 * n);
		printf("pressure: %f\n", pressure);

		//tyre Melted
		if (temp >= 400) {
			*out_tyreMelted = true;
			varMelted = true;
		}
		//Tyre Bursted
		if (pressure >= 15) {
			*out_tyreBursted = true;
			varBursted=true;
		}
		//Cool a little
		temp = (10 * temp + 300) / 11 ;
		pressure = (0.287058 * n * temp) / (*in_volume);
		counter--;
	}while( counter >= 1 ) ;
}

void pumpExtended(const int* const in_pumps, const double* const in_volume,
		const double* const in_pumpvolume, bool* out_tyreMelted,
		bool* out_tyreBursted) {
	pump(in_pumps, in_volume,
			in_pumpvolume, out_tyreMelted,
			out_tyreBursted);
}
void pumpInfeasiblePaths(const int* const in_pumps, const double* const in_volume,
		const double* const in_pumpvolume, bool* out_tyreMelted,
		bool* out_tyreBursted) {
	pump(in_pumps, in_volume,
			in_pumpvolume, out_tyreMelted,
			out_tyreBursted);
}


//void (*pumpInfeasiblePaths)(const int* const, const double* const,
//		const double* const, bool*, bool*) = pump;
//void (*pumpExtended)(const int* const, const double* const, const double* const,
//		bool*, bool*) = pump;

