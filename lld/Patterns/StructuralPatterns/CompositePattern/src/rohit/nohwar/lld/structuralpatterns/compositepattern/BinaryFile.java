package rohit.nohwar.lld.structuralpatterns.compositepattern;

import java.util.ArrayList;
import java.util.List;

public class BinaryFile extends AbstractFile{
    public String fileName;

    public BinaryFile(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void addFile(AbstractFile file) {
        throw new UnsupportedOperationException("Cant add files in binary file");
    }

    @Override
    public void deleteFile(AbstractFile file) {
        throw new UnsupportedOperationException("Cant remove files in binary file");
    }

    @Override
    public List<AbstractFile> getChildren() {
        throw new UnsupportedOperationException("Cant get children files in binary file");
    }
}
