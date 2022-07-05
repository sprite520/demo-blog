package rhr.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rhr.po.Blog;
import rhr.vo.BlogQuery;

public interface BlogService {

    Blog getBlog (Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);
}
