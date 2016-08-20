
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yuri
 */



public class Vector<E>
        implements IndexList<E>
{

    private E[] A;   		// armazena os elementos do vetor
    private int capacity;	// capacidade do vetor
    private int size;		// tamanho do vetor
    private int count;          // conta as comparações do InsertionSort
    private int count2;         // contas as comparações do MergeSort
    
    /**
     * Retorna o valor de comaparações armazenada na variável count
     */
    public int getCount() 
    {
        return count;
    }

    /**
     * Retorna o valor de comaparações armazenada na variável count2
     */
    public int getCount2() 
    {
        return count2;
    }
    
    /**
     * Retorna a capacidade do vetor.
     */
     public int getCapacity() 
     {
        return capacity;
    }

    public Vector(int capacity) 
    {
        // implementação da operação empty, que cria um vetor com certa capacidade
        A = (E[]) new Object[capacity];
        this.capacity=capacity;
        size=0;
    }
    
    public Vector (E[] A, int capacity, int size)
    {
        this.A=A;
        this.capacity=capacity;
        this.size=size;
    }
    
    public Vector (E[] A,  int size)
    {
        this.A=A;
        this.size=size;
    }

    @Override
    public boolean isEmpty() 
    {
       return size==0;
    }

    @Override
    public int size() 
    {
        return size;
    }

    @Override
    public E get(int i) throws ArrayIndexOutOfBoundsException 
    {
        return A[i];
    }

    @Override
    public E set(int i, E e) throws ArrayIndexOutOfBoundsException
    {
        E obj=A[i];
        A[i]=e;
        return obj;
    }

    @Override
    public void add(int i, E e) throws ArrayIndexOutOfBoundsException 
    {
        if (size==capacity){ // Se há estouro da capacidade, aloca mais espaço
            E[] obj = (E[]) new Object[2*capacity];
            for(int j=0;j<size;j++) // Copia valores do antigo vetor
                obj[j]=A[j];
            A=obj;
        }
        for (int j=size-1;j>=i;j--)
            A[j+i]=A[j];
        A[i]=e;
        size++;
            
    }
    
    

    @Override
    public void remove(int i) throws ArrayIndexOutOfBoundsException 
    {
        for(int j=i;j<=size-2;j++)
            A[j]=A[j+1];
        size--;
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone()
            throws CloneNotSupportedException 
    {
        E []obj = (E[]) new Object[capacity];
        for(int i=0;i<size;i++) obj[i]=A[i];
        Vector v = new Vector(obj,capacity,size);
        return v;
    }

    public E[] getArray() 
    {
        return A;
    }
    
    private int binarySearch(E e, int low, int high) 
    {
        if (low>high)  // Elemento não encontrado
            return -1;
        int mid=(low+high)/2;
        if (A[mid].equals(e))
            return mid;
        else if (((Comparable) e).compareTo(A[mid])<0)
                return binarySearch(e,low,mid-1);
             else return binarySearch(e,mid+1,high);
    }
    
    
    /**
     * Faz a intercalação dos dois vetores,ordenando-os e adicionando os elementos
     * ordenados no terceiro vetor.
     */
    private void merge(Vector<E> S1, Vector<E> S2, Vector<E> S)
    {
        int i=0, j=0, k = 0;
        
        while((i<S1.size()) && (j<S2.size()))
        {
            this.count2+=1;
            if(((Comparable)S1.get(i)).compareTo(S2.get(j))<=0)
            {
                this.count2+=1;
                S.set(k,S1.get(i));
                i=i+1;  
            }
            else
            {
                S.set(k,S2.get(j));
                j=j+1;
                this.count2+=1;                
            }
            k++;
        }
        
        while(i<S1.size())
        {
            S.set(k,S1.get(i));
            i=i+1;
            k++;
            this.count2+=1;
        }
        
        while(j<S2.size())
        {
            S.set(k,S2.get(j));
            j=j+1;
            k++;
            this.count2+=1;
        }
  
    }

    public int indexOf(E e) 
    {
        return binarySearch(e,0,size-1);
    }
    
          
    /**
     * Este método faz a ordenação do vetor baseado no algoritmo
     * InsertionSort.
     */
    public void InsertionSort()
    {
        for(int i=0;i<size;i++)
        {
            E cur=A[i];
            int j=i-1;
            
            while((j>=0) && ((Comparable)A[j]).compareTo(cur)>0)
            {
                this.count+=1;
                A[j+1]=A[j];
                j=j-1;
                
            }
            A[j+1]=cur;   
        }
               
    }
    
    /**
     * Este método atribui os valores a um novo vetor,mediante os 
     * índices passados.
     */
    public Vector<E> subVector(int i,int j)
    {
        E[] B = (E[]) new Object[(j-i)+1];
        
        for (int k = 0; k < B.length; k++, i++) {
            B[k] = A[i];
        }
        
        Vector T = new Vector(B,B.length);
        
        return T;
        
    }
    
    /**
     * Este método ordena o vetor baseado no algoritmo MergeSort
     */
    public void sort()
    {
        if(this.size>1)
        {
            int Index = (A.length-1)/2;
            Vector<E> S1 = subVector(0,Index);
            Vector<E> S2 = subVector(Index+1,A.length-1);
        
            S1.sort();
            S2.sort();
        
            merge(S1,S2,this);
        }
        
    }

   

    
    
}
