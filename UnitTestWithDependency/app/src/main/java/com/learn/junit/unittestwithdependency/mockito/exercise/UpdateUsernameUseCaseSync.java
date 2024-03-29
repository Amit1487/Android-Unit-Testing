package com.learn.junit.unittestwithdependency.mockito.exercise;

import com.learn.junit.unittestwithdependency.mockito.exercise.eventbus.EventBusPoster;
import com.learn.junit.unittestwithdependency.mockito.exercise.eventbus.UserDetailsChangedEvent;
import com.learn.junit.unittestwithdependency.mockito.exercise.networking.NetworkErrorException;
import com.learn.junit.unittestwithdependency.mockito.exercise.networking.UpdateUsernameHttpEndpointSync;
import com.learn.junit.unittestwithdependency.mockito.exercise.users.User;
import com.learn.junit.unittestwithdependency.mockito.exercise.users.UsersCache;

public class UpdateUsernameUseCaseSync {

    public enum UseCaseResult {
        SUCCESS,
        FAILURE,
        NETWORK_ERROR
    }

    private final UpdateUsernameHttpEndpointSync mUpdateUsernameHttpEndpointSync;
    private final UsersCache mUsersCache;
    private final EventBusPoster mEventBusPoster;

    public UpdateUsernameUseCaseSync(UpdateUsernameHttpEndpointSync updateUsernameHttpEndpointSync,
                                     UsersCache usersCache,
                                     EventBusPoster eventBusPoster) {
        mUpdateUsernameHttpEndpointSync = updateUsernameHttpEndpointSync;
        mUsersCache = usersCache;
        mEventBusPoster = eventBusPoster;
    }

    public UseCaseResult updateUsernameSync(String userId, String username) {
        UpdateUsernameHttpEndpointSync.EndpointResult endpointResult = null;
        try {
            endpointResult = mUpdateUsernameHttpEndpointSync.updateUsername(userId, username);
        } catch (NetworkErrorException e) {
            // the bug here is "swallowed" exception instead of return
        }

        if (isSuccessfulEndpointResult(endpointResult)) {
            // the bug here is reversed arguments
            User user = new User(endpointResult.getUsername(), endpointResult.getUserId());
            mEventBusPoster.postEvent(new UserDetailsChangedEvent(new User(userId, username)));
            mUsersCache.cacheUser(user);
            return UseCaseResult.SUCCESS;
        } else {
            return UseCaseResult.FAILURE;
        }
    }

    private boolean isSuccessfulEndpointResult(UpdateUsernameHttpEndpointSync.EndpointResult endpointResult) {
        // the bug here is the wrong definition of successful response
        return endpointResult.getStatus() == UpdateUsernameHttpEndpointSync.EndpointResultStatus.SUCCESS
                || endpointResult.getStatus() == UpdateUsernameHttpEndpointSync.EndpointResultStatus.GENERAL_ERROR;
    }
}
