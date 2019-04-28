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
 * 已上报物资
 * </p>
 *
 * @author 修身
 * @since 2019-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("lcb_reported_material")
@ApiModel(value = "ReportedMaterial对象", description = "已上报物资")
public class ReportedMaterial implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "物资唯一码")
    @TableField("material_unique_code")
    private String materialUniqueCode;

    @TableField("approval_status")
    private String approvalStatus;

    @TableField("approval_status_description")
    private String approvalStatusDescription;

    @TableField("approval_suggestion")
    private String approvalSuggestion;

    @TableField("right_property")
    private String rightProperty;

    @TableField("construct_property")
    private String constructProperty;

    @TableField("material_code")
    private String materialCode;

    @TableField("material_description")
    private String materialDescription;

    @TableField("material_expansion_code")
    private String materialExpansionCode;

    @TableField("material_expansion_description")
    private String materialExpansionDescription;

    @TableField("big_class")
    private String bigClass;

    @TableField("middle_class")
    private String middleClass;

    @TableField("small_class")
    private String smallClass;

    @TableField("standard_material")
    private String standardMaterial;

    @ApiModelProperty(value = "已申报数量")
    @TableField("reported_num")
    private Double reportedNum;

    @TableField("unit")
    private String unit;

    @TableField("planned_batch_number")
    private String plannedBatchNumber;

    @TableField("planned_batch_name")
    private String plannedBatchName;

    @TableField("project_code")
    private String projectCode;

    @TableField("project_name")
    private String projectName;

    @TableField("engineer_code")
    private String engineerCode;

    @TableField("engineer_number")
    private String engineerNumber;

    @TableField("engineer_voltage_level")
    private String engineerVoltageLevel;

    @TableField("engineer_property")
    private String engineerProperty;

    @TableField("city_level_place")
    private String cityLevelPlace;

    @TableField("estimated_unit_price")
    private Double estimatedUnitPrice;

    @TableField("estimated_total_price")
    private Double estimatedTotalPrice;

    @TableField("delivery_date")
    private LocalDate deliveryDate;

    @TableField("delivery_place")
    private String deliveryPlace;

    @TableField("editor")
    private String editor;

    @TableField("phonenumber")
    private String phonenumber;

    @TableField("demand_plan_remark")
    private String demandPlanRemark;

    @TableField("early_factory")
    private String earlyFactory;

    @TableField("electronic_id")
    private String electronicId;

    @TableField("plan_submission_date")
    private LocalDate planSubmissionDate;

    @TableField("provincial_company_approval_date")
    private LocalDate provincialCompanyApprovalDate;

    @TableField("city_company_approval_date")
    private LocalDate cityCompanyApprovalDate;

    @TableField("provincial_company_return_date")
    private LocalDate provincialCompanyReturnDate;

    @TableField("city_company_return_date")
    private LocalDate cityCompanyReturnDate;

    @TableField("project_account_unit_description")
    private String projectAccountUnitDescription;

    @TableField("specification_model_technical_parameter")
    private String specificationModelTechnicalParameter;

    @TableField("bidding_model")
    private String biddingModel;

    @TableField("kypfwh")
    private String kypfwh;

    @TableField("procurement_method")
    private String procurementMethod;

    @TableField("contract_draft_num")
    private String contractDraftNum;

    @TableField("contract_line_project")
    private String contractLineProject;

    @TableField("plan_code")
    private String planCode;

    @TableField("line_project_num")
    private String lineProjectNum;

    @TableField("plan_type")
    private String planType;

    @TableField("approver")
    private String approver;

    @TableField("dump_order_num")
    private String dumpOrderNum;

    @TableField("outer_phone")
    private String outerPhone;

    @TableField("outer_storekeeper")
    private String outerStorekeeper;

    @TableField("outer_factory")
    private String outerFactory;

    @TableField("outer_material_unique_code")
    private String outerMaterialUniqueCode;

    @TableField("outer_stockplace")
    private String outerStockplace;

    @TableField("inner_phone")
    private String innerPhone;

    @TableField("inner_storekeeper")
    private String innerStorekeeper;

    @TableField("zcddhxm")
    private String zcddhxm;

    @TableField("balance_liku_suggestion")
    private String balanceLikuSuggestion;

    @TableField("liku_blocked_stock")
    private String likuBlockedStock;

    @TableField("material_freezing_voucher_num")
    private String materialFreezingVoucherNum;

    @TableField("project_ledger_unit_code")
    private String projectLedgerUnitCode;

    @TableField("technical_id_state")
    private String technicalIdState;

    @TableField("select_column")
    private String selectColumn;

    @TableField("material_group")
    private String materialGroup;

    @TableField("state_grid_return_time")
    private LocalDate stateGridReturnTime;

    @TableField("county_company_approval_date")
    private LocalDate countyCompanyApprovalDate;

    @TableField("county_company_return_date")
    private LocalDate countyCompanyReturnDate;

    @TableField("emergency_sign")
    private String emergencySign;

    @TableField("plan_type_description")
    private String planTypeDescription;

    @TableField("material_freezing_voucher_year")
    private String materialFreezingVoucherYear;

    @TableField("last_operator")
    private String lastOperator;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("create_time")
    private LocalDateTime createTime;


}
