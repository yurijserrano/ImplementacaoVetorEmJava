/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yuri
 */
public interface IndexList<E> 
{
	public boolean isEmpty();
	public int size();
	public E get(int i) throws ArrayIndexOutOfBoundsException;
	public E set(int i, E e) throws ArrayIndexOutOfBoundsException;
	public void add(int i, E e) throws ArrayIndexOutOfBoundsException;
	public void remove(int i) throws ArrayIndexOutOfBoundsException;
}

