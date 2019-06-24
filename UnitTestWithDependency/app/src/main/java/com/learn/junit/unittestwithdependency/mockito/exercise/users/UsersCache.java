package com.learn.junit.unittestwithdependency.mockito.exercise.users;

import com.learn.junit.unittestwithdependency.mockito.exercise.users.User;

public interface UsersCache {

    void cacheUser(User user);

    User getUser(String userId);

}
