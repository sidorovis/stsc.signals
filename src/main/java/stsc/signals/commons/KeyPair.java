package stsc.signals.commons;

/**
 * {@link KeyPair} is a class that store two String, you can think about that
 * class as Immutable Pair of two strings with hashCode / equals methods.<br/>
 * You can usage getLeft, getRight to access fields of pair.<br/>
 * Also it automatically sort left, right values at constructor. <br/>
 * I thought about ImmutablePair from Apache commons lang3.
 */
public final class KeyPair implements Comparable<KeyPair> {

	private final String left;
	private final String right;

	public KeyPair(String first, String second) {
		super();
		if (first.compareTo(second) > 0) {
			String swap = first;
			first = second;
			second = swap;
		}
		this.left = first;
		this.right = second;
	}

	public String getLeft() {
		return left;
	}

	public String getRight() {
		return right;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyPair other = (KeyPair) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}

	public String toString() {
		return left + "-" + right;
	}

	@Override
	public int compareTo(final KeyPair compare) {
		if (getLeft().compareTo(compare.getLeft()) == 0) {
			return getRight().compareTo(compare.getRight());
		}
		return getLeft().compareTo(compare.getLeft());
	}

}