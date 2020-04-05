package checkResult;


public abstract class Middleware {
    private Middleware next;

    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(boolean result);

    protected boolean checkNext(boolean result) {
        if(next == null) {
            return false;
        }

        return next.check(result);
    }

}
