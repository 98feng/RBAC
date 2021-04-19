<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">

    <link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <link href="jquery/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" type="text/css"
          rel="stylesheet"/>

    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
    <script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="jquery/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript"
            src="jquery/bootstrap-datetimepicker-master/salale/bootstrap-datetimepicker.zh-CN.js"></script>

    <link rel="stylesheet" type="text/css" href="jquery/bs_pagination/jquery.bs_pagination.min.css">
    <script type="text/javascript" src="jquery/bs_pagination/jquery.bs_pagination.min.js"></script>
    <script type="text/javascript" src="jquery/bs_pagination/en.js"></script>


    <script type="text/javascript">

        $(function () {

            //为创建按钮绑定事件，打开添加操作的模态窗口
            $("#addBtn").click(function () {

                $(".time").datetimepicker({
                    minView: "month",
                    language: 'zh-CN',
                    format: 'yyyy-mm-dd',
                    autoclose: true,
                    todayBtn: true,
                    pickerPosition: "bottom-left"
                });
                /*

                    操作模态窗口的方式：

                        需要操作的模态窗口的jquery对象，调用modal方法，为该方法传递参数 show:打开模态窗口   hide：关闭模态窗口


                 */

                //走后台，目的是为了取得用户信息列表，为所有者下拉框铺值
                $.ajax({

                    url: "workbench/empActivity/getUserList.do",
                    type: "get",
                    dataType: "json",
                    success: function (data) {

                        /*

                            data
                                [{"id":?,"name":?,"loginAct":?.......},{2},{3}...]

                         */

                        var html = "<option></option>";

                        //遍历出来的每一个n，就是每一个user对象
                        $.each(data, function (i, n) {

                            html += "<option value='" + n.id + "'>" + n.name + "</option>";

                        })

                        $("#create-owner").html(html);
                        //在js中使用el表达式，el表达式一定要套用在字符串中
                        var id = "${user.id}";

                        $("#create-owner").val(id);
                        //所有者下拉框处理完毕后，展现模态窗口
                        $("#createActivityModal").modal("show");

                    }

                })


            })


            //为保存按钮绑定事件，执行添加操作
            $("#saveBtn").click(function () {

                $.ajax({

                    url: "workbench/empActivity/creatActivity.do",
                    data: {

                        "owner": $.trim($("#create-owner").val()),
                        "ename": $.trim($("#create-ename").val()),
                        "job": $.trim($("#create-job").val()),
                        "sal": $.trim($("#create-sal").val()),
                        "comm": $.trim($("#create-comm").val()),
                        "mgr": $.trim($("#create-mgr").val()),
                        "startDate": $.trim($("#create-startDate").val()),
                        "description": $.trim($("#create-description").val())

                    },
                    type: "post",
                    dataType: "json",
                    success: function (data) {

                        /*

                            data
                                {"success":true/false}

                         */
                        if (data.success) {


                            //做完添加操作后，应该回到第一页，维持每页展现的记录数

                            pageList(1, $("#empActivityPage").bs_pagination('getOption', 'rowsPerPage'));


                            $("#empActivityAddForm")[0].reset();

                            //关闭添加操作的模态窗口
                            $("#createActivityModal").modal("hide");


                        } else {

                            alert("添加信息活动失败");

                        }


                    }

                })

            })


            //页面加载完毕后触发一个方法
            //默认展开列表的第一页，每页展现两条记录
            pageList(1, 7);

            //为查询按钮绑定事件，触发pageList方法
            $("#searchBtn").click(function () {
                /*

                    点击查询按钮的时候，我们应该将搜索框中的信息保存起来,保存到隐藏域中


                 */

                $("#hidden-ename").val($.trim($("#search-ename").val()));
                $("#hidden-owner").val($.trim($("#search-owner").val()));
                $("#hidden-job").val($.trim($("#search-job").val()));
                $("#hidden-sal").val($.trim($("#search-sal").val()));
                $("#hidden-comm").val($.trim($("#search-comm").val()));
                $("#hidden-mgr").val($.trim($("#search-mgr").val()));
                $("#hidden-startDate").val($.trim($("#search-startDate").val()));

                pageList(1, 7);

            })


            //为全选的复选框绑定事件，触发全选操作
            $("#qx").click(function () {

                $("input[name=xz]").prop("checked", this.checked);

            })


            $("#empActivityBody").on("click", $("input[name=xz]"), function () {

                $("#qx").prop("checked", $("input[name=xz]").length == $("input[name=xz]:checked").length);

            })

            //为删除按钮绑定事件，执行信息活动删除操作
            $("#deleteBtn").click(function () {

                //找到复选框中所有挑√的复选框的jquery对象
                var $xz = $("input[name=xz]:checked");

                if ($xz.length === 0) {

                    alert("请选择需要删除的记录");

                    //肯定选了，而且有可能是1条，有可能是多条
                } else {


                    if (confirm("确定删除所选中的记录吗？")) {

                        //url:workbench/empActivity/delete.do?id=xxx&id=xxx&id=xxx

                        //拼接参数
                        var param = "";

                        //将$xz中的每一个dom对象遍历出来，取其value值，就相当于取得了需要删除的记录的id
                        for (var i = 0; i < $xz.length; i++) {

                            param += "id=" + $($xz[i]).val();

                            //如果不是最后一个元素，需要在后面追加一个&符
                            if (i < $xz.length - 1) {

                                param += "&";

                            }

                        }

                        //alert(param);
                        $.ajax({

                            url: "workbench/empActivity/delete.do",
                            data: param,
                            type: "post",
                            dataType: "json",
                            success: function (data) {

                                /*

                                    data
                                        {"success":true/false}

                                 */
                                if (data.success) {

                                    //删除成功后
                                    //回到第一页，维持每页展现的记录数
                                    pageList(1, $("#empActivityPage").bs_pagination('getOption', 'rowsPerPage'));


                                } else {

                                    alert("删除信息活动失败");

                                }


                            }

                        })


                    }


                }


            })


            //为修改按钮绑定事件，打开修改操作的模态窗口
            $("#editBtn").click(function () {

                var $xz = $("input[name=xz]:checked");

                if ($xz.length == 0) {

                    alert("请选择需要修改的记录");

                } else if ($xz.length > 1) {

                    alert("只能选择一条记录进行修改");

                    //肯定只选了一条
                } else {

                    var id = $xz.val();

                    $.ajax({

                        url: "workbench/empActivity/getUserListAndActivity.do",
                        data: {

                            "id": id

                        },
                        type: "get",
                        dataType: "json",
                        success: function (data) {

                            /*

                                data
                                    用户列表
                                    信息活动对象

                                    {"uList":[{用户1},{2},{3}],"a":{信息活动}}

                             */

                            //处理所有者下拉框
                            var html = "<option></option>";

                            $.each(data.uList, function (i, n) {

                                html += "<option value='" + n.id + "'>" + n.name + "</option>";

                            })

                            $("#edit-owner").html(html);


                            //处理单条empActivity
                            $("#edit-id").val(data.a.id);
                            $("#edit-ename").val(data.a.ename);
                            $("#edit-owner").val(data.a.owner);
                            $("#edit-job").val(data.a.job);
                            $("#edit-sal").val(data.a.sal);
                            $("#edit-comm").val(data.a.comm);
                            $("#edit-mgr").val(data.a.mgr);
                            $("#edit-startDate").val(data.a.startDate);
                            $("#edit-description").val(data.a.description);

                            //所有的值都填写好之后，打开修改操作的模态窗口
                            $("#editActivityModal").modal("show");

                        }

                    })

                }

            })
            $("#updateBtn").click(function () {

                $.ajax({

                    url: "workbench/empActivity/update.do",
                    data: {

                        "id": $.trim($("#edit-id").val()),
                        "owner": $.trim($("#edit-owner").val()),
                        "ename": $.trim($("#edit-ename").val()),
                        "job": $.trim($("#edit-job").val()),
                        "sal": $.trim($("#edit-sal").val()),
                        "comm": $.trim($("#edit-comm").val()),
                        "mgr": $.trim($("#edit-mgr").val()),
                        "startDate": $.trim($("#edit-startDate").val()),
                        "description": $.trim($("#edit-description").val())

                    },
                    type: "post",
                    dataType: "json",
                    success: function (data) {

                        /*

                            data
                                {"success":true/false}

                         */
                        if (data.success) {
                            pageList($("#empActivityPage").bs_pagination('getOption', 'currentPage')
                                , $("#empActivityPage").bs_pagination('getOption', 'rowsPerPage'));


                            //关闭修改操作的模态窗口
                            $("#editActivityModal").modal("hide");


                        } else {

                            alert("修改信息活动失败");

                        }


                    }

                })

            })


        });

        function pageList(pageNo, pageSize) {

            //将全选的复选框的√干掉
            $("#qx").prop("checked", false);

            //查询前，将隐藏域中保存的信息取出来，重新赋予到搜索框中
            $("#search-name").val($.trim($("#hidden-name").val()));
            $("#search-owner").val($.trim($("#hidden-owner").val()));
            $("#search-ename").val($.trim($("#hidden-ename").val()));
            $("#search-job").val($.trim($("#hidden-job").val()));
            $("#search-sal").val($.trim($("#hidden-sal").val()));
            $("#search-comm").val($.trim($("#hidden-comm").val()));
            $("#search-mgr").val($.trim($("#hidden-mgr").val()));
            $("#search-startDate").val($.trim($("#hidden-startDate").val()));

            $.ajax({

                url: "workbench/empActivity/pageList.do",
                data: {

                    "pageNo": pageNo,
                    "pageSize": pageSize,
                    "owner": $.trim($("#search-owner").val()),
                    "ename": $.trim($("#search-ename").val()),
                    "job": $.trim($("#search-job").val()),
                    "sal": $.trim($("#search-sal").val()),
                    "comm": $.trim($("#search-comm").val()),
                    "mgr": $.trim($("#search-mgr").val()),
                    "startDate": $.trim($("#search-startDate").val()),

                },
                type: "get",
                dataType: "json",
                success: function (data) {

                    /*

                        data

                            信息活动信息列表
                            [{信息活动1},{2},{3}] List<Activity> aList
                            一会分页插件需要的：查询出来的总记录数
                            {"total":100} int total

                            {"total":100,"dataList":[{信息活动1},{2},{3}]}

                     */

                    var html = "";

                    //每一个n就是每一个信息活动对象
                    $.each(data.dataList, function (i, n) {

                        html += '<tr class="active">';
                        html += '<td><input type="checkbox" name="xz" value="' + n.id + '"/></td>';
                        html += '<td><a style="text-decoration: none; cursor: pointer;" onclick="window.location.href=\'workbench/empActivity/detail.do?id=' + n.id + '\';">' + n.ename + '</a></td>';
                        html += '<td>' + n.owner + '</td>';
                        html += '<td>' + n.job + '</td>';
                        html += '<td>' + n.sal + '</td>';
                        html += '<td>' + n.comm + '</td>';
                        html += '<td>' + n.mgr + '</td>';
                        html += '<td>' + n.startDate + '</td>';
                        html += '</tr>';

                    })

                    $("#empActivityBody").html(html);

                    //计算总页数
                    var totalPages = data.total % pageSize == 0 ? data.total / pageSize : parseInt(data.total / pageSize) + 1;

                    //数据处理完毕后，结合分页查询，对前端展现分页信息
                    $("#empActivityPage").bs_pagination({
                        currentPage: pageNo, // 页码
                        rowsPerPage: pageSize, // 每页显示的记录条数
                        maxRowsPerPage: 20, // 每页最多显示的记录条数
                        totalPages: totalPages, // 总页数
                        totalRows: data.total, // 总记录条数

                        visiblePageLinks: 3, // 显示几个卡片

                        showGoToPage: true,
                        showRowsPerPage: true,
                        showRowsInfo: true,
                        showRowsDefaultInfo: true,

                        //该回调函数时在，点击分页组件的时候触发的
                        onChangePage: function (event, data) {
                            pageList(data.currentPage, data.rowsPerPage);
                        }
                    });


                }

            })

        }


        $(function () {
            $("#search-startDate").click(function () {
                $(".time").datetimepicker({
                    minView: "month",
                    language: 'zh-CN',
                    format: 'yyyy-mm-dd',
                    autoclose: true,
                    todayBtn: true,
                    pickerPosition: "bottom-left"
                });
            })
        })
    </script>
