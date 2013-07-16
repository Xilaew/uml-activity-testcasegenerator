package sortingMachine;

public enum State {
	idle,
	object_inserted,
	object_evaluated,
	object_recognized,
	object_not_recognized,
	object_is_too_big,
	object_is_too_small,
	object_is_fitting
}
