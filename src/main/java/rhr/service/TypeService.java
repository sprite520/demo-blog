package rhr.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rhr.po.Type;

import java.util.List;

public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();

    List<Type> listTypeTOP(Integer size);

    Type update(Long id,Type type);

    void deleteType(Long id);
}
