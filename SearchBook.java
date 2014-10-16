package action;

/**
 * Created by xiaomin on 2014/10/7.
 */

import bean.Bookbean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.Map;


public class SearchBook extends ActionSupport
{
   private String ISBN;
   private String title;
   private String author;
   private String publisher;
    public String execute()
    {
        int m=0;
        String w=" where ";
        if(ISBN.equals(""))
        {
           m++;
        }
        else {
            w+="ISBN="+"\""+ISBN+"\"";

        }

        if(title.equals(""))
        {
            m++;
        }
        else {
            if(m<1)
            {
                w += " and ";
            }
            w+=" title="+"\""+title+"\" ";
        }
        if(author.equals(""))
        {
            m++;

        }
        else
        {
            if(m<2)
            {
                w += " and ";
            }
            w+="author="+"\""+author+"\"";
        }
        if(publisher.equals(""))
        {
            m++;
        }
        else
        {
            if(m<3)
            {
                w += " and ";
            }
            w+="publisher="+"\""+publisher+"\"";
        }
        if(m>=4)
        {
            String msg="查询信息不能全为空.";
            String msg1="/search.jsp";
            ActionContext context=ActionContext.getContext();
            Map request=(Map)context.get("request");
            request.put("msg",msg);
            request.put("msg1",msg1);
            return "error";
        }
      /*  ISBN="*";
        title="*";
        author="*";
        publisher="*";*/
        String sql="select * from books"+w;


     // String  sql="select * from books where author="+"\""+"Stephen King"+"\"";
        Bookbean book=new Bookbean();
       // System.out.println("dfsaf");
        ArrayList books=book.searchBook(sql);
        ActionContext context=ActionContext.getContext();
        Map session=(Map)context.getSession();
        session.put("searchresult",books);


     return "success";
    }
    public void setISBN(String ISBN)
    {
        this.ISBN=ISBN;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }
    public void setAuthor(String author)
    {
        this.author=author;
    }
    public void setPublisher(String publisher)
    {
        this.publisher=publisher;
    }
    public String getISBN()
    {
        return ISBN;
    }
    public String getTitle()
    {
        return title;
    }
    public String getAuthor()
    {
        return author;
    }
    public String getPublisher()
    {
        return publisher;
    }


}

