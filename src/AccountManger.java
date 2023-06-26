import java.util.Scanner;

public class AccountManger extends Account implements UserOperation
{
    private final String accountType = "Manager Account";

    public AccountManger(String userId, String userPass)
    {
        super(userId,userPass);
    }

    public AccountManger(String userId, String userPass, String userName)
    {
        super(userId,userPass,userName);
    }
    @Override
    void print()
    {
        System.out.println("==========================");
        System.out.printf("%12s : %s%n","User Name"  , super.getUserName());
        System.out.printf("%12s : %s%n","User Id"    , super.getUserPass());
        System.out.printf("%12s : %s%n","AccountType", this.accountType);
        System.out.println("==========================");
    }
    @Override
    public void addNewUser(DataBase dataBase)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input User Name:");
        String name = scanner.next();
        System.out.println("Please input User id:");
        String id = scanner.next();
        System.out.println("Please input User password:");
        String password = scanner.next();
        System.out.println("Please input User balance:");
        Double balance = scanner.nextDouble();
        System.out.println("Please input Address");
        Address address = new Address();
        address.create();
        AccountCustomerPersonal newUser = new AccountCustomerPersonal(id,password,name,balance);
        newUser.setAddress(address);
        DataBase.perAccountList.add(newUser);
        newUser.print();
/*
        Account[] newUserList = new Account[dataBase.perAccountList.length+1];
        for(int i = 0; i <= dataBase.perAccountList.length; i++)
        {
            if(i < dataBase.perAccountList.length)
            {
                newUserList[i] = dataBase.perAccountList[i];
            }
            else
            {
                newUserList[i] = newUser;
            }
        }
        dataBase.perAccountList = newUserList;*/
    }

    @Override
    public void deleteUser(String id, DataBase dataBase)
    {
        boolean deleteSuccessful = false;
        for(int i = 0; i < DataBase.perAccountList.size(); i++)
        {
            if(DataBase.perAccountList.get(i).getUserId().equals(id))
            {
                dataBase.perAccountList.remove(i);
                deleteSuccessful = true;
                break;
            }
        }
        if(deleteSuccessful == true)
        {
            System.out.println("success delete User: " + id);
        }
        else
        {
            System.out.println("can not find user: " + id);
        }
    }

    public void searchUser(String id, DataBase dataBase)
    {
        boolean findUser = false;
        for(int i = 0; i < DataBase.perAccountList.size(); i++)
        {
            if(DataBase.perAccountList.get(i).getUserId().equals(id))
            {
                dataBase.perAccountList.get(i).print();
                findUser = true;
                break;
            }
        }
        if(findUser == false)
        {
            System.out.println("can not find user: " + id);
        }
    }

    @Override
    public void listUsers(DataBase dataBase)
    {
        for(int i = 0; i < DataBase.perAccountList.size(); i++)
        {
            DataBase.perAccountList.get(i).print();
        }
    }
}
