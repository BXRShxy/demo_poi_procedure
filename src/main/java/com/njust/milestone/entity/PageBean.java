package com.njust.milestone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

/**
 * 分页工具
 *
 * @author 修身
 * @since 2019/4/25
 **/

@Data
public class PageBean<T> {

    private Long total;      //总记录数
    private List<T> result = null; //分页查询的结果

    @JsonIgnore //一般标记在属性或者方法上，返回的json数据即不包含该属性
    private Integer currPage = 1;   //当前页数
    @JsonIgnore
    private Integer pageSize = 10;   //每页显示的个数

    @JsonIgnore
    private Integer start = 1;  //起始页
    @JsonIgnore
    private Integer end = 10;    //末页

    @JsonIgnore
    private String sort = "createTime";// 排序字段
    @JsonIgnore
    private String order = "asc";// asc，desc

    public PageBean(int currPage, int pageSize) {
        this.currPage = currPage;
        this.pageSize = pageSize;
        this.start = (currPage - 1) * pageSize;
        this.end = currPage * pageSize - this.start;
    }

    public PageBean(int currPage, int pageSize, String sort, String order) {
        this.currPage = currPage;
        this.pageSize = pageSize;
        this.start = (currPage - 1) * pageSize;
        this.end = currPage * pageSize - this.start;
        this.sort = sort;
        this.order = order;
    }
}