import java.util.List;

public abstract class Account
{
    private String userId;
    private String userPass;
    private String userName;

    public Account(String userId, String userPass)
    {
        this.userId = userId;
        this.userPass = userPass;
    }

    public Account(String userId, String userPass, String userName)
    {
        this.userId = userId;
        this.userPass = userPass;
        this.userName = userName;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setUserPass(String userPass)
    {
        this.userPass = userPass;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public String getUserPass()
    {
        return this.userPass;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public Account login(List<Account> accountList)
    {
        for(int i = 0; i < accountList.size(); i++)
        {
            Account tmp = accountList.get(i);
            if(tmp.getUserId().equals(this.userId) && tmp.getUserPass().equals(this.userPass))
            {
                return accountList.get(i);
            }
        }
        return null;
    }

    abstract void print();
}
