package com.david.mybatis.cfg;

/**
 * 用于封装执行的SQL语句和结果类型的全限定类名
 * @author david
 * @create 2019-06-18 9:45
 */
public class Mapper {
    private String queryString;
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
