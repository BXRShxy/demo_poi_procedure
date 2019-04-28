package com.njust.milestone.excel;

import com.njust.milestone.entity.ProjectMilestone;
import com.njust.milestone.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class ProjectMilestoneImp {

    private static final String SQL_FIND = " SELECT * FROM lcb_project_milestone WHERE engineer_code = ?";

    private static final String SQL_SAVE = " INSERT INTO lcb_project_milestone(code,project_code,project_name,engineer_voltage_level," +
            "engineer_property,construction_property,engineer_code,engineer_name,start_time,project_firstreview_time,product_time,project_manager," +
            "project_phone) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

    //判断数据库是否已存在此条数据
    boolean exist(ProjectMilestone projectMilestone) {
        Connection conn = null;
        PreparedStatement prep = null;
        boolean exist = false;

        if (projectMilestone.getEngineerCode() != null) {
            try {
                conn = DBUtil.getConnection();
                prep = conn.prepareStatement(SQL_FIND);
                prep.setString(1, projectMilestone.getEngineerCode());
                ResultSet rs = prep.executeQuery();
                if (rs.next()) {
                    exist = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.release(prep, conn);
            }
        }
        return exist;
    }

    //保存到数据库
    void save(ProjectMilestone projectMilestone) {
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBUtil.getConnection();
            prep = conn.prepareStatement(SQL_SAVE);
            prep.setInt(1, projectMilestone.getCode());
            prep.setString(2, projectMilestone.getProjectCode());
            prep.setString(3, projectMilestone.getProjectName());
            prep.setString(4, projectMilestone.getEngineerVoltageLevel());
            prep.setString(5, projectMilestone.getEngineerProperty());
            prep.setString(6, projectMilestone.getConstructionProperty());
            prep.setString(7, projectMilestone.getEngineerCode());
            prep.setString(8, projectMilestone.getEngineerName());
            prep.setString(9, projectMilestone.getStartTime());
            prep.setString(10, projectMilestone.getProjectFirstreviewTime());
            prep.setString(11, projectMilestone.getProductTime());
            prep.setString(12, projectMilestone.getProjectManager());
            prep.setString(13, projectMilestone.getProjectPhone());
            int i = prep.executeUpdate();

            if (i > 0) {
                System.out.print(" --> 1 row affected...");
            } else if (i == 0) {
                System.out.print("insert failed...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.release(prep, conn);
        }
    }
}
