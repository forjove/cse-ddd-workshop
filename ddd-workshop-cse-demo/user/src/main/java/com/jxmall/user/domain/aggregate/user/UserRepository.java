package com.jxmall.user.domain.aggregate.user;

import java.util.List;
import com.jxmall.user.domain.aggregate.user.root.User;

public interface UserRepository {

    List<User> search(String key);

    void create(User user);

    User findById(String id);
}
