/*
 * @Author: feng
 * @Date: 2021-01-30 18:14:07
 * @Description: file content
 */
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
*/
function $(param) {

     var domArray; //这是一个数组，存放定位的所有的DOM对象
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
          } else {
               var size = array[1].substring(3, array[1].length - 1);
               var tempArray = new Array();
               tempArray[0] = domArray[size];
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

     return domArray;
}