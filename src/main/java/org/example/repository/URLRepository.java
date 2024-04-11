package org.example.repository;

public interface URLRepository {
    void addLink(String s1, String s2);
    String getLinkShort(String s);
    String getLinkLong(String s);
    Boolean checkLong(String s);
    Boolean checkShort(String s);
}
