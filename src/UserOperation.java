public interface UserOperation
{
    void addNewUser(DataBase dataBase);
    void deleteUser(String id, DataBase dataBase);
    void searchUser(String id, DataBase dataBase);
    void listUsers(DataBase dataBase);
}
