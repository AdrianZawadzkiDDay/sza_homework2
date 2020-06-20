package pl.bykowski.spring_secutity_homework2.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LoginCounter {

    private HashMap<String, Integer> counter;

    public LoginCounter() {
        counter = new HashMap<String, Integer>();
    }

    public void incrementCounter(String username) {
        Integer count = counter.get(username);
        if (count != null) {
            count++;
            counter.put(username, count);
        } else {
            counter.put(username, 1);
        }
    }

    public Integer getCountByUsername(String username) {
        return counter.get(username);
    }

}
