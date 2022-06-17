package com.zijin.educationaladministration.common;

/**
 * @Auth: 丁嘉铧
 * @Desc: 返回结果消息提示常量类
 */
public class MessageConstant {
    //---------------------------班级（Classes）操作消息提示信息---------------------------------------
    public static final String CLASSES_SEARCH_SUCCESS="查询班级信息成功！";
    public static final String CLASSES_ADD_SUCCESS="新增班级信息成功！";
    public static final String CLASSES_ADD_ERROR="当前班级名称重复!";
    public static final String CLASSES_UPDATE_SUCCESS="修改班级信息成功！";
    public static final String CLASSES_DELETE_SUCCESS="删除班级信息成功！";
    public static final String CLASSES_DELETE_ERROR="当前班级还有其他绑定信息存在,无法删除！";
    public static final String CLASSES_FIND_BY_ID_SUCCESS = "根据主键获取班级对象成功！";
    //---------------------------专业（Major）操作消息提示信息---------------------------------------
    public static final String MAJOR_SEARCH_SUCCESS="查询专业信息成功！";
    public static final String MAJOR_ADD_SUCCESS="新增专业信息成功！";
    public static final String MAJOR_ADD_ERROR="当前专业名称重复!";
    public static final String MAJOR_UPDATE_SUCCESS="修改专业信息成功！";
    public static final String MAJOR_DELETE_SUCCESS="删除专业信息成功！";
    public static final String MAJOR_DELETE_ERROR="当前专业还有其他绑定信息存在,无法删除！";
    public static final String MAJOR_FIND_BY_ID_SUCCESS = "根据主键获取专业对象成功！";
    //---------------------------学院（College）操作消息提示信息---------------------------------------
    public static final String COLLEGE_SEARCH_SUCCESS="查询学院信息成功！";
    public static final String COLLEGE_ADD_SUCCESS="新增学院信息成功！";
    public static final String COLLEGE_ADD_ERROR="当前学院号存在另一个学院！";
    public static final String COLLEGE_UPDATE_SUCCESS="修改学院信息成功！";
    public static final String COLLEGE_DELETE_SUCCESS="删除学院信息成功！";
    public static final String COLLEGE_DELETE_ERROR="当前学院还有其他绑定信息存在,无法删除！";
    public static final String COLLEGE_FIND_BY_ID_SUCCESS = "根据主键获取学院对象成功！";
    //---------------------------学生（Student）操作消息提示信息---------------------------------------
    public static final String STUDENT_SEARCH_SUCCESS="查询学生信息成功！";
    public static final String STUDENT_ADD_SUCCESS="新增学生信息成功！";
    public static final String STUDENT_ADD_ERROR="当前学号存在另一名学生！";
    public static final String STUDENT_UPDATE_SUCCESS="修改学生信息成功！";
    public static final String STUDENT_DELETE_SUCCESS="删除学生信息成功！";
    public static final String STUDENT_FIND_BY_ID_SUCCESS = "根据主键获取学生对象成功！";
    public static final String STUDENT_UPDATE_STATUS_SUCCESS = "学生状态信息更新成功！";
    //---------------------------教师（Teacher）操作消息提示信息---------------------------------------
    public static final String TEACHER_SEARCH_SUCCESS="查询教师信息成功！";
    public static final String TEACHER_ADD_SUCCESS="新增教师信息成功！";
    public static final String TEACHER_ADD_ERROR="当前工号存在另一名教师！";
    public static final String TEACHER_UPDATE_SUCCESS="修改教师信息成功！";
    public static final String TEACHER_DELETE_SUCCESS="删除教师信息成功！";
    public static final String TEACHER_DELETE_ERROR="删除的教师正在带班,请更换对应班级辅导员！";
    public static final String TEACHER_DELETE_ERROR_DEAN="删除教师是院长,请更换对应学院的院长！";
    public static final String TEACHER_FIND_BY_ID_SUCCESS = "根据主键获取教师对象成功！";
    public static final String TEACHER_UPDATE_STATUS_SUCCESS = "教师状态信息更新成功！";
    //---------------------------账号（Account）操作消息提示信息---------------------------------------
    public static final String ACCOUNT_UPDATE_SUCCESS="修改密码成功！";
    public static final String ACCOUNT_UPDATE_ERROR="输入的新密码和确认密码不一致！";
    public static final String ACCOUNT_UPDATE_ERROR_AGREEMENT="密码不能和原密码一致！";
    //---------------------------系统提示信息----------------------------------------------------------
    public static final String SYSTEM_BUSY = "系统繁忙，请求稍后重试！";
    //---------------------------文件上传提示信息-------------------------------------------------------
    public static final String NO_FILE_SELECTED = "未选择上传的文件,请求选择后上传!";
    public static final String NO_WRITE_PERMISSION = "上传目录没有写权限!";
    public static final String INCORRECT_DIRECTORY_NAME = "目录名不正确!";
    public static final String SIZE_EXCEEDS__LIMIT = "上传文件大小超过限制!";
    public static final String FILE_TYPE_ERROR = "文件类型错误，只允许上传JPG/PNG/JPEG/GIF等图片类型的文件!";

}
