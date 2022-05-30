
package bukharicmd;

import java.io.File;

public class LinkedList {
    Link first;
    Link last;
    LinkedList()
    {
        first=null;
        last=null;
    }
    public void insertLast(String path)
    {
        Link newLink=new Link(path);
        if(first==null)
        {
            first=newLink;
            newLink.previous=null;
            last=newLink;
            first.next=null;
        }
        else
        {
            last.next=newLink;
            newLink.next=null;
            newLink.previous=last;
            last=newLink;
        }
        Link current =first;
        while(current !=null)
        {
            System.out.println(current.getPath());
            current=current.next;
        }
        
    }
    public String getLastPath()
    {
        return(last.getPath());
    }
    public void pop()
    {
        if(first !=last)
        {
        last=last.previous;
        last.next=null;
        }
        
    }
    
}
