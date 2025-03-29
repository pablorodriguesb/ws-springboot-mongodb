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

    public void delete(String id) {
        User obj = repo.findById(id).orElse(null);
        if (obj == null) {
            throw new ObjectNotFoundException("Usuário não encontrado com o ID: " + id);
        }
        repo.delete(obj);
    }

    public User update(User obj) {
        User newObj = repo.findById(obj.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado com o ID: " + obj.getId()));
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
