package com.david.domain;

import com.david.domain.User;

import java.util.List;

/**
 * @author david
 * @create 2019-06-26 10:52
 */
public class QueryVo {
    private User user;
    private List<Integer> ids;
    public void setUser(User user) {
        this.user = user;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
