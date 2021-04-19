/*
 * @Descripttion:
 * @version:
 * @Author: feng
 * @Date: 2021-01-30
 */
class Map {
    constructor() {
        /**
         * @Descripttion: 初始化变量
         * @test: test font
         * @msg: 
         * @param {*}
         * @return {*}
         */
        this.elements = new Array();
        /**
         * @Descripttion: 元素的个数
         * @test: test font
         * @msg: 
         * @param {*}
         * @return {*}数组的个数
         */
        this.size = function () {
            return this.elements.length;
        };
        /**
         * @Descripttion: 是否为空
         * @test: test font
         * @msg: 
         * @param {*}
         * @return {*}
         */
        this.isEmpty = function () {
            return (this.elements.length < 1);
        };
        /**
         * @Descripttion: 删除全部元素
         * @test: test font
         * @msg: 
         * @param {*}
         * @return {*}
         */
        this.clear = function () {
            //重新初始化
            this.elements = new Array();
        };
        /**
         * @Descripttion: 添加元素 
         * @test: test font
         * @msg: 
         * @param {*} _key
         * @param {*} _value
         * @return {*}
         */
        this.put = function (_key, _value) {
            this.elements.push({
                key: _key,
                value: _value
            });
        };
        /**
         * @Descripttion: 删除
         * @test: test font
         * @msg: 
         * @param {*} _key
         * @return {*}
         */
        this.removeByKey = function (_key) {
            var flag = false;
            try {
                for (i = 0; i < this.elements.length; i++) {
                    if (this.elements[i].key == _key) {
                        this.elements.splice(i, 1);
                        return true;
                    }
                }
            } catch (e) {
                flag = false;
            }
            return flag;
        };
        this.removeByValue = function (_value) {
            var bln = false;
            try {
                for (i = 0; i < this.elements.length; i++) {
                    if (this.elements[i].value == _value) {
                        this.elements.splice(i, 1);
                        return true;
                    }
                }
            } catch (e) {
                bln = false;
            }
            return bln;
        };
        /**
         * @Descripttion: 删除
         * @test: test font
         * @msg: 
         * @param {*} _key
         * @param {*} _value
         * @return {*}
         */
        this.removeByValueAndKey = function (_key, _value) {
            var flag = false;
            try {
                for (i = 0; i < this.elements.length; i++) {
                    if (this.elements[i].value == _value && this.elements[i].key == _key) {
                        this.elements.splice(i, 1);
                        return true;
                    }
                }
            } catch (e) {
                flag = false;
            }
            return flag;
        };
        /**
         * @Descripttion: 获取指定KEY的元素值VALUE，失败返回NULL
         * @test: test font
         * @msg: 
         * @param {*} _key
         * @return {*}
         */
        this.get = function (_key) {
            try {
                for (i = 0; i < this.elements.length; i++) {
                    if (this.elements[i].key == _key) {
                        return this.elements[i].value;
                    }
                }
            } catch (e) {
                return false;
            }
            return false;
        };
       /**
         * @Descripttion:  获取指定索引的元素（使用element.key，element.value获取KEY和VALUE），失败返回NULL
         * @param {*} _index
         * @return {*}
         */
        this.element = function (_index) {
            if (_index < 0 || _index >= this.elements.length) {
                return null;
            }
            return this.elements[_index];
        };
        /**
         * @Descripttion: 是否含有指定KEY的元素
         * @test: test font
         * @msg: 
         * @param {*} _key
         * @return {*}
         */
        this.containsKey = function (_key) {
            var flag = false;
            try {
                for (i = 0; i < this.elements.length; i++) {
                    if (this.elements[i].key == _key) {
                        flag = true;
                    }
                }
            }
            catch (e) {
                flag = false;
            }
            return flag;
        };
        /**
         * @Descripttion: 推断MAP中是否含有指定VALUE的元素
         * @test: test font
         * @msg: 
         * @param {*} _value
         * @return {*}
         */
        this.containsValue = function (_value) {
            var flag = false;
            try {
                for (i = 0; i < this.elements.length; i++) {
                    if (this.elements[i].value == _value) {
                        flag = true;
                    }
                }
            }
            catch (e) {
                flag = false;
            }
            return flag;
        };
        /**
         * @Descripttion: MAP中是否含有指定VALUE的元素
         * @test: test font
         * @msg: 
         * @param {*} _key
         * @param {*} _value
         * @return {*}
         */
        this.containsObj = function (_key, _value) {
            var flag = false;
            try {
                for (i = 0; i < this.elements.length; i++) {
                    if (this.elements[i].value == _value && this.elements[i].key == _key) {
                        flag = true;
                    }
                }
            }
            catch (e) {
                flag = false;
            }
            return flag;
        };
        /**
         * @Descripttion:  获取MAP中全部VALUE的数组
         * @test: test font
         * @msg: 
         * @param {*}
         * @return {*}
         */
        this.values = function () {
            var arr = new Array();
            for (i = 0; i < this.elements.length; i++) {
                arr.push(this.elements[i].value);
            }
            return arr;
        };
        /**
         * @Descripttion: 获取MAP中全部VALUE的数组
         * @test: test font
         * @msg: 
         * @param {*} _key
         * @return {*}
         */
        this.valuesByKey = function (_key) {
            var arr = new Array();
            for (i = 0; i < this.elements.length; i++) {
                if (this.elements[i].key == _key) {
                    arr.push(this.elements[i].value);
                }
            }
            return arr;
        };
        /**
         * @Descripttion: 获取MAP中全部KEY的数组
         * @test: test font
         * @msg: 
         * @param {*}
         * @return {*}
         */
        this.keys = function () {
            var arr = new Array();
            for (i = 0; i < this.elements.length; i++) {
                arr.push(this.elements[i].key);
            }
            return arr;
        };
        /**
         * @Descripttion: 通过value获取key
         * @test: test font
         * @msg: 
         * @param {*} _value
         * @return {*}
         */
        this.keysByValue = function (_value) {
            var arr = new Array();
            for (i = 0; i < this.elements.length; i++) {
                if (_value == this.elements[i].value) {
                    arr.push(this.elements[i].key);
                }
            }
            return arr;
        };
        /**
         * @Descripttion: 获取MAP中全部KEY的数组
         * @test: test font
         * @msg: 
         * @param {*}
         * @return {*} arr
         */
        this.keysRemoveDuplicate = function () {
            var arr = new Array();
            for (i = 0; i < this.elements.length; i++) {
                var flag = true;
                for (var j = 0; j < arr.length; j++) {
                    if (arr[j] == this.elements[i].key) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    arr.push(this.elements[i].key);
                }
            }
            return arr;
        };
    }
}

var myMap = {
    getMapInstance: function () {
        var map = new Map();
		/**
		 * 假设key已存在,覆盖value
		 */
        map.putNoRepeat = function (_key, _value) {
            if (!this.containsKey(_key)) {
                this.put(_key, _value);
            } else {
                for (i = 0; i < this.elements.length; i++) {
                    if (this.elements[i].key == _key) {
                        this.elements[i].value = _value;
                        break;
                    }
                }
            }
        }
        return map;
    }
};

/**
 * @Descripttion: 测试map
 * @test: test font
 * @msg:
 * @param {*}
 * @return {*}
 */
const testMap = () => {
    const map = new Map();
    for (var i = 0; i < 10; i++) {
        map.put(i, 2);
    }
    console.log(map);
    console.log(map.removeByKey('1'));
    console.log(map);
    console.log(map.get('3'));
};

testMap();
