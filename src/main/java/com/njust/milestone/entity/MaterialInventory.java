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
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 材料清册
 * </p>
 *
 * @author 修身
 * @since 2019-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("lcb_material_inventory")
@ApiModel(value = "MaterialInventory对象", description = "材料清册")
public class MaterialInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "序号")
    @TableField("code")
    private Integer code;

    @ApiModelProperty(value = "物料编码")
    @TableField("material_code")
    private String materialCode;

    @ApiModelProperty(value = "物料描述")
    @TableField("material_description")
    private String materialDescription;

    @ApiModelProperty(value = "物料扩展编码")
    @TableField("material_expansion_code")
    private String materialExpansionCode;

    @ApiModelProperty(value = "物料扩展描述")
    @TableField("material_expansion_description")
    private String materialExpansionDescription;

    @ApiModelProperty(value = "大类")
    @TableField("big_class")
    private String bigClass;

    @ApiModelProperty(value = "中类")
    @TableField("middle_class")
    private String middleClass;

    @ApiModelProperty(value = "小类")
    @TableField("small_class")
    private String smallClass;

    @ApiModelProperty(value = "标准物料")
    @TableField("standard_material")
    private String standardMaterial;

    @ApiModelProperty(value = "需求数量")
    @TableField("require_num")
    private Double requireNum;

    @ApiModelProperty(value = "计量单位")
    @TableField("unit")
    private String unit;

    @ApiModelProperty(value = "项目编码")
    @TableField("project_code")
    private String projectCode;

    @ApiModelProperty(value = "项目名称")
    @TableField("project_name")
    private String projectName;

    @ApiModelProperty(value = "工程名称")
    @TableField("engineer_code")
    private String engineerCode;

    @ApiModelProperty(value = "工程编码")
    @TableField("engineer_name")
    private String engineerName;

    @ApiModelProperty(value = "工程电压等级")
    @TableField("engineer_voltage_level")
    private String engineerVoltageLevel;

    @ApiModelProperty(value = "概算单价")
    @TableField("estimated_unit_price")
    private Double estimatedUnitPrice;

    @ApiModelProperty(value = "概算总价")
    @TableField("estimated_total_price")
    private Double estimatedTotalPrice;

    @ApiModelProperty(value = "交货日期")
    @TableField("delivery_date")
    private LocalDate deliveryDate;

    @ApiModelProperty(value = "交货地点")
    @TableField("delivery_place")
    private String deliveryPlace;

    @ApiModelProperty(value = "编制人")
    @TableField("editor")
    private String editor;

    @ApiModelProperty(value = "电子商务平台技术规范书ID")
    @TableField("electronic_id")
    private String electronicId;

    @ApiModelProperty(value = "上报状态")
    @TableField("state")
    private String state;

    @ApiModelProperty(value = "合理交货期")
    @TableField("reasonable_delivery_time")
    private String reasonableDeliveryTime;

    @ApiModelProperty(value = "最迟上报批次")
    @TableField("latest_report_batch")
    private String latestReportBatch;

    @ApiModelProperty(value = "最佳上报批次")
    @TableField("best_report_batch")
    private String bestReportBatch;

    @ApiModelProperty(value = "最迟上报批次类型")
    @TableField("last_batch_type")
    private String lastBatchType;

    @ApiModelProperty(value = "最佳上报批次类型")
    @TableField("best_batch_type")
    private String bestBatchType;

    @ApiModelProperty(value = "供应计划调整最迟时间")
    @TableField("supply_plan_latest_time")
    private String supplyPlanLatestTime;

    @ApiModelProperty(value = "项目经理")
    @TableField("project_manager")
    private String projectManager;

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
