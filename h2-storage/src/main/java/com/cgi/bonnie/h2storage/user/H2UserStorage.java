package com.cgi.bonnie.h2storage.user;

import com.cgi.bonnie.businessrules.user.User;
import com.cgi.bonnie.businessrules.user.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Primary
public class H2UserStorage implements UserStorage {

    final private H2UserRepository repository;
    final private UserMapper mapper;

    @Autowired
    public H2UserStorage(H2UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public long create(User o, String password) {
        try {
            return repository.save(mapper.assemblyUserFromUser(o, password)).getId();
        } catch (Exception e) {
            return 0L;
        }
    }

    @Override
    public User load(long id) {
        return mapper.userFromAssemblyUser(repository.findById(id).orElseThrow(() -> new IllegalStateException("User not found")));
    }

    @Override
    public User findByUsername(String username) {
        return mapper.userFromAssemblyUser(repository.findByName(username));
    }

    public List<User> findAll() {
        return repository.findAll().stream().map(mapper::userFromAssemblyUser).collect(Collectors.toList());
    }

    @Override
    public User findByEmail(String email) {
        return mapper.userFromAssemblyUser(repository.findByEmail(email));
    }
}