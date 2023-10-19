package rohit.nohwar.lld.structuralpatterns.chainofresponsibiltypattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        processorInterface tenPowerProcessor = new TenPowerProcessor(null);
        processorInterface fivePowerProcessor = new FivePowerProcessor(tenPowerProcessor);

        fivePowerProcessor.process(4);
        fivePowerProcessor.process(8);
        fivePowerProcessor.process(13);
    }
}