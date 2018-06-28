package banking.user.domain.repository;

import banking.user.domain.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserRepository {
    User findByUsername(String username) throws UsernameNotFoundException;
    void save(User user);    
}
