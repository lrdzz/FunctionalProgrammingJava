package org.lrdz.SimpleInterface;

import java.util.List;

public interface IDatabaseService<T> {
    //Generic programming to prevent single implementations.
    T getById(Long id);
    List<T> getAllRecords();

}