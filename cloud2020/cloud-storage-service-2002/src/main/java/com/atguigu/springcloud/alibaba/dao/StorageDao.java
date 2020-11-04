package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface StorageDao {

    void decrease(@Param(value = "productId") Long productId, @Param(value = "count")Integer count);
}
