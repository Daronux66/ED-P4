package ule.edi.recursiveList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.edi.exceptions.EmptyCollectionException;

public class AbstractLinkedListImpl<T> implements ListADT<T> {

	// Estructura de datos, lista simplemente enlazada
	//
	// Este es el primer nodo de la lista
	protected Node<T> front = null;

	// Clase para cada nodo en la lista
	protected  class Node<T> {

		T elem;

		Node<T> next;

		Node(T element) {
			this.elem = element;
			this.next = null;
		}

		@Override
		public String toString() {
			return "(" + elem + ")";
		}

	}

	private class IteratorImpl implements Iterator<T> {
		// TODO Implementar el iterador normal

		@Override
		public boolean hasNext() {

			return false;
		}

		@Override
		public T next() {



			return null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}


	// Ejemplos de ejercicios de recursividad
	//



	@Override
	public String toString() {
		// TODO RECURSIVO
		//	Construye y devuelve con el formato adecuado "(A B C )" 

		return null;
	}


	@Override
	public boolean contains(T target) {	
		if (target==null)throw new NullPointerException();
		return containsRec(front, target);
	}

	private boolean containsRec(Node <T> aux, T elem) {
		boolean contains=false;
		if(elem==aux.elem) contains=true;
		if(!contains)
			if(aux!=null) contains = containsRec(aux.next, elem);
		return contains;
	}

	@Override
	public int count(T element) {
		return countRec(front,element);
	}

	private int countRec(Node <T> aux, T elem) {
		int count;
		if(aux==null) count=0;
		else{
			if(elem == aux.elem) count = countRec(aux.next, elem) + 1;
			else count = countRec(aux.next, elem);
		}
		return count;
	}


	@Override
	public T getLast() throws EmptyCollectionException {
		return getLastRec(front);
	}

	private T getLastRec(Node <T> aux) {
		T elem;
		if(aux.next==null) elem=aux.elem;
		else elem=getLastRec(aux.next);
		return elem;
	}


	@Override
	public boolean isOrdered() {
		// TODO RECURSIVO
		return false;
	}


	@Override
	public T remove(T element) throws EmptyCollectionException {
		if (element==null) throw new NullPointerException();
		if (isEmpty()) throw new EmptyCollectionException("ERROR: THE LIST IS EMPTY")
		if (!contains(element)) throw new NoSuchElementException(); 
		return removeRec(front, element);
	}

	private T removeRec(Node<T> aux, T elem) {
		T element=null;
		if(aux!=null)
			if(elem==aux.next.elem) {
				element=aux.next.elem;
				aux.next=aux.next.next;
				return element;
			}
		return element = removeRec(aux.next, elem);
	}


	@Override
	public T removeLast(T element) throws EmptyCollectionException {
		if (element==null) throw new NullPointerException();
		if (isEmpty()) throw new EmptyCollectionException("ERROR: THE LIST IS EMPTY")
		if (!contains(element)) throw new NoSuchElementException(); 
		return removeLastRec(front, element, 0);
	}
	
	//REVISAR METODO
	private T removeLastRec(Node<T> aux, T elem, int counter) {
		T element=null;
		if(aux!=null)
			if(counter<count(elem)) {
				if(elem==aux.next.elem) {
					element=aux.next.elem;
					element = removeLastRec(aux.next, elem, counter++);
				}
				else element = removeLastRec(aux.next, elem, counter);
			}
			else aux.next=aux.next.next;;
		return element;
	}

	@Override
	public boolean isEmpty() {
		return (front==null);
	}

	@Override
	public int size() {
		// TODO RECURSIVO
		return sizeRec(front);
	}

	private int sizeRec(Node <T> aux) {
		int size;
		if(aux==null) size=0;
		else {
			size=sizeRec(aux.next)+1;
		}
		return size;
	}

	@Override
	public T getFirst() throws EmptyCollectionException {
		if(this.isEmpty())throw new EmptyCollectionException("ERROR: THE LIST IS EMPTY");
		return front.elem;
	}

	@Override
	public String toStringFromUntil(int from, int until) {
		// TODO RECURSIVO

		return null;

	}


	@Override
	public String toStringReverse() {
		// TODO RECURSIVE
		return null;
	}


	@Override
	public int removeDuplicates() {
		// TODO RECURSIVE
		// Implementar teniendo en cuenta que la lista está desordenada
		return 0;

	}


	@Override
	public Iterator<T> iterator() {
		// TODO 
		return null;
	}


}
