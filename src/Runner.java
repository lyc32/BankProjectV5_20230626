import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner
{
    public Runner(DataBase dataBase)
    {
        System.out.println("Welcome to AB bank.");
        Scanner scanner = new Scanner(System.in);
        Account tmpAccount = null;
        String id = "";
        String password = "";
        int type = -1;

        while (true)
        {
            // account type

            for(;true;)
            {
                if(tmpAccount == null)
                {
                    for(;true;)
                    {
                        System.out.println("Please select your Account Type:\n 1 for personal\n 2.for business\n 3.for Manager");
                        try
                        {
                            type = scanner.nextInt();
                            if(type == 1 || type == 2 || type == 3)
                            {
                                break;
                            }
                            else
                            {
                                System.out.println("You enter a wrong number, please try again\n");
                            }
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Please input a number, try again\n");
                            scanner.next();
                        }
                    }
                    // login
                    System.out.println("Please enter your Account Id:");
                    id = scanner.next();
                    System.out.println("Please enter your password:");
                    password = scanner.next();
                }
                else
                {
                    id = tmpAccount.getUserId();
                    password = tmpAccount.getUserPass();
                }

                if(type == 1)
                {
                    tmpAccount = new AccountCustomerPersonal(id,password);
                    tmpAccount = tmpAccount.login(DataBase.perAccountList);
                    if(tmpAccount != null)
                    {
                        tmpAccount.print();
                        System.out.println("Do you want to check your Balance?\nEnter 'Yes' to check");
                        if(("Yes").equals(scanner.next()))
                        {
                            System.out.println("your account balance is: " + ((AccountCustomerPersonal) tmpAccount).getBalance());
                        }
                        break;
                    }
                    else
                    {
                        System.out.println("your ID and password not match\nDo you want to try again.");
                        tmpAccount = null;
                        String tryAgain = scanner.next();
                        if(tryAgain.equals("No"))
                        {
                            break;
                        }
                    }
                }
                else if(type == 2)
                {
                    tmpAccount = new AccountCustomerBusiness(id,password);
                    tmpAccount = tmpAccount.login(DataBase.busAccountList);
                    if(tmpAccount != null)
                    {
                        tmpAccount.print();
                        System.out.println("Do you want to check your Balance?\nEnter 'Yes' to check");
                        if(("Yes").equals(scanner.next()))
                        {
                            System.out.println("your account balance is: " + ((AccountCustomerBusiness) tmpAccount).getBalance());
                        }
                        break;
                    }
                    else
                    {
                        System.out.println("your ID and password not match\nDo you want to try again.");
                        tmpAccount = null;
                        String tryAgain = scanner.next();
                        if(tryAgain.equals("No"))
                        {
                            break;
                        }
                    }
                }
                else
                {
                    tmpAccount = new AccountManger(id,password);
                    tmpAccount = tmpAccount.login(DataBase.magAccountList);
                    if( tmpAccount != null)
                    {
                        tmpAccount.print();
                        int choose = -1;
                        for(;true;)
                        {
                            System.out.println("What you want to do?\n 1.add new user\n 2.delete user\n 3.search user\n 4.list all users");
                            try
                            {
                                choose= scanner.nextInt();
                                if(choose == 1 || choose == 2 || choose == 3 || choose == 4)
                                {
                                    break;
                                }
                                else
                                {
                                    System.out.println("You enter a wrong number, please try again\n");
                                }
                            }
                            catch (InputMismatchException e)
                            {
                                System.out.println("Please input a number, try again\n");
                                scanner.next();
                            }
                        }

                        if(choose == 1)
                        {
                            ((AccountManger) tmpAccount).addNewUser(dataBase);
                        }
                        else if(choose == 3)
                        {
                            System.out.println("please input User ID:");
                            String userId = scanner.next();
                            ((AccountManger) tmpAccount).searchUser(userId, dataBase);
                        }
                        else if(choose == 4)
                        {
                            ((AccountManger) tmpAccount).listUsers(dataBase);
                        }
                        else
                        {
                            System.out.println("please input User ID:");
                            String deleteId = scanner.next();
                            ((AccountManger) tmpAccount).deleteUser(deleteId,dataBase);
                        }
                        break;
                    }
                    else
                    {
                        System.out.println("your ID and password not match\nDo you want to try again.");
                        tmpAccount = null;
                        String tryAgain = scanner.next();
                        if(tryAgain.equals("No"))
                        {
                            break;
                        }
                    }
                }
            }

            System.out.println("Do you want to logout or continue? \nEnter Yes to logout");
            if(("Yes").equals(scanner.next()))
            {
                tmpAccount = null;
                type = -1;
                System.out.println("Do you want to Exit? \nEnter Yes to Exit.");
                if(scanner.next().equals("Yes"))
                {
                    break;
                }
            }
        }

    }
}
