package com.njust.milestone.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.njust.milestone.entity.ProjectMilestone;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 项目里程碑 Mapper 接口
 * </p>
 *
 * @author 修身
 * @since 2019-04-25
 */
public interface ProjectMilestoneMapper extends BaseMapper<ProjectMilestone> {

    /**
     * 信息列表
     */
    List<ProjectMilestone> listOfPage(Map<String, Object> map);

    /**
     * 查询总记录数
     */
    Long totalOfList(Map<String, Object> map);

}
