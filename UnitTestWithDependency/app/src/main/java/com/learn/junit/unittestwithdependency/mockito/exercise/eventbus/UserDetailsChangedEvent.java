package com.learn.junit.unittestwithdependency.mockito.exercise.eventbus;


import com.learn.junit.unittestwithdependency.mockito.exercise.users.User;

public class UserDetailsChangedEvent {

    private final User mUser;

    public UserDetailsChangedEvent(User user) {
        mUser = user;
    }

    public User getUser() {
        return mUser;
    }
}
