package Enums;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Plant {
	
	enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }
	final String name;
	final LifeCycle lifeCycle;
	Plant(String name, LifeCycle lifeCycle) {
	this.name = name;
	this.lifeCycle = lifeCycle;
	}
	@Override public String toString() {
	return name;
	}
	
	public static void main(String[] args) {
		// Using an EnumMap to associate data with an enum
		Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle =
				new EnumMap<> (Plant.LifeCycle.class);
		for (Plant.LifeCycle lc : Plant.LifeCycle.values())
		plantsByLifeCycle.put(lc, new HashSet<>());
		for (Plant p : garden)
		plantsByLifeCycle.get(p.lifeCycle).add(p);
		System.out.println(plantsByLifeCycle);
	}

}
