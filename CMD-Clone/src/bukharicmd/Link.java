
package bukharicmd;

public class Link {
    private String path;
    Link next;
    Link previous;
    Link(String path)
    {
        this.path=path;
    }
    public String getPath()
    {
        return(path);
    }
}
