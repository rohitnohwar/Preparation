public enum EnumSingletonRegistry {
    INSTANCE;
    public void a() {
        System.out.println("hmm");
    }

    EnumSingletonRegistry() {
        System.out.println("here");
    }
}
