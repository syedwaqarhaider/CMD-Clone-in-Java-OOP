/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bukharicmd;

import com.sun.glass.events.KeyEvent;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author S.W.H.B
 */
public class BukhariCMD extends javax.swing.JFrame {
private int noOfCharacter=0;
Logic l= new Logic();
File f;
String tempData;
String []list;
String Message;
int fileIndex=0;
int i=0;
    public BukhariCMD() {
        initComponents();
        setIcon();
        setInitial();
        initialDirectory();
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt.setBackground(new java.awt.Color(0, 0, 0));
        txt.setColumns(20);
        txt.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        txt.setForeground(new java.awt.Color(255, 255, 255));
        txt.setRows(5);
        txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFocusGained(evt);
            }
        });
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFocusGained
       
    }//GEN-LAST:event_txtFocusGained

    private void txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
        String allText=txt.getText();
            int totalLen=allText.length();
            int Actual=totalLen-noOfCharacter;
            Message=allText.substring(Actual);
           
        }
        else if(evt.getKeyCode()==KeyEvent.VK_BACKSPACE)
        {
            if(noOfCharacter==0)
            {
                txt.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"), "none");
                txt.getInputMap().put(KeyStroke.getKeyStroke("UP"), "none");
                txt.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "none");
                
                
            }
            else if(noOfCharacter>0)
            {
                txt.getInputMap().remove(KeyStroke.getKeyStroke("BACK_SPACE"));
                
            }
        }
        else if(evt.getKeyCode()==KeyEvent.VK_LEFT)
        {
            if(noOfCharacter==0)
            {
                
                
                txt.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "none");
                
                
            }
            else if(noOfCharacter>0)
            {
                txt.getInputMap().remove(KeyStroke.getKeyStroke("LEFT"));
                
            }
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP)
        {
            txt.getInputMap().put(KeyStroke.getKeyStroke("UP"), "none");
                
         }
    }//GEN-LAST:event_txtKeyPressed

    private void txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            if(noOfCharacter>0)
            {
                // JOptionPane.showMessageDialog(null,  Message);
         
            if(Message.length()==2)
            {
                String path =l.driveCommand(Message);
                System.out.println(path);
                if(path.length()==4)
                {
                setPathCMD(path);
                }
                else
                {
                    txt.append(path);
                    setAgain();
                }
            }
            else if(Message.equals("cd.."))
            {
                back();
            }
            else if(Message.equals("cls"))
        {
            txt.setText("");
            setInitial();
            setAgain();
           
        }
            else if(Message.length()>2)
            {
                try {
                    otherCommands(Message);
                } catch (Exception ex) {
                    
                    txt.append("Invalid Command");
                    setAgain();
                }
            }
            }
            else
            {
                setAgain();
            }
            //noOfCharacter++;
        }
        else if(evt.getKeyCode()==KeyEvent.VK_ESCAPE||evt.getKeyCode()==KeyEvent.VK_F1||evt.getKeyCode()==KeyEvent.VK_F2
                ||evt.getKeyCode()==KeyEvent.VK_F3||evt.getKeyCode()==KeyEvent.VK_F4||evt.getKeyCode()==KeyEvent.VK_F5
                ||evt.getKeyCode()==KeyEvent.VK_F6||evt.getKeyCode()==KeyEvent.VK_F7||evt.getKeyCode()==KeyEvent.VK_F8
                ||evt.getKeyCode()==KeyEvent.VK_F9||evt.getKeyCode()==KeyEvent.VK_F10||evt.getKeyCode()==KeyEvent.VK_F11
                ||evt.getKeyCode()==KeyEvent.VK_F12||evt.getKeyCode()==KeyEvent.VK_HOME||evt.getKeyCode()==KeyEvent.VK_END
                ||evt.getKeyCode()==KeyEvent.VK_INSERT||evt.getKeyCode()==KeyEvent.VK_DELETE||evt.getKeyCode()==KeyEvent.VK_CAPS_LOCK
                ||evt.getKeyCode()==KeyEvent.VK_SHIFT||evt.getKeyCode()==KeyEvent.VK_CONTROL
                ||evt.getKeyCode()==KeyEvent.VK_WINDOWS||evt.getKeyCode()==KeyEvent.VK_ALT||evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN
                ||evt.getKeyCode()==KeyEvent.VK_PAGE_UP||evt.getKeyCode()==KeyEvent.VK_UP||evt.getKeyCode()==KeyEvent.VK_DOWN
                ||evt.getKeyCode()==KeyEvent.VK_LEFT|| evt.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            
        }
        else if(evt.getKeyCode()==KeyEvent.VK_TAB)
        {
          /*  f=new File(l.getPath());
            String [] file=f.list();
            if(file.length>fileIndex)
            {
            txt.append(file[fileIndex]);
            
            fileIndex++;
            }
            else
            {
            fileIndex=0;
            }*/
        }
        else if(evt.getKeyCode()==KeyEvent.VK_BACKSPACE)
        {
            if(noOfCharacter>0)
            {
                noOfCharacter--;
            }
            
        }
        else
        {
            noOfCharacter++;
            System.out.println(noOfCharacter);
        }
    }//GEN-LAST:event_txtKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BukhariCMD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BukhariCMD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BukhariCMD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BukhariCMD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BukhariCMD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        this.setTitle("Bukhari's Terminal");
      setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("cmd.png")));
    
    
    }

    private void setInitial() {
        txt.append("SODS Windows [Version 10.0.16299.371]\n"+
           "(c) 2018 SODS Corporation. All rights reserved.\n\n");
    }

    private void initialDirectory() {
     
     
        Path p= Paths.get("C:");
       String path=p.toString();
     
       path=l.OpenInitialPath(path);
        
       setPathCMD(path);
    }

    private void setPathCMD(String path) {
        
        txt.append("\n"+path);
         noOfCharacter=0;
         fileIndex=0;
    
        
    }
    private void setAgain()
    {
        txt.append("\n"+l.getPath()+"\\>");
        noOfCharacter=0;
        fileIndex=0;
    }
    private void setAgainDirectory()
    {
        
        txt.append("\n"+l.getPath()+"\\>");
        noOfCharacter=0;
    }
    private void otherCommands(String path) throws IOException
    {
        
        
        if(path.equals("list"))
        {
            f= new File(l.getPath());
            list=f.list();
            txt.append("\n");
            listFiles();
            i=0;
        }
        else if(path.equals("exit"))
        {
            System.exit(0);
        }
        else if(path.substring(0, 2).equals("cd"))
        {
            String cd=path.substring(3);
            System.out.println(cd);
            int lo=l.directoryChanged(cd);
            if(lo==1)
            {
                txt.append("\nGiven Name is not a Directory");
            }
            else if(lo==2)
            {
                txt.append("\nDirectory by This Name Not Exist");
            }
            setAgainDirectory();
        }
        else if(path.substring(0, 6).equals("search"))
        {
            String file=path.substring(7);
            System.out.println(file);
            file=l.getPath()+"\\"+file;
            f=new File(file);
            if(f.exists())
            {
                
                txt.append("\nName : "+f.getName()+""
                        +  "\nSize : "+f.getTotalSpace()+""
                        + "\nOrigen : "+f.getPath()
                        + "\nDirectory : "+f.isDirectory()
                        + "\nFile      : "+f.isFile()
                        + "\nHidden    : "+f.isHidden()+"\n");
            }
            else
            {
                txt.append("File By this Name Not Found");
            }
            setAgain();
        }
        else if(path.substring(0, 4).equals("open"))
        {
            
            
            boolean isNotFile=true;
            String file=l.getPath()+"\\"+path.substring(5);
            System.out.println(file);
            f=new File(file);
            if(f.exists())
            {
                if(f.isFile())
                {
                   setAgain(); 
                   Desktop d= Desktop.getDesktop();
                   
                   d.open(f);
                   isNotFile=false;
                  
                   
                }
                else
                {
                    txt.append("Sorry, Please Give a File Name");
                    
                }
            }
            
            else 
            {
                txt.append("File By This Name Not Exist");
            }
            if(isNotFile)
            {
            setAgain();
            }
        }
        else if(path.substring(0, 5).equals("mkdir"))
            {
                String file1=l.getPath()+"\\"+path.substring(6);
                System.out.println(file1);
                f =new File(file1);
                if(f.mkdir())
                {
                    txt.append("Directory Has Been Created");
                }
                else
                {
                    txt.append("Directory Already Exist");
                }
                setAgain();
            }
        else if(path.substring(0, 6).equals("delete"))
        {
            String file=l.getPath()+"\\"+path.substring(7);
            System.out.println(file);
            f=new File(file);
            if(!f.exists())
            {
                System.out.println("File or Directory Not Found");
                setAgain();
            }
            else
            {
                delete(f);
                setAgain();
            }
        }
        
        else
        {
            txt.append("\nInavalid Command");
            setAgain();
        }
        
        
            
           
        
            
    }
    public void back()
    {
         l.goPrevious();
            setAgain();
    }
    
    public void listFiles()
    {
        i++;
        if(list.length>i)
        {
        txt.append(list[i]+"\n");
        
        listFiles();
        
        }
        else
        {  
        setAgain();
        }
    }
    public void delete(File file)
    {
        if(file.isDirectory())
                {
                    if(file.list().length==0)
                    {
                        file.delete();
                    }
                    else
                    {
                        File fu[]=file.listFiles();
                        for(File fileDelete : fu)
                        {
                            delete(fileDelete);
                        }
                        if(file.list().length==0)
                        {
                            file.delete();
                        }
                    }
                }
        else
        {
            file.delete();
        }
    }
}