</head>
<body>

<input type="hidden" id="hidden-name"/>
<input type="hidden" id="hidden-owner"/>
<input type="hidden" id="hidden-ename"/>
<input type="hidden" id="hidden-job"/>
<input type="hidden" id="hidden-sal"/>
<input type="hidden" id="hidden-comm"/>
<input type="hidden" id="hidden-mgr"/>
<input type="hidden" id="hidden-startDate"/>


<!-- 修改信息活动的模态窗口 -->
<div class="modal fade" id="editActivityModal" role="dialog">
    <div class="modal-dialog" role="document" style="width: 85%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel2">修改信息活动</h4>
            </div>
            <div class="modal-body">

                <form class="form-horizontal" role="form">

                    <input type="hidden" id="edit-id"/>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">管理员<span
                                style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <select class="form-control" id="edit-owner">


                            </select>
                        </div>
                        <label class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="edit-ename">
                        </div>
                        <br>
                        <br>
                        <label class="col-sm-2 control-label">工作<span
                                style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="edit-job">
                        </div>
                        <label class="col-sm-2 control-label">工资</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="edit-sal">
                        </div>
                        <label class="col-sm-2 control-label">津贴</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="edit-comm">
                        </div>
                        <label class="col-sm-2 control-label">上级领导</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="edit-mgr">
                        </div>

                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">入职日期</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control time" id="edit-startDate">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">描述</label>
                        <div class="col-sm-10" style="width: 81%;">
                            <textarea class="form-control" rows="3" id="edit-description"></textarea>
                        </div>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="updateBtn">更新</button>
            </div>
        </div>
    </div>
