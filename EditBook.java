/*
package action;

*/
/**
 * Created by xiaomin on 2014/10/8.
 *//*

import bean.Bookbean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import sun.util.resources.cldr.te.CurrencyNames_te;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class EditBook extends ActionSupport{

   */
/* private String ISBN=null;
    private String title=null;
    private String author=null;
    private String publisher=null;
    private float price;
    private String date;
    private  String age;
    private String nation;

    public void setNation(String nation)
    {
        this.nation=nation;
    }
    public String getNation()
    {
        return nation;
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
    public  void setPrice(float price)
    {
        this.price=price;
    }
    public void setDate(String date)
    {
        this.date=date;
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
    public String getDate()
    {
        return date;
    }
    public float getPrice()
    {
        return price;
    }*//*



    public String execute()
    {

       */
/* String values=" title=\""+title+"\",author=\""+author+"\",publisher=\""+publisher+"\",price=\""+price+"\"," +
                "date=\""+date+"\",age=\""+age+"\",nation=\""+nation+"\" ";
        String sql="update books set "+values+" where ISBN=\""+ISBN+"\"";
        int result=0;
        Bookbean book=new Bookbean();
        ArrayList books=new ArrayList();
        ActionContext context=ActionContext.getContext();
        result=book.editBook(sql);
        String msg="";

        if(result!=0)
        {
            msg="修改成功";

            Map session=(Map)context.getSession();
            books=(ArrayList)session.get("searchresult");
            Iterator<Bookbean> bookListIterator=books.iterator() ;
            while(bookListIterator.hasNext())
            {
                Bookbean b=bookListIterator.next();
                if(b.getISBN().equals(ISBN))
                {
                    b.setNation(nation);
                    b.setTitle(title);
                    b.setPrice(price);
                    b.setAge(age);
                    b.setAuthor(author);
                    b.setDate(date);
                    b.setPublisher(publisher);
                    break;
                }
            }

        }
        else
        {
            msg="修改失败";
        }
        String msg1="/result.jsp";
        Map request=(Map) context.get("request");
        request.put("msg",msg);
        request.put("msg1",msg1);*//*


        return "success";
    }
}*/

package action;

import bean.Bookbean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class EditBook extends ActionSupport
{
    private String ISBN;
    private String title;
    private String author;
    private String age;
    private  String nation;
    private String publisher;
    private String price;
    private String date;
    public  void setDate(String date)
    {
        this.date=date;
    }
     public String getDate()
     {
         return date;
     }
    public void setPrice(String price)
    {
        this.price=price;
    }
    public String getPrice()
    {
        return price;
    }
    public  void setPublisher(String publisher)
    {
        this.publisher=publisher;
    }
    public String getPublisher()
    {
        return publisher;
    }
    public  void setNation(String nation)
    {
        this.nation=nation;
    }
    public  String getNation()
    {
        return nation;
    }
    public void setAge(String age)
    {
        this.age=age;
    }

    public String getAge()
    {
        return age;
    }
    public void setAuthor(String author)
    {
        this.author=author;
    }
    public String getAuthor()
    {
        return author;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }
    public String getTitle()
    {
        return title;
    }
    public  void setISBN(String ISBN)
    {
        this.ISBN=ISBN;
    }
    public String getISBN()
    {
        return ISBN;
    }

    public String execute()
    {

        String str=price.substring(0,1);
        if(str.equals("$"))
        {
            price=price.substring(1);
        }

        String values=" title=\""+title+"\",author=\""+author+"\",publisher=\""+publisher+"\",price=\""+price+"\"," +
                "date=\""+date+"\",age=\""+age+"\",nation=\""+nation+"\" ";
        String sql="update books set "+values+" where ISBN=\""+ISBN+"\"";
        //System.out.println(sql);
        int result=0;
        Bookbean book=new Bookbean();
        result=book.editBook(sql);
        ActionContext context=ActionContext.getContext();
        ArrayList books=new ArrayList();
        Map request=(Map)context.get("request");
        String msg="";
        if(result!=0)
        {
            msg="修改成功.";
            Map session=(Map)context.getSession();
            books=(ArrayList)session.get("searchresult");
            Iterator<Bookbean> bookListIterator=books.iterator() ;
            while(bookListIterator.hasNext())
            {
                Bookbean b=bookListIterator.next();
                if(b.getISBN().equals(ISBN))
                {
                   b.setTitle(title);
                    b.setNation(nation);
                    b.setPublisher(publisher);
                    b.setAge(age);
                    b.setDate(date);
                    b.setAuthor(author);
                    b.setPrice(Float.valueOf(price));
                    break;
                }
            }
        }
        else
        {
            msg="修改失败";
        }
        String msg1="/result.jsp";
        request.put("msg",msg);
        request.put("msg1",msg1);
        return "success";
    }
}