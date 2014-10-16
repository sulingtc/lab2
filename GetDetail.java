package action;

/**
 * Created by xiaomin on 2014/10/8.
 */
import bean.Bookbean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class GetDetail extends ActionSupport{
    private String ISBN;
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

        Bookbean book=new Bookbean();
        book=book.getDetail(ISBN);
        ActionContext context=ActionContext.getContext();
        Map request=(Map)context.get("request");
        request.put("bookdetail",book);
        return "success";
    }
}

