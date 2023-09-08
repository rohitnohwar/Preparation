package rohit.nohwar.lld.structuralpatterns.compositepattern;

import java.util.List;

public abstract class AbstractFile {
    public abstract void addFile(AbstractFile file);
    public abstract void deleteFile(AbstractFile file);
    public abstract List<AbstractFile> getChildren();
}
