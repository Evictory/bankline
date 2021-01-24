package service;

import model.User;
import repository.UserRepository;
import util.TextUseful;

public class UserService {
    public void save (User user){
        if(!TextUseful.validateTextSize(user.getLogin(), 20))
            throw new IllegalArgumentException("Login informado ultrapassa os 20 caracteres ou está vazio");

        UserRepository.save(user);
    }
}
