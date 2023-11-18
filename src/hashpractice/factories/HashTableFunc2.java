package hashpractice.factories;

import hashpractice.Lista;

/**
 
 * @param <Key>
 * @param <Value>
 */
public class HashTableFunc2<Key, Value> extends AbstractHashTable<Key, Value> 
{
    HashTableFunc2(int size){
        super(size);
    }
    
    @Override
    public void put(Key llave, Value valor) {
        int hash = llave.hashCode() % array.length;
        
       
        
        if(array[hash] == null){
            array[hash] = new Lista();
        }
        
        for(int i = 0; i < array[hash].size(); i++){
            if(array[hash].get(i).getLlave().equals(llave)){
                array[hash].get(i).setValor(valor);
                return;
            }
        }
        
        array[hash].add(new Entrada(llave, valor));
        if(array[hash].size() > 1){
            collisions += 1;
        }
    }

    @Override
    public Value search(Key llave) {
        int hash = llave.hashCode() % array.length;
        
        if(array[hash] == null) return null;
        
        for(int i = 0; i < array[hash].size(); i++)
        {
            if(array[hash].get(i).getLlave().equals(llave)){
                return array[hash].get(i).getValor();
            }
        }
        
        return null;
    }

    @Override
    public boolean delete(Key llave) {
        int hash = llave.hashCode() % array.length;
        
        if(array[hash] == null) return false;
        
        for(int i = 0; i < array[hash].size(); i++)
        {
            if(array[hash].get(i).getLlave().equals(llave)){
                array[hash].remove(i);
                if(array[hash].size() > 0){
                    collisions--;
                }
                return true;
            }
        }
        
        return false; 
    }
    
}
