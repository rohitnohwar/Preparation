package rohit.nohwar.lld.structuralpatterns.compositepattern;

import java.util.ArrayList;
import java.util.List;

public class Directory extends AbstractFile{
    public List<AbstractFile> children;
    String fileName;

    public Directory(String fileName) {
        this.fileName = fileName;
        children = new ArrayList<>();
    }

    @Override
    public void addFile(AbstractFile file) {
        if (file == this) {
            throw new UnsupportedOperationException("Cant add directory inside itself");
        }
        this.children.add(file);
    }

    @Override
    public void deleteFile(AbstractFile file) {
        this.children.remove(file);
    }

    @Override
    public List<AbstractFile> getChildren() {
        return children;
    }
}
