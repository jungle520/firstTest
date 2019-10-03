package com.test.redis;

import com.test.dao.User;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by wangjiang on 2019/9/14.
 */
@NoRepositoryBean
public interface UserRepository {
    boolean save(User user);
    User findUser(Long id);
}
