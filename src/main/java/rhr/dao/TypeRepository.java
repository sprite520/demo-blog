package rhr.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rhr.po.Type;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type,Long> {

    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
