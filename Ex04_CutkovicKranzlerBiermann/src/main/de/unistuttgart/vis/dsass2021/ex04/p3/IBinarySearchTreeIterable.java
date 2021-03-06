package de.unistuttgart.vis.dsass2021.ex04.p3;

import javax.naming.OperationNotSupportedException;
import java.util.Iterator;

/**
 * Interface for an iterable {@link IBinarySearchTree}
 */
public interface IBinarySearchTreeIterable<T extends Comparable<T>> extends IBinarySearchTree<T> {
	
	/**
	 * Returns an iterator which traverses the tree given a traversal type 
	 * 
	 * @param traversalType traversal type
	 * @return an iterator which traverses the tree given a traversal type
	 */
	public Iterator<T> iterator(TreeTraversalType traversalType) throws OperationNotSupportedException;
	
}
