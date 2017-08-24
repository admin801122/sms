var http = {};
http.param = function (data) {
    if (!data) return null;
    var array = new Array();
    for (var name in data) {
        var key = name;
        var value = data[name];
        if (value == null) {
            continue;
        }
        if (Object.prototype.toString.call(value) == '[object Array]') {
            var parent = key;
            var children = value;
            for (var i = 0; i < children.length; i++) {
                var json = children[i];
                if (Object.prototype.toString.call(json) == '[object Object]') {
                    for (var name in json) {
                        key = parent + '[' + i + '].' + name;
                        value = json[name];
                        if (value == null) {
                            continue;
                        }
                        key = encodeURIComponent(key);
                        value = encodeURIComponent(value);
                        array.push(key + '=' + value);
                    }
                } else {
                    key = parent + '[' + i + ']';
                    key = encodeURIComponent(key);
                    value = encodeURIComponent(json);
                    array.push(key + '=' + value);
                }
            }
        } else {
            key = encodeURIComponent(key);
            value = encodeURIComponent(value);
            array.push(key + '=' + value);
        }
    }
    return array.join('&');
};
http.post = function (url, param, success, error) {
    $.ajax({
        type: "POST",
        url: url,
        data: this.param(param),
        success: function (r) {
            r = $.parseJSON(r);
            if (!r.errcode) {
                if (success) {
                    success(r);
                }
            } else {
                if (error) {
                    error(r);
                }
                showErrorTips(r.errmsg);
            }

        },
        error: function (data, status) {
            if (error) {
                error(data);
            }
            showErrorTips('系统忙,请稍后再试');
        }
    });
};
http.getJSON = function (url, param, callback) {
    if ($.isFunction(param)) {
        callback = param;
        param = undefined;
    }
    $.getJSON(url, this.param(param), function(r){
        if (!r.errcode) {
            if (callback) {
                callback(r);
            }
        } else {
            showErrorTips(r.errmsg);
        }
    });
};