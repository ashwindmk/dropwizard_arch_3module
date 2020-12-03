package com.ashwin.repository;

import java.util.List;

public interface MessageRepository {
    List<String> fetchAll();
    String fetchAny();
}
