
package hashpractice;

public class Lista<T> 
{
    private Nodo<T> first;
    private int size;
    
    public Lista(){
        size = 0;
    }
    
    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public boolean add(T value)
    {
        if(size == 0)
        {
            return addFirst(value);
        }
        return addLast(value);
    }
    
    public boolean addFirst(T value)
    {
        Nodo<T> nuevoFirst = new Nodo(value);
        nuevoFirst.setNext(first);
        first = nuevoFirst;
        size++;
        return true;
    }
    
    public boolean addLast(T value)
    {
        if(size == 0) return addFirst(value);
        Nodo<T> last = searchByIndex(size-1);
        last.setNext(new Nodo(value));
        size++;
        return true;
    }
    
    private Nodo<T> searchByIndex(int index)
    {
        Nodo<T> piv = first;
        for(int i = 0; i < index; i++)
        {
            piv = piv.getNext();
        }
        return piv;
    }
    
    public T get(int index)
    {
        if(size == 0) return null;
        return searchByIndex(index).getValue();
    }
    
    public T remove(int index)
    {
        if(size == 0) return null;
        
        if(index == 0)
        {
            return removeFirst();
        }
        
        if(index == size-1)
        {
            return removeLast();
        }
        
        Nodo<T> previoAlEliminar = searchByIndex(index-1);
        Nodo<T> nodoAEliminar = previoAlEliminar.getNext();
        
        previoAlEliminar.setNext(nodoAEliminar.getNext());
        
        size--;
        return nodoAEliminar.getValue();
    }
    
    public T removeLast()
    {
        Nodo<T> previoAlEliminar = searchByIndex(size-2);
        Nodo<T> nodoAEliminar = previoAlEliminar.getNext();
        previoAlEliminar.setNext(null);
        size--;
        return nodoAEliminar.getValue();
    }
    
    public T removeFirst()
    {
        if(size == 0) return null;
        
        T valor = first.getValue();
        
        first = first.getNext();
        
        size--;
        
        return valor;
    }
    
    @Override
    public String toString()
    {
        if(size == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Nodo<T> piv = first;
        while(piv.getNext() != null)
        {
            sb.append(piv.getValue()).append(", ");
            piv = piv.getNext();
        }
        sb.append(piv.getValue()).append("]");
        return sb.toString();
    }
}
