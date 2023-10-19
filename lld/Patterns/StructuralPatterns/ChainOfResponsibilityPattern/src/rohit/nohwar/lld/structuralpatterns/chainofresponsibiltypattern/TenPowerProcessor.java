package rohit.nohwar.lld.structuralpatterns.chainofresponsibiltypattern;

public class TenPowerProcessor implements processorInterface{
    private processorInterface nextPowerfulProcessor;
    public TenPowerProcessor(processorInterface nextPowerfulProcessor) {
        this.nextPowerfulProcessor = nextPowerfulProcessor;
    }
    public void process(int resourcesRequired) {
        if (resourcesRequired <= 10) {
            System.out.println("processing by TenPowerProcessor");
        }
        else if(nextPowerfulProcessor != null) {
            nextPowerfulProcessor.process(resourcesRequired);
        }
        else {
            System.out.println("Can't process");
        }
    }
}
