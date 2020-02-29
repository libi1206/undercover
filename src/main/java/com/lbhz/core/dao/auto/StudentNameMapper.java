package com.lbhz.core.dao.auto;

import com.lbhz.core.bean.auto.StudentName;
import com.lbhz.core.bean.auto.StudentNameExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StudentNameMapper {
    long countByExample(StudentNameExample example);

    int deleteByExample(StudentNameExample example);

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
    int insert(StudentName record);

    int insertSelective(StudentName record);

    List<StudentName> selectByExample(StudentNameExample example);

    @Select({
        "select",
        "id, name, club, major",
        "from student",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.lbhz.core.dao.auto.StudentNameMapper.BaseResultMap")
    StudentName selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StudentName record, @Param("example") StudentNameExample example);

    int updateByExample(@Param("record") StudentName record, @Param("example") StudentNameExample example);

    int updateByPrimaryKeySelective(StudentName record);

    @Update({
        "update student",
        "set name = #{name,jdbcType=VARCHAR},",
          "club = #{club,jdbcType=VARCHAR},",
          "major = #{major,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(StudentName record);
}