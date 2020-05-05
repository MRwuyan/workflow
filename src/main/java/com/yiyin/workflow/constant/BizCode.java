package com.yiyin.workflow.constant;

/*
 * 00 11 00
 *
 * 业务code
 * 定义原则:根据用户行为定义，如果粉丝操作粉丝圈应定义在粉丝模块
 * 系统错误 code org.springframework.http.HttpStatus
 * 公共模块 code 取值范围 1001-1999
 * 业务模块 code 取值范围 2001-9999
 *
 *      9001-9999 其他
 * @date 2018/4/11 17:14
 */
public interface BizCode {

    //----------------------------- 1001-1999 公共模块 -----------------------------
    /** 操作失败  所有方法默认返回 **/
     Integer FAIL = 1001;

    /** 参数错误 old = 6 **/
     Integer PARAM_ERROR = 1002;

    /** 签名校验失败 old = 7 **/
     Integer SIGNATURE_FAIL = 1003;

    /** 验证码错误 old = 8**/
     Integer VERIFICATION_ERROR = 1004;

    /** 未登录 **/
     Integer NOT_LOGIN  = 1005;


     Integer DELETE_FAIL  = 1006;

    /** 修改失败 **/
     Integer UPDATE_FAIL  = 1007;

    /** 登录失败，用户不存在 **/
    Integer LOGIN_NON_EXISTENT  = 1008;

    /** 数据存在 **/
     Integer DATA_EXISTS = 1009;

    /** 操作异常 **/
     Integer EXEC_EXCEPTION = 1010;

    /** 用户不可用 **/
     Integer USER_NOT_DISABLE = 1011;

    /** 帐号或密码错误 **/
    Integer PWD_ERROR = 1012;


    /** 通用状态 审核状态 审核失败**/
    Integer AUDIT_FAILURE = 1012;
    /** 通用状态 审核状态 审核成功 预留，请使用 HttpStatus.OK.value() **/
    Integer AUDIT_SUCCESS = 1013;
    /** 通用状态 审核状态 审核中  **/
    Integer AUDIT_ING = 1014;
    /** 没有权限  **/
    Integer NOT_AUTH = 1015;

    /** 已经提交审核 **/
    Integer SUBMIT_AUTH = 1016;




    /** org.springframework.http.HttpStatus
    200;	//成功
    400	//错误请求，该请求是无效的
    401	//未授权，验证失败
    403	//服务器拒绝请求，被拒绝调用
    404	//未找到，服务器找不到请求的地址
    405	//方法禁用
    500	//服务器内部错误
    504	//网关超时，服务器在运行，本次请求响应超时，请稍后重试
    **/
}

