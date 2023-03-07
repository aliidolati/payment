package com.example.payment.convertors;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseConvertor<D,E> {
    E convertDto(D d);

    D convertEntity(E e);

    default List<E> convertDto(List<D> dList) {
        if (dList != null) {
            return dList.stream()
                    .map(this::convertDto) //maybe be wrong
                    .collect(Collectors.toList());
        }
        return null;
    }

    default List<D> convertEntity(List<E> dList) {
        if (dList != null) {
            return dList.stream()
                    .map(this::convertEntity) //maybe be wrong
                    .collect(Collectors.toList());
        }
        return null;

    }
}