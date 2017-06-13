package FileSystem;

class File implements Basic{
    private String name;
    private int size;
    private int level;


    public File(String name, int size) {
         check(size);
         this.name = name;

         this.size = size;
     }

    private void check(int value){
        if(value <= 0){
            throw new IllegalArgumentException("Value should be more than 0");
        }
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", level=" + level +
                '}';
    }
}
