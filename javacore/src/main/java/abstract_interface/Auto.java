package abstract_interface;

public abstract class Auto {
    protected void checkEngine() {
        System.out.println("ZZZZZZZZZZZZZZZZZZZZZZa");
    };

    public Auto() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
