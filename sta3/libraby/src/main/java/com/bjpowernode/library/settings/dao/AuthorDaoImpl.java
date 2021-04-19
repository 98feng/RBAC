package com.bjpowernode.library.settings.dao;

import com.bjpowernode.library.annotation.Bean;
import com.bjpowernode.library.settings.domain.Admin;
import com.bjpowernode.library.settings.domain.Author;
import com.bjpowernode.library.settings.domain.Author_Books_Relation;
import com.bjpowernode.library.settings.serializable.AbstractSerializable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @date 2021/1/2
 * @Description
 */
@Bean
public class AuthorDaoImpl extends AbstractSerializable implements AuthorDao {

    public AuthorDaoImpl() {
    }

    /**
     * 读者登录
     *
     * @param map
     * @return 有就返回该读者，没有则返回null
     */
    @Override
    public Author authorLogin(Map<String, String> map) {
        List<Author> list = getAuthorList();
        if (list == null) {
            return null;
        }
        for (Author author : list) {
            if (map.get("authorLoginId").equals(author.getAuthorLoginId()) && map.get("authorLoginPwd").equals(author.getAuthorLoginPwd())) {
                return author;
            }
        }
        return null;
    }

    /**
     * @return 获取所有的读者
     */
    @Override
    public List<Author> getAuthorList() {
        Object o = descSeri("Author.txt");
        @SuppressWarnings("unchecked")
        List<Author> list = (List<Author>) o;
        return list;
    }


    /**
     * 修改读者密码
     *
     * @param author
     * @return 修改成功返回author，修改失败返回null
     */
    @Override
    public Author updataAuthorLoginPwd(Author author) {
        List<Author> list = getAuthorList();
        for (Author au : list) {
            if (author.getAuthorLoginId().equals(au.getAuthorLoginId())) {
                //删除原来的用户，添加修改密码后的用户
                list.remove(au);
                list.add(author);
                serialize(list, "Author.txt");
                return author;
            }
        }
        return null;
    }

    /**
     * 查看某个读者借阅记录
     *
     * @param author
     * @return
     */
    @Override
    public List<Author_Books_Relation> getAuthorBooksRelationByAuthor(Author author) {
        List<Author_Books_Relation> list = getAllRelationsList();
        List<Author_Books_Relation> lits = new ArrayList<>();
        for (Author_Books_Relation abr : list) {
            if (author.equals(abr.getAuthor())) {
                lits.add(abr);
            }
        }

        return lits;
    }

    /**
     * 添加读者借阅信息
     *
     * @param abr
     * @return 添加成功返回1添加失败返回0
     */
    @Override
    public int addAuthorBooksRelation(Author_Books_Relation abr) {
        List<Author_Books_Relation> allRelationsList = getAllRelationsList();
        boolean add = allRelationsList.add(abr);

        serialize(allRelationsList, "abr.txt");
        return add ? 1 : 0;
    }


    /**
     * 获取所有读者的借阅信息
     */
    @Override
    public List<Author_Books_Relation> getAllRelationsList() {
        Object o = descSeri("abr.txt");
        @SuppressWarnings("unchecked")
        List<Author_Books_Relation> list = (List<Author_Books_Relation>) o;
        return list;
    }

    /**
     * 管理员登录
     *
     * @param adminLoginAct
     * @param adminLoginPwd
     * @return 查到admin返回admin, 没有就返回null
     */
    @Override
    public Admin adminLogin(String adminLoginAct, String adminLoginPwd) {
        Object o = descSeri("Admin.txt");
        Admin admin = (Admin) o;
        assert admin != null;
        if (adminLoginAct.equals(admin.getLoginAct()) && adminLoginPwd.equals(admin.getLoginPwd())) {
            return admin;
        }
        return null;
    }

    /**
     * 添加读者，如果有本地有该读者(即id相同)，则添加失败
     *
     * @param author
     * @return 添加成功返回1, 否则返回0;
     */
    @Override
    public int addAuthor(Author author) {
        List<Author> authorList = getAuthorList();
        for (Author author1 : authorList) {
            if (author.getAuthorLoginId().equals(author1.getAuthorLoginId())) {
                return 0;
            }
        }
        //没有该读者则添加
        authorList.add(author);
        serialize(authorList, "Author.txt");
        return 1;
    }

    /**
     * 删除读者
     *
     * @param authorId
     * @return 删除成功返回1, 否则返回0
     */
    @Override
    public int rmAuthorById(String authorId) {
        List<Author> authorList = getAuthorList();
        boolean remove = false;
        for (Author author : authorList) {
            if (authorId.equals(author.getAuthorLoginId())) {
                remove = authorList.remove(author);
                break;
            }
        }
        //如果删除成功，则重新序列化
        if (remove) {
            serialize(authorList, "Author.txt");
            return 1;
        }
        return 0;
    }

    /**
     * 删除读者的借阅记录
     *
     * @param authorId
     * @return 删除成功返回1删除失败返回0
     */
    @Override
    public int rmAuthorBooksRelationByAuthorId(String authorId) {
        List<Author_Books_Relation> allRelationsList = getAllRelationsList();
        boolean remove = false;
        for (Author_Books_Relation abr : allRelationsList) {
            if (abr.getAuthor().getAuthorLoginId().equals(authorId)) {
                remove = allRelationsList.remove(abr);
                break;
            }
        }
        //删除之后重新序列化到本地
        if (remove) {
            serialize(allRelationsList, "abr.txt");
            return 1;
        }
        return 0;
    }

    /**
     * 序列化
     *
     * @param obj
     * @param descPath
     */
    private void serialize(Object obj, String descPath) {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File(descPath)));
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert oos != null;
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 反序列化文件
     *
     * @param s
     * @return
     */
    private Object descSeri(String s) {
        ObjectInputStream ois = null;
        Object o = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File(s)));
            o = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
//            throw e.getCause();
        } finally {
            try {
                assert ois != null;
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return o;
    }

}
