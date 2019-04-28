package com.njust.milestone.controller;


import com.njust.milestone.entity.PageBean;
import com.njust.milestone.entity.ProjectMilestone;
import com.njust.milestone.service.IProjectMilestoneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * <p>
 * 项目里程碑 前端控制器
 * </p>
 *
 * @author 修身
 * @since 2019-04-25
 */
@Controller
@RequestMapping("/projectMilestone")
public class ProjectMilestoneController {

    @Resource
    private IProjectMilestoneService projectMilestoneService;

    /**
     * 进入项目里程碑页面
     * <p>
     * url: http://www.localhost:8080/projectMilestone/manager
     **/
    @RequestMapping("/manager")
    public String manager() {
        return "projectMilestone";
    }

    /**
     * 项目里程碑列表
     * 可模糊查询
     **/
    @RequestMapping(value = "/pagingProjectMilestone")
    @ResponseBody
    public String pagingProjectMilestone(ProjectMilestone projectMilestone,
                                         @RequestParam(value = "page", defaultValue = "1") Integer page,
                                         @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        return projectMilestoneService.listOfPage(projectMilestone, new PageBean<>(page, rows));
    }

}
