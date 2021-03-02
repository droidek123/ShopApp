package dao;

import api.UserDao;
import entity.Product;
import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final String fileName;

    public UserDaoImpl(String fileName) throws IOException {
        this.fileName=fileName;
        File file = new File(fileName);
        file.createNewFile();
    }


    public void saveUser(User user) throws IOException {
        List<User> users = getAllUsers();
        users.add(user);
        saveUsers(users);
    }

    public void saveUsers(List<User> users) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for(User user : users) {
            printWriter.write(user.toString() + "\n");
        }
        printWriter.close();
    }

    public void removeUserById(Long userId) throws IOException {
        List<User> users = getAllUsers();

        for(int i=0;i<users.size(); i++) {
            boolean isFoundUser = users.get(i).getId().equals(userId);
            if (isFoundUser) {
                users.remove(i);
            }
        }

        saveUsers(users);
    }

    public void removeUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();

        for(int i=0;i<users.size(); i++) {
            boolean isFoundUser = users.get(i).getLogin().equals(login);
            if (isFoundUser) {
                users.remove(i);
            }
        }

        saveUsers(users);
    }

    public List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<User>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String readLine = bufferedReader.readLine();
        while(readLine != null) {
            String [] userInformations = readLine.split("#");

            Long userId = Long.parseLong(userInformations[0]);
            String login = userInformations[1];
            String password = userInformations[2];

            User user = new User(userId,login,password);
            if (user != null) {
                users.add(user);
            }
        }

        return users;
    }

    public User getUserById(Long userId) throws IOException {
        List<User> users = getAllUsers();

        for (User user : users
        ) {
            boolean isFoundUser = user.getId().equals(userId);
            if (isFoundUser) {
                return user;
            }

        }

        return null;
    }

    public User getUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();

        for (User user : users
        ) {
            boolean isFoundUser = user.getLogin().equals(login);
            if (isFoundUser) {
                return user;
            }

        }

        return null;
    }
}
