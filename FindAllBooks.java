package action;

/**
 * Created by xiaomin on 2014/10/7.
 */
import bean.Bookbean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import  java.util.Map;

public class FindAllBooks extends ActionSupport{

    public String execute()
    {
        Bookbean book=new Bookbean();
        ArrayList books=book.findAllBooks();
        ActionContext context=ActionContext.getContext();
        Map request=(Map)context.get("request");
        request.put("books",books);
        return "success";

    }
}
