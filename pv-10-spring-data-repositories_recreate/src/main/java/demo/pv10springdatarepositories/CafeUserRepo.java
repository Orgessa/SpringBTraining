package demo.pv10springdatarepositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CafeUserRepo extends CrudRepository<CafeUser,Long> {


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update CafeUser set username=?2 where userId=?1")
    int updateUsername(Long userId, String username);


}
