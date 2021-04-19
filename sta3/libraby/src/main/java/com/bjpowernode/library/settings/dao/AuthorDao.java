package com.bjpowernode.library.settings.dao;

import com.bjpowernode.library.settings.domain.Admin;
import com.bjpowernode.library.settings.domain.Author;
import com.bjpowernode.library.settings.domain.Author_Books_Relation;

import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @date 2021/1/2
 * @Description
 */
public interface AuthorDao {
    /**
     * 读者登录
     *
     * @param map
     * @return
     */
    Author authorLogin(Map<String, String> map);

    /**
     * 获取所有读者
     *
     * @return
     */
    List<Author> getAuthorList();

    /**
     * 修改读者密码
     *
     * @param author
     * @return
     */
    Author updataAuthorLoginPwd(Author author);

    /**
     * 获取读者借阅信息
     *
     * @param author
     * @return
     */
    List<Author_Books_Relation> getAuthorBooksRelationByAuthor(Author author);

    /**
     * 获取所有的借阅信息
     *
     * @return
     */
    List<Author_Books_Relation> getAllRelationsList();

    /**
     * 添加读者的借阅信息
     *
     * @param abr
     * @return
     */
    int addAuthorBooksRelation(Author_Books_Relation abr);

    /**
     * 管理员登录验证
     *
     * @param adminLoginAct
     * @param adminLoginPwd
     * @return
     */
    Admin adminLogin(String adminLoginAct, String adminLoginPwd);

    /**
     * 添加读者
     *
     * @param author
     * @return
     */
    int addAuthor(Author author);

    /**
     * 删除读者
     *
     * @param authorId
     * @return
     */
    int rmAuthorById(String authorId);

    /**
     * 删除读者对应的借阅信息
     *
     * @param authorId
     * @return
     */
    int rmAuthorBooksRelationByAuthorId(String authorId);

}
