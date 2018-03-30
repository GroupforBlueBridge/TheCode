package DomainMessage;


import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;

import DBJavaBean.DB;
import JavaBean.MyMessBean;
import javassist.bytecode.Descriptor.Iterator;


public class AddnewurlAction {
  private String email;
  private String UrlName;
  private String urlcode;
  private String rowid = null;
  private int rowid1;
 
  public String friendmail;
  public String Strresult;
  public ResultSet result2;
  private HttpServletRequest request;
  DB Mysql = new DB();
  //Â·¾¶µ¼Èëadd.jsp
  public String passhref()
  {
    String Str =null;
    result2 = Mysql.selectMess(request,email);
    //System.out.println(email);
    Str="success";
    return Str;
  }
  
  public String addfriend()
  {
    String Str =null;
    Str = Mysql.addfriend(request,email,friendmail);
    //System.out.println(email);
    Str="success";
    return Str;
  }
  
  public String askfriend()
  {
    String Str =null;
    Str = Mysql.askfriend(request,email,friendmail);
    //System.out.println(email);
    Str="success";
    return Str;
  }
  
  
  public String refusefriend()
  {
    String Str =null;
    Str = Mysql.refusefriend(request,email,friendmail);
    //System.out.println(email);
    Str="success";
    return Str;
  }
  //addmessage Action
  public String addmess()
  {
    String sure = null;
    DB Mysql = new DB();   
    //System.out.println(UrlName);
    //System.out.println(urlcode);
    //System.out.println(rowid1);
    //System.out.println(email);
    rowid = email+urlcode+UrlName;
    sure = Mysql.inserturl(request,email,UrlName,urlcode,rowid);
    //sure = "success"; 
    return sure;
  }
  
  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public String getUrlName() {
    return UrlName;
  }


  public void setUrlName(String urlName) {
    UrlName = urlName;
  }


  public String getUrlcode() {
    return urlcode;
  }


  public void setUrlcode(String urlcode) {
    this.urlcode = urlcode;
  }


  public String getRowid() {
    return rowid;
  }


  public void setRowid(String rowid) {
    this.rowid = rowid;
  }


  public int getRowid1() {
    return rowid1;
  }


  public void setRowid1(int rowid1) {
    this.rowid1 = rowid1;
  }

  public String getFriendmail() {
    return friendmail;
  }

  public void setFriendmail(String friendmail) {
    this.friendmail = friendmail;
  }
}
