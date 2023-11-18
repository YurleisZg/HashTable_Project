
package hashpractice;

public class Nodo<T> 
{
   private T value;
   private Nodo<T> next;
   
   public Nodo(){
       
   }
   
   public Nodo(T value){
       this.value = value;
   }
   
   public Nodo(T value, Nodo<T> next){
       this(value);
       this.next = next;
   }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }
   
   
}
