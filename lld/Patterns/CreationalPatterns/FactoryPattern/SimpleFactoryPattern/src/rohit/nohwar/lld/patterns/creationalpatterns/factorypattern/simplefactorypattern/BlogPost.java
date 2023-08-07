package rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.simplefactorypattern;

public class BlogPost extends PostAbstractClass{
    private String blogTitle;

    @Override
    public void setTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }
}
