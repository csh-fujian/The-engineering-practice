package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.whch.presentCloud.entity.checkInHistory;

public interface checkInHistoryRepository {
    public List<checkInHistory> get(String number);
    public List<checkInHistory> getAll();
    public int add(checkInHistory checkInH);
    public int update(checkInHistory checkInH);
    public int delete(checkInHistory checkInH);

}