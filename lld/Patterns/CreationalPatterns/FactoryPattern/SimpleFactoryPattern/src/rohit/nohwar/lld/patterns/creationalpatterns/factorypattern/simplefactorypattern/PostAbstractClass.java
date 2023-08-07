package rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.simplefactorypattern;

public abstract class PostAbstractClass {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public abstract void setTitle(String title);
}
