package mvcpatternmainfile.Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.Label;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahir
 */
public class DBmodel {
    protected boolean validcheck(String x){
        char [] a=x.toCharArray();
        boolean y=false;
        boolean z=false;
        for(int i=0;i<a.length;i++){
            if(Character.isUpperCase(a[i])){
                y=true;
            }
            if(Character.isDigit(a[i])){
                z=true;
            }
            if(y&&z){
                break;
            }
        
        }
        return y&&z;
    }
    public void accinsertdb(String n,String p, Label swarning3, Label ssuccess) throws Exception{
        boolean flag = true;
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\BRAC stuff\\Summer2020\\CSE470\\Project\\MVCPatternMainFile\\gamedb.db");
        Statement st = con.createStatement();
        Statement st2 = con.createStatement();
        Statement st3 = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT Name FROM playerinfo");
        while(rs.next()){
            if(n.equals(rs.getString("Name"))){
                swarning3.setVisible(true);
                flag=false;
                break;
            }
        }
        if(flag){
            swarning3.setVisible(false);
            ssuccess.setVisible(flag);
            String x=""+p.hashCode();
            String def = "0.0";
            st2.executeUpdate("INSERT INTO playerinfo VALUES ('"+n+"','"+x+"','"+def+"','"+def+"','"+def+"','"+def+"','"+def+"','"+def+"','"+def+"','"+def+"');");
            st3.executeUpdate("INSERT INTO passcheck VALUES ('"+n+"','"+x+"');");
        }
        rs.close();
        st.close();
        st2.close();
        st3.close();
        con.close();
    }
    public void forgetpassdb(String n,String p,Label fwarning1,Label fsuccess) throws Exception{
        boolean flag = true;
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\BRAC stuff\\Summer2020\\CSE470\\Project\\MVCPatternMainFile\\gamedb.db");
        Statement st = con.createStatement();
        Statement st2 = con.createStatement();
        Statement st3 = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM passcheck where Name = '"+n+"'");
        String x=""+p.hashCode();
        while(rs.next()){
            if(x.equals(rs.getString("Pass"))){
                fwarning1.setVisible(true);
                flag=false;
                break;
            }
        }
        if(flag){
            fwarning1.setVisible(false);
            fsuccess.setVisible(flag);
            st2.executeUpdate("UPDATE playerinfo SET Pass ='"+x+"' WHERE Name ='"+n+"';");
            st3.executeUpdate("INSERT INTO passcheck VALUES ('"+n+"','"+x+"');");
        }
        rs.close();
        st.close();
        st2.close();
        st3.close();
        con.close();
    }
    public boolean loginuserdb(String n,String p, Label lsuccess,Label lwarning) throws Exception{
        boolean flag = true;
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\BRAC stuff\\Summer2020\\CSE470\\Project\\MVCPatternMainFile\\gamedb.db");
        Statement st = con.createStatement();
        Statement st2 = con.createStatement();
        Statement st3 = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM playerinfo");
        String x=p.hashCode()+"";
        while(rs.next()){
            if(n.equals(rs.getString("Name")) && x.equals(rs.getString("Pass"))){
                lsuccess.setVisible(true);
                flag=false;
                break;
            }
        }
        if(flag){
            lsuccess.setVisible(false);
            lwarning.setVisible(true);
        }
        rs.close();
        st.close();
        st2.close();
        st3.close();
        con.close();
        return !flag;
    }
    
    public boolean usernameexists(String x)throws Exception{
        boolean flag = true;
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\BRAC stuff\\Summer2020\\CSE470\\Project\\MVCPatternMainFile\\gamedb.db");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT Name FROM playerinfo");
        while(rs.next()){
            if(x.equals(rs.getString("Name"))){
                flag=false;
                break;
            }
        }
        rs.close();
        st.close();
        con.close();
        return flag;
    }
    public int signupmethod(String p,String cp){
        boolean x=validcheck(p);
        if(p.length()<8 || !(x)){
           int y=0;
           if(p.length()<8){
           y=1;
           }
           else if(!(x)){
           y=4;
           }
           return y;
        }
        else if(!(p.equals(cp))){
           return 2;
        }
        else{
           return 3;
        }
    }
    public void setUserName(String x, String currentuser){
        currentuser = x;
    }
    public void setData(GameObject ally,GameObject player, String currentuser){
        try{
         Class.forName("org.sqlite.JDBC");
         Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\BRAC stuff\\Summer2020\\CSE470\\Project\\MVCPatternMainFile\\gamedb.db");
         Statement set = con.createStatement();
         set.executeUpdate("UPDATE playerinfo SET allyposx='"+ally.getView().getTranslateX()+"',allyposy='"+ally.getView().getTranslateY()+"', playerposx='"+player.getView().getTranslateX()+"', playerposy='"+player.getView().getTranslateY()+"', playervx='"+player.getVelocity().getX()+"', playervy='"+player.getVelocity().getY()+"', playerax='"+player.accy+"', playeray='"+ player.accy+"' WHERE Name ='"+currentuser+"'");
         set.close();
         con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
