package com.njust.milestone.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 物资里程碑
 * </p>
 *
 * @author 修身
 * @since 2019-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("lcb_material_milestone")
@ApiModel(value="MaterialMilestone对象", description="物资里程碑")
public class MaterialMilestone implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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
    private LocalDate startTime;

    @ApiModelProperty(value = "内控开工时间")
    @TableField("incontroller_start_time")
    private LocalDate incontrollerStartTime;

    @ApiModelProperty(value = "项目可研批复时间")
    @TableField("project_keyan_audit_time")
    private LocalDate projectKeyanAuditTime;

    @ApiModelProperty(value = "项目核准时间")
    @TableField("project_approval_time")
    private LocalDate projectApprovalTime;

    @ApiModelProperty(value = "项目初设评审时间")
    @TableField("project_firstreview_time")
    private LocalDate projectFirstreviewTime;

    @ApiModelProperty(value = "物资定标时间")
    @TableField("material_calibration_time")
    private LocalDate materialCalibrationTime;

    @ApiModelProperty(value = "投产时间")
    @TableField("product_time")
    private LocalDate productTime;

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

    @ApiModelProperty(value = "物资唯一码")
    @TableField("material_unique_code")
    private String materialUniqueCode;

    @ApiModelProperty(value = "大类")
    @TableField("big_class")
    private String bigClass;

    @ApiModelProperty(value = "中类")
    @TableField("middle_class")
    private String middleClass;

    @ApiModelProperty(value = "小类")
    @TableField("small_class")
    private String smallClass;
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

    @ApiModelProperty(value = "标准物料")
    @TableField("standard_material")
    private String standardMaterial;

    @ApiModelProperty(value = "需求数量")
    @TableField("require_num")
    private Double requireNum;

    @ApiModelProperty(value = "实际数量")
    @TableField("reported_num")
    private Double reportedNum;

    @ApiModelProperty(value = "计量单位")
    @TableField("unit")
    private String unit;

    @TableField("planned_batch_name")
    private String plannedBatchName;

    @TableField("planned_batch_number")
    private String plannedBatchNumber;

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
    @TableField("report_state")
    private String reportState;

    @ApiModelProperty(value = "合理交货期")
    @TableField("reasonable_delivery_time")
    private String reasonableDeliveryTime;

    @ApiModelProperty(value = "最佳上报批次")
    @TableField("best_report_batch")
    private String bestReportBatch;

    @ApiModelProperty(value = "最迟上报批次")
    @TableField("latest_report_batch")
    private String latestReportBatch;

    @ApiModelProperty(value = "最迟上报批次类型")
    @TableField("last_batch_type")
    private String lastBatchType;

    @ApiModelProperty(value = "最佳上报批次类型")
    @TableField("best_batch_type")
    private String bestBatchType;

    @ApiModelProperty(value = "供应计划调整最迟时间")
    @TableField("supply_plan_latest_time")
    private String supplyPlanLatestTime;

    @ApiModelProperty(value = "催缴反馈")
    @TableField("remission_feedback")
    private String remissionFeedback;

    @ApiModelProperty(value = "供应商、联系人、联系方式")
    @TableField("supplier_contact_phone")
    private String supplierContactPhone;

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
