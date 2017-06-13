package FileSystem;

public class FileSystemRunner {
    public static void main(String[] args) {

        Directory root = new Directory("root");

        root.add(new File("f5", 50));

        Directory dir1 = new Directory("dir1", new File("f1", 10));
        dir1.add(new File("f2", 20));

        root.add(dir1);

        Directory dir2 = new Directory("dir2", new File("f4", 40));
        dir2.add(new Directory("dir3", new File("f3", 30)));

        root.add(dir2);

        System.out.println(root);
    }
}
