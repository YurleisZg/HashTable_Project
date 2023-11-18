package hashpractice.factories;


public class HashTablesFactory<Key, Value> 
{
    
    public AbstractHashTable<Key, Value> getHashTable(int tipo, int size){
        if(tipo != 1 && tipo != 2){
            throw new IllegalArgumentException("Tipo " +  tipo + " de Hashtable no valido.");
        }
        if(tipo == 1){
            return new HashTableFunc1(size);
        }
        return new HashTableFunc2(size);
    }
}
