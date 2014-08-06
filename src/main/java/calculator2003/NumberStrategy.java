package calculator2003;

// Defines how to interact with the current strategy used when a numeric
// key is hit.
public interface NumberStrategy
{	public void apply(int value);
}