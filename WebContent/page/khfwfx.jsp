<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/highcharts4/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/highcharts4/js/highcharts.js" type="text/javascript"></script>
<script type="text/javascript">
	$ (function ()
    {
	    
	    var chart = new Highcharts.Chart (
	    {
	        chart :
	        {
	            // 			渲染到id为container的div
	            renderTo : 'container',
	            // 			背景颜色
	            plotBackgroundColor : null,
	            //             边框
	            plotBorderWidth : null,
	            //             阴影
	            plotShadow : false,
	            //             表格事件
	            events :
	            {
		            //             	加载数据
		            load : function (event)
		            {
			            //             		获取数据
			            // 					因为饼块的数据（series）就是一个数组格式的数据类型
			            // 					而本例 只需要 获取一个数据 所以是[0]
			            var series = this.series[0];
			            // ajax请求后台加载数据
			            $.post ("${pageContext.request.contextPath}/customer/findCustomerFw.do", {}, function (result)
			            {
				            //             			定义一个数组（二维数组）
				            var xArr = new Array ();
				            for (var i = 0; i < result.length; i++)
				            {
					            // 							因为饼图的数据格式 就是一个 二维的数组格式
					            // 							注意格式 数组下标
					            xArr[i] = new Array ();
					            xArr[i][0] = result[i].serveType;
					            xArr[i][1] = result[i].num;
				            }
				            //             			设置数据
				            series.setData (xArr);
			            }, "json");
		            }
	            }
	        },
	        //         表格名称
	        title :
	        {
		        text : '客服服务分析'
	        },
	        //         提示（即光标移到饼块上后的提示）
	        tooltip :
	        {
		        formatter : function ()
		        {
			        //					point 即为series 即为 饼块的数据对象
			        // 					this.y 获取统计的个数
			        return '<b>' + this.point.name + '</b>:' + Highcharts.numberFormat (this.percentage, 1) + '% ('
			                + this.y + '个)'
		        }
	        },
	        plotOptions :
	        {
		        //         	饼块属性
		        pie :
		        {
		            //             	允许选择
		            allowPointSelect : true,
		            //                 光标属性 （手型）
		            cursor : 'pointer',
		            //                 数据属性
		            dataLabels :
		            {
		                enabled : true,
		                //                     字体颜色 eg 建议：28.6% 中的字体颜色
		                color : 'blue',
		                //                     连接线的颜色（饼块到字体的连接线）eg 建议：28.6% 到饼块的连接线
		                connectorColor : 'red',
		                //                     格式化数据 eg 建议：28.6% 的显示内容
		                // 					point 即为series 即为 饼块的数据对象
		                format : '<b>{point.name}</b>: {point.percentage:.1f} %'
		            }
		        }
	        },
	        //      初始化数据 ， 随便写点 不写会出错
	        series : [
		        {
		            type : 'pie',
		            name : '比例',
		            //             数据动态加载
		            data : [

		            ]
		        }
	        ]
	    });
    });
</script>
<title>Insert title here</title>
</head>
<body style="margin: 1px">
	<div id="container" style="min-width: 800px; height: 400px"></div>
</body>
</html>