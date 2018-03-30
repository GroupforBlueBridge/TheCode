package webCl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class News163 {
	private String sec_add; //domestic
	private String date_time;
	private static String charset = "gbk";
	News163(String sec_add) {
		this.sec_add = sec_add;
	}
	private String htmlS(String sec_add) {
		return WebC.httpRequest("http://news.163.com/" + sec_add, charset);
	}
	public String saveCtt() {
		
		String sql = "select * from urlsdb.urls where url = " + "'http://news.163.com/" + sec_add + "'";
		Connection conn = SqlCon.con();
		boolean existThis = false;
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);  
			while (rs.next()) {
				existThis = true;
				date_time = rs.getString("cur");
			}
			rs.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		StringBuffer ctt = new StringBuffer();
		String html = htmlS(sec_add);
		Main.textWrite("html.txt", html);
        Pattern p = Pattern.compile("<h3>\r\n" + 
        		"                    <a href=\"((.*?)(.{7}).html)\">(.*?)</a>\r\n" + 
        		"                </h3>");
        Matcher m = p.matcher(html);
        Pattern p_title = Pattern.compile("<title>(.*?)</title>");
        Matcher m_title = p_title.matcher(html);
        while (m_title.find()) {
        	ctt.append(m_title.group(1) + "<hr>");
        	//System.out.println("ssss" + m_title.group(1));
        }
        String max_d = "0";
        while (m.find()) {
        	String href = m.group(1);
        	String t_tile = m.group(4);
        	String t_time = m.group(3);
        	//String b = m.group(4);
        	//System.out.println(href);
        	//System.out.println(t_tile);
        	//new
        	if (date_time != null && t_time.compareTo(date_time) < 0) {
            continue;
          }
        	ctt.append( "<a href='" + href + "'>" +  t_tile + "</a><br>");
        	if ((max_d.compareTo(t_time) < 0)) {
            max_d = t_time;
            System.out.println(max_d);
          }
        	//new
        	//ctt.append( "<a href='" + href + "'>" +  t_tile + "</a><br>");
        }
        date_time = max_d;
        conn = SqlCon.con();
		String nsvCtt = Main.filterUtf8mb4(ctt.toString());
		//String svCtt = Main.filterUtf8mb4("");
		//String svCtt = "bbbbbbbbbbbaa";
		Main.textWrite("svC.html", nsvCtt);
		String svUrl = "http://news.163.com/" + sec_add;
		String svCur = date_time;
		System.out.println(ctt);
		try {
			PreparedStatement statement;// = conn.prepareStatement(sql);
			if (existThis) {
			  System.out.println("fffff");
				sql = "UPDATE `urlsdb`.`urls` SET `contt`=?, `cur`=? WHERE `url`=?";
				statement = conn.prepareStatement(sql);
				statement.setString(1, nsvCtt);
				statement.setString(2, svCur);
				statement.setString(3, svUrl);
				Statement statement1 = conn.createStatement();
	      ResultSet rs = statement1.executeQuery("select * from urlsdb.urls");  
	      while (rs.next()) {
	        System.out.println(rs.getString("cur"));
	      }
	      rs.close();
			} else {
			  System.out.println("eee");
				sql = "INSERT INTO `urlsdb`.`urls` (`url`, `contt`, `cur`) VALUES (?, ?, ?)";
				statement = conn.prepareStatement(sql);
				statement.setString(1, svUrl);
				statement.setString(2, nsvCtt);
				statement.setString(3, svCur);
			}
			statement.executeUpdate();
			System.out.println("ss");
			conn.close(); 
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
        
        return "su";
	}
}
