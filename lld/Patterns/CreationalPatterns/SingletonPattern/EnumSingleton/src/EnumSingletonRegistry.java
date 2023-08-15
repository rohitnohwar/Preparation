public enum EnumSingletonRegistry {
    INSTANCE;

    private EnumSingletonRegistry() {
        System.out.println("here");
    }
}
