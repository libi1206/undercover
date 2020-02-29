package com.lbhz.core.dao.auto;

import com.lbhz.core.bean.auto.StudentBean;
import com.lbhz.core.bean.auto.StudentBeanExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StudentBeanMapper {
    long countByExample(StudentBeanExample example);

    int deleteByExample(StudentBeanExample example);

    @Delete({
        "delete from student",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into student (id, name, ",
        "club, major)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{club,jdbcType=VARCHAR}, #{major,jdbcType=VARCHAR})"
    })
    int insert(StudentBean record);

    int insertSelective(StudentBean record);

    List<StudentBean> selectByExample(StudentBeanExample example);

    @Select({
        "select",
        "id, name, club, major",
        "from student",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.lbhz.core.dao.auto.StudentBeanMapper.BaseResultMap")
    StudentBean selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StudentBean record, @Param("example") StudentBeanExample example);

    int updateByExample(@Param("record") StudentBean record, @Param("example") StudentBeanExample example);

    int updateByPrimaryKeySelective(StudentBean record);

    @Update({
        "update student",
        "set name = #{name,jdbcType=VARCHAR},",
          "club = #{club,jdbcType=VARCHAR},",
          "major = #{major,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(StudentBean record);
}