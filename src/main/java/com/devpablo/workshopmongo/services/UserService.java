package com.devpablo.workshopmongo.services;

import com.devpablo.workshopmongo.domain.User;
import com.devpablo.workshopmongo.dto.UserDTO;
import com.devpablo.workshopmongo.repository.UserRepository;
import com.devpablo.workshopmongo.services.exception.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repo.findById(id);
        if (!user.isPresent()) {
            throw new ObjectNotFoundException("Objeto não encontrado! ID: " + id);
        }
        return user.get();
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }
    
    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
