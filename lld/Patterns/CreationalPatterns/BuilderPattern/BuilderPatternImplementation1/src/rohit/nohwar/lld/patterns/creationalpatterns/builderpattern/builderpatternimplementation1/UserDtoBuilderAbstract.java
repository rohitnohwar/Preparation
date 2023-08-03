package rohit.nohwar.lld.patterns.creationalpatterns.builderpattern.builderpatternimplementation1;

public interface UserDtoBuilderAbstract {
    public UserDtoBuilderAbstract fillFirstName(String firstName);
    public UserDtoBuilderAbstract fillLastName(String lastName);
    public UserDtoBuilderAbstract fillAge(int age);

    public UserDtoAbstract build();
}
