package Genric;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Genric {
	
	// A first cut at making Chooser generic - won't compile
	public class Chooser<T> {
	private final T[] choiceArray;
	public Chooser(Collection<T> choices) {
	choiceArray = choices.toArray();
	}
	// choose method unchanged
	}
	
}


class Chooser2 {
private final Object[] choiceArray;
public Chooser2(Collection choices) {
choiceArray = choices.toArray();
}
public Object choose() {
Random rnd = ThreadLocalRandom.current();
return choiceArray[rnd.nextInt(choiceArray.length)];
}
}

//List-based Chooser - typesafe
class Chooser3<T> {
	private final List<T> choiceList;

	public Chooser3(Collection<T> choices) {
		choiceList = new ArrayList<>(choices);
	}

	public T choose() {
		Random rnd = ThreadLocalRandom.current();
		return choiceList.get(rnd.nextInt(choiceList.size()));
	}
}
