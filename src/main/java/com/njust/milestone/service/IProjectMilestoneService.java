package com.njust.milestone.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.njust.milestone.entity.PageBean;
import com.njust.milestone.entity.ProjectMilestone;

/**
 * <p>
 * 项目里程碑 服务类
 * </p>
 *
 * @author 修身
 * @since 2019-04-25
 */
public interface IProjectMilestoneService extends IService<ProjectMilestone> {

    /**
     * 分页查询
     **/
    String listOfPage(ProjectMilestone projectMilestone, PageBean<ProjectMilestone> pageBean);
}
