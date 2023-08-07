package rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.simplefactorypattern;

public class PostFactory {
    public static PostAbstractClass createPost(String post) {
        switch (post){
            case "news post":
                return new NewsPost();
            case "blog post":
                return new BlogPost();
            default:
                return null;
        }
    }
}
