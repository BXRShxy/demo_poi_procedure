package com.njust.milestone.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.njust.milestone.entity.MaterialMilestone;
import com.njust.milestone.entity.PageBean;
import com.njust.milestone.entity.ProjectMilestone;

/**
 * <p>
 * 物资里程碑 服务类
 * </p>
 *
 * @author 修身
 * @since 2019-04-25
 */
public interface IMaterialMilestoneService extends IService<MaterialMilestone> {

    /**
     * 分页查询
     **/
    String listOfPage(MaterialMilestone materialMilestone, PageBean<MaterialMilestone> pageBean);

    /**
     * 调用存储过程
     */
    void generateMaterialMilestone();

    /**
     * 获取最新记录
     */
    String findRecentMilestone(PageBean<MaterialMilestone> pageBean);
}
