public class UserDto {
    private String firstName;

    private String lastName;
    private int age;

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public static UserDtoBuilder getBuilder() {
        return new UserDtoBuilder();
    }

    public static class UserDtoBuilder {
        private String firstName;
        private String lastName;
        private int age;

        private UserDto userDto = new UserDto();

        public UserDtoBuilder fillFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserDtoBuilder fillLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserDtoBuilder fillAge(int age) {
            this.age = age;
            return this;
        }

        public UserDto build() {
            userDto.firstName = this.firstName;
            userDto.lastName = this.lastName;
            userDto.age = this.age;
            return userDto;
        }
    }
}


