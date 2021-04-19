<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />

    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
    <script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="jquery/bs_typeahead/bootstrap3-typeahead.min.js"></script>
    <base href="<%=basePath%>">
    <title>演示bs_typeahead插件</title>
    <script type="text/javascript">
        $(function () {

            var name2id={};


           $("#customerName").typeahead({
               //source:['动力节点','字节跳动','阿里','小米','大米']
               //query:关键字 节
               //process是一个函数，它可以将后端返回的数据（['动力节点','字节跳动','阿里','小米','大米']），交给source去使用
               source:function(query,process){
                   $.ajax({
                       url:'workbench/transaction/typeahead.do',
                       data:{
                           customerName:query
                       },
                       type:'post',
                       dataType:'json',
                       success:function (data) {
                           //返回customer对象，2个，customerName ['动力节点','字点跳动'],将这个数组交给process,它会将数组给source使用
                           var customerNameArr=[];
                           $.each(data,function(index,obj){
                               //alert(obj.name);
                               customerNameArr.push(obj.name); //栈：入栈push 出栈pop
                               //name2id是json,{'动力节点':'1001',}
                               name2id[obj.name]=obj.id;
                           })
                           process(customerNameArr)

                       }
                   })

               },
               afterSelect:function(item){ //item就是当前选择的customer
                  //alert(item);
                   alert(name2id[item]);
               }
           })
        });
    </script>
</head>
<body>
<input type="text" id="customerName">
</body>
</html>
