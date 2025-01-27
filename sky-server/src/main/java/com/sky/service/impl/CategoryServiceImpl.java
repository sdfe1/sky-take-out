package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.entity.Employee;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import com.sky.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.sky.constant.StatusConstant.DISABLE;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;


    /**
     * 新增分类
     * @param categoryDTO
     */
    /*//分类状态 0标识禁用 1表示启用
    private Integer status;

    //创建时间
    private LocalDateTime createTime;

    //更新时间
    private LocalDateTime updateTime;

    //创建人
    private Long createUser;

    //修改人
    private Long updateUser;*/
    @Override
    public void add(CategoryDTO categoryDTO) {
        //1.将dto转为category存储
        Category category = new Category();
        //1.1 拷贝
        BeanUtils.copyProperties(categoryDTO,category);
        //1.2 设置其他属性
        category.setStatus(DISABLE);
        //category.setCreateTime(LocalDateTime.now());
        //category.setUpdateTime(LocalDateTime.now());

        //category.setCreateUser(10L);
        //category.setUpdateUser(10L);

        categoryMapper.add(category);


    }


    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageHelper.startPage(categoryPageQueryDTO.getPage(),categoryPageQueryDTO.getPageSize());

        Page<Category> page = categoryMapper.pageQuery(categoryPageQueryDTO);

        long total = page.getTotal();
        List<Category> records = page.getResult();

        PageResult pageResult = new PageResult(total,records);
        return pageResult;
    }

    @Override
    public void startOrstop(Integer status, Long id) {
        Category category = new Category();
        category.setId(id);
        category.setStatus(status);
        categoryMapper.update(category);

    }

    @Override
    public Category getByType(Integer type) {
        Category category =categoryMapper.getByType(type);
        return category;
    }

    @Override
    public void delete(Integer id) {
        categoryMapper.delete(id);
    }

    @Override
    public void update(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);
        //category.setUpdateTime(LocalDateTime.now());
       // category.setCreateTime(LocalDateTime.now());
        //
       // category.setUpdateUser(3L);

        categoryMapper.update(category);
    }
}
