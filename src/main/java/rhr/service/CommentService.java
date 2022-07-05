package rhr.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rhr.po.Comment;

public interface CommentService{
Comment savemessage(String content);


}
