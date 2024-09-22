
public abstract class Chef {
    Chef chef;

    public Chef setSuccesor(Chef chef){
        this.chef = chef;
        return this;
    }

    public abstract void pedido(String pedido);
}
