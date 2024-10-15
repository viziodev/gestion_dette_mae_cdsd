package ism.maecdsd.repository.list;



import ism.maecdsd.entity.User;
import ism.maecdsd.repository.UserRepository;

public class UserRepositoryList extends RepositoryListImpl<User> implements UserRepository {

    @Override
    public boolean loginExist(String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loginExist'");
    }

    @Override
    public void seConnecter(String login, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'seConnecter'");
    }

}
