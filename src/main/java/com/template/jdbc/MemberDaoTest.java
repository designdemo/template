package com.template.jdbc;

import java.util.List;

/**
 * author:曲终、人散
 * Date:2019/4/11 22:41
 */
public class MemberDaoTest {
    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> list = memberDao.selectAll();
        System.out.println(list);

    }
}
