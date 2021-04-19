/*
 * @Descripttion:定义map  
 * @version:
 * @Author: feng
 * @Date: 2021-01-30
 */
class Map {
    /**
     * @Descripttion: 初始化容器
     * @param {*}
     * @return {*}
     */
    constructor() {
        this.container = {};
    }

    /**
     * @Descripttion: 
     * @param {*}
     * @return {*}
     */
    clear() {
        this.container = {};
    }
    /**
     * @Descripttion: 
     * @param {*}
     * @return {*}
     */
    isEmpty() {
        return this.keyArray().length == 0 ? true : false;
    }
    /**
     * @Descripttion: 
     * @param {*}
     * @return {*}
     */
    size() {
        return this.keyArray().length;
    }

    /**
     * @Descripttion: 
     * @param {*} key
     * @param {*} value
     * @return {*}
     */
    put(key, value) {
        try {
            if (key != "") {
                this.container[key] = value;
            }
        } catch (error) {
            return error;
        }
    }
    /**
     * @Descripttion: get(key) 
     * @param {*} key
     * @return {*}
     */
    get(key) {
        return this.container[key];
    }
    /**
     * @Descripttion:containsKey(key) 
     * @param {*} key
     * @return {*}
     */
    containsKey(key) {
        var falg = false;
        try {
            for (var p in this.container) {
                if (p == key) {
                    falg = true;
                }
            }
        } catch (error) {
            falg = false;
        }
        return falg;
    }
    /**
     * @Descripttion: containsValue(value)
     * @param {*} value
     * @return {*}
     */
    containsValue(value) {
        var flag = false;
        try {
            for (var p in this.container) {
                if (this.container[p] == value) {
                    flag = true;
                }
            }
        } catch (error) {
            flag = false;
        }
        return flag;
    }
    /**
     * @Descripttion: 如果删除成功，返回true；反之，false;delete删除不存在的变量返回true
     * @param {*} key
     * @return {*}
     */
    remove(key) {
        var flag = this.containsKey(key);
        return flag == true ? delete this.container[key] : false;
    }
    /**
     * @Descripttion: map中的key
     * @param {*}
     * @return {*}
     */
    keyArray() {
        var keys = new Array();
        for (var p in this.container) {
            keys.push(p);
        }
        return keys;
    }
    /**
     * @Descripttion: map中的value
     * @param {*}
     * @return {*}
     */
    valueArray() {
        var values = new Array();
        var keys = this.keyArray();
        for (var i = 0; i < keys.length; i++) {
            values.push(this.container[keys[i]]);
        }
        return values;
    }
}


/**
* @Descripttion: 测试map
* @test: test font
* @msg:
* @param {*}
* @return {*}
*/
function testMap() {
    var map = new Map();
    for (var i = 0; i < 10; i++) {
        map.put(i, 2);
        map.put(i, 3);
    }
    console.log(map);
    console.log(map.get(3));//3
    console.log(map.get(-1));
    console.log(map.remove(1));//true
    console.log(map.remove(-1));//false
    console.log("keys : " + map.keyArray());
    console.log("values : " + map.valueArray());
    console.log(map.containsKey(1));//false
    console.log(map.containsValue(3));//true
    console.log(map.size());//8
    console.log(map.isEmpty());//false
    map.clear();
    console.log(map);//Map { container: {} }
}
testMap();







