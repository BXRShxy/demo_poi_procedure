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
 * 物资供应计划
 * </p>
 *
 * @author 修身
 * @since 2019-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("lcb_material_supply_plan")
@ApiModel(value = "MaterialSupplyPlan对象", description = "物资供应计划")
public class MaterialSupplyPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "序号")
    @TableField("code")
    private Integer code;

    @ApiModelProperty(value = "批次号、物资唯一码")
    @TableField("material_unique_code")
    private String materialUniqueCode;

    @ApiModelProperty(value = "催缴反馈")
    @TableField("remission_feedback")
    private String remissionFeedback;

    @ApiModelProperty(value = "项目编码")
    @TableField("project_code")
    private String projectCode;

    @ApiModelProperty(value = "项目名称")
    @TableField("project_name")
    private String projectName;

    @ApiModelProperty(value = "工程电压等级")
    @TableField("engineer_voltage_level")
    private String engineerVoltageLevel;

    @ApiModelProperty(value = "项目经理")
    @TableField("project_manager")
    private String projectManager;

    @ApiModelProperty(value = "联系电话")
    @TableField("project_phone")
    private String projectPhone;

    @ApiModelProperty(value = "物料编码")
    @TableField("material_code")
    private String materialCode;

    @ApiModelProperty(value = "物料描述")
    @TableField("material_description")
    private String materialDescription;

    @ApiModelProperty(value = "物料扩展编码")
    @TableField("material_expansion_code")
    private String materialExpansionCode;

    @ApiModelProperty(value = "已上报数量")
    @TableField("require_num")
    private Double requireNum;

    @ApiModelProperty(value = "计量单位")
    @TableField("unit")
    private String unit;

    @ApiModelProperty(value = "供应商、联系人、联系方式")
    @TableField("supplier_contact_phone")
    private String supplierContactPhone;

    @ApiModelProperty(value = "合同交货日期")
    @TableField("contract_delivery_date")
    private LocalDate contractDeliveryDate;

    @ApiModelProperty(value = "确定交货期")
    @TableField("certain_delivery_date")
    private LocalDate certainDeliveryDate;

    @ApiModelProperty(value = "物资实际需求时间")
    @TableField("material_actual_delivery")
    private LocalDate materialActualDelivery;

    @ApiModelProperty(value = "图纸交付日期")
    @TableField("draw_lead_date")
    private LocalDate drawLeadDate;

    @ApiModelProperty(value = "技术交底日期")
    @TableField("technology_background_date")
    private LocalDate technologyBackgroundDate;

    @ApiModelProperty(value = "重点物资排产时间")
    @TableField("keymaterial_product_time")
    private String keymaterialProductTime;

    @ApiModelProperty(value = "重点物资到货验收时间")
    @TableField("keymaterial_test_date")
    private LocalDate keymaterialTestDate;

    @ApiModelProperty(value = "物资到货验收时间")
    @TableField("material_arrival_date")
    private LocalDate materialArrivalDate;

    @ApiModelProperty(value = "入库时间")
    @TableField("storage_date")
    private LocalDate storageDate;

    @ApiModelProperty(value = "出库日期")
    @TableField("first_outage_date")
    private LocalDate firstOutageDate;

    @ApiModelProperty(value = "交票时间")
    @TableField("payment_date")
    private LocalDate paymentDate;

    @ApiModelProperty(value = "物资投运时间")
    @TableField("material_delivery_time")
    private LocalDate materialDeliveryTime;

    @ApiModelProperty(value = "物资质保时间")
    @TableField("material_warranty_time")
    private String materialWarrantyTime;

    @ApiModelProperty(value = "物资到货状态")
    @TableField("material_arrival_status")
    private String materialArrivalStatus;

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
