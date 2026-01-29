
public interface battleObject<T> {
    public void attack(T target) throws InterruptedException;
    public void defend() throws InterruptedException;
    public void special(statClass target) throws InterruptedException;
    public boolean isDead() throws InterruptedException;
}