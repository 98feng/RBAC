package com.bjpowernode.library.settings.service.impl;

import com.bjpowernode.library.annotation.AuthoWrite;
import com.bjpowernode.library.annotation.Bean;
import com.bjpowernode.library.exception.*;
import com.bjpowernode.library.settings.dao.AuthorDao;
import com.bjpowernode.library.settings.domain.Admin;
import com.bjpowernode.library.settings.domain.Author;
import com.bjpowernode.library.settings.domain.Author_Books_Relation;
import com.bjpowernode.library.settings.service.UserService;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static mian.Main.objectApplicationContext;

/**
 * @author feng
 * @date 2021/1/2
 * @Description
 */
@Bean
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {}

    /**
     * 从容器中获取AuthorDaoImpl对象
     */
    @AuthoWrite
    AuthorDao ad;// = (AuthorDao) objectApplicationContext.getBean(AuthorDao.class);

    @Override
    public Author authorLogin(String authorLonginId, String authorLonginPwd) throws AuthorLoginException {
        Map<String, String> map = new HashMap<>();
        map.put("authorLoginId", authorLonginId);
        map.put("authorLoginPwd", authorLonginPwd);
        Author author = ad.authorLogin(map);
        if (author == null) {
            throw new AuthorLoginException("读者登录失败！");
        }
        return author;
    }

    @Override
    public List<Author> getAuthorList() throws GetAuthorException {
        List<Author> list = ad.getAuthorList();
        if (list == null) {
            throw new GetAuthorException("读者信息获取失败！");
        }
        return list;
    }

    @Override
    public Author updataAuthorLoginPwd(Author author) throws UpdataAuthorLoginPwdException {
        Author au = ad.updataAuthorLoginPwd(author);
        if (au == null) {
            throw new UpdataAuthorLoginPwdException("读者密码修改失败！");
        }
        return author;
    }

    /**
     * 获取所有的借阅信息
     *
     * @return
     */
    @Override
    public List<Author_Books_Relation> getAllRelationsList() throws GetRelationsException {
        List<Author_Books_Relation> relations = ad.getAllRelationsList();
        if (relations == null) {
            throw new GetRelationsException();
        }
        return relations;
    }

    @Override
    public List<Author_Books_Relation> getAuthorBooksRelationByAuthor(Author author) throws GetAuthorBooksRelationException {
        List<Author_Books_Relation> list = ad.getAuthorBooksRelationByAuthor(author);
        if (list == null) {
            throw new GetAuthorBooksRelationException("查看借阅信息失败");
        }
        return list;
    }

    /**
     * 添加借阅信息
     *
     * @param abr
     * @return
     */
    @Override
    public Boolean addAuthorBooksRelation(Author_Books_Relation abr) {
        boolean flag = true;
        int count = ad.addAuthorBooksRelation(abr);
        if (count != 1) {
            flag = false;
//            throw new AddAuthorBooksRelationException("读者借书失败！");
        }
        return flag;
    }


    /**
     * 管理员登录
     *
     * @param adminLoginAct
     * @param adminLoginPwd
     * @return
     */
    @Override
    public Admin adminLogin(String adminLoginAct, String adminLoginPwd) throws LoginException {
        Admin admin = ad.adminLogin(adminLoginAct, adminLoginPwd);
        if (admin == null) {
            throw new LoginException("管理员登录失败！");
        }
        return admin;
    }


    /**
     * 添加读者
     *
     * @param author
     * @return
     */
    @Override
    public boolean addAuthor(Author author) {
        boolean flag = true;
        int count = ad.addAuthor(author);
        if (count != 1) {
            flag = false;
        }
        return flag;
    }

    /**
     * 删除读者
     *
     * @param authorId
     * @return
     */
    @Override
    public boolean rmAuthorById(String authorId) {
        boolean flag = true;
        int count = ad.rmAuthorById(authorId);
        if (count != 1) {
            flag = false;
        }
        return flag;
    }

    /**
     * 删除借阅信息
     *
     * @param authorId
     * @return
     */
    @Override
    public boolean rmAuthorBooksRelationByAuthorId(String authorId) {
        boolean flag = true;
        int count = ad.rmAuthorBooksRelationByAuthorId(authorId);
        if (count != 1) {
            flag = false;
        }
        return flag;
    }

}
