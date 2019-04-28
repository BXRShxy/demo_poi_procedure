package com.njust.milestone.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.njust.milestone.entity.MaterialMilestone;
import com.njust.milestone.entity.ProjectMilestone;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 物资里程碑 Mapper 接口
 * </p>
 *
 * @author 修身
 * @since 2019-04-25
 */
public interface MaterialMilestoneMapper extends BaseMapper<MaterialMilestone> {

    /**
     * 信息列表
     */
    List<MaterialMilestone> listOfPage(Map<String, Object> map);

    /**
     * 查询总记录数
     */
    Long totalOfList(Map<String, Object> map);

    /**
     * 调用存储过程，获取最新记录
     */
    @Select("call generateMaterialMilestone()")
    void generateMaterialMilestone();

    /**
     * 获取最新的里程碑信息
     **/
    List<MaterialMilestone> findRecentMilestone(@Param("start") Integer start, @Param("end") Integer end);

    /**
     * 获取总数
     **/
    Long getMaterialMilestoneTotal();

}
