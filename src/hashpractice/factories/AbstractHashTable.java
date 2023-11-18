package hashpractice.factories;

import hashpractice.Lista;


public abstract class AbstractHashTable<Key, Value> 
{
    protected Lista<Entrada<Key, Value>> [] array;
    private int size;
    protected int collisions;
    
    AbstractHashTable(int size)
    {
        array = new Lista[size];
        collisions = 0;
    }
    
    public int size()
    {
        return size;
    }
    
    public int collisions(){
        return collisions;
    }
    
    public Lista<Entrada<Key, Value>> [] getArray()
    {
        return array;
    }
    
    public abstract void put(Key llave, Value valor);
    public abstract Value search(Key llave);
    public abstract boolean delete(Key llave);
}
