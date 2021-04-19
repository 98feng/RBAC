/*
  一。document对象对于DOM对象定位方式

      var dom = document.getElementById("id")
	  var domArray = document.getElementsByName("name")
	  var domArray =document.getElementByTagName("标签类型名")

  二。JavaScript标识符命名规则:
      1.标识符可以由四种符号 字母，数字，_,$
	  2.标识符不能以数字开头
	  3.标识符不能使用JavaScript关键字

  三  $(param):
      param表示用于定位DOM对象定位条件(id编号，name属性值，标签类型名)
	  使用时
	  比如定位id等于one的标签的关联的DOM对象
	  var dom = $("one")
	  定位name等于ck的标签关联的DOM对象
	  var dom =$("ck")

 四。根据条件定位DOM对象实现时遇到问题
      $("one"),此时"one"含义如何判断？？？？
	  参考CSS选择器，CSS选择器根据判断条件定位HTML标签
	  #one{
	  
	  } 定位id=one的html标签
	  tr{
	  } 定位类型为tr的标签

	  使用特定修饰符描述参数含义
	  $("#one")：根据ID编号定位标签关联的DOM
	  $(".one"): 根据name属性值定位标签关联的DOM
	  $("tr")  : 根据标签类型名定位标签关联的DOM

 五。过滤器设置:

      1.参考依据：DOM对象在数组中存放位置与关联的标签在页面
	              中声明顺序一一对应
      2.过滤条件:

	          $("div:first"):定位第一个DIV
			  $("div:last"): 定位最后一个DIV
			  $("div:eq(1)"):定位第二个DIV
			  $("div:eq(3)"):定位第四个DIV
			  $("div:gt(1)"): "gt"表示大于,定位页面第二个DIV之后所有div关联的DOM
			                        0         1       2      3
							  array[ div_1 ] [div_2] [div_3][div_4]
							  过滤之后
							  array    0        1
							        [div_3]  [div_4]
              $("div:gt(0)"):定位页面第一个DIV之后所有DIV关联的DOM

 六。Jquery对象：

      1.Jquery对象就是一个数组 (var array = new Array())
	  2.这个数组存放本次定位的DOM对象
	  3.Jquery对象可以帮助开发人员对DOM对象进行管理
	  4.Jquery对象的类型object

	  **** JavaScript--->Jquery对象--->DOM---->HTML

   七。将DOM封装为JQUERY对象
       $("定位条件"):根据定位条件得到DOM对象并封装到JQUERY对象
	   $(dom对象)   :将得到dom对象封装到JQUERY对象

*/

function $(param) {

	var domArray; //这是一个数组，存放定位的所有的DOM对象
	if (typeof param == 'string') {
		//判断条件是否既有选择器又存在过滤器
		if (param.indexOf(":") != -1) {
			var array = param.split(":"); //[0]选择器 [1]过滤器  
			//首先根据选择器，将满足条件的DOM对象进行定位并存放在数组
			if (array[0].indexOf(".") == 0) {
				var name = array[0].substring(1)
				domArray = document.getElementsByName(name);
			} else if (array[0].indexOf("#") == 0) {
				var id = array[0].substring(1);
				var dom = document.getElementById(id);
				domArray = new Array();
				domArray[0] = dom
			} else {
				domArray = document.getElementsByTagName(array[0]);
			}
			//然后在数组根据过滤器精准定位需要的DOM对象
			if (array[1] == 'first') {
				var tempArray = new Array();
				tempArray[0] = domArray[0];
				domArray = tempArray;
			} else if (array[1] == 'last') {
				var tempArray = new Array();
				tempArray[0] = domArray[domArray.length - 1];
				domArray = tempArray;
			} else if (array[1].indexOf("eq") != -1) {
				var size = array[1].substring(3, array[1].length - 1);
				var tempArray = new Array();
				tempArray[0] = domArray[size];
				domArray = tempArray;
			} else if (array[1].indexOf("gt") != -1) {
				var size = array[1].substring(3, array[1].length - 1);//$("div:gt(1)") 得到1
				var tempArray = new Array();
				for (var i = parseInt(size) + 1; i < domArray.length; i++) {
					tempArray.push(domArray[i]);//向数组添加数据
				}
				domArray = tempArray;
			}
		} else {
			if (param.indexOf(".") == 0) {
				var name = param.substring(1)
				domArray = document.getElementsByName(name);
			} else if (param.indexOf("#") == 0) {
				var id = param.substring(1);
				var dom = document.getElementById(id);
				domArray = new Array();
				domArray[0] = dom
			} else {
				domArray = document.getElementsByTagName(param);
			}
		}
	} else {
		domArray = new Array();
		domArray[0] = param;//DOM对象转换为JQUERY对象
	}


	//为jquery对象追加功能函数，操作DOM对象

	/*
	   "value属性"：是表单域标签专有属性
	   val函数体现功能:
			功能1：对jquery对象中所有DOM对象管理的标签的value属性
				   进行集中赋值
			功能2：读取jqurey对象中第一个位置的DOM对象所管理的标签的
				   value属性值进行读取
						 0       1
				   $obj =[dom1] [dom2]
				   $obj.val() ===== $obj[0].value
 
		jquery作者定义调用规则:
 
				  $obj.val(值)：对数组中所有DOM对象所管理的HTML标签的
								value属性进行统一赋值
 
				  $obj.val()  : 读取数组中0位置的DOM对象所管理的标签的
								value属性值
	    arugments:
				 1.JavaScript中每一个函数都拥有一个arguments属性
				 2.arguments属性是一个数组
				 3.arguments属性用于接收函数在调用时传递而来的实参
	*/
	domArray.val = function (param) {

		if (arguments.length == 1) {
			for (var i = 0; i < domArray.length; i++) {
				var dom = domArray[i];
				dom.value = param;
			}
		} else if (arguments.length == 0) {
			var dom = domArray[0];
			return dom.value;
		}
	}
	/*
	   attr函数:
	   $obj.attr("属性名",值):对数组中所有DOM对象中指定的属性进行同一赋值
	   $obj.attr("属性名")   :读取数组中0位上的DOM对象指定属性的内容
	*/
	domArray.attr = function (field, value) {
		if (arguments.length == 2) {
			for (var i = 0; i < domArray.length; i++) {
				var dom = domArray[i];
				dom[field] = value;
			}
		} else if (arguments.length == 1) {
			var dom = domArray[0];
			return dom[field]
		}
	}
	/*
	   css函数
	   $obj.css("样式属性名",值):对数组中所有DOM对象关联的标签中样式属性集中赋值
 
	*/
	domArray.css = function (styleName, value) {
		for (var i = 0; i < domArray.length; i++) {
			var dom = domArray[i];
			dom.style[styleName] = value
		}
	}
	/*
	   bind函数
	   $obj.bind("监听属性名",事件处理函数名)：
		 要求数组中所有的DOM对象对关联的标签中监听属性绑定一个统一处理函数
	*/

	domArray.bind = function (listenerName, fun) {
		for (var i = 0; i < domArray.length; i++) {
			var dom = domArray[i];
			dom[listenerName] = fun
		}

	}
	return domArray;//jquery对象
}