package infrastructure.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDataMapper implements DataMapper {
    List<User> users = new ArrayList<>();

    public FileDataMapper() {
        try (BufferedReader rb = new BufferedReader(new FileReader(new File("user.txt")))) {
            String line = null;
            while ((line = rb.readLine()) != null) {
                String[] splitedUser = line.split(";");
                users.add(new User(splitedUser[0], splitedUser[1], splitedUser[2], splitedUser[3]));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void findUserByEmail(String userEmail) {
        try {
            for (User user : users) {
                if (user.getUserEmail().equals(userEmail)) {
                    System.out.println(user);
                    break;
                }
            }
        } catch (NullPointerException y) {
            System.err.println("User isn't exist with email: " + userEmail);
        }
    }

    @Override
    public void findUserByUserName(String userName) {
        try {
            for (User user : users) {
                if (user.getUserName().equals(userName)) {
                    System.out.println(user);
                    break;
                }
            }
        } catch (NullPointerException y) {
            System.err.println("User isn't exist with userName: " + userName);
        }
    }

}
