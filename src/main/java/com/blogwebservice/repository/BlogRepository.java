package com.blogwebservice.repository;

import com.blogwebservice.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query("select b from Blog b where b.user.id = :id and b.status like 'only me'")
    List<Blog> findAllBlogsOnlyMeByUserId(Long id);
    @Query("select b from Blog b where b.status like 'public' order by b.likes desc")
    List<Blog> findAllByLikeDesc();
    @Query("select b from Blog b where b.status like 'public' order by b.likes desc limit 4")
    List<Blog> top4ByLikes();
    List<Blog> findByUserIdAndStatus(Long user_id, String status);
    @Query("select b from Blog b where b.status like 'public' order by b.likes desc limit 4")
    List<Blog> findTop4ByOrderByLikesDesc();
    List<Blog> findTop4ByStatusOrderByLikesDesc(String status);
    List<Blog> findByStatusOrderByLikesDesc(String status);
    @Query("select b from Blog b where b.user.username = :username and b.user.password = :password")
    List<Blog> findAllByUser(String username, String password);
    List<Blog> findAllByUserId(Long id);
}
