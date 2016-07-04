<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入hcharts -->
<script src="${pageContext.request.contextPath}/highcharts4/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/highcharts4/js/highcharts.js" type="text/javascript"></script>
<script type="text/javascript">
	$ (function ()
    {
	    // 	实例化对象
	    var chart = new Highcharts.Chart (
	    {
	        // 		表格对象chart
	        chart :
	        {
	            // 			渲染到id为container的<div> 注意 有 单引号
	            renderTo : 'container',
	            // 			表格样式 column是柱状图样式
	            type : 'column',
	            //          表格事件
	            events :
	            {
		            // 				表格加载数据（load方法）
		            load : function (event)
		            {
			            // ajax请求后台加载数据
			            $.post ("${pageContext.request.contextPath}/customer/findCustomerGc.do", {}, function (result)
			            {
				            //             			定义两个数组，代表X，Y轴
				            var xArr = new Array ();
				            var yArr = new Array ();
				            for (var i = 0; i < result.length; i++)
				            {
					            //             				向X,Y数组（X,Y轴） 写入数据
					            //             				X轴是 名称
					            xArr.push (result[i].customerLevel);
					            //             				Y轴是 数据
					            yArr.push (result[i].customerNum);
					            //             				表格对象chart
					            // 							表格对象的X轴的第一个categories
					            // 							同一端X轴上可以有多个柱状条（xAxis[n]） 下同
					            chart.xAxis[0].categories = xArr;
					            //             				表格对象的Y轴的第一个数据
					            chart.series[0].setData (yArr);
				            }
			            }, "json");
		            }
	            }
	        },
	        //         表格标题
	        title :
	        {
		        text : '客户构成分析'
	        },
	        //         定义X坐标
	        xAxis :
	        {
		        title : '客户等级',
	        // 	            categories : [
	        // 	                    'A', 'B', 'C'
	        // 	            ]
	        },
	        //         定义Y坐标
	        yAxis :
	        {
		        title :
		        {
			        //             	text显示的文本内容
			        text : '客户数量'
		        }
	        },
	        series : [
		        {
			        //         	name的值 决定了 图例（legend）
			        name : '客户等级'
		        }
	        ]
	    });
    });
</script>
<title>Insert title here</title>
</head>
<body style="margin: 1px">
	<!-- 表格数据渲染到对应的<div id=""></div> -->
	<div id="container" style="min-width: 800px; height: 400px"></div>
</body>
</html>