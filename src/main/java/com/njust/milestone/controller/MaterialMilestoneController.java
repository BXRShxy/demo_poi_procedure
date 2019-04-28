package com.njust.milestone.controller;


import com.njust.milestone.entity.MaterialMilestone;
import com.njust.milestone.entity.PageBean;
import com.njust.milestone.service.IMaterialMilestoneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * <p>
 * 物资里程碑 前端控制器
 * </p>
 *
 * @author 修身
 * @since 2019-04-25
 */
@Controller
@RequestMapping("/materialMilestone")
public class MaterialMilestoneController {

    @Resource
    private IMaterialMilestoneService materialMilestoneService;

    /**
     * 进入物资里程碑页面
     * <p>
     * url: http://www.localhost:8080/materialMilestone/manager
     **/
    @RequestMapping("/manager")
    public String manager() {
        return "materialMilestone";
    }

    /**
     * 物资里程碑列表
     * 可模糊查询
     **/
    @RequestMapping(value = "/pagingMaterialMilestone")
    @ResponseBody
    public String pagingMaterialMilestone(MaterialMilestone materialMilestone,
                                          @RequestParam(value = "page", defaultValue = "1") Integer page,
                                          @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        return materialMilestoneService.findRecentMilestone(new PageBean<>(page, rows));
    }

    /**
     * 调用存储过程，获取最新记录
     */
    @RequestMapping(value = "/pagingLatestMilestone")
    @ResponseBody
    public String pageBeanMaterialMilestone(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                            @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        materialMilestoneService.generateMaterialMilestone();
        return materialMilestoneService.findRecentMilestone(new PageBean<>(page, rows));
    }

}
