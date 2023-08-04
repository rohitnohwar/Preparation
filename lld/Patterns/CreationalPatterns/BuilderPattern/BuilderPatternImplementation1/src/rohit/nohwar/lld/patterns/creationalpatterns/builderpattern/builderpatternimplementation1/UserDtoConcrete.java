package rohit.nohwar.lld.patterns.creationalpatterns.builderpattern.builderpatternimplementation1;

public class UserDtoConcrete implements UserDtoAbstract {
    private String firstName;
    private String lastName;
    private int age;

    public UserDtoConcrete(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
