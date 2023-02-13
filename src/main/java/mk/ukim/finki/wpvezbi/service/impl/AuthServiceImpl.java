package mk.ukim.finki.wpvezbi.service.impl;

import mk.ukim.finki.wpvezbi.model.User;
import mk.ukim.finki.wpvezbi.model.exceptions.InvalidArgumentException;
import mk.ukim.finki.wpvezbi.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.wpvezbi.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.wpvezbi.model.exceptions.UsernameAlreadyExistsException;
import mk.ukim.finki.wpvezbi.repository.impl.InMemoryUserRepository;
import mk.ukim.finki.wpvezbi.repository.jpa.UserRepository;
import mk.ukim.finki.wpvezbi.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null||password.isEmpty()){
            throw new InvalidArgumentException();
        }
        return userRepository.findByUsernameAndPassword(username,password).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidArgumentException();
        }
        if (!password.equals(repeatPassword)){
            throw new PasswordsDoNotMatchException();
        }

        if (this.userRepository.findByUsername(username).isPresent() || !this.userRepository.findByUsername(username).isEmpty())
            throw new UsernameAlreadyExistsException(username);
        User user=new User(username,password,name,surname);
        return userRepository.save(user);

    }
}
