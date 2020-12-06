package infrastructure.data;

public interface DataMapper {
    void findUserByEmail(String email);

    void findUserByUserName(String username);
}
