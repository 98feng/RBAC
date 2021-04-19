package com.bjpowernode.library.settings.domain;

import com.bjpowernode.library.activity.domain.Books;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author feng
 * @date 2021/1/3
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author_Books_Relation implements Serializable {

    private static final long serialVersionUID = -2662898261227528918L;
    Author author;
    Books books;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("author=").append(author.getAuthorLoginId());
        sb.append(", books=").append(books);
        return sb.toString();
    }
}
