package com.njust.milestone.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 项目里程碑
 * </p>
 *
 * @author 修身
 * @since 2019-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("lcb_project_milestone")
@ApiModel(value = "ProjectMilestone对象", description = "项目里程碑")
public class ProjectMilestone implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "序号")
    @TableField("code")
    private Integer code;

    @ApiModelProperty(value = "项目编码")
    @TableField("project_code")
    private String projectCode;

    @ApiModelProperty(value = "项目名称")
    @TableField("project_name")
    private String projectName;

    @ApiModelProperty(value = "工程编码")
    @TableField("engineer_code")
    private String engineerCode;

    @ApiModelProperty(value = "工程名称")
    @TableField("engineer_name")
    private String engineerName;

    @ApiModelProperty(value = "工程电压等级")
    @TableField("engineer_voltage_level")
    private String engineerVoltageLevel;

    @ApiModelProperty(value = "工程性质")
    @TableField("engineer_property")
    private String engineerProperty;

    @ApiModelProperty(value = "建设性质")
    @TableField("construction_property")
    private String constructionProperty;

    @ApiModelProperty(value = "开工时间")
    @TableField("start_time")
    private String startTime;

    @ApiModelProperty(value = "内控开工时间")
    @TableField("incontroller_start_time")
    private String incontrollerStartTime;

    @ApiModelProperty(value = "项目可研批复时间")
    @TableField("project_keyan_audit_time")
    private String projectKeyanAuditTime;

    @ApiModelProperty(value = "项目核准时间")
    @TableField("project_approval_time")
    private String projectApprovalTime;

    @ApiModelProperty(value = "项目初设评审时间")
    @TableField("project_firstreview_time")
    private String projectFirstreviewTime;

    @ApiModelProperty(value = "物资定标时间")
    @TableField("material_calibration_time")
    private String materialCalibrationTime;

    @ApiModelProperty(value = "投产时间")
    @TableField("product_time")
    private String productTime;

    @ApiModelProperty(value = "竣工结算")
    @TableField("completion_settlement")
    private String completionSettlement;

    @ApiModelProperty(value = "项目经理")
    @TableField("project_manager")
    private String projectManager;

    @ApiModelProperty(value = "联系电话")
    @TableField("project_phone")
    private String projectPhone;

    @ApiModelProperty(value = "施工单位经理")
    @TableField("construction_manager")
    private String constructionManager;

    @ApiModelProperty(value = "联系电话")
    @TableField("construction_phone")
    private String constructionPhone;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "最后操作人")
    @TableField("last_operator")
    private String lastOperator;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;


}
