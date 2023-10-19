package rohit.nohwar.lld.structuralpatterns.chainofresponsibiltypattern;

public class FivePowerProcessor implements processorInterface{
    private processorInterface nextPowerfulProcessor;
    public FivePowerProcessor(processorInterface nextPowerfulProcessor) {
        this.nextPowerfulProcessor = nextPowerfulProcessor;
    }
    public void process(int resourcesRequired) {
        if (resourcesRequired <= 5) {
            System.out.println("processing by FivePowerProcessor");
        }
        else if(nextPowerfulProcessor != null) {
            nextPowerfulProcessor.process(resourcesRequired);
        }
        else {
            System.out.println("Can't process");
        }
    }
}
