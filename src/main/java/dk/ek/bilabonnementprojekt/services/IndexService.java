package dk.ek.bilabonnementprojekt.services;

import dk.ek.bilabonnementprojekt.models.User;
import dk.ek.bilabonnementprojekt.respositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {
    private final UserRepository userRepo;

    public IndexService(UserRepository repo) {
        this.userRepo = repo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
