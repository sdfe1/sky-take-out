package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import org.springframework.stereotype.Service;


@Service
public interface CategoryService {

    /**
     * 新增分类
     * @param categoryDTO
     */
    void add(CategoryDTO categoryDTO);


    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);


    /**
     * 启用禁用
     * @param status
     * @param id
     */
    void startOrstop(Integer status, Long id);

    Category getByType(Integer type);

    void delete(Integer id);

    void update(CategoryDTO categoryDTO);

}
