package action;

/**
 * Created by xiaomin on 2014/10/8.
 */
import bean.Bookbean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class DeleteBook extends ActionSupport{
    private  String ISBN;
    public void setISBN(String ISBN)
    {
        this.ISBN=ISBN;
    }
    public String getISBN()
    {
        return ISBN;
    }
    public String execute()
    {
        ActionContext context=ActionContext.getContext();
        Bookbean book=new Bookbean();
        int result=book.deleteBook(ISBN);
        String msg="";
        ArrayList books=new ArrayList();
       if(result!=0)

       {
           msg="删除成功.";
          Map session=(Map)context.getSession();
          books=(ArrayList)session.get("searchresult");
          Iterator<Bookbean> bookListIterator=books.iterator() ;
            while(bookListIterator.hasNext())
            {
                Bookbean b=bookListIterator.next();
                if(b.getISBN().equals(ISBN))
                {
                    bookListIterator.remove();
                    break;
                }
            }

       }
        else
       {
           msg="删除失败.";
       }
        String msg1="/result.jsp";

        Map request=(Map)context.get("request");
        request.put("msg",msg);
        request.put("msg1",msg1);
        return "success";
    }
}