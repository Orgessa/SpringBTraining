package demo.pv10springdatarepositories;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CafeUserService {

    @Autowired
    private CafeUserRepo cafeUserRepo;

    public long getUserCount(){
        return  cafeUserRepo.count();
    }

    public Optional<CafeUser> getUser(long userId) {

        return cafeUserRepo.findById(userId);
    }

    public List<CafeUser> getUsers() {

        List<CafeUser> users = new ArrayList<>();
        cafeUserRepo.findAll().forEach(users::add);
        return users;
    }

    public CafeUser insertUser(CafeUser user) {

        return cafeUserRepo.save(user);
    }

    public void updateUser(Long id, String username) {

        CafeUser r = cafeUserRepo.findById(id).orElseThrow();
        r.setUsername(username);
        cafeUserRepo.save(r);
    }

    public void deleteUser(Long id) {

        cafeUserRepo.deleteById(id);

    }

    public int updateUsername(Long userId, String username){
        return  cafeUserRepo.updateUsername(userId,username);
    }
}
