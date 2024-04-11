package org.example.repository;

import org.example.database.Database;

public class URLRepositoryImpl {
    void addLink(String s1, String s2){
        Database.getInstance().addLink(s1,s2);
    }

    String getLinkShort(String s){
        return Database.getInstance().getLinkShort(s);
    }
    String getLinkLong(String s){
        return Database.getInstance().getLinkLong(s);
    }
    Boolean checkLong(String s){
        return Database.getInstance().checkLong(s);
    }

    Boolean checkShort(String s){
        return Database.getInstance().checkShort(s);
    }
}
