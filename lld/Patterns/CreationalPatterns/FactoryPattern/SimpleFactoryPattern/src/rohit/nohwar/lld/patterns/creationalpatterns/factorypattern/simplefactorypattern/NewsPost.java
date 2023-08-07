package rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.simplefactorypattern;

public class NewsPost extends PostAbstractClass {
    private String newTitle;

    @Override
    public void setTitle(String newTitle) {
        this.newTitle = newTitle;
    }
}
