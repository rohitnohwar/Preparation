package rohit.nohwar.lld.patterns.creationalpatterns.builderpattern.builderpatternimplementation1;

public class Client {
    private static UserDtoAbstract directBuild(UserDtoBuilderAbstract userDtoBuilder, String firstName, String lastName, int age) {
        return userDtoBuilder.fillFirstName(firstName).fillLastName(lastName).fillAge(23).build();
    }
    public static void main(String args[]) {
        UserDtoBuilderAbstract userDtoBuilder = new UserDtoBuilderConcrete();
        UserDtoAbstract userDtoCreatedByBuilderPattern = directBuild(userDtoBuilder, "Rohit", "Nohwar", 23);;
        System.out.println("User first name:- "+userDtoCreatedByBuilderPattern.getFirstName());
        System.out.println("User last name:- "+userDtoCreatedByBuilderPattern.getLastName());
        System.out.println("User age:- "+userDtoCreatedByBuilderPattern.getAge());
    }
}
