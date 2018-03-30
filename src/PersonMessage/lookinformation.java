package PersonMessage;


import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;

import DBJavaBean.DB;
import JavaBean.MyMessBean;
import javassist.bytecode.Descriptor.Iterator;
import webCl.SqlCon;
import webCl.User;
import webCl.CSDN;
import webCl.Main;
import webCl.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
 
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ognl.OgnlValueStack;

public class lookinformation extends ActionSupport{
  private String email;
  private String password;
  public HttpServletRequest request;
  public String newsmail;
  public ResultSet result1;
  public ResultSet result2;
  ArrayList listName =null;
  DB Mysql = new DB();
  public ResultSet result10010;
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String mainhref()
  {
    String Str =null;
    result10010 = Mysql.selectMess(request,email);
    //System.out.println(email);
    Str="success";
    return Str;
  }
  
  
  public String helphref()
  {
    String Str =null;
    result10010 = Mysql.selectMess(request,email);
    //System.out.println(email);
    Str="success";
    return Str;
  }
  
  public String getinformation(){
    
    result1 = Mysql.selectMess(request,email);
    String Str = myMessage(request,email);
    return Str;
  }
  
  public String getmaininformation(){
    
    result1 = Mysql.selectMess(request,email);
    String Str = myMessagemain(request,email);
    return Str;
  }
  
  public String news(){
    
    result1 = Mysql.selectMess(request,email);
    String Str = mynews(request,email);
    //String Str = shownews();
    return Str;
  }
  
//  public String shownews() {
//    String s_crawWeb = webCl.Main.crawlWeb();
//    if (s_crawWeb.equals("error")) {
//      return "error";
//    }
//    newsmail=show();
//    //request.setAttribute("bmhbean", newsmail);
//    
//    return "success";
//  }
  public static void main(String[] args) {
    String a=show();
    System.out.println(a);
 }
  
  public static String show() {
    String s_crawWeb = webCl.Main.crawlWeb();
    if (s_crawWeb.equals("error")) {
      return "error";
    }
    String sql = "select * from urlsdb.mails order by mails";
    Connection conn = SqlCon.con();
    User curSendUser = null;
    try {
      Statement statement = conn.createStatement();
      ResultSet rs = statement.executeQuery(sql);  
      String lastMail = "hh996896116@163.com";
      String mail;
      while (rs.next()) {
        mail = rs.getString("mails");
        if (!mail.equals(lastMail)) {
          if (curSendUser != null) {
            return curSendUser.ctt.toString();
          }
          curSendUser = new User(mail);
          lastMail = mail;
        }
        curSendUser.addCtt(rs.getString("url"));
      }
      if (curSendUser != null) {
        return curSendUser.ctt.toString();
      }
      rs.close(); 
      conn.close(); 
    } catch(SQLException e) {
      e.printStackTrace();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return curSendUser.ctt.toString();
  }
  public String getfriendinformation(){
    
    result1 = Mysql.selectMess(request,email);
    String Str = myMessagefriend(request,email);
    return Str;
  }
  
  public String myMessagemain(HttpServletRequest request,String mail)
  {
    try{
      
      //HttpSession session =request.getSession();
      listName=new ArrayList();     
      result1=Mysql.selectMessfriend(request,mail);
      //result2=Mysql.selectMessfriend2(request,mail);
      if(result1.next())
      {
        result1 = Mysql.selectMessfriend(request,mail);
        //result2 = Mysql.selectMessfriend2(request,mail);
        while(result1.next()){
          MyMessBean mess = new MyMessBean();
          //mess.setMail(result1.getString("usermail"));
          mess.setFriendmail(result1.getString("usermail"));
          //mess.setACfriend(result2.getString("friendmail"));
          //mess.setUrl(result1.getString("url"));
          //mess.setTag(result1.getString("tag"));
          //mess.setState(result1.getString("state"));
          //System.out.println(result1.getString("url"));
          listName.add(mess);
          //session.setAttribute("Message", listName);
        }
      }
      else{
        //session.setAttribute("Message", listName);
      }
      
        
     
      return "success"; 
    }catch(Exception e)
    {
      e.printStackTrace();
      return null;
    }  
  }
  
  public String mynews(HttpServletRequest request,String mail)
  {
    try{
      request = (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
      HttpSession session =request.getSession();
      //listName=new ArrayList();     
      //result1=Mysql.selectnews(request,mail);
      //result2=Mysql.selectMessfriend2(request,mail);
      //if(result1.next())
      //{
        //result1 = Mysql.selectnews(request,mail);
        //result2 = Mysql.selectMessfriend2(request,mail);
        //while(result1.next()){
          //MyMessBean mess = new MyMessBean();
          //mess.setMail(result1.getString("usermail"));
          //mess.setContt(newsmail);
          //mess.setACfriend(result2.getString("friendmail"));
          //mess.setUrl(result1.getString("url"));
          //mess.setTag(result1.getString("tag"));
          //mess.setState(result1.getString("state"));
          //System.out.println(result1.getString("url"));
          //listName.add(mess);
          newsmail=show();
          session.setAttribute("abc", newsmail);
        //}
//      }
//      else{
//        //session.setAttribute("Message", listName);
//      }
//      
        
     
      return "success"; 
    }catch(Exception e)
    {
      e.printStackTrace();
      return null;
    }  
  }
  
  
  public String myMessage(HttpServletRequest request,String mail)
  {
    try{
      
      //HttpSession session =request.getSession();
      listName=new ArrayList();     
      result1=Mysql.selectMess(request,mail);
      if(result1.next())
      {
        result1 = Mysql.selectMess(request,mail);
        while(result1.next()){
          MyMessBean mess = new MyMessBean();
          //mess.setMail(rs.getString("mail"));
          mess.setUrl(result1.getString("url"));
          mess.setTag(result1.getString("tag"));
          mess.setState(result1.getString("state"));
          //System.out.println(result1.getString("url"));
          listName.add(mess);
          //session.setAttribute("Message", listName);
        }
      }
      else{
        //session.setAttribute("Message", listName);
      }
      
        
     
      return "success"; 
    }catch(Exception e)
    {
      e.printStackTrace();
      return null;
    }  
  }
  
  public String myMessagefriend(HttpServletRequest request,String mail)
  {
    try{
      
      //HttpSession session =request.getSession();
      listName=new ArrayList();     
      result1=Mysql.selectMessfriend2(request,mail);
      if(result1.next())
      {
        result1 = Mysql.selectMessfriend2(request,mail);
        while(result1.next()){
          MyMessBean mess = new MyMessBean();
          mess.setFriendmail(result1.getString("friendmail"));
          //mess.setUrl(result1.getString("url"));
          //mess.setTag(result1.getString("tag"));
          //mess.setState(result1.getString("state"));
          System.out.println(result1.getString("friendmail"));
          listName.add(mess);
          //session.setAttribute("Message", listName);
        }
      }
      else{
        //session.setAttribute("Message", listName);
      }
      
        
     
      return "success"; 
    }catch(Exception e)
    {
      e.printStackTrace();
      return null;
    }  
  }
  
  
  public ArrayList getListName() {
    return listName;
  }
  public void setListName(ArrayList listName) {
    this.listName = listName;
  }
  public String getNewsmail() {
    return newsmail;
  }
  public void setNewsmail(String newsmail) {
    this.newsmail = newsmail;
  }
}