</div>

<!-- 创建信息活动的模态窗口 -->
<div class="modal fade" id="createActivityModal" role="dialog">
    <div class="modal-dialog" role="document" style="width: 85%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel1">创建信息</h4>
            </div>
            <div class="modal-body">

                <form id="empActivityAddForm" class="form-horizontal" role="form">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">管理员<span
                                style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <select class="form-control" id="create-owner">
                            </select>
                        </div>
                        <label class="col-sm-2 control-label">姓名<span
                                style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="create-ename">
                        </div>
                        <br>
                        <br>
                        <label class="col-sm-2 control-label">工作<span
                                style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="create-job">
                        </div>
                        <label class="col-sm-2 control-label">工资</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="create-sal">
                        </div>
                        <label class="col-sm-2 control-label">津贴</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="create-comm">
                        </div>
                        <label class="col-sm-2 control-label">上级领导</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="create-mgr">
                        </div>

                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">入职日期</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control time" id="create-startDate">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">描述</label>
                        <div class="col-sm-10" style="width: 81%;">
                            <textarea class="form-control" rows="3" id="create-description"></textarea>
                        </div>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="saveBtn">保存</button>
            </div>
        </div>
    </div>
</div>


<div>
    <div style="position: relative; left: 10px; top: -10px;">
        <div class="page-header">
            <h3>信息活动列表</h3>
        </div>
    </div>
