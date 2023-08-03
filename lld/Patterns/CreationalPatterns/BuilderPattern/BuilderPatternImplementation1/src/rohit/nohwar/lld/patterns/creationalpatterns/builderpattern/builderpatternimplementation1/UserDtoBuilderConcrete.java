package rohit.nohwar.lld.patterns.creationalpatterns.builderpattern.builderpatternimplementation1;

public class UserDtoBuilderConcrete implements UserDtoBuilderAbstract {
    private UserDtoConcrete userDto;

    private String firstName;
    private String lastName;
    private int age;



    public UserDtoBuilderAbstract fillFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public UserDtoBuilderAbstract fillLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public UserDtoBuilderAbstract fillAge(int age) {
        this.age = age;
        return this;
    }

    public UserDtoAbstract build(){
        userDto = new UserDtoConcrete(firstName, lastName, age);
        return userDto;
    }
}
