<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:set var="cp" value="<%=basePath%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>数据展示</title>

    <script src="http://webapi.amap.com/loca?key=4ee7322d13aead8173d8066de2708736"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<a href="${cp}">返回首页</a><br>
<div id="user">
    请选择用户的编号： <select class="select" id="user_code" name="user_code" onchange="getdate()">
    <option value="">请选择</option>
</select>
    <input type="submit" value="提交" onclick="getData()">
</div>
<div id='map' style='width:100%; height:1000px;'></div>
</body>
<script  type="text/javascript" >
    $(function () {
        $.ajax({
            type: "post",
            url: "/uid",
            success: function (data) {
                var obj = JSON.parse(data);
                console.log(obj);
                var datas = obj.datas;
                for (var i = 0; i < datas.length; i++) {
                    $('#user_code').append("<option value='" + datas[i].uid + "' >" + datas[i].uid + "</option>");
                }
            },
            error: function () {
                alert("加载失败");
            }
        });
    });
    var loca = Loca.create('map', {
        mapStyle: 'amap://styles/whitesmoke',
        zoom: 10,
        center:[116.326236,39.995805],

    });
    var layer = Loca.visualLayer({
        container: loca,
        type: 'point',
        shape: 'circle'
    });

    var alldatas = [];

    function getData() {
        console.log("123")
        var usernumber = $('#user_code').val();
        $.ajax({
            url: "/listData",
            type: "POST",
            /**
             *必须false才会自动加上正确的Content-Type
             */
            contentType: false,
            /**
             * 必须false才会避开jQuery对 formdata 的默认处理
             * XMLHttpRequest会对 formdata 进行正确的处理
             */
            processData: false,
            success: function (data) {
                var obj = JSON.parse(data);
                var datas = obj.datas;

                for(var i = 0;i<datas.length;i++) {
                    var tempjson={};
                    var lat = datas[i].latitude;
                    var longt = datas[i].longtitude;
                    var temp =[];
                    temp[1] = lat;
                    temp[0] = longt;
                    console.log(temp);
                    tempjson.lnglat=temp;
                    tempjson.name="西城区";
                    tempjson.style="2";
                    alldatas.push(tempjson);
                }
                layer.setData(alldatas, {
                    lnglat: 'lnglat'   // 指定坐标数据的来源，数据格式: 经度在前，维度在后，数组格式。
                });

                // 配置样式
                layer.setOptions({
                    style: {
                        radius: 2,     // 圆形半径，单位像素
                        fill: '#FF3300', // 填充颜色
                        lineWidth: 0.5,   // 边框宽度
                        stroke: '#ffffff'  // 边框颜色
                    }
                });
                layer.render();


            },
            error: function () {

            }
        });
    }

    // 传入原始数据
    console.log(alldatas);

</script>


</html>