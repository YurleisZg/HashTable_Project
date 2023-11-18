package hashpractice.factories;

public class Entrada<Key, Value>
{
    private Key llave;
    private Value valor;
    
    public Entrada(Key llave, Value valor)
    {
        this.llave = llave;
        this.valor = valor;
    }

    public Key getLlave() {
        return llave;
    }

    public void setLlave(Key llave) {
        this.llave = llave;
    }

    public Value getValor() {
        return valor;
    }

    public void setValor(Value valor) {
        this.valor = valor;
    }
    
    
}
