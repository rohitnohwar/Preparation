package rohit.nohwar.lld.creationdesignpatterns.builderpattern.implementation2;

public class Client {
    private static UserDto directBuild(UserDto.UserDtoBuilder builder, String firstName, String lastName, int age) {
        return builder.fillFirstName(firstName).fillLastName("Nohwar").fillAge(23).build();
    }
    public static void main(String args[]) {
        UserDto userDtoCreatedByBuilderPattern = directBuild(UserDto.getBuilder(), "Rohit", "Nohwar", 23);
        System.out.println("User first name:- "+userDtoCreatedByBuilderPattern.getFirstName());
        System.out.println("User last name:- "+userDtoCreatedByBuilderPattern.getLastName());
        System.out.println("User age:- "+userDtoCreatedByBuilderPattern.getAge());
        UserDto userDtoCreatedByBuilderPattern2 = UserDto.getBuilder().fillFirstName("Ro").fillLastName("No").build();
        System.out.println("User first name:- "+userDtoCreatedByBuilderPattern2.getFirstName());
        System.out.println("User last name:- "+userDtoCreatedByBuilderPattern2.getLastName());
        System.out.println("User age:- "+userDtoCreatedByBuilderPattern2.getAge());

    }
}
