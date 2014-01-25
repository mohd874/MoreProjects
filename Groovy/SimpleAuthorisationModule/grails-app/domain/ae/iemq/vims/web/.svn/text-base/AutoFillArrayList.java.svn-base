package ae.iemq.vims.web;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Subclass of ArrayList that automatically adds instances of its prototype object
 * to itself when it is indexed at a location beyond its current size.  Iteration is still safe
 * since the size() method call does not modify the contents of the ArrayList
 *
 * @param <E>
 */
@SuppressWarnings("serial")
public class AutoFillArrayList<E> extends ArrayList<E> {

	private E prototype;

	public AutoFillArrayList(E prototype) {
		this.prototype = prototype;
	}

	@Override
	public E set(int index, E element) {
		if (index < size())
			return super.set(index, element);

		addAll(Collections.nCopies(index - size(), prototype));
		add(element);
		return null;
	}

	@Override
	public E get(int index) {
		if (index < size())
			return super.get(index);

		addAll(Collections.nCopies(index - size() + 1, prototype));
		return prototype;
	}

}
