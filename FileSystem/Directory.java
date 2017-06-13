package FileSystem;

import java.util.List;
import java.util.ArrayList;
import java.util.StringJoiner;


public class Directory implements Basic{

    private List<Basic> files = new ArrayList<Basic>();
    private String name;
    private int size;

    public Directory(String name) {
        this.size = 0;
        this.name = name;
    }

    public Directory(String name, Basic file) {
        this(name);
        add(file);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Directory add(Basic file) {
        files.add(file);
        return this;
    }


    @Override
    public int getSize() {
        this.size = 0;
        for (Basic file : files){
            size += file.getSize();
        }
        return size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        for (Basic file : files) {
                joiner.add(file.toString());
        }
        return "Directory "+ name + " :\n" + joiner.toString();
    }
}
