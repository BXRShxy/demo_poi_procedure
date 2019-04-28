package com.njust.milestone.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njust.milestone.entity.PageBean;
import com.njust.milestone.entity.ProjectMilestone;
import com.njust.milestone.mapper.ProjectMilestoneMapper;
import com.njust.milestone.service.IProjectMilestoneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 项目里程碑 服务实现类
 * </p>
 *
 * @author 修身
 * @since 2019-04-25
 */
@Service
public class ProjectMilestoneServiceImpl extends ServiceImpl<ProjectMilestoneMapper, ProjectMilestone> implements IProjectMilestoneService {

    @Resource
    private ProjectMilestoneMapper projectMilestoneMapper;

    @Override
    public String listOfPage(ProjectMilestone projectMilestone, PageBean<ProjectMilestone> pageBean) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("projectName", projectMilestone.getProjectName());
            map.put("engineerName", projectMilestone.getEngineerName());
            map.put("projectManager", projectMilestone.getProjectManager());
            //查询记录总数
            pageBean.setTotal(projectMilestoneMapper.totalOfList(map));
            map.put("start", pageBean.getStart());
            map.put("end", pageBean.getEnd());
            //查询总记录结果
            pageBean.setResult(projectMilestoneMapper.listOfPage(map));

            JSONObject result = new JSONObject();
            result.put("rows", pageBean.getResult());
            result.put("total", pageBean.getTotal());
            return JSON.toJSONString(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
