package rhr.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rhr.NotFoundException;
import rhr.dao.BlogRepository;
import rhr.dao.CommentRepository;
import rhr.dao.UserRepository;
import rhr.po.Blog;
import rhr.po.Type;
import rhr.po.Comment;
import rhr.po.User;
import rhr.vo.BlogQuery;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentSeriveImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment savemessage(String content) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setCreateTime(new Date());
        Comment comment1 = commentRepository.save(comment);
        return comment1;

    }
}


