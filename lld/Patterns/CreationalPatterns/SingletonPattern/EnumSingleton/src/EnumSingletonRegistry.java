public enum EnumSingletonRegistry {
    INSTANCE;
    public void a() {
        System.out.println("hmm");
    }

    private EnumSingletonRegistry() {
        System.out.println("here");
    }
}
