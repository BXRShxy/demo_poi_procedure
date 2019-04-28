package com.njust.milestone.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njust.milestone.entity.MaterialMilestone;
import com.njust.milestone.entity.PageBean;
import com.njust.milestone.mapper.MaterialMilestoneMapper;
import com.njust.milestone.service.IMaterialMilestoneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 物资里程碑 服务实现类
 * </p>
 *
 * @author 修身
 * @since 2019-04-25
 */
@Service
public class MaterialMilestoneServiceImpl extends ServiceImpl<MaterialMilestoneMapper, MaterialMilestone> implements IMaterialMilestoneService {

    @Resource
    private MaterialMilestoneMapper materialMilestoneMapper;

    @Override
    public String listOfPage(MaterialMilestone materialMilestone, PageBean<MaterialMilestone> pageBean) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("projectName", materialMilestone.getProjectName());
            map.put("engineerName", materialMilestone.getEngineerName());
            map.put("projectManager", materialMilestone.getProjectManager());
            //查询记录总数
            pageBean.setTotal(materialMilestoneMapper.totalOfList(map));
            map.put("start", pageBean.getStart());
            map.put("end", pageBean.getEnd());
            //查询总记录结果
            pageBean.setResult(materialMilestoneMapper.listOfPage(map));

            JSONObject result = new JSONObject();
            result.put("rows", pageBean.getResult());
            result.put("total", pageBean.getTotal());
            return JSON.toJSONString(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void generateMaterialMilestone() {
        materialMilestoneMapper.generateMaterialMilestone();
    }

    @Override
    public String findRecentMilestone(PageBean<MaterialMilestone> pageBean) {
        //查询分页结果
        pageBean.setResult(materialMilestoneMapper.findRecentMilestone(pageBean.getStart(), pageBean.getEnd()));
        //查询记录总数
        pageBean.setTotal(materialMilestoneMapper.getMaterialMilestoneTotal());
        JSONObject result = new JSONObject();
        result.put("rows", pageBean.getResult());
        result.put("total", pageBean.getTotal());
        return JSON.toJSONString(result);
    }


}