</div>
<div style="position: relative; top: -20px; left: 0px; width: 100%; height: 100%;">
    <div style="width: 100%; position: absolute;top: 5px; left: 10px;">

        <div class="btn-toolbar" role="toolbar" style="height: 80px;">
            <form class="form-inline" role="form" style="position: relative;top: 8%; left: 5px;">

                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">管理员</div>
                        <input class="form-control" type="text" id="search-owner">
                        <div class="input-group-addon">员工姓名</div>
                        <input class="form-control" type="text" id="search-ename">
                        <div class="input-group-addon">工作</div>
                        <input class="form-control" type="text" id="search-job">
                        <div class="input-group-addon">工资</div>
                        <input class="form-control" type="text" id="search-sal">
                        <div class="input-group-addon">津贴</div>
                        <input class="form-control" type="text" id="search-comm">
                        <div class="input-group-addon">入职日期</div>
                        <input class="form-control time" type="text" id="search-startDate"/>
                        <div class="input-group-addon">上级领导</div>
                        <input class="form-control" type="text" id="search-mgr">
                    </div>
                </div>
                <button type="button" id="searchBtn" class="btn btn-default">查询</button>

            </form>
        </div>
        <div class="btn-toolbar" role="toolbar"
             style="background-color: #F7F7F7; height: 50px; position: relative;top: 5px;">
            <div class="btn-group" style="position: relative; top: 30%;">
                <button type="button" class="btn btn-primary" id="addBtn"><span class="glyphicon glyphicon-plus"></span>
                    创建
                </button>
                <button type="button" class="btn btn-default" id="editBtn"><span
                        class="glyphicon glyphicon-pencil"></span> 修改
                </button>
                <button type="button" class="btn btn-danger" id="deleteBtn"><span
                        class="glyphicon glyphicon-minus"></span> 删除
                </button>
            </div>
        </div>
        <div style="position: relative;top: 10px;">
            <table class="table table-hover">
                <thead>
                <tr style="color: #B3B3B3;">
                    <td><input type="checkbox" id="qx"/></td>
                    <td>员工姓名</td>
                    <td>管理员</td>
                    <td>工作</td>
                    <td>工资</td>
                    <td>津贴</td>
                    <td>上级领导</td>
                    <td>入职日期</td>
                </tr>
                </thead>
                <tbody id="empActivityBody">
                <%--<tr class="active">
                    <td><input type="checkbox" /></td>
                    <td><a style="text-decoration: none; cursor: pointer;" onclick="window.salation.href='workbench/empActivity/detaildept.jsp';">发传单</a></td>
                    <td>zhangsan</td>
                    <td>2020-10-10</td>
                    <td>2020-10-20</td>
                </tr>
                <tr class="active">
                    <td><input type="checkbox" /></td>
                    <td><a style="text-decoration: none; cursor: pointer;" onclick="window.salation.href='detaildept.jsp';">发传单</a></td>
                    <td>zhangsan</td>
                    <td>2020-10-10</td>
                    <td>2020-10-20</td>
                </tr>--%>
                </tbody>
            </table>
        </div>

        <div style="height: 50px; position: relative;top: 30px;">

            <div id="empActivityPage"></div>

        </div>

    </div>

</div>
</body>
</html>