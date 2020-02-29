package com.lbhz.core.dao.auto;

import com.lbhz.core.bean.auto.RecordBean;
import com.lbhz.core.bean.auto.RecordBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RecordBeanMapper {
    long countByExample(RecordBeanExample example);

    int deleteByExample(RecordBeanExample example);

    @Delete({
        "delete from record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into record (id, student_id, ",
        "screenshot, time_lenth, ",
        "week_num)",
        "values (#{id,jdbcType=INTEGER}, #{studentId,jdbcType=VARCHAR}, ",
        "#{screenshot,jdbcType=VARCHAR}, #{timeLenth,jdbcType=INTEGER}, ",
        "#{weekNum,jdbcType=INTEGER})"
    })
    int insert(RecordBean record);

    int insertSelective(RecordBean record);

    List<RecordBean> selectByExample(RecordBeanExample example);

    @Select({
        "select",
        "id, student_id, screenshot, time_lenth, week_num",
        "from record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.lbhz.core.dao.auto.RecordBeanMapper.BaseResultMap")
    RecordBean selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RecordBean record, @Param("example") RecordBeanExample example);

    int updateByExample(@Param("record") RecordBean record, @Param("example") RecordBeanExample example);

    int updateByPrimaryKeySelective(RecordBean record);

    @Update({
        "update record",
        "set student_id = #{studentId,jdbcType=VARCHAR},",
          "screenshot = #{screenshot,jdbcType=VARCHAR},",
          "time_lenth = #{timeLenth,jdbcType=INTEGER},",
          "week_num = #{weekNum,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RecordBean record);
}