package com.bjpowernode.library.settings.service;

import com.bjpowernode.library.exception.*;
import com.bjpowernode.library.settings.domain.Admin;
import com.bjpowernode.library.settings.domain.Author;
import com.bjpowernode.library.settings.domain.Author_Books_Relation;

import javax.security.auth.login.LoginException;
import java.util.List;

/**
 * @author feng
 * @date 2021/1/2
 * @Description
 */
public interface UserService {
    /**
     * 读者登录
     *
     * @param authorLonginId
     * @param authorLonginPwd
     * @return
     * @throws AuthorLoginException
     */
    Author authorLogin(String authorLonginId, String authorLonginPwd) throws AuthorLoginException;

    /**
     * 获取所有读者
     *
     * @return
     * @throws GetAuthorException
     */
    List<Author> getAuthorList() throws GetAuthorException;

    /**
     * 修改读者密码
     *
     * @param author
     * @return
     * @throws UpdataAuthorLoginPwdException
     */
    Author updataAuthorLoginPwd(Author author) throws UpdataAuthorLoginPwdException;

    /**
     * 获取所有读者的借阅信息
     *
     * @return
     * @throws GetRelationsException
     */
    List<Author_Books_Relation> getAllRelationsList() throws GetRelationsException;

    /**
     * 根据读者查询借阅信息
     *
     * @param author
     * @return
     * @throws GetAuthorBooksRelationException
     */
    List<Author_Books_Relation> getAuthorBooksRelationByAuthor(Author author) throws GetAuthorBooksRelationException;

    /**
     * 添加借阅信息
     *
     * @param abr
     * @return
     */
    Boolean addAuthorBooksRelation(Author_Books_Relation abr);

    /**
     * 管理员登录
     *
     * @param adminLoginAct
     * @param adminLoginPwd
     * @return
     * @throws LoginException
     */
    Admin adminLogin(String adminLoginAct, String adminLoginPwd) throws LoginException;

    /**
     * 添加读者
     *
     * @param author
     * @return
     */
    boolean addAuthor(Author author);

    /**
     * 删除读者
     *
     * @param authorId
     * @return
     */
    boolean rmAuthorById(String authorId);

    /**
     * 删除借阅信息
     *
     * @param authorId
     * @return
     */
    boolean rmAuthorBooksRelationByAuthorId(String authorId);

}
