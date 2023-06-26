import java.util.ArrayList;
import java.util.List;

public class DataBase
{
    /*
    public static Account[] perAccountList;
    public static Account[] busAccountList;
    public static Account[] magAccountList;
    */

    public static List<Account> perAccountList = new ArrayList<>();
    public static List<Account> busAccountList = new ArrayList<>();
    public static List<Account> magAccountList = new ArrayList<>();

    DataBase()
    {
        AccountCustomerPersonal p1 = new AccountCustomerPersonal("AB1001","12345","Jim", 800);
        Address address1 = new Address("405", "605", "W", "Madison", "Chicago", "IL", "60661");
        p1.setAddress(address1);

        AccountCustomerPersonal p2 = new AccountCustomerPersonal("AB1004","12345","Tom", 200);
        Address address2 = new Address("B", "1346", "W", "32nd", "Chicago", "IL", "60608");
        p2.setAddress(address2);

        AccountCustomerPersonal p3 = new AccountCustomerPersonal("AB1005","12345", "Lucky",1000);
        Address address3 = new Address("305", "525","S", "State","Chicago", "IL", "60605");
        p3.setAddress(address3);

        AccountCustomerBusiness p4 = new AccountCustomerBusiness("AB1002","12345","Apple", 1000000000);
        p4.setAddress("One Apple Park Way\nCupertino, CA 95014, U.S.A.");
        AccountCustomerBusiness p5 = new AccountCustomerBusiness("AB1003","12345","Google", 20000000);
        p5.setAddress("1600 Amphitheatre Parkway Mountain View\nCA 94043, USA.");


        AccountManger p6 = new AccountManger("M001","12345", "Manger1");
        AccountManger p7 = new AccountManger("M002","12345", "Manger2");


        //this.perAccountList = new AccountCustomerPersonal[]{p1,p2,p3};
        //this.busAccountList = new AccountCustomerBusiness[]{p4,p5};
        //this.magAccountList = new AccountManger[]{p6,p7};

        perAccountList.add(p1);
        perAccountList.add(p2);
        perAccountList.add(p3);

        busAccountList.add(p4);
        busAccountList.add(p5);

        magAccountList.add(p6);
        magAccountList.add(p7);

    }
}
