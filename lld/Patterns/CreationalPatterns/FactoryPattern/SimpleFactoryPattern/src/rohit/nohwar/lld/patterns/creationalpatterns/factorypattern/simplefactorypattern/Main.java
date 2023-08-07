package rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.simplefactorypattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        PostAbstractClass post1 = PostFactory.createPost("news post");
        PostAbstractClass post2 = PostFactory.createPost("blog post");

        System.out.println("post1 is of class:- " + post1.getClass());
        System.out.println("post2 is of class:- " + post2.getClass());
    }
}