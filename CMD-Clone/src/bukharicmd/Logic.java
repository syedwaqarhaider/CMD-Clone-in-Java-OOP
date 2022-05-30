
package bukharicmd;

import java.io.File;

public class Logic   {
    File f;
    LinkedList ls=new LinkedList();
    public String OpenInitialPath(String path)
    {
        f=new File(path);
        ls.insertLast(path);
        
        return(path+"\\>");
    }
    public String driveCommand(String path)
    {
        String now = null;
        int body1=0,body2=0,body3=0;
        if(path.equals("D:") || path.equals("C:")|| path.equals("E:")||path.equals("F:")||path.equals("G:")||path.equals("H:")||path.equals("I:")
                ||path.equals("J:")||path.equals("K:"))
        {
            f=new File(path);
           
            if( f.exists())
            {
                body1++;
                now= OpenInitialPath(path);
            }
            else
            {
                body2++;
            }
        }
        else
        {
            body3++;
        }
        if(body1>0)
        {
            return now;
        }
        else if(body2>0)
        {
            return ("Drive By this Name Not Found");
        }
        else
        {
        return ("Invalid Command");
        }
        
    }
    public String getPath()
    {
        return(ls.getLastPath());
    }
    public int directoryChanged(String cdName)
    {
       cdName=getPath()+"\\"+cdName;
        System.out.println(cdName);
        f= new File(cdName);
        if(f.exists())
        {
            if(f.isDirectory())
            {
                ls.insertLast(cdName);
                return 0;
            }
            else
            {
                return 1;
            }
        }
        else
        {
          return 2;    
        }
        
    }
    public void goPrevious()
    {
        ls.pop();
    }
    
}